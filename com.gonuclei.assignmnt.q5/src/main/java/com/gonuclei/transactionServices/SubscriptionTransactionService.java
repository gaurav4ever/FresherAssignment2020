package com.gonuclei.transactionServices;

import com.gonuclei.bo.SubscriptionBo;
import com.gonuclei.entities.SubscriptionEntity;
import com.gonuclei.exceptions.BadRequestException;
import com.gonuclei.exceptions.CustomException;
import com.gonuclei.exceptions.InternalServerException;
import com.gonuclei.exceptions.NotFoundException;
import com.gonuclei.repositories.MasterSubscriptionRepository;
import com.gonuclei.repositories.SlaveSubscriptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * The type Subscription transaction service.
 */
@Component
public class SubscriptionTransactionService {

  /**
   * The Modelmapper.
   */
  ModelMapper modelmapper = new ModelMapper();

  /**
   * The Slave subscription repository.
   */
  @Autowired
  private SlaveSubscriptionRepository slaveSubscriptionRepository;

  /**
   * The Master subscription repository.
   */
  @Autowired
  private MasterSubscriptionRepository masterSubscriptionRepository;

  /**
   * Gets all subscriptions.
   *
   * @return the all subscriptions
   */
  public List<SubscriptionBo> getAllSubscriptions() {
    return Optional.of(slaveSubscriptionRepository.findAll()
      .stream()
      .map(subscriptionEntity -> modelmapper.map(subscriptionEntity, SubscriptionBo.class))
      .collect(Collectors.toList())
    ).orElse(new ArrayList<>());
  }

  /**
   * Add subscription.
   *
   * @param subscriptionBO the subscription bo
   */
  public void addSubscription(SubscriptionBo subscriptionBO) {
    try {
      masterSubscriptionRepository.save(modelmapper.map(subscriptionBO, SubscriptionEntity.class));
    } catch (RuntimeException e) {
      throw new BadRequestException("Subscription Could not be added", HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Find subscription by category list.
   *
   * @param category the category
   * @return the list
   */
  public List<SubscriptionBo> findSubscriptionByCategory(String category) {
    return Optional.of(slaveSubscriptionRepository.findByCategory(category)
      .stream()
      .map(subscriptionEntity -> modelmapper.map(subscriptionEntity, SubscriptionBo.class))
      .collect(Collectors.toList())
    ).orElse(new ArrayList<>());
  }


  /**
   * Find subscription by name list.
   *
   * @param name the name
   * @return the list
   */
  public List<SubscriptionBo> findSubscriptionByName(String name) {
    try {
      return Optional.of(slaveSubscriptionRepository.findByNameContaining(name)
        .stream()
        .map(subscriptionEntity -> modelmapper.map(subscriptionEntity, SubscriptionBo.class))
        .collect(Collectors.toList())
      ).orElse(new ArrayList<>());
    } catch (Exception e) {
      throw new InternalServerException(
        "Couldn't fetch the Subscriptions", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  /**
   * Gets susbcription by id.
   *
   * @param id the id
   * @return the susbcription by id
   * @throws CustomException the custom exception
   */
  public SubscriptionBo getSusbcriptionById(Long id) throws CustomException {
    if (slaveSubscriptionRepository.findById(id).isPresent()) {
      return modelmapper.map(slaveSubscriptionRepository.findById(id).get(), SubscriptionBo.class);
    } else {
      throw new NotFoundException("Not Found", HttpStatus.NOT_FOUND);
    }
  }
}
