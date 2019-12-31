package com.gonuclei.Assignment5.service.impl;

import com.gonuclei.Assignment5.bos.ArticleBo;
import com.gonuclei.Assignment5.config.KafkaProducerConfig;
import com.gonuclei.Assignment5.dto.ArticleDto;
import com.gonuclei.Assignment5.exception.SubscriptionNotFound;
import com.gonuclei.Assignment5.transactionService.ArticleTransactionService;
import com.gonuclei.Assignment5.transactionService.SubscriptionTransactionService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    private final KafkaProducer<String, ArticleDto> articleProducer;
    private final SubscriptionTransactionService subscriptionService;
    private final ArticleTransactionService articleService;

    @Autowired
    public PublishService(KafkaProducerConfig producerConfig, SubscriptionTransactionService subscriptionService, ArticleTransactionService articleService) {
        this.articleProducer = new KafkaProducer<>(producerConfig.producerConfigs());
        this.subscriptionService = subscriptionService;
        this.articleService = articleService;
    }

    public void publishArticle(Integer subscriptionId, ArticleBo article) throws SubscriptionNotFound {

        final String kafkaTopic = subscriptionService.getSubscription(subscriptionId).getKafkaTopic();
        final ArticleDto payload = articleService.getArticleDto(article);
        articleProducer.send(new ProducerRecord<>(kafkaTopic, payload));
    }
}
