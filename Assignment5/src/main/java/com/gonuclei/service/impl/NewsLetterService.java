package com.gonuclei.service.impl;

import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.bos.NewsLetterBo;
import com.gonuclei.repository.impl.NewsLetterCacheRepository;
import com.gonuclei.repository.MasterNewsLetterRepository;
import com.gonuclei.service.transactions.NewsLetterTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLetterService {

    private final MasterNewsLetterRepository databaseRepository;
    private final NewsLetterCacheRepository redisRepo;
    private final NewsLetterTransactionService subscriptionTransaction;

    @Autowired
    public NewsLetterService(MasterNewsLetterRepository databaseRepository, NewsLetterCacheRepository redisRepo, NewsLetterTransactionService subscriptionTransaction){
        this.subscriptionTransaction = subscriptionTransaction;
        this.databaseRepository = databaseRepository;
        this.redisRepo = redisRepo;
    }

    //TODO: Add Redis Logic using Scheduler

    public List<NewsLetterBo> getSubscriptions() {
        List<NewsLetterBo> responseSubscriptions;
        if(redisRepo.isEmpty()){
//            responseSubscriptions =  StreamSupport.stream(databaseRepository.findAll().spliterator(),false)
//                    .collect(Collectors.toList());
            responseSubscriptions = subscriptionTransaction.getAllSubscriptions();
//          responseSubscriptions.forEach(subscription -> redisRepo.save(subscription));
            responseSubscriptions.forEach(redisRepo::save);
            System.out.println("Filled cache from db");
        }else{
            responseSubscriptions = redisRepo.findAll();
        }
        return responseSubscriptions;
    }

    public NewsLetterBo getSubscription(Integer id) throws NewsLetterNotFound {

        NewsLetterBo obtainedSubscription;
        if(redisRepo.hasSubscription(id)){
            obtainedSubscription = redisRepo.findById(id);
        }else {
            obtainedSubscription = subscriptionTransaction.getSubscription(id);
            redisRepo.save(obtainedSubscription);
        }
        return obtainedSubscription;
    }

    public void addSubscription(NewsLetterBo sub){

        subscriptionTransaction.addSubscription(sub);
    }

    public void modifySubscription(NewsLetterBo sub) {

//        subs.set(subs.indexOf(subs.stream()
//                .filter( tsub -> id.equals(tsub.getId()))
//                .findFirst()
//                .orElseThrow(SubscriptionNotFound::new)
//        ), sub);
        //TODO: Modify this method for proper implementation
        subscriptionTransaction.addSubscription(sub);
    }

    public void removeSubscription(Integer id) {

//        subs.remove(subs.stream()
//                .filter( tsub -> id.equals(tsub.getId()))
//                .findFirst()
//                .orElseThrow(SubscriptionNotFound::new)
//        );
        redisRepo.delete(id);
        //TODO: Modify this service
        databaseRepository.deleteById(id);
    }

    public void removeAllSubscription() {

        redisRepo.clear();
        //TODO: Modify this service
        databaseRepository.deleteAll();
    }
}
