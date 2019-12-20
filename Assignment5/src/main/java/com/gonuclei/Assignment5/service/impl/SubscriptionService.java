package com.gonuclei.Assignment5.service.impl;

import com.gonuclei.Assignment5.exception.SubscriptionNotFound;
import com.gonuclei.Assignment5.model.Subscription;
import com.gonuclei.Assignment5.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;
//    private List<Subscription> subs = new ArrayList<>(Arrays.asList(
//            new Subscription(1, "TOI", "Times of India"),
//            new Subscription(2, "HT", "Hindustan Times"),
//            new Subscription(3, "TH", "The Hindu"),
//            new Subscription(4, "ET", "Economic Times"),
//            new Subscription(5, "BM", "Bloomberg")
//    ));

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> getSubscriptions() {

        return StreamSupport.stream(subscriptionRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Subscription getSubscription(Integer id) throws SubscriptionNotFound {

//        return subs.stream()
//                .filter(topic -> id.equals(topic.getId()))
//                .findFirst()
//                .orElse(null);
        return subscriptionRepository.findById(id).orElseThrow(SubscriptionNotFound::new);

    }

    public void addSubscription(Subscription sub){

        //subs.add(sub);
        subscriptionRepository.save(sub);
    }

    public void modifySubscription(Integer id, Subscription sub) throws SubscriptionNotFound {

//        subs.set(subs.indexOf(subs.stream()
//                .filter( tsub -> id.equals(tsub.getId()))
//                .findFirst()
//                .orElseThrow(SubscriptionNotFound::new)
//        ), sub);
        subscriptionRepository.save(sub);
    }

    public void removeSubscription(Integer id) throws SubscriptionNotFound {

//        subs.remove(subs.stream()
//                .filter( tsub -> id.equals(tsub.getId()))
//                .findFirst()
//                .orElseThrow(SubscriptionNotFound::new)
//        );
        subscriptionRepository.deleteById(id);
    }

    public void removeAllSubscription() {

        //subs.clear();
    }
}
