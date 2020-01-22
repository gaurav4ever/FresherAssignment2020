package com.example.myapplication.Presenter;


import android.content.Intent;

import com.example.myapplication.Model.Contact;
import com.example.myapplication.Repository.ContactRepository;
import com.example.myapplication.View.ContactActivityView;

import java.util.List;

public class ContactActivityPresenter {
    private List<Contact> contactList;
    private ContactActivityView view;
    private ContactRepository repository;

    public ContactActivityPresenter(ContactActivityView view, ContactRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loadContacts() {
        contactList = repository.getContactListFromPhone();

        if (contactList.size() == 0)
            view.displayNoContacts();
        else
            view.displayContact(contactList);

    }


    public void addContactToList(Intent data) {

        Contact contact = repository.getContactFromPhone(data);
        contactList.add(contact);

    }




    public List<Contact> getContactlist() {
        return contactList;
    }

    public void deleteContact(Contact contact) {
        repository.deleteContactFromPhone(contact);
        contactList.remove(contact);
    }


    public void deleteContactFromList(Contact contact) {
        contactList.remove(contact);
    }
}
