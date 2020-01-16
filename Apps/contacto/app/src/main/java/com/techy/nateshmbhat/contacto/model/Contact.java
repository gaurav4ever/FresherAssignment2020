package com.techy.nateshmbhat.contacto.model;

public class Contact {

    private String id ;
    private String displayName ;
    private String fullName ;
    private String mobileNumber ;
    private String imageUrl ;

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
