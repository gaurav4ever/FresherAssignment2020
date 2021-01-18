package com.gonuclei.transactionServices;

import com.gonuclei.bo.UserSubscriptionBo;
import com.gonuclei.entities.UserSubscriptionEntity;
import com.gonuclei.exceptions.BadRequestException;
import com.gonuclei.exceptions.InternalServerException;
import com.gonuclei.repositories.MasterUserSubscriptionRepository;
import com.gonuclei.repositories.SlaveUserSubscriptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * The type User subscription transaction service.
 */
@Component
public class UserSubscriptionTransactionService {

  /**
   * The Modelmapper.
   */
  ModelMapper modelmapper = new ModelMapper();
  /**
   * The Slave user subscription repository.
   */
  @Autowired
  private SlaveUserSubscriptionRepository slaveUserSubscriptionRepository;
  /**
   * The Master user subscription repository.
   */
  @Autowired
  private MasterUserSubscriptionRepository masterUserSubscriptionRepository;

  /**
   * Gets all user subscriptions.
   *
   * @param email the email
   * @return the all user subscriptions
   */
  public List<UserSubscriptionBo> getAllUserSubscriptions(String email) {
    try {
      return Optional.of(slaveUserSubscriptionRepository.findByEmail(email)
        .stream()
        .map(userSubscriptionEntity -> modelmapper
            .map(userSubscriptionEntity, UserSubscriptionBo.class))
        .collect(Collectors.toList())
      ).orElse(new ArrayList<>());
    } catch (Exception e) {
      throw new
        InternalServerException("Couldn load User Subscriptions", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public  List<UserSubscriptionBo> getAllActiveSubscriptions(){
    try{
      return Optional.of(slaveUserSubscriptionRepository.findByStatus(1)
          .stream()
          .map(userSubscriptionEntity -> modelmapper
            .map(userSubscriptionEntity, UserSubscriptionBo.class))
          .collect(Collectors.toList())
      ).orElse(new ArrayList<>());
    } catch (Exception e) {
      throw new
        InternalServerException("Couldn't fetch the subscriptions",
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Save user subscription boolean.
   *
   * @param userSubscriptionBO the user subscription bo
   * @return the boolean
   */
  public boolean saveUserSubscription(UserSubscriptionBo userSubscriptionBO) {
    try {
      masterUserSubscriptionRepository
        .save(modelmapper.map(userSubscriptionBO, UserSubscriptionEntity.class));
      return true;
    } catch (RuntimeException e) {
      throw new
        BadRequestException("couldn't add the subcription", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Gets user subscription by email and subscription id.
   *
   * @param email          the email
   * @param subscriptionId the subscription id
   * @return the user subscription by email and subscription id
   */
  public UserSubscriptionBo getUserSubscriptionByEmailAndSubscriptionId(
    String email, Long subscriptionId) {
    try {
      return Optional.of(modelmapper.map(
        slaveUserSubscriptionRepository.findByEmailAndSubscriptionId(email, subscriptionId).get(),
        UserSubscriptionBo.class)
      ).orElse(null);
    } catch (RuntimeException e) {
      throw new InternalServerException("Subscription not found", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Delete subscription boolean.
   *
   * @param userSubscriptionBO the user subscription bo
   * @return the boolean
   */
  public boolean deleteSubscription(UserSubscriptionBo userSubscriptionBO) {
    try {
      masterUserSubscriptionRepository
        .delete(modelmapper.map(userSubscriptionBO, UserSubscriptionEntity.class));
      return true;
    } catch (RuntimeException e) {
      throw new InternalServerException("User hasn't subscribed to the Subscription",
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Gets all user subscriptions bycategory.
   *
   * @param category the category
   * @return the all user subscriptions bycategory
   */
  public List<UserSubscriptionBo> getAllUserSubscriptionsBycategory(String category) {
    try {
      return Optional.of(slaveUserSubscriptionRepository
        .findBySubscriptionCategoryAndStatus(category, 1)
        .stream()
        .map(userSubscriptionEntity -> modelmapper
          .map(userSubscriptionEntity, UserSubscriptionBo.class))
        .collect(Collectors.toList())
      ).orElse(new ArrayList<>());
    } catch (RuntimeException e) {
      throw new
        InternalServerException("Couldn't load subscriptions", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
