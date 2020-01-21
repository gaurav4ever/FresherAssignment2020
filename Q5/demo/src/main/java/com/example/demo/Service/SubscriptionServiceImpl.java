package com.example.demo.Service;

import com.example.demo.Model.NewsLetter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private static Map<String, NewsLetter> subscriptionRepo = new HashMap<>();
    static {
        NewsLetter toi = new NewsLetter();
        toi.setId("1");
        toi.setName("Times of India");
        subscriptionRepo.put(toi.getId(), toi);

        NewsLetter ht = new NewsLetter();
        ht.setId("2");
        ht.setName("Hindustan Times");
        subscriptionRepo.put(ht.getId(), ht);
    }

    @Override
    public void createSubscription(NewsLetter newsLetter){
        subscriptionRepo.put(newsLetter.getId(),newsLetter);
    }
    @Override
    public void updateSubscription(String id, NewsLetter newsLetter) {
        subscriptionRepo.remove(id);
        newsLetter.setId(id);
        subscriptionRepo.put(id,newsLetter);
    }
    @Override
    public void deleteSubscription(String id) {
        subscriptionRepo.remove(id);
    }
    @Override
    public Collection<NewsLetter> getSubscriptions(){
        return subscriptionRepo.values();
    }
}
