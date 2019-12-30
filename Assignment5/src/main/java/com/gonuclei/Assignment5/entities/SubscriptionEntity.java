package com.gonuclei.Assignment5.entities;

import com.gonuclei.Assignment5.model.AbstractSubscriptionModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="subscriptions")
public class SubscriptionEntity extends AbstractSubscriptionModel {


    @OneToMany(mappedBy = "subscriptions", cascade = CascadeType.ALL)
    private Set<UserSubscriptionEntity> userSubscriptions;

    public SubscriptionEntity() {

    }


}
