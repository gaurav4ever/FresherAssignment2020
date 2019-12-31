package com.gonuclei.entities;

import com.gonuclei.model.AbstractUserModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractUserModel {

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<SubscriptionEntity> userSubscriptions;
}
