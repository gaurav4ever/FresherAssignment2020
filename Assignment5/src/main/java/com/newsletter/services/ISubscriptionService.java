package com.newsletter.services;

import com.newsletter.bos.SubscriptionBo;
import java.util.Date;
import java.util.List;

public interface ISubscriptionService {

  List<SubscriptionBo> getAllSubscriptions();

  void buyASubscription(SubscriptionBo subscriptionBo);

  boolean cancelSubscription(long id);

  boolean renewSubscription(long id, Date date, String dailyweekly);

  List<SubscriptionBo> getSubscriptionOfType(String s);

  List<SubscriptionBo> getSortedSubscriptions(String type, String sortOrder);

  void sendContentThroughEmail();

  void sendEmail(String email, String content, String subject);

  List<SubscriptionBo> getMySubscriptions(String email);
}
