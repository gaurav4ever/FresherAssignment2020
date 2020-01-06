package com.newsletter.services.transactions;

import com.newsletter.bos.NewsletterBo;
import com.newsletter.entities.NewsletterEntity;
import java.util.List;

public interface INewsletterTransactionService {

  List<NewsletterEntity> getAllNewslettersDetails();

  void saveNewsletter(NewsletterBo dto);

  void editNewsletter(NewsletterBo dto);

  boolean deleteNewsletter(int id);

  boolean addContent(int id, NewsletterBo dto);

  String getContent(int id);
}
