package com.example.myapplication.Repository;

import android.content.Intent;

import com.example.myapplication.Model.Contact;

import java.util.List;

public interface ContactRepository {

    List<Contact> getContactListFromPhone();

    Contact getContactFromPhone(Intent data);

    void deleteContactFromPhone(Contact contact);
}
