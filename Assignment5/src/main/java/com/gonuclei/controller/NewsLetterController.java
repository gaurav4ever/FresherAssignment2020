package com.gonuclei.controller;

import com.gonuclei.dto.NewsLetterDto;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.service.impl.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type News letter controller.
 */
@RestController
public class NewsLetterController {

    private final NewsLetterService newsLetterService;

    /**
     * Instantiates a new News letter controller.
     *
     * @param newsLetterService the service
     */
    @Autowired
    public NewsLetterController(NewsLetterService newsLetterService) {
        this.newsLetterService = newsLetterService;
    }

    /**
     * Get subscriptions list.
     *
     * @return the list
     */
    @GetMapping("/news-letters")
    public List<NewsLetterDto> getNewsLetters(){
        return newsLetterService.getNewsLetters();
    }

    /**
     * Gets subscription.
     *
     * @param id the id
     * @return the subscription
     * @throws NewsLetterNotFound the news letter not found
     */
    @GetMapping("/news-letters/{id}")
    public NewsLetterDto getNewsLetter(@PathVariable long id) throws NewsLetterNotFound {
        return newsLetterService.getNewsLetter(id);
    }

    /**
     * Add subscription.
     *
     * @param newsLetter the news letter
     */
    @PostMapping("/news-letters")
    public void addNewsLetter(@RequestBody NewsLetterDto newsLetter){
        newsLetterService.addNewsLetter(newsLetter);
    }

    /**
     * Modify subscription.
     *
     * @param id         the id
     * @param newsLetter the news letter
     * @throws NewsLetterNotFound the news letter not found
     */
    @PutMapping("/news-letters/{id}")
    public void modifyNewsLetter(@PathVariable Integer id, @RequestBody NewsLetterDto newsLetter) throws NewsLetterNotFound {
        newsLetterService.modifyNewsLetter(newsLetter);
    }

    /**
     * Remove all subscription.
     */
    @DeleteMapping("/news-letters")
    public void removeAllNewsLetter(){
        newsLetterService.removeAllNewsLetters();
    }

    /**
     * Remove subscription.
     *
     * @param id the id
     * @throws NewsLetterNotFound the news letter not found
     */
    @DeleteMapping("/news-letters/{id}")
    public void removeNewsLetter(@PathVariable long id) throws NewsLetterNotFound {
        newsLetterService.removeNewsLetter(id);
    }
}
