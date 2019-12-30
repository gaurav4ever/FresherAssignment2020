package com.gonuclei.transactionService;

import com.gonuclei.mapper.UserSubscriptionObjectMapper;
import com.gonuclei.models.bo.UserSubscriptionBo;
import com.gonuclei.models.entities.SubscriptionEntity;
import com.gonuclei.models.entities.UserSubscriptionEntity;
import com.gonuclei.repo.master.MasterUserSubscriptionRepository;
import com.gonuclei.repo.slave.SlaveSubscriptionRepository;
import com.gonuclei.repo.slave.SlaveUserSubscriptionRepository;
import com.gonuclei.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type User subscription transaction service.
 */
@Service
public class UserSubscriptionTransactionService {

  /**
   * The Slave user subscription repository.
   */
  @Autowired
  private SlaveUserSubscriptionRepository slaveUserSubscriptionRepository;

  /**
   * The User subscription object mapper.
   */
  @Autowired
  private UserSubscriptionObjectMapper userSubscriptionObjectMapper;

  /**
   * The Slave subscription repository.
   */
  @Autowired
  private SlaveSubscriptionRepository slaveSubscriptionRepository;

  /**
   * The Master user subscription repository.
   */
  @Autowired
  private MasterUserSubscriptionRepository masterUserSubscriptionRepository;

  /**
   * Gets all user subscriptions.
   *
   * @param emailId the email id
   * @return the all user subscriptions
   */
  public List<UserSubscriptionBo> getAllUserSubscriptions(String emailId) {
    List<UserSubscriptionEntity> userSubscriptionEntityList = slaveUserSubscriptionRepository
      .findByEmailId(emailId);
    return userSubscriptionObjectMapper
      .getUserSubscriptionBoFromEntityList(userSubscriptionEntityList);
  }

  /**
   * Gets user subscriptionby id.
   *
   * @param sub_id the sub id
   * @return the user subscriptionby id
   */
  public List<UserSubscriptionBo> getUserSubscriptionbyId(Long sub_id) {
    List<UserSubscriptionEntity> userSubscriptionEntity = slaveUserSubscriptionRepository
      .findBySubscriptionId(sub_id);
    return userSubscriptionObjectMapper.getUserSubscriptionBoFromEntityList(userSubscriptionEntity);
  }

  /**
   * Buy subscription boolean.
   *
   * @param userSubscriptionBo the user subscription bo
   * @return the boolean
   */
//TODO handle sql exception
  public boolean buySubscription(UserSubscriptionBo userSubscriptionBo) {
    masterUserSubscriptionRepository.save(userSubscriptionObjectMapper
      .boToEntity(userSubscriptionBo));
    return true;
  }

  /**
   * Delete subscription boolean.
   *
   * @param emaiId         the emai id
   * @param subscriptionId the subscription id
   * @return the boolean
   */
  public boolean deleteSubscription(String emaiId, Long subscriptionId) {
    UserSubscriptionEntity userSubscriptionEntity = slaveUserSubscriptionRepository
      .findByEmailIdAndSubscriptionId(emaiId, subscriptionId);
    if (userSubscriptionEntity != null) {
      masterUserSubscriptionRepository.delete(userSubscriptionEntity);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Renew subscription user subscription bo.
   *
   * @param emaiId         the emai id
   * @param subscriptionId the subscription id
   * @return the user subscription bo
   */
  public UserSubscriptionBo renewSubscription(String emaiId, Long subscriptionId) {
    UserSubscriptionEntity userSubscriptionEntity = slaveUserSubscriptionRepository
      .findByEmailIdAndSubscriptionId(emaiId, subscriptionId);

    Optional<SubscriptionEntity> subscriptionEntity = slaveSubscriptionRepository
      .findById(subscriptionId);

    //change date of expiry,  date of subscription and status
    userSubscriptionEntity.setStatus(true);

    Date date = new Date();
    userSubscriptionEntity.setDateOfSubscription(date);

    userSubscriptionEntity.setDateOfExpiry(DateUtil.getDateOfExpiry(subscriptionEntity.get()
      .getValidity()));

    masterUserSubscriptionRepository.save(userSubscriptionEntity);
    return userSubscriptionObjectMapper.entityToBo(userSubscriptionEntity);
  }

  /**
   * Gets email by category.
   *
   * @param category the category
   * @param status   the status
   * @return the email by category
   */
  public List<UserSubscriptionBo> getEmailByCategoryAndStatus(String category, boolean status) {
    return userSubscriptionObjectMapper
      .getUserSubscriptionBoFromEntityList(slaveUserSubscriptionRepository
        .findBySubscriptionCategoryAndStatus(category, status));
  }

  /**
   * Update subscription status boolean.
   *
   * @return the boolean
   */
  public List<UserSubscriptionBo> getAllUserSubscriptions() {
    return userSubscriptionObjectMapper.getUserSubscriptionBoFromEntityList(
      slaveUserSubscriptionRepository.findByStatus(true));
  }

  /**
   * Update status.
   *
   * @param userSubscriptionBoList the user subscription bo list
   */
  public void updateStatus(List<UserSubscriptionBo> userSubscriptionBoList) {
    List<UserSubscriptionEntity> userSubscriptionEntityList = userSubscriptionObjectMapper.getUserSubscriptionEntityFromBoList(userSubscriptionBoList);
    for (UserSubscriptionEntity userSubscriptionEntity : userSubscriptionEntityList) {
      userSubscriptionEntity.setStatus(false);
      masterUserSubscriptionRepository.save(userSubscriptionEntity);
    }
  }
}
