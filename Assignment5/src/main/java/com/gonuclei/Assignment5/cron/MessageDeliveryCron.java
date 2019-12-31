package com.gonuclei.Assignment5.cron;

import org.springframework.scheduling.annotation.Scheduled;

public class MessageDeliveryCron {

    @Scheduled(cron = "0 15 10 15 * ?")
    public void sendMails() {

    }

}
