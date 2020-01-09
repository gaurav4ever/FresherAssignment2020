package com.gonuclei.entities;

import com.gonuclei.model.AbstractUserModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type User entity.
 */
@Entity(name="User")
@Table(name = "users")
public class UserEntity extends AbstractUserModel {

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<SubscriptionEntity> userSubscriptionEntities = new HashSet<>();

  /**
   * Instantiates a new User entity.
   */
  public UserEntity() {
  }

  /**
   * Instantiates a new User entity.
   *
   * @param id                       the id
   * @param name                     the name
   * @param address                  the address
   * @param email                    the email
   * @param userSubscriptionEntities the user subscription entities
   */
  public UserEntity(Long id, String name, String address, String email, SubscriptionEntity... userSubscriptionEntities) {
    super(id, name, address, email);
    for(SubscriptionEntity subscriptionEntity : userSubscriptionEntities) subscriptionEntity.setUser(this);
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
