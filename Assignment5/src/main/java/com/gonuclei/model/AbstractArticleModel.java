package com.gonuclei.model;

import java.util.Date;

/**
 * The type Abstract article model.
 */
public abstract class AbstractArticleModel {

    private String author;
    private String body;
    private Date publishingDate;
    private String title;

    /**
     * Instantiates a new Abstract article model.
     */
    public AbstractArticleModel() {
    }

    /**
     * Instantiates a new Abstract article model.
     *
     * @param author         the author
     * @param body           the body
     * @param publishingDate the publishing date
     * @param title          the title
     */
    public AbstractArticleModel(String author, String body, Date publishingDate, String title) {
        this.author = author;
        this.body = body;
        this.publishingDate = publishingDate;
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets publishing date.
     *
     * @return the publishing date
     */
    public Date getPublishingDate() {
        return publishingDate;
    }

    /**
     * Sets publishing date.
     *
     * @param publishingDate the publishing date
     */
    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
