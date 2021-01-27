package com.newsletter.services.impl;

import com.newsletter.bos.SubscriptionBo;
import com.newsletter.services.ISubscriptionService;
import com.newsletter.services.transactions.SubscriptionTransactionService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("PMD")
public class SubscriptionServiceImpl implements ISubscriptionService {

  @Autowired
  private static JavaMailSender sender;
  @Autowired
  private static NewsletterServiceImpl newsletterService;

  @Autowired
  private static SubscriptionTransactionService subscriptionTransactionService;

  private Logger logger = Logger.getLogger(SubscriptionServiceImpl.class.getName());

  @Override
  public List<SubscriptionBo> getAllSubscriptions() {
    return subscriptionTransactionService.getAllSubscriptions();
  }

  @Override
  public void buyASubscription(SubscriptionBo subscriptionBo) {
    subscriptionTransactionService.buyASubscription(subscriptionBo);
  }

  @Override
  public boolean cancelSubscription(long id) {
    return subscriptionTransactionService.cancelSubscription(id);
  }

  @Override
  public boolean renewSubscription(long id, Date date, String dailyweekly) {
    return subscriptionTransactionService.renewSubscription(id, date, dailyweekly);
  }

  //filter on the basis of movie type
  @Override
  public List<SubscriptionBo> getSubscriptionOfType(String filterType) {
    return subscriptionTransactionService.getSubscriptionOfType(filterType);
  }

  @Override
  public List<SubscriptionBo> getSortedSubscriptions(String type, String sortOrder) {
    return subscriptionTransactionService.getSortedSubscriptions(type, sortOrder);
  }

  @Override
  public void sendContentThroughEmail() {
    List<SubscriptionBo> subscriptionBos = getAllSubscriptions();
    //get current day
    Calendar calendar = Calendar.getInstance();
    int d = calendar.get(Calendar.DAY_OF_WEEK);
    String[] days = {"mon", "tues", "wed", "thus", "fri", "sat", "sun"};
    String day = days[d - 2];
    for (SubscriptionBo s : subscriptionBos) {
      if (s.getDailyweekly().equalsIgnoreCase("DAILY") || s.getDailyweekly()
          .equalsIgnoreCase(day)) {
        logger.log(Level.INFO, s.getEmail());
        String content = newsletterService.getContent(s.getId());
        try {
          sendEmail(s.getEmail(), content, s.getNewsLetterType());
        } catch (Exception e) {
          logger.log(Level.WARNING, "Error while sending email :" + e.getMessage());
        }
      }
    }


  }

  @Override
  public void sendEmail(String email, String content, String subject) {
    MimeMessage message = sender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

    try {
      helper.setTo(email);
      helper.setText(content);
      helper.setSubject(subject);
    } catch (MessagingException e) {
      logger.log(Level.WARNING, "Error while sending email :" + e.getMessage());
    }

    sender.send(message);
  }

  //user specific services
  @Override
  public List<SubscriptionBo> getMySubscriptions(String email) {
    return subscriptionTransactionService.getMySubscriptions(email);
  }
}
