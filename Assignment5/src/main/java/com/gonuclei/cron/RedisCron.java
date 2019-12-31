package com.gonuclei.cron;

import org.springframework.scheduling.annotation.Scheduled;

public class RedisCron {

    @Scheduled(fixedDelay = 4*60*601000)
    public void flushRedis() {
        //TODO: Write cron job to flush redis and populate it in every 4 hours
    }
}
