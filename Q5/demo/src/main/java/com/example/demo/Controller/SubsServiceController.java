package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.Model.NewsLetter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SubsServiceController {
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
        subscriptionRepo.put(ht.getId(),dh);
    }

    @RequestMapping(value = "/subscriptions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete (@PathVariable("id") String id){
        subscriptionRepo.remove(id);
        return new ResponseEntity<>("Product is deleted Successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/subscriptions")
    public ResponseEntity<Object> getSubscription() {
        return new ResponseEntity<>(subscriptionRepo.values(), HttpStatus.OK);
    }
}