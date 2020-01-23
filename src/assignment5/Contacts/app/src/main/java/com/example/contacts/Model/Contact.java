package com.example.contacts.Model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Parcelable,Comparable<Contact> {
    private String mName, mCompanyInfo, mLookupKey;
    private ArrayList<String> mPhoneNumbers;
    private String mImage;
    private long mId;
    private ArrayList<String> mEmail;

    public Contact(String mName, ArrayList<String> mEmail, String mCompanyInfo, String mLookupKey, ArrayList<String> mPhoneNumbers, String mImage, long mId) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mCompanyInfo = mCompanyInfo;
        this.mLookupKey = mLookupKey;
        this.mPhoneNumbers = mPhoneNumbers;
        this.mImage = mImage;
        this.mId = mId;
    }

    protected Contact(Parcel in) {
        mName = in.readString();
        mCompanyInfo = in.readString();
        mLookupKey = in.readString();
        mPhoneNumbers = in.createStringArrayList();
        mImage = in.readString();
        mId = in.readLong();
        mEmail = in.createStringArrayList();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getmName() {
        return mName;
    }

    public ArrayList<String> getmEmail() {
        return mEmail;
    }

    public String getmCompanyInfo() {
        return mCompanyInfo;
    }

    public String getmLookupKey() {
        return mLookupKey;
    }

    public ArrayList<String> getmPhoneNumbers() {
        return mPhoneNumbers;
    }

    public String getmImage() {
        return mImage;
    }

    public long getmId() {
        return mId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "mName='" + mName + '\'' +
                ", mCompanyInfo='" + mCompanyInfo + '\'' +
                ", mLookupKey='" + mLookupKey + '\'' +
                ", mPhoneNumbers=" + mPhoneNumbers +
                ", mImage='" + mImage + '\'' +
                ", mId='" + mId + '\'' +
                ", mEmail=" + mEmail +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mCompanyInfo);
        dest.writeString(mLookupKey);
        dest.writeStringList(mPhoneNumbers);
        dest.writeString(mImage);
        dest.writeLong(mId);
        dest.writeStringList(mEmail);
    }

    @Override
    public int compareTo(Contact o) {
        return this.getmName().compareTo(o.getmName());
    }
}