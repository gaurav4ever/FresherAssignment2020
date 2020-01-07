package com.gonuclei.entities;

import com.gonuclei.model.AbstractNewsLetterModel;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity(name="NewsLetter")
@Table(name="news_letters")
public class NewsLetterEntity extends AbstractNewsLetterModel {


    @OneToMany(mappedBy = "newsLetter", cascade = CascadeType.ALL)
    private Set<SubscriptionEntity> userSubscriptionEntities = new HashSet<>();

    public NewsLetterEntity() {

    }

    public NewsLetterEntity(Long id, String name, String description, String kafkaTopic, SubscriptionEntity... userSubscriptionEntities) {
        super(id, name, description, kafkaTopic);
        for(SubscriptionEntity subscriptionEntity : userSubscriptionEntities) subscriptionEntity.setNewsLetter(this);
        this.userSubscriptionEntities = Stream.of(userSubscriptionEntities).collect(Collectors.toSet());
    }

    public Set<SubscriptionEntity> getUserSubscriptionEntities() {
        return userSubscriptionEntities;
    }

    public void setUserSubscriptionEntities(Set<SubscriptionEntity> userSubscriptionEntities) {
        this.userSubscriptionEntities = userSubscriptionEntities;
    }
}
