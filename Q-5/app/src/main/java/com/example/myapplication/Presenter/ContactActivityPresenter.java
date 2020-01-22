package com.example.myapplication.Presenter;

import android.content.Intent;

import com.example.myapplication.View.Controller.ContactListController;
import com.example.myapplication.Model.Contact;
import com.example.myapplication.Permission.PermissionHandler;
import com.example.myapplication.Repository.ContactRepository;


import java.util.List;

public class ContactActivityPresenter {
    private List<Contact> contactList;
    private ContactListController view;
    private ContactRepository repository;

    public ContactActivityPresenter(ContactListController view, ContactRepository repository) {
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


    public void addContactToList(Contact contact) {
        contactList.add(contact);
    }

    public Contact getContact(Intent data) {
        return repository.getContactFromPhone(data);
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

    public void requestPermission() {
        //Permission
        PermissionHandler permissionHandler = new PermissionHandler(view.getActivity());
        permissionHandler.requestPermission();
    }

}
