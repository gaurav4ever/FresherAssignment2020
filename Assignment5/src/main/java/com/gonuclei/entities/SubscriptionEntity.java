package com.gonuclei.entities;

import com.gonuclei.model.AbstractSubscriptionModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="user_subscriptions")
public class SubscriptionEntity extends AbstractSubscriptionModel {

    @Id
    @ManyToOne
    @JoinColumn
    private NewsLetterEntity newsLetter;

    @Id
    @ManyToOne
    @JoinColumn
    private UserEntity user;

    public SubscriptionEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriptionEntity)) return false;
        SubscriptionEntity that = (SubscriptionEntity) o;
        return Objects.equals(user.getId(), that.user.getId()) &&
                Objects.equals(newsLetter.getId(), that.newsLetter.getId()) &&
                Objects.equals(getSubscriptionEndDate(), that.getSubscriptionEndDate()) &&
                Objects.equals(getSubscriptionBeginDate(), that.getSubscriptionBeginDate()) &&
                Objects.equals(getSubscriptionState(), that.getSubscriptionState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId(), newsLetter.getId(), getSubscriptionEndDate(), getSubscriptionBeginDate(), getSubscriptionState() );
    }
}
