package com.gonuclei.entities;

import com.gonuclei.model.AbstractNewsLetterModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="news_letter")
public class NewsLetterEntity extends AbstractNewsLetterModel {


    @OneToMany(mappedBy = "user_subscriptions", cascade = CascadeType.ALL)
    private Set<SubscriptionEntity> userSubscriptions;

    public NewsLetterEntity() {

    }

    public Set<SubscriptionEntity> getUserSubscriptions() {
        return userSubscriptions;
    }

    public void setUserSubscriptions(Set<SubscriptionEntity> userSubscriptions) {
        this.userSubscriptions = userSubscriptions;
    }
}
