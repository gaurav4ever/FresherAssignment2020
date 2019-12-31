package com.gonuclei.entities;

import com.gonuclei.model.AbstractNewsLetterModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="subscriptions")
public class NewsLetterEntity extends AbstractNewsLetterModel {


    @OneToMany(mappedBy = "subscriptions", cascade = CascadeType.ALL)
    private Set<SubscriptionEntity> userSubscriptions;

    public NewsLetterEntity() {

    }


}
