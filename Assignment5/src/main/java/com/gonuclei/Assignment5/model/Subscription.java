package com.gonuclei.Assignment5.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Subscription implements Serializable {

    @Id
    private int id;
    private String name;
    private String Description;

    public Subscription() {
    }

    public Subscription(int id, String name, String description) {
        this.id = id;
        this.name = name;
        Description = description;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
