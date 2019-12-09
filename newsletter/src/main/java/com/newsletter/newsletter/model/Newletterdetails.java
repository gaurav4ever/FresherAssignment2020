package com.newsletter.newsletter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Newletterdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float dailyprice;
	private float weeklyprice;
	private String content;
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
	public float getDailyprice() {
		return dailyprice;
	}
	public void setDailyprice(float dailyprice) {
		this.dailyprice = dailyprice;
	}
	public float getWeeklyprice() {
		return weeklyprice;
	}
	public void setWeeklyprice(float weeklyprice) {
		this.weeklyprice = weeklyprice;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
