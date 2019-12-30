package com.gonuclei.Assignment5.repository.impl;

import com.gonuclei.Assignment5.bos.SubscriptionBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SubscriptionCacheRepository {

    public static final String redisKey = "SUBSCRIPTION";
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    @Autowired
    public SubscriptionCacheRepository(RedisTemplate<String, Object> redisTemplate) {

        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void save(SubscriptionBo subscription) {

        hashOperations.put(redisKey, subscription.getId(), subscription);
    }

    public boolean isEmpty() {
        return !redisTemplate.hasKey(redisKey);
    }

    public void update(SubscriptionBo subscription) {
        save(subscription);
    }

    public List<SubscriptionBo> findAll() {

        return (List<SubscriptionBo>)hashOperations.entries(redisKey)
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public void delete(Integer id){

        hashOperations.delete(redisKey, id);
    }

    public SubscriptionBo findById(Integer id) {

        return (SubscriptionBo)hashOperations.get(redisKey, id);
    }

    public boolean hasSubscription(Integer id) {

        return hashOperations.hasKey(redisKey, id);
    }

    public void clear() {

        hashOperations.delete(redisKey, hashOperations.keys(redisKey));
    }
}
