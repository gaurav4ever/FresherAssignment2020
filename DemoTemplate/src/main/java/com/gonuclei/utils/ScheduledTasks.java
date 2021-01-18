package com.gonuclei.utils;


import com.gonuclei.bo.UserSubscriptionBo;
import com.gonuclei.transactionServices.UserSubscriptionTransactionService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
public class ScheduledTasks {

  @Autowired
  private UserSubscriptionTransactionService userSubscriptionTransactionService;


  @PostConstruct
  @Scheduled(cron = "0 0 * * * ?")
  public void scheduleTaskWithCronExpression() {

    List<UserSubscriptionBo> userSubscriptionList =
      userSubscriptionTransactionService.getAllActiveSubscriptions()
      .stream()
      .filter(userSubscriptionBo -> userSubscriptionBo.getDateOfExpiry().compareTo(new Date())<0)
      .collect(Collectors.toList());

    for (UserSubscriptionBo userSubscription: userSubscriptionList){
      userSubscription.setStatus(0);
    }

    userSubscriptionList.stream()
      .map(userSubscriptionBo ->
        userSubscriptionTransactionService.saveUserSubscription(userSubscriptionBo))
      .collect(Collectors.toList());

  }

  @Bean
  public TaskScheduler taskScheduler() {
    return new ConcurrentTaskScheduler(); //single threaded by default
  }

}
