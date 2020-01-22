package com.example.demo.Model;

import javax.persistence.*;

import java.util.Set;


@Entity
public class NewsLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int newsLetterId;
    private String name;

//    @ManyToMany
//    Set<User> subscribers;
//
////    @ManyToMany (mappedBy = "subscribers")
////    Set<User> subscriptions;
////    @OneToMany(mappedBy = "userId")
//    Set<Subscription> subscriptions;

    public NewsLetter(int newsLetterId, String name) {
        this.newsLetterId = newsLetterId;
        this.name = name;
    }

    public NewsLetter(int newsLetterId) {
        this.newsLetterId = newsLetterId;
    }

    public NewsLetter(String name) {
        this.name = name;
    }

    public NewsLetter() {
    }

    public int getNewsLetterId() {
        return newsLetterId;
    }

    public void setNewsLetterId(int newsLetterId) {
        this.newsLetterId = newsLetterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
