package com.gonuclei.service.transactions;

import com.gonuclei.bos.SubscriptionBo;
import com.gonuclei.dto.SubscriptionDto;
import com.gonuclei.entities.NewsLetterEntity;
import com.gonuclei.entities.SubscriptionEntity;
import com.gonuclei.entities.UserEntity;
import com.gonuclei.enums.SubscriptionStatusEnum;
import com.gonuclei.exception.NewsLetterNotFoundException;
import com.gonuclei.exception.SubscriptionNotFoundException;
import com.gonuclei.exception.UserNotFoundException;
import com.gonuclei.repository.MasterSubscriptionRepository;
import com.gonuclei.repository.SalveNewsLetterRepository;
import com.gonuclei.repository.SlaveSubscriptionRepository;
import com.gonuclei.repository.SlaveUserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Article transaction service.
 */
@Service
public class SubscriptionTransactionService {

  private final MasterSubscriptionRepository masterSubscriptionRepository;
  private final SlaveSubscriptionRepository slaveSubscriptionRepository;
  private final SlaveUserRepository slaveUserRepository;
  private final SalveNewsLetterRepository salveNewsLetterRepository;
  private final ModelMapper modelMapper;

  /**
   * Instantiates a new Subscription transaction service.
   *
   * @param masterSubscriptionRepository the master subscription repository
   * @param slaveSubscriptionRepository  the slave subscription repository
   * @param slaveUserRepository          the slave user repository
   * @param salveNewsLetterRepository    the salve news letter repository
   */
  @Autowired
  public SubscriptionTransactionService(MasterSubscriptionRepository masterSubscriptionRepository, SlaveSubscriptionRepository slaveSubscriptionRepository, SlaveUserRepository slaveUserRepository, SalveNewsLetterRepository salveNewsLetterRepository) {
    this.masterSubscriptionRepository = masterSubscriptionRepository;
    this.slaveSubscriptionRepository = slaveSubscriptionRepository;
    this.slaveUserRepository = slaveUserRepository;
    this.salveNewsLetterRepository = salveNewsLetterRepository;
    this.modelMapper = new ModelMapper();

    /**
     * Lambda expression to populate user and newsletter from SubscriptionEntity to SubscriptionBo
     */
//    this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//    Converter<SubscriptionEntity, SubscriptionBo> entityToBoConverter = context -> {
//      SubscriptionEntity source = context.getSource();
//      SubscriptionBo destination = context.getDestination();
//      destination.setUser(source.getUser());
//      destination.setNewsLetter(source.getNewsLetter());
//      return destination;
//    };
//
//    this.modelMapper.addConverter(entityToBoConverter);
  }


  /**
   * Add subscription.
   *
   * @param subscription the subscription
   * @throws NewsLetterNotFoundException the news letter not found exception
   * @throws UserNotFoundException       the user not found exception
   */
  public void addSubscription(SubscriptionDto subscription) throws NewsLetterNotFoundException, UserNotFoundException {

    NewsLetterEntity newsLetter = salveNewsLetterRepository.findById(subscription.getNewsLetterId()).orElseThrow(NewsLetterNotFoundException::new);
    UserEntity user = slaveUserRepository.findById(subscription.getUserId()).orElseThrow(UserNotFoundException::new);
    SubscriptionEntity subscriptionEntity = modelMapper.map(subscription, SubscriptionEntity.class);
    subscriptionEntity.setUser(user);
    subscriptionEntity.setNewsLetter(newsLetter);
    masterSubscriptionRepository.save(subscriptionEntity);
  }

  /**
   * Gets subscription.
   *
   * @param subscriptionId the subscription id
   * @return the subscription
   * @throws SubscriptionNotFoundException the subscription not found exception
   */
  public SubscriptionDto getSubscription(Long subscriptionId) throws SubscriptionNotFoundException {
    final SubscriptionEntity subscription = slaveSubscriptionRepository.findById(subscriptionId)
        .orElseThrow(SubscriptionNotFoundException::new);
    return modelMapper.map(subscription, SubscriptionDto.class);
  }

  /**
   * Gets all subscription bo.
   *
   * @return the all subscription bo
   */
  public List<SubscriptionBo> getAllSubscriptionBo() {

    return slaveSubscriptionRepository.findAllBySubscriptionState(SubscriptionStatusEnum.SUBSCRIBED).stream()
        .map(subscriptionEntity -> {
          SubscriptionBo subscriptionBo = modelMapper.map(subscriptionEntity, SubscriptionBo.class);
          return subscriptionBo;
        }).collect(Collectors.toList());
  }

}
