package com.example.myapplication.View;

import com.example.myapplication.Model.Contact;

import java.util.List;

public interface ContactActivityView {

    void displayContact(List<Contact> contacts);

    void displayNoContacts();

}
