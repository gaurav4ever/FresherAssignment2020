package com.gonuclei.Assignment5.controller;

import com.gonuclei.Assignment5.exception.SubscriptionNotFound;
import com.gonuclei.Assignment5.bos.SubscriptionBo;
import com.gonuclei.Assignment5.service.impl.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private final SubscriptionService service;

    @Autowired
    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionBo> getSubscriptions(){
        return service.getSubscriptions();
    }

    @GetMapping("/subscriptions/{id}")
    public SubscriptionBo getSubscription(@PathVariable int id) throws SubscriptionNotFound {
        return service.getSubscription(id);
    }

    @PostMapping("/subscriptions")
    public void addSubscription(@RequestBody SubscriptionBo sub){
        service.addSubscription(sub);
    }

    @PutMapping("/subscriptions/{id}")
    public void modifySubscription(@PathVariable Integer id, @RequestBody SubscriptionBo sub) throws SubscriptionNotFound {
        service.modifySubscription(sub);
    }

    @DeleteMapping("/subscriptions")
    public void removeAllSubscription(){
        service.removeAllSubscription();
    }

    @DeleteMapping("/subscriptions/{id}")
    public void removeSubscription(@PathVariable Integer id) throws SubscriptionNotFound {
        service.removeSubscription(id);
    }
}
