package com.example.demo.Service;

import com.example.demo.Model.NewsLetter;

import java.util.Collection;

public interface SubscriptionService {
    public abstract void createSubscription(NewsLetter newsLetter);
    public abstract void updateSubscription(String id, NewsLetter newsLetter);
    public abstract void deleteSubscription(String id);
    public abstract Collection<NewsLetter> getSubscriptions();
}
