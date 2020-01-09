package com.gonuclei.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * The type Redis cron.
 */
//@Component
public class RedisCron {

  /**
   * Flush redis.
   */
  @Scheduled(cron = "0 55 */2 * * ?")
  public void flushRedis() {
    //TODO: Write cron job to flush redis and populate it at 55th minute of every alternate hour
  }
}
