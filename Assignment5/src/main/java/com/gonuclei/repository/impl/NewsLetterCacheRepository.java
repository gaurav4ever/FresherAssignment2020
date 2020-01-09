package com.gonuclei.repository.impl;

import com.gonuclei.dto.NewsLetterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type News letter cache repository.
 */
@Repository
public class NewsLetterCacheRepository {

  /**
   * The constant redisKey.
   */
  public static final String redisKey = "SUBSCRIPTION";
  private HashOperations hashOperations;
  private RedisTemplate redisTemplate;

  /**
   * Instantiates a new News letter cache repository.
   *
   * @param redisTemplate the redis template
   */
  @Autowired
  public NewsLetterCacheRepository(RedisTemplate<String, Object> redisTemplate) {

    this.hashOperations = redisTemplate.opsForHash();
    this.redisTemplate = redisTemplate;
  }

  /**
   * Save.
   *
   * @param newsLetterDto the newsLetterDto
   */
  public void save(NewsLetterDto newsLetterDto) {

    hashOperations.put(redisKey, newsLetterDto.getId(), newsLetterDto);
  }

  /**
   * Is empty boolean.
   *
   * @return the boolean
   */
  public boolean isEmpty() {
    return !redisTemplate.hasKey(redisKey);
  }

  /**
   * Update.
   *
   * @param subscription the subscription
   */
  public void update(NewsLetterDto subscription) {
    save(subscription);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<NewsLetterDto> findAll() {

    return (List<NewsLetterDto>)hashOperations.entries(redisKey)
        .values()
        .stream()
        .collect(Collectors.toList());
  }

  /**
   * Delete.
   *
   * @param id the id
   */
  public void delete(Long id){

    hashOperations.delete(redisKey, id);
  }

  /**
   * Find by id news letter bo.
   *
   * @param id the id
   * @return the news letter bo
   */
  public NewsLetterDto findById(Long id) {

    return (NewsLetterDto)hashOperations.get(redisKey, id);
  }

  /**
   * Has subscription boolean.
   *
   * @param id the id
   * @return the boolean
   */
  public boolean hasSubscription(Long id) {

    return hashOperations.hasKey(redisKey, id);
  }

  /**
   * Clear.
   */
  public void clear() {

    hashOperations.delete(redisKey, hashOperations.keys(redisKey));
  }
}
