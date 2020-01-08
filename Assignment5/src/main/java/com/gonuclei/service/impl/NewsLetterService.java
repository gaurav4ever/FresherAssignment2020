package com.gonuclei.service.impl;

import com.gonuclei.dto.NewsLetterDto;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.repository.impl.NewsLetterCacheRepository;
import com.gonuclei.repository.MasterNewsLetterRepository;
import com.gonuclei.service.transactions.NewsLetterTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type News letter service.
 */
@Service
public class NewsLetterService {

    private final MasterNewsLetterRepository databaseRepository;
    private final NewsLetterCacheRepository redisRepo;
    private final NewsLetterTransactionService subscriptionTransaction;

    /**
     * Instantiates a new News letter service.
     *
     * @param databaseRepository      the database repository
     * @param redisRepo               the redis repo
     * @param subscriptionTransaction the subscription transaction
     */
    @Autowired
    public NewsLetterService(MasterNewsLetterRepository databaseRepository, NewsLetterCacheRepository redisRepo, NewsLetterTransactionService subscriptionTransaction){
        this.subscriptionTransaction = subscriptionTransaction;
        this.databaseRepository = databaseRepository;
        this.redisRepo = redisRepo;
    }

    //TODO: Add Redis Logic using Scheduler

    /**
     * Gets subscriptions.
     *
     * @return the subscriptions
     */
    public List<NewsLetterDto> getNewsLetters() {
        List<NewsLetterDto> responseSubscriptions;
        if(redisRepo.isEmpty()){
            responseSubscriptions = subscriptionTransaction.getAllNewsLetters();
            responseSubscriptions.forEach(redisRepo::save);
            System.out.println("Filled cache from db");
        }else{
            responseSubscriptions = redisRepo.findAll();
        }
        return responseSubscriptions;
    }

    /**
     * Gets subscription.
     *
     * @param id the id
     * @return the subscription
     * @throws NewsLetterNotFound the news letter not found
     */
    public NewsLetterDto getNewsLetter(Long id) throws NewsLetterNotFound {

        NewsLetterDto newsLetter;
        if(redisRepo.hasSubscription(id)){
            newsLetter = redisRepo.findById(id);
        }else {
            newsLetter = subscriptionTransaction.getNewsLetter(id);
            redisRepo.save(newsLetter);
        }
        return newsLetter;
    }

    /**
     * Add subscription.
     *
     * @param sub the sub
     */
    public void addNewsLetter(NewsLetterDto sub){

        subscriptionTransaction.addNewsLetter(sub);
    }

    /**
     * Modify subscription.
     *
     * @param sub the sub
     */
    public void modifyNewsLetter(NewsLetterDto sub) {

//        subs.set(subs.indexOf(subs.stream()
//                .filter( tsub -> id.equals(tsub.getId()))
//                .findFirst()
//                .orElseThrow(SubscriptionNotFound::new)
//        ), sub);
        //TODO: Modify this method for proper implementation
        subscriptionTransaction.addNewsLetter(sub);
    }

    /**
     * Remove subscription.
     *
     * @param id the id
     */
    public void removeNewsLetter(Long id) {

//        subs.remove(subs.stream()
//                .filter( tsub -> id.equals(tsub.getId()))
//                .findFirst()
//                .orElseThrow(SubscriptionNotFound::new)
//        );
        redisRepo.delete(id);
        //TODO: Modify this service
        databaseRepository.deleteById(id);
    }

    /**
     * Remove all subscription.
     */
    public void removeAllNewsLetters() {

        redisRepo.clear();
        //TODO: Modify this service
        //databaseRepository.deleteAll();
    }
}
