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

@Entity(name="User")
@Table(name = "users")
public class UserEntity extends AbstractUserModel {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<SubscriptionEntity> userSubscriptionEntities = new HashSet<>();

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String address, String email, SubscriptionEntity... userSubscriptionEntities) {
        super(id, name, address, email);
        for(SubscriptionEntity subscriptionEntity : userSubscriptionEntities) subscriptionEntity.setUser(this);
        this.userSubscriptionEntities = Stream.of(userSubscriptionEntities).collect(Collectors.toSet());
    }

    public Set<SubscriptionEntity> getUserSubscriptionEntities() {
        return userSubscriptionEntities;
    }

    public void setUserSubscriptionEntities(Set<SubscriptionEntity> userSubscriptionEntities) {
        this.userSubscriptionEntities = userSubscriptionEntities;
    }
}
