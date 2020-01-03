package com.gonuclei.service.impl;

import com.gonuclei.bos.ArticleBo;
import com.gonuclei.config.KafkaProducerConfig;
import com.gonuclei.dto.ArticleDto;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.service.transactions.ArticleTransactionService;
import com.gonuclei.service.transactions.NewsLetterTransactionService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    private final KafkaProducer<String, ArticleDto> articleProducer;
    private final NewsLetterTransactionService subscriptionService;
    private final ArticleTransactionService articleService;

    @Autowired
    public PublishService(KafkaProducerConfig producerConfig, NewsLetterTransactionService subscriptionService, ArticleTransactionService articleService) {

        this.articleProducer = new KafkaProducer<>(producerConfig.producerConfigs());
        this.subscriptionService = subscriptionService;
        this.articleService = articleService;
    }

    public void publishArticle(Integer subscriptionId, ArticleBo article) throws NewsLetterNotFound {

        final String kafkaTopic = subscriptionService.getSubscription(subscriptionId).getKafkaTopic();
        final ArticleDto payload = articleService.getArticleDto(article);
        articleProducer.send(new ProducerRecord<>(kafkaTopic, payload));
    }
}
