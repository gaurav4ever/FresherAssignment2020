package com.example.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Subscription")
@Getter @Setter @NoArgsConstructor
public class Subscription {
    @Id
    int subscriptionId;
    int userId;
    String userName;
    int newsLetterId;
    String newsLetterName;

    public Subscription(int subscriptionId, int userId, String userName, int newsLetterId, String newsLetterName) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.userName = userName;
        this.newsLetterId = newsLetterId;
        this.newsLetterName = newsLetterName;
    }



}
