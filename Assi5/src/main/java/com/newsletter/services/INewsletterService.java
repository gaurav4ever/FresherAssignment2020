package com.newsletter.services;

import com.newsletter.bos.NewsletterBo;
import java.util.List;

public interface INewsletterService {

  List<NewsletterBo> getAllNewslettersDetails();

  void saveNewsletter(NewsletterBo dto);

  void editNewsletter(NewsletterBo dto);

  boolean deleteNewsletter(int id);

  boolean addContent(int id, NewsletterBo dto);

  String getContent(int id);
}
