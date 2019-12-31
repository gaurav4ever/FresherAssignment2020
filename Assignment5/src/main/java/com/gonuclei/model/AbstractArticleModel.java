package com.gonuclei.model;

import java.util.Date;

public abstract class AbstractArticleModel {

    private String author;
    private String body;
    private Date publishingDate;
    private String title;

    public AbstractArticleModel() {
    }

    public AbstractArticleModel(String author, String body, Date publishingDate, String title) {
        this.author = author;
        this.body = body;
        this.publishingDate = publishingDate;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
