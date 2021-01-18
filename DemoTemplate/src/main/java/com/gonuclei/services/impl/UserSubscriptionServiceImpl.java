package com.gonuclei.services.impl;

import com.gonuclei.bo.NewsLetterBo;
import com.gonuclei.bo.SubscriptionBo;
import com.gonuclei.bo.UserSubscriptionBo;
import com.gonuclei.constants.Constants;
import com.gonuclei.exceptions.CustomException;
import com.gonuclei.security.JwtUtil;
import com.gonuclei.services.SubscriptionService;
import com.gonuclei.services.UserSubscriptionService;
import com.gonuclei.transactionServices.UserSubscriptionTransactionService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * The type User subscription service.
 */
@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

  /**
   * The User subscription transaction service.
   */
  @Autowired
  private UserSubscriptionTransactionService userSubscriptionTransactionService;
  /**
   * The Subscription service.
   */
  @Autowired
  private SubscriptionService subscriptionService;
  /**
   * The Sender.
   */
  @Autowired
  private JavaMailSender sender;
  /**
   * The Jwt util.
   */
  @Autowired
  private JwtUtil jwtUtil;

  /**
   * Buy subscription boolean.
   *
   * @param subscriptionId the subscription id
   * @param request        the request
   * @return the boolean
   * @throws CustomException the custom exception
   */
  @Override
  public boolean buySubscription(Long subscriptionId, HttpServletRequest request)
      throws CustomException {

    String bearerToken = request.getHeader(Constants.AUTHORIZATION);
    String username = jwtUtil.extractUsername(bearerToken.substring(7));

    Date date = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(date);

    SubscriptionBo subscriptionBO = subscriptionService.getSubscriptionById(subscriptionId);
    c.add(Calendar.DATE, subscriptionBO.getValidity());

    UserSubscriptionBo userSubscriptionBO = new UserSubscriptionBo();
    userSubscriptionBO.setSubscriptionId(subscriptionId);
    userSubscriptionBO.setEmail(username);
    userSubscriptionBO.setDateOfSubscription(date);
    userSubscriptionBO.setDateOfExpiry(c.getTime());
    userSubscriptionBO.setStatus(1);
    userSubscriptionBO.setSubscriptionCategory(subscriptionBO.getCategory());

    userSubscriptionTransactionService.saveUserSubscription(userSubscriptionBO);
    return true;
  }

  /**
   * Renew subscription boolean.
   *
   * @param subscriptionId the subscription id
   * @param request        the request
   * @return the boolean
   */
  @Override
  public boolean renewSubscription(final Long subscriptionId, final HttpServletRequest request) {

    String bearerToken = request.getHeader(Constants.AUTHORIZATION);
    String username = jwtUtil.extractUsername(bearerToken.substring(7));

    UserSubscriptionBo userSubscriptionBO = userSubscriptionTransactionService
      .getUserSubscriptionByEmailAndSubscriptionId(username, subscriptionId);

    Date date = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(date);

    SubscriptionBo subscriptionBO = subscriptionService.getSubscriptionById(subscriptionId);
    c.add(Calendar.DATE, subscriptionBO.getValidity());

    if (Objects.isNull(subscriptionBO)) {
      throw new CustomException("The Subscription wasn't taken by the user",
        HttpStatus.BAD_REQUEST);
    }

    userSubscriptionBO.setStatus(1);
    userSubscriptionBO.setDateOfExpiry(c.getTime());

    return userSubscriptionTransactionService.saveUserSubscription(userSubscriptionBO);

  }

  /**
   * Delete subscription boolean.
   *
   * @param subscriptionId the subscription id
   * @param request        the request
   * @return the boolean
   */
  @Override
  public boolean deleteSubscription(Long subscriptionId, HttpServletRequest request) {

    String bearerToken = request.getHeader("Authorization");
    String username = jwtUtil.extractUsername(bearerToken.substring(7));

    UserSubscriptionBo userSubscriptionBO = null;
    userSubscriptionBO = userSubscriptionTransactionService
      .getUserSubscriptionByEmailAndSubscriptionId(username, subscriptionId);

    if (userSubscriptionBO.equals(null)) {
      throw new CustomException("Couldn't delete the Subscription", HttpStatus.BAD_REQUEST);
    }

    return userSubscriptionTransactionService.deleteSubscription(userSubscriptionBO);
  }

  /**
   * Gets user subscriptions.
   *
   * @param request the request
   * @return the user subscriptions
   */
  @Override
  public List<UserSubscriptionBo> getUserSubscriptions(HttpServletRequest request) {

    String bearerToken = request.getHeader(Constants.AUTHORIZATION);
    String username = jwtUtil.extractUsername(bearerToken.substring(7));

    List<SubscriptionBo> subscriptionBoList = new ArrayList<>();
    return userSubscriptionTransactionService
      .getAllUserSubscriptions(username);

  }

  /**
   * Send news letter boolean.
   *
   * @param newsLetterBO the news letter bo
   * @return the boolean
   */
  @Override
  public void sendNewsLetter(NewsLetterBo newsLetterBO) {

    try {
      userSubscriptionTransactionService
        .getAllUserSubscriptionsBycategory(newsLetterBO.getCategory())
        .stream()
        .map(userSubscriptionBo -> sendMail(
          newsLetterBO.getCategory(), newsLetterBO.getMessage(), userSubscriptionBo.getEmail()))
        .collect(Collectors.toList());
    } catch (Exception e) {
      throw new CustomException("Couldn't send mails", HttpStatus.BAD_REQUEST);
    }

  }

  /**
   * Send mail string.
   *
   * @param category the category
   * @param text     the text
   * @param target   the target
   * @return the string
   */
  public boolean sendMail(String category, String text, String target) {

    MimeMessage message = sender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    try {
      helper.setTo(target);
      helper.setText(text);
      helper.setSubject(category + Constants.EMAIL_SUBJECT);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
    sender.send(message);
    return true;
  }

}
