package com.example.myapplication.Model;


import android.net.Uri;

public class Contact {
    private String mFullName;
    private String mContactNumber;
    private String mEmail;
    private String mCompanyInformation;
    private Uri mImageURI;
    private long mContactID;
    private String mLookupKey;

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public String getmContactNumber() {
        return mContactNumber;
    }

    public long getmContactID() {
        return mContactID;
    }

    public void setmContactID(long mContactID) {
        this.mContactID = mContactID;
    }

    public String getmLookupKey() {
        return mLookupKey;
    }

    public void setmLookupKey(String mLookupKey) {
        this.mLookupKey = mLookupKey;
    }

    public void setmContactNumber(String mContactNumber) {
        this.mContactNumber = mContactNumber;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmCompanyInformation() {
        return mCompanyInformation;
    }

    public void setmCompanyInformation(String mCompanyInformation) {
        this.mCompanyInformation = mCompanyInformation;
    }

    public Uri getmImageURI() {
        return mImageURI;
    }

    public void setmImageURI(Uri mImageURI) {
        this.mImageURI = mImageURI;
    }

    public long getContactID() {
        return mContactID;
    }


}
