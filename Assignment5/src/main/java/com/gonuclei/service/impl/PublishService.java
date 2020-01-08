package com.gonuclei.service.impl;

import com.gonuclei.config.KafkaProducerConfig;
import com.gonuclei.dto.ArticleDto;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.service.transactions.ArticleTransactionService;
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
    private final ArticleTransactionService articleService;

    /**
     * Instantiates a new Publish service.
     *
     * @param producerConfig      the producer config
     * @param newsLetterTransactionService the subscription service
     * @param articleService      the article service
     */
    @Autowired
    public PublishService(KafkaProducerConfig producerConfig, NewsLetterTransactionService newsLetterTransactionService, ArticleTransactionService articleService) {

        this.articleProducer = new KafkaProducer<>(producerConfig.producerConfigs());
        this.newsLetterTransactionService = newsLetterTransactionService;
        this.articleService = articleService;
    }

    /**
     * Publish article.
     *
     * @param newsLetterId the news letter id
     * @param article      the article
     * @throws NewsLetterNotFound the news letter not found
     */
    public void publishArticle(Long newsLetterId, ArticleDto article) throws NewsLetterNotFound {

        final String kafkaTopic = newsLetterTransactionService.getNewsLetter(newsLetterId).getKafkaTopic();
        //final ArticleDto payload = articleService.getArticleDto(article);
        articleProducer.send(new ProducerRecord<>(kafkaTopic, article));
    }
}
