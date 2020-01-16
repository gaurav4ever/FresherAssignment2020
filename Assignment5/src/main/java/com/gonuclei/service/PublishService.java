package com.gonuclei.service;

import com.gonuclei.config.KafkaProducerConfig;
import com.gonuclei.dto.ArticleDto;
import com.gonuclei.exception.NewsLetterNotFoundException;
import com.gonuclei.service.transactions.SubscriptionTransactionService;
import com.gonuclei.service.transactions.NewsLetterTransactionService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Publish service.
 */
@Service
public class PublishService {

  private final KafkaProducer<String, ArticleDto> articleProducer;
  private final NewsLetterTransactionService newsLetterTransactionService;
  //private final SubscriptionTransactionService articleService;

  /**
   * Instantiates a new Publish service.
   *
   * @param producerConfig               the producer config
   * @param newsLetterTransactionService the subscription service
   */
  @Autowired
  public PublishService(KafkaProducerConfig producerConfig, NewsLetterTransactionService newsLetterTransactionService) { //}, SubscriptionTransactionService articleService) {

    this.articleProducer = new KafkaProducer<>(producerConfig.producerConfigs());
    this.newsLetterTransactionService = newsLetterTransactionService;
    //this.articleService = articleService;
  }

  /**
   * Publish article.
   *
   * @param newsLetterId the news letter id
   * @param article      the article
   * @throws NewsLetterNotFoundException the news letter not found
   */
  public void publishArticle(Long newsLetterId, ArticleDto article) throws NewsLetterNotFoundException {

    final String kafkaTopic = newsLetterTransactionService.getNewsLetter(newsLetterId).getKafkaTopic();
    //final ArticleDto payload = articleService.getArticleDto(article);
    articleProducer.send(new ProducerRecord<>(kafkaTopic, article));
  }
}
