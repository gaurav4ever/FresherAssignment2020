package com.gonuclei.Assignment5.repository;

import com.gonuclei.Assignment5.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SubscriptionCacheRepository {

    private RedisTemplate<String, Subscription> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public SubscriptionCacheRepository(RedisTemplate<String, Subscription> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(Subscription subscription) {
        hashOperations.put("SUBSCRIPTION", subscription.getId(), subscription);
    }

    public void update(Subscription subscription) {
        save(subscription);
    }

    public Map<Integer, Subscription> findAll() {
        return hashOperations.entries("SUBSCRIPTION");
    }

    public void delete(Integer id){
        hashOperations.delete("USER", id);
    }

    public Subscription findById(Integer id) {
        return (Subscription)hashOperations.get("SUBSCRIPTION", id);
    }

    public boolean hasSubscription(Integer id) {
        return hashOperations.hasKey("SUBSCRIPTION", id);
    }
}
