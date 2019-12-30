package com.gonuclei.Assignment5.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="user_subscriptions")
public class UserSubscriptionEntity {

    @Id
    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @Id
    @ManyToOne
    @JoinColumn
    private SubscriptionEntity subscription;

    private Date subscriptionEndTime;

    public UserSubscriptionEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSubscriptionEntity)) return false;
        UserSubscriptionEntity that = (UserSubscriptionEntity) o;
        return Objects.equals(user.getId(), that.user.getId()) &&
                Objects.equals(subscription.getId(), that.subscription.getId()) &&
                Objects.equals(subscriptionEndTime, that.subscriptionEndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId(), subscription.getId(), subscriptionEndTime);
    }
}
