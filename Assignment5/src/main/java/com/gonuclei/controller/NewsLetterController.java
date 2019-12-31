package com.gonuclei.controller;

import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.bos.NewsLetterBo;
import com.gonuclei.service.impl.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsLetterController {

    private final NewsLetterService service;

    @Autowired
    public NewsLetterController(NewsLetterService service) {
        this.service = service;
    }

    @GetMapping("/subscriptions")
    public List<NewsLetterBo> getSubscriptions(){
        return service.getSubscriptions();
    }

    @GetMapping("/subscriptions/{id}")
    public NewsLetterBo getSubscription(@PathVariable int id) throws NewsLetterNotFound {
        return service.getSubscription(id);
    }

    @PostMapping("/subscriptions")
    public void addSubscription(@RequestBody NewsLetterBo sub){
        service.addSubscription(sub);
    }

    @PutMapping("/subscriptions/{id}")
    public void modifySubscription(@PathVariable Integer id, @RequestBody NewsLetterBo sub) throws NewsLetterNotFound {
        service.modifySubscription(sub);
    }

    @DeleteMapping("/subscriptions")
    public void removeAllSubscription(){
        service.removeAllSubscription();
    }

    @DeleteMapping("/subscriptions/{id}")
    public void removeSubscription(@PathVariable Integer id) throws NewsLetterNotFound {
        service.removeSubscription(id);
    }
}
