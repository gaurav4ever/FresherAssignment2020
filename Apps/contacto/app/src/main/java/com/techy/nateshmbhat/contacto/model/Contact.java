package com.techy.nateshmbhat.contacto.model;

import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Contact {

    @NonNull
    @Override
    public String toString() {
        return displayName+" - " + mobileNumber ;
    }

    @PrimaryKey
    @NonNull
    private String id  ;

    private String displayName   ;
    private String email  ;
    private String companyInfo;
    private String mobileNumber  ;

    public void setPropertiesFromContact(Contact contact){
        displayName = contact.getDisplayName();
        email = contact.getEmail() ;
        companyInfo = contact.getCompanyInfo() ;
        mobileNumber = contact.getMobileNumber() ;
    }


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

    public void setId(String id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}