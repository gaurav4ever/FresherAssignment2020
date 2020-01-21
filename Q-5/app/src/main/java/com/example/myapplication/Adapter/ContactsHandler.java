package com.example.myapplication.Adapter;

import com.example.myapplication.Model.Contact;

public interface ContactsHandler {
    void onDeleteContactClicked(Contact contact);

    void onEditContactClicked(Contact contact);
}
