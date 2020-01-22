package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Model.Subscription;
import com.example.demo.Repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriptionsController {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @GetMapping("/subscriptions")
    public List<Subscription> index() {
        return subscriptionRepository.findAll();
    }

    @GetMapping("/subscriptions/{id}")
    public Subscription show(@PathVariable String id) throws Exception{
        int subscriptionId = Integer.parseInt(id);
        return subscriptionRepository.findById(subscriptionId).orElseThrow(Exception::new);
    }

    @PostMapping("/subscriptions")
    public Subscription create(@RequestBody Subscription subscription){
//        String name = newsLetter.get("name");
        return subscriptionRepository.save(subscription);
    }

    @DeleteMapping("subscriptions/{id}")
    public String delete(@PathVariable String id){
        int newsLetterId = Integer.parseInt(id);
        subscriptionRepository.deleteById(newsLetterId);
        return "Subscription Deleted";
    }
}
