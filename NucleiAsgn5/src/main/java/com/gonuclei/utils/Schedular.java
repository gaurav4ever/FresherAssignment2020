package com.gonuclei.utils;

import com.gonuclei.constants.Constants;
import com.gonuclei.services.UserSubscriptionService;
import com.gonuclei.transactionService.UserSubscriptionTransactionService;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

/**
 * The type Schedular.
 */
@Configuration
public class Schedular {

  /**
   * The constant logger.
   */
  private static Logger logger = LoggerFactory.getLogger(Schedular.class);

  /**
   * The User subscription transaction service.
   */
  @Autowired
  private UserSubscriptionService userSubscriptionService;

  /**
   * Update validity status.
   *
   * @throws Exception the exception
   */
  @PostConstruct
  @Scheduled(cron = Constants.CRON_SCHEDULE)
  public void updateValidityStatus() throws Exception {
    userSubscriptionService.updateSubscriptionStatus();
    logger.info("cron is working!");
  }

  /**
   * Task scheduler task scheduler.
   *
   * @return the task scheduler
   */
  @Bean
  public TaskScheduler taskScheduler() {
    return new ConcurrentTaskScheduler();
  }
}
