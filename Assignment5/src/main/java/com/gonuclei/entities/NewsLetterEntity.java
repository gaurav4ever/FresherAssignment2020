package com.gonuclei.entities;

import com.gonuclei.model.AbstractNewsLetterModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * The type News letter entity.
 */
@Entity(name="NewsLetter")
@Table(name="news_letters")
public class NewsLetterEntity extends AbstractNewsLetterModel {


  @OneToMany(mappedBy = "newsLetter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<SubscriptionEntity> userSubscriptionEntities = new HashSet<>();

  /**
   * Instantiates a new News letter entity.
   */
  public NewsLetterEntity() {

  }

  /**
   * Instantiates a new News letter entity.
   *
   * @param id                       the id
   * @param name                     the name
   * @param description              the description
   * @param kafkaTopic               the kafka topic
   * @param userSubscriptionEntities the user subscription entities
   */
  public NewsLetterEntity(Long id, String name, String description, String kafkaTopic, SubscriptionEntity... userSubscriptionEntities) {
    super(id, name, description, kafkaTopic);
    for(SubscriptionEntity subscriptionEntity : userSubscriptionEntities) subscriptionEntity.setNewsLetter(this);
    this.userSubscriptionEntities = Stream.of(userSubscriptionEntities).collect(Collectors.toSet());
  }

  /**
   * Gets user subscription entities.
   *
   * @return the user subscription entities
   */
  public Set<SubscriptionEntity> getUserSubscriptionEntities() {
    return userSubscriptionEntities;
  }

  /**
   * Sets user subscription entities.
   *
   * @param userSubscriptionEntities the user subscription entities
   */
  public void setUserSubscriptionEntities(Set<SubscriptionEntity> userSubscriptionEntities) {
    this.userSubscriptionEntities = userSubscriptionEntities;
  }
}
