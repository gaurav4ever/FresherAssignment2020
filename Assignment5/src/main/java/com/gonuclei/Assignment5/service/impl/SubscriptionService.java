package com.gonuclei.Assignment5.service.impl;

import com.gonuclei.Assignment5.exception.SubscriptionNotFound;
import com.gonuclei.Assignment5.bos.SubscriptionBo;
import com.gonuclei.Assignment5.repository.impl.SubscriptionCacheRepository;
import com.gonuclei.Assignment5.repository.MasterSubscriptionRepository;
import com.gonuclei.Assignment5.transactionService.SubscriptionTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SubscriptionService {

    private final MasterSubscriptionRepository databaseRepository;
    private final SubscriptionCacheRepository redisRepo;
    private final SubscriptionTransactionService subscriptionTransaction;

    @Autowired
    public SubscriptionService(MasterSubscriptionRepository databaseRepository, SubscriptionCacheRepository redisRepo, SubscriptionTransactionService subscriptionTransaction){
        this.subscriptionTransaction = subscriptionTransaction;
        this.databaseRepository = databaseRepository;
        this.redisRepo = redisRepo;
    }

    //TODO: Add Redis Logic using Scheduler

    public List<SubscriptionBo> getSubscriptions() {
        List<SubscriptionBo> responseSubscriptions;
        if(redisRepo.isEmpty()){
//            responseSubscriptions =  StreamSupport.stream(databaseRepository.findAll().spliterator(),false)
//                    .collect(Collectors.toList());
            responseSubscriptions = subscriptionTransaction.getAllSubscriptions();
            responseSubscriptions.forEach(subscription -> redisRepo.save(subscription));
            System.out.println("Filled cache from db");
        }else{
            responseSubscriptions = redisRepo.findAll();
        }
        return responseSubscriptions;
    }

    public SubscriptionBo getSubscription(Integer id) throws SubscriptionNotFound {

        SubscriptionBo obtainedSubscription;
        if(redisRepo.hasSubscription(id)){
            obtainedSubscription = redisRepo.findById(id);
        }else {
            obtainedSubscription = subscriptionTransaction.getSubscription(id);
            redisRepo.save(obtainedSubscription);
        }
        return obtainedSubscription;
    }

    public void addSubscription(SubscriptionBo sub){

        subscriptionTransaction.addSubscription(sub);
    }

    public void modifySubscription(SubscriptionBo sub) {

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
        databaseRepository.deleteById(id);
    }

    public void removeAllSubscription() {

        redisRepo.clear();
        databaseRepository.deleteAll();
    }
}
