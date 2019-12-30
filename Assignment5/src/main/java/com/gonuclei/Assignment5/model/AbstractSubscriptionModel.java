package com.gonuclei.Assignment5.model;

import com.gonuclei.Assignment5.entities.UserSubscriptionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class AbstractSubscriptionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="kafka-topic-name", nullable = false, unique = true)
    private String kafkaTopic;


    public AbstractSubscriptionModel() {

    }

    public AbstractSubscriptionModel(Long id, String name, String description, String kafkaTopic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.kafkaTopic = kafkaTopic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKafkaTopic() {
        return kafkaTopic;
    }

    public void setKafkaTopic(String kafkaTopic) {
        this.kafkaTopic = kafkaTopic;
    }

}
