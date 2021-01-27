package com.newsletter.services.transactions.impl;

import com.newsletter.bos.NewsletterBo;
import com.newsletter.dao.NewsletterRepository;
import com.newsletter.entities.NewsletterEntity;
import com.newsletter.mappers.NewsletterObjectMapper;
import com.newsletter.models.NewsletterModel;
import com.newsletter.services.INewsletterService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public class NewsletterTransactionServiceImpl implements INewsletterService {

  @Autowired
  private static NewsletterRepository newsletterRepository;

  @Autowired
  private static NewsletterObjectMapper newsletterObjectMapper;

  @Override
  public List<NewsletterBo> getAllNewslettersDetails() {
    return newsletterObjectMapper.subscriptionBoFromEntityList(newsletterRepository.findAll());
  }

  @Override
  public void saveNewsletter(NewsletterBo newsletterBo) {
    NewsletterEntity newsletter = new NewsletterEntity();
    newsletter.setName(newsletterBo.getName());
    newsletter.setContent(newsletterBo.getContent());
    newsletter.setDailyprice(newsletterBo.getDailyprice());
    newsletter.setWeeklyprice(newsletterBo.getWeeklyprice());
    newsletterRepository.save(newsletter);
  }

  @Override
  public void editNewsletter(NewsletterBo dto) {
    NewsletterEntity newsletter = null;
    List<NewsletterEntity> l = newsletterRepository.findAll();
    for (NewsletterEntity e : l) {
      if (e.getId() == dto.getId()) {
        newsletter = e;
        break;
      }
    }
    if (newsletter == null) {
      saveNewsletter(dto);
    } else {
      newsletter.setContent(dto.getContent());
      newsletter.setName(dto.getName());
      newsletter.setDailyprice(dto.getDailyprice());
      newsletter.setWeeklyprice(dto.getWeeklyprice());
      newsletterRepository.save(newsletter);
    }
  }

  @Override
  public boolean deleteNewsletter(int id) {
    List<NewsletterEntity> l = newsletterRepository.findAll();
    for (NewsletterModel e : l) {
      if (e.getId() == id) {
        newsletterRepository.deleteById(id);
        return true;
      }
    }
    //0 if id not found
    return false;
  }

  @Override
  public boolean addContent(int id, NewsletterBo newsletterBo) {
    try {
      Optional<NewsletterEntity> newsletterId = newsletterRepository.findById(id);
      if (newsletterId.isPresent()) {
        NewsletterEntity newletter = newsletterId.get();
        newletter.setContent(newsletterBo.getContent());
        newsletterRepository.save(newletter);
      }

      return true;
    } catch (Exception e) {
      return false;
    }

  }

  @Override
  public String getContent(int id) {
    Optional<NewsletterEntity> newsletter = newsletterRepository.findById(id);
    if (newsletter.isPresent()) {
      NewsletterEntity newl = newsletter.get();
      return newl.getContent();
    }
    return null;
  }
}
