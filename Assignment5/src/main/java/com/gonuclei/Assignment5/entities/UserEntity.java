package com.gonuclei.Assignment5.entities;

import com.gonuclei.Assignment5.model.AbstractUserModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractUserModel {

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<UserSubscriptionEntity> userSubscriptions;
}
