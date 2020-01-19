package com.techy.nateshmbhat.contacto.util;

import com.techy.nateshmbhat.contacto.DataHolder.DataHolder;
import com.techy.nateshmbhat.contacto.model.Contact;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ContactUtil {
    public static void addContact(Contact contact) {
        List<Contact> contactList = DataHolder.getInstance().getContactList();
        contactList.add(contact);
    }

    public static List<Contact> readContacts() {
        List<Contact> contactList = DataHolder.getInstance().getContactList();
        return contactList;
    }

    public static void updateContact(String contactId, Contact newContact) {
        List<Contact> contactList = DataHolder.getInstance().getContactList();
        for(Contact contact : contactList){
            if(contact.getId()==contactId){
                contact.setPropertiesFromContact(newContact);
            }
        }
    }

    public static void deleteContact(Contact contact) {
        List<Contact> contactList = DataHolder.getInstance().getContactList();
        contactList.remove(contact) ;
    }
}
