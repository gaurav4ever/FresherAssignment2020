package com.newsletter.services.transactions.impl;

import com.newsletter.bos.SubscriptionBo;
import com.newsletter.dao.SubscriptionRepository;
import com.newsletter.entities.SubscriptionEntity;
import com.newsletter.mappers.SubscriptionObjectMapper;
import com.newsletter.services.transactions.SubscriptionTransactionService;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionTransactionServiceImpl implements SubscriptionTransactionService {

  @Autowired
  private static SubscriptionRepository subscriptionRepository;

  @Autowired
  private static SubscriptionObjectMapper subscriptionObjectMapper;

  private static final Logger logger = Logger
      .getLogger(SubscriptionTransactionServiceImpl.class.getName());

  @Override
  public List<SubscriptionBo> getAllSubscriptions() {
    List<SubscriptionEntity> subscriptionEntityList = subscriptionRepository.findAll();
    return subscriptionObjectMapper.subscriptionBoFromEntityList(subscriptionEntityList);
  }

  @Override
  public void buyASubscription(SubscriptionBo subscriptionBo) {
    SubscriptionEntity subscriptionEntity = subscriptionObjectMapper.boToEntity(subscriptionBo);
    subscriptionRepository.save(subscriptionEntity);
  }

  @Override
  public boolean cancelSubscription(long id) {
    Optional<SubscriptionEntity> s = subscriptionRepository.findById(id);
    if (s.isPresent()) {
      SubscriptionEntity ss = s.get();
      ss.setIsCanceled((byte) 1);
      ss.setIsSubscribed((byte) 0);
      ss.setEndDateOfSubscription(new Date());
      subscriptionRepository.save(ss);
      return true;
    }
    return false;
  }

  @Override
  public boolean renewSubscription(long id, Date date, String dailyweekly) {
    Optional<SubscriptionEntity> s = subscriptionRepository.findById(id);
    if (s.isPresent()) {
      SubscriptionEntity ss = s.get();
      ss.setIsCanceled((byte) 0);
      ss.setIsSubscribed((byte) 1);
      ss.setIsRenewed((byte) 1);
      ss.setDateOfSubscription(new Date());
      ss.setEndDateOfSubscription(date);
      if (dailyweekly != null) {
        ss.setDailyweekly(dailyweekly);
      }
      subscriptionRepository.save(ss);
      return true;
    }
    return false;
  }

  @Override
  public List<SubscriptionBo> getSubscriptionOfType(String filterType) {
    List<SubscriptionEntity> l = subscriptionRepository.findAll();

    switch (filterType) {
      case "isCanceled":
        l.stream().filter(sub -> sub.getIsCanceled() == 1).collect(Collectors.toList());
        break;
      case "isSubscribed":
        l.stream().filter(sub -> sub.getIsSubscribed() == 1).collect(Collectors.toList());
        break;
      case "isRenewed":
        l.stream().filter(sub -> sub.getIsRenewed() == 1).collect(Collectors.toList());
        break;
      default:
        l.stream().filter(sub -> sub.getNewsLetterType().equals(filterType))
            .collect(Collectors.toList());
        break;
    }
    return subscriptionObjectMapper.subscriptionBoFromEntityList(l);
  }

  @Override
  public List<SubscriptionBo> getSortedSubscriptions(String type, String sortOrder) {
    List<SubscriptionBo> sortedSubscriptionBoList = sortSubscriptions(type);
    if (sortOrder.equalsIgnoreCase("asc")) {
      return sortedSubscriptionBoList;
    }
    Collections.reverse(sortedSubscriptionBoList);
    return sortedSubscriptionBoList;
  }

  @Override
  public List<SubscriptionBo> sortSubscriptions(String type) {
    List<SubscriptionEntity> allSubscriptionBos = subscriptionRepository.findAll();
    switch (type) {
      case "email":
        allSubscriptionBos.sort((SubscriptionEntity o1, SubscriptionEntity o2) -> o1.getEmail()
            .compareToIgnoreCase(o2.getEmail()));
        break;
      case "dateOfSubscription":
        //method reference operator
        allSubscriptionBos.sort(Comparator.comparing(SubscriptionEntity::getDateOfSubscription));
        break;
      case "endDateOfSubscription":
        allSubscriptionBos.sort(Comparator.comparing(SubscriptionEntity::getEndDateOfSubscription));
        break;
      default:
        logger.log(Level.INFO, "Wrong choice.");
        break;
    }
    return subscriptionObjectMapper.subscriptionBoFromEntityList(allSubscriptionBos);
  }

  @Override
  public List<SubscriptionBo> getMySubscriptions(String email) {
    return subscriptionObjectMapper
        .subscriptionBoFromEntityList(subscriptionRepository.findByEmail(email));
  }

}