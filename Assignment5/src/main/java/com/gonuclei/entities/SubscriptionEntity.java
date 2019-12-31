package com.gonuclei.entities;

import com.gonuclei.model.AbstractSubscriptionModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="user_subscriptions")
public class SubscriptionEntity extends AbstractSubscriptionModel {


    public SubscriptionEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriptionEntity)) return false;
        SubscriptionEntity that = (SubscriptionEntity) o;
        return Objects.equals(getUser().getId(), that.getUser().getId()) &&
                Objects.equals(getNewsLetter().getId(), that.getNewsLetter().getId()) &&
                Objects.equals(getSubscriptionEndDate(), that.getSubscriptionEndDate()) &&
                Objects.equals(getSubscriptionBeginDate(), that.getSubscriptionBeginDate()) &&
                Objects.equals(getSubscriptionState(), that.getSubscriptionState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser().getId(), getNewsLetter().getId(), getSubscriptionEndDate(), getSubscriptionBeginDate(), getSubscriptionState() );
    }
}
