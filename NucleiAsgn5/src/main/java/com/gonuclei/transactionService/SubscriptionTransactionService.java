package com.gonuclei.transactionService;

import com.gonuclei.exceptions.SubscriptionNotFoundException;
import com.gonuclei.models.bo.SubscriptionBo;
import com.gonuclei.models.entities.SubscriptionEntity;
import com.gonuclei.repo.master.MasterSubscriptionRepository;
import com.gonuclei.repo.slave.SlaveSubscriptionRepository;
import com.gonuclei.mapper.SubscriptionObjectMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * The type Subscription transaction service.
 */
@Service
public class SubscriptionTransactionService {

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
   * The Subscription object mapper.
   */
  @Autowired
  private SubscriptionObjectMapper subscriptionObjectMapper;

  /**
   * Gets all subscriptions.
   *
   * @return the all subscriptions
   */
  public List<SubscriptionBo> getAllSubscriptions() {
    try {
      List<SubscriptionEntity> subscriptionEntityList = slaveSubscriptionRepository.findAll();
      return subscriptionObjectMapper.subscriptionBoFromEntityList(subscriptionEntityList);
    } catch (RuntimeException e) {
      throw new SubscriptionNotFoundException("Error getting subscriptions from db!",
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Gets subscription by id.
   *
   * @param id the id
   * @return the subscription by id
   */
  public Optional<SubscriptionBo> getSubscriptionById(Long id) {
    Optional<SubscriptionEntity> subscriptionEntity = slaveSubscriptionRepository.findById(id);
    return Optional.ofNullable(subscriptionObjectMapper.entityToBo(subscriptionEntity.get()));
  }

  /**
   * Add subscription boolean.
   *
   * @param subscriptionBO the subscription bo
   * @return the boolean
   */
  public boolean addSubscription(SubscriptionBo subscriptionBO) {
    try {
      masterSubscriptionRepository.save(subscriptionObjectMapper.boToEntity(subscriptionBO));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Search by category list.
   *
   * @param category the category
   * @return the list
   */
  public List<SubscriptionBo> searchByCategory(String category) {
    try {
      List<SubscriptionEntity> subscriptionEntityList = slaveSubscriptionRepository
        .findByCategory(category);
      return subscriptionObjectMapper.subscriptionBoFromEntityList(subscriptionEntityList);
    } catch (RuntimeException e) {
      throw new SubscriptionNotFoundException("Error getting subscriptions from db!",
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Search by name subscription bo.
   *
   * @param name the name
   * @return the subscription bo
   */
  public SubscriptionBo searchByName(String name) {
    try {
      SubscriptionEntity subscriptionEntity = slaveSubscriptionRepository.findByName(name);
      return subscriptionObjectMapper.entityToBo(subscriptionEntity);
    } catch (RuntimeException e) {
      throw new SubscriptionNotFoundException("Error getting subscriptions from db!",
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
