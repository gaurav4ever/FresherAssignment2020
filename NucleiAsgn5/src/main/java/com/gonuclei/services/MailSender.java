package com.gonuclei.services;

import com.gonuclei.models.bo.EmailBo;

import java.io.IOException;
import javax.mail.MessagingException;

/**
 * The interface Mail sender.
 */
public interface MailSender {

  /**
   * Send news letter mail boolean.
   *
   * @param emailBo the email bo
   * @return the boolean
   * @throws MessagingException the messaging exception
   * @throws IOException        the io exception
   */
  boolean sendNewsLetterMail(EmailBo emailBo) throws MessagingException, IOException;

  /**
   * Send mail.
   *
   * @param email   the email
   * @param emailBo the email bo
   * @throws MessagingException the messaging exception
   */
  void sendMail(String email, EmailBo emailBo) throws MessagingException;
}
