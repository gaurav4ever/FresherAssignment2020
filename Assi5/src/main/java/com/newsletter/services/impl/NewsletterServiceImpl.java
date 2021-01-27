package com.newsletter.services.impl;

import com.newsletter.bos.NewsletterBo;
import com.newsletter.services.INewsletterService;
import com.newsletter.services.transactions.impl.NewsletterTransactionServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsletterServiceImpl implements INewsletterService {

  @Autowired
  private static NewsletterTransactionServiceImpl newsletterTransactionService;

  @Override
  public List<NewsletterBo> getAllNewslettersDetails() {
    return newsletterTransactionService.getAllNewslettersDetails();
  }

  @Override
  public void saveNewsletter(NewsletterBo newsletterBo) {
    newsletterTransactionService.saveNewsletter(newsletterBo);
  }

  @Override
  public void editNewsletter(NewsletterBo newsletterBo) {
    newsletterTransactionService.editNewsletter(newsletterBo);
  }

  @Override
  public boolean deleteNewsletter(int id) {
    return newsletterTransactionService.deleteNewsletter(id);
  }

  @Override
  public boolean addContent(int id, NewsletterBo newsletterBo) {
    return newsletterTransactionService.addContent(id, newsletterBo);
  }

  @Override
  public String getContent(int id) {
    return newsletterTransactionService.getContent(id);
  }
}
