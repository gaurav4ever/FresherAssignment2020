package com.techy.nateshmbhat.contacto.model;

import androidx.annotation.NonNull;

public class Contact {

    @NonNull
    @Override
    public String toString() {
        return displayName+" - " + mobileNumber ;
    }

    private String id  ;   
    private String displayName   ; 
    private String email  ; 
    private String companyInfo;
    private String mobileNumber  ; 
    private String imageUrl  ; 


    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
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

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
