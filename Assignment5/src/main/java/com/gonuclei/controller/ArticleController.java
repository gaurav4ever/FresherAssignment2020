package com.gonuclei.controller;

import com.gonuclei.bos.ArticleBo;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.service.impl.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ArticleController {

    private final Logger logger;
    private final PublishService publishService;

    @Autowired
    public ArticleController(PublishService publishService) {
        this.publishService = publishService;
        this.logger =  Logger.getLogger(ArticleController.class.getName());
    }

    @PostMapping("/subscriptions/{subscriptionId}/articles")
    public void publishArticle(@PathVariable Integer subscriptionId, @RequestBody ArticleBo article) {

        try {
            publishService.publishArticle(subscriptionId, article);
        } catch (NewsLetterNotFound newsLetterNotFound) {
            this.logger.log(Level.WARNING, "Subscription Not Found");
        }
    }
}
