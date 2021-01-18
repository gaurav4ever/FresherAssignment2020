package com.gonuclei.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Abstract news letter model.
 */
@MappedSuperclass
public abstract class AbstractNewsLetterModel implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="name", nullable = false)
  private String name;

  @Column(name="description")
  private String description;

  @Column(name="kafka_topic_name", nullable = false, unique = true)
  private String kafkaTopic;

  /**
   * Instantiates a new Abstract news letter model.
   */
  public AbstractNewsLetterModel() {
  }

  /**
   * Instantiates a new Abstract news letter model.
   *
   * @param id          the id
   * @param name        the name
   * @param description the description
   * @param kafkaTopic  the kafka topic
   */
  public AbstractNewsLetterModel(Long id, String name, String description, String kafkaTopic) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.kafkaTopic = kafkaTopic;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets kafka topic.
   *
   * @return the kafka topic
   */
  public String getKafkaTopic() {
    return kafkaTopic;
  }

  /**
   * Sets kafka topic.
   *
   * @param kafkaTopic the kafka topic
   */
  public void setKafkaTopic(String kafkaTopic) {
    this.kafkaTopic = kafkaTopic;
  }

}
