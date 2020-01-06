package com.gonuclei.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractNewsLetterModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="news_letter_name", nullable = false)
    private String name;

    @Column(name="news_letter_description")
    private String description;

    @Column(name="news_letter_kafka_topic_name", nullable = false, unique = true)
    private String kafkaTopic;


    public AbstractNewsLetterModel() {

    }

    public AbstractNewsLetterModel(Long id, String name, String description, String kafkaTopic) {
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
