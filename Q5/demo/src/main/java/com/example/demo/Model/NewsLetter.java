package com.example.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class NewsLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int newsLetterId;
    private String name;

    public NewsLetter(int newsLetterId, String name) {
        this.newsLetterId = newsLetterId;
        this.name = name;
    }
}
