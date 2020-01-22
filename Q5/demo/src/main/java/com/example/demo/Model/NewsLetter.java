package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.web.bind.annotation.*;


@Entity
public class NewsLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String name;

    public NewsLetter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public NewsLetter(int id) {
        this.id = id;
    }

    public NewsLetter(String name) {
        this.name = name;
    }

    public NewsLetter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
