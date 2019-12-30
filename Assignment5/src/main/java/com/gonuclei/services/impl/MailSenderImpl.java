package com.gonuclei.services.impl;

import com.gonuclei.exceptions.UserNotFoundException;
import com.gonuclei.models.bo.EmailBo;
import com.gonuclei.models.bo.UserSubscriptionBo;
import com.gonuclei.services.MailSender;
import com.gonuclei.transactionService.UserSubscriptionTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * The type Mail sender.
 */
@Service
public class MailSenderImpl implements MailSender {

  /**
   * The User subscription transaction service.
   */
  @Autowired
  private UserSubscriptionTransactionService userSubscriptionTransactionService;

  /**
   * The Sender.
   */
  @Autowired
  private JavaMailSender sender;

  /**
   * The Logger.
   */
  private Logger logger = LoggerFactory.getLogger(MailSenderImpl.class);

  /**
   * Send news letter mail boolean.
   *
   * @param emailBo the email bo
   * @return the boolean
   * @throws MailAuthenticationException the mail authentication exception
   */
  @Override
  public boolean sendNewsLetterMail(EmailBo emailBo) throws MailAuthenticationException {

    final boolean status = true;

    List<UserSubscriptionBo> userSubscriptionBoList = userSubscriptionTransactionService
      .getEmailByCategoryAndStatus(emailBo.getCategory(), status);

    if (userSubscriptionBoList.isEmpty()) {
      throw new UserNotFoundException("Can't find any subscribed user for this category!",
        HttpStatus.BAD_REQUEST);
    } else {
      for (UserSubscriptionBo userSubscriptionBo : userSubscriptionBoList) {
        try {
          sendMail(userSubscriptionBo.getEmailId(), emailBo);
        } catch (MessagingException e) {
          logger.error("Could not send email!");
        }
      }
      return true;
    }
  }

  /**
   * Send mail.
   *
   * @param email   the email
   * @param emailBo the email bo
   * @throws MessagingException          the messaging exception
   * @throws MailAuthenticationException the mail authentication exception
   */
  @Override
  public void sendMail(String email, EmailBo emailBo)
    throws MessagingException, MailAuthenticationException {
    MimeMessage mimeMessage = sender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    helper.setTo(email);
    helper.setText(emailBo.getMessage());
    helper.setSubject(emailBo.getCategory() + " update");
    sender.send(mimeMessage);
  }
}
