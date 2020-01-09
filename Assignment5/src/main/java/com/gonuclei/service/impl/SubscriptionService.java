package com.gonuclei.service.impl;

import com.gonuclei.dto.SubscriptionDto;
import com.gonuclei.exception.NewsLetterNotFoundException;
import com.gonuclei.exception.UserNotFoundException;
import com.gonuclei.service.transactions.SubscriptionTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

  private final SubscriptionTransactionService subscriptionService;

  @Autowired
  public SubscriptionService(SubscriptionTransactionService subscriptionService) {

    this.subscriptionService = subscriptionService;
  }

  public void addSubscription(SubscriptionDto subscription) throws UserNotFoundException, NewsLetterNotFoundException {

    subscriptionService.addSubscription(subscription);
  }
}
