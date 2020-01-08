package com.gonuclei.controller;

import com.gonuclei.dto.ArticleDto;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.service.impl.PublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Article controller.
 */
@RestController
public class ArticleController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class.getName());
    private final PublishService publishService;

    /**
     * Instantiates a new Article controller.
     *
     * @param publishService the publish service
     */
    @Autowired
    public ArticleController(PublishService publishService) {
        this.publishService = publishService;
    }

    /**
     * Publish article.
     *
     * @param subscriptionId the subscription id
     * @param article        the article
     */
    @PostMapping("/subscriptions/{subscriptionId}/articles")
    public void publishArticle(@PathVariable long subscriptionId, @RequestBody ArticleDto article) {

        try {
            publishService.publishArticle(subscriptionId, article);
        } catch (NewsLetterNotFound newsLetterNotFound) {
            LOGGER.error("Subscription Not Found");
        }
    }
}
