package com.newsletter.services.transactions;

import com.newsletter.bos.SubscriptionBo;
import java.util.Date;
import java.util.List;

public interface SubscriptionTransactionService {

  List<SubscriptionBo> getAllSubscriptions();

  void buyASubscription(SubscriptionBo subscriptionBo);

  boolean cancelSubscription(long id);

  boolean renewSubscription(long id, Date date, String dailyweekly);

  List<SubscriptionBo> getSubscriptionOfType(String filterType);

  List<SubscriptionBo> getSortedSubscriptions(String type, String sortOrder);

  List<SubscriptionBo> sortSubscriptions(String type);

  List<SubscriptionBo> getMySubscriptions(String email);
}
