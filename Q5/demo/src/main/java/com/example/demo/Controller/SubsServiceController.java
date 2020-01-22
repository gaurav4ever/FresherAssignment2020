package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.Model.NewsLetter;
import com.example.demo.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Exception.SubscriptionNotFoundException;
import com.example.demo.Model.NewsLetter;

@RestController
public class SubsServiceController {
    @Autowired
    SubscriptionService subscriptionService;

    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }

    private static Map<String, NewsLetter> subscriptionRepo = new HashMap<>();
    static {
        NewsLetter toi = new NewsLetter();
        toi.setId("1");
        toi.setName("Times of India");
        subscriptionRepo.put(toi.getId(),toi);

        NewsLetter ht = new NewsLetter();
        ht.setId("2");
        ht.setName("Hindustan Times");
        subscriptionRepo.put(ht.getId(),ht);

        NewsLetter dh = new NewsLetter();
        dh.setId("3");
        dh.setName("Deccan Herald");
        subscriptionRepo.put(dh.getId(),dh);
    }

    @RequestMapping(value = "/subscriptions")
    public ResponseEntity<Object> getSubscription() {
        return new ResponseEntity<>(subscriptionService.getSubscriptions(), HttpStatus.OK);
    }

    @RequestMapping(value = "/subscriptions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubscription (@PathVariable("id") String id){
        subscriptionRepo.remove(id);
        return new ResponseEntity<>("NewsLetter is deleted Successfully", HttpStatus.OK);
    }

//    @RequestMapping(value = "/subscriptions")
//    public ResponseEntity<Object> getSubscription() {
//        return new ResponseEntity<>(subscriptionRepo.values(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/subscriptions/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSubscription(@PathVariable("id") String id, @RequestBody NewsLetter newsLetter) {
        if(!subscriptionRepo.containsKey(id)) throw new SubscriptionNotFoundException();
        subscriptionRepo.remove(id);
        newsLetter.setId(id);
        subscriptionRepo.put(id, newsLetter);
        return new ResponseEntity<>("Newsletterr is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/subscriptions", method = RequestMethod.POST)
    public ResponseEntity<Object> createSubscription(@RequestBody NewsLetter newsLetter) {
        subscriptionRepo.put(newsLetter.getId(),newsLetter);
        return new ResponseEntity<>("Newsletter created Successfully",HttpStatus.OK);
    }

}
