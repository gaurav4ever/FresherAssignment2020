package com.gonuclei.repository.impl;

import com.gonuclei.bos.NewsLetterBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NewsLetterCacheRepository {

    public static final String redisKey = "SUBSCRIPTION";
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    @Autowired
    public NewsLetterCacheRepository(RedisTemplate<String, Object> redisTemplate) {

        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void save(NewsLetterBo subscription) {

        hashOperations.put(redisKey, subscription.getId(), subscription);
    }

    public boolean isEmpty() {
        return !redisTemplate.hasKey(redisKey);
    }

    public void update(NewsLetterBo subscription) {
        save(subscription);
    }

    public List<NewsLetterBo> findAll() {

        return (List<NewsLetterBo>)hashOperations.entries(redisKey)
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public void delete(Integer id){

        hashOperations.delete(redisKey, id);
    }

    public NewsLetterBo findById(Integer id) {

        return (NewsLetterBo)hashOperations.get(redisKey, id);
    }

    public boolean hasSubscription(Integer id) {

        return hashOperations.hasKey(redisKey, id);
    }

    public void clear() {

        hashOperations.delete(redisKey, hashOperations.keys(redisKey));
    }
}
