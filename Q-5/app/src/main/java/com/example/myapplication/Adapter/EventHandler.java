package com.example.myapplication.Adapter;

import com.example.myapplication.Model.Contact;

public interface EventHandler {
    void onDeleteContactClicked(Contact contact);

    void onShowDetailClicked(Contact contact);
}
