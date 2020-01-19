package com.techy.nateshmbhat.contacto.DataHolder  ;

import com.techy.nateshmbhat.contacto.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    private static List<Contact> contactList ;
    private static DataHolder instance ;
    private DataHolder(){}

    public static DataHolder getInstance(){
        if(instance==null){
            instance = new DataHolder() ;
        }
        if(contactList==null){
            contactList = new ArrayList<Contact>() ;
        }
        return instance ;
    }

    public void setContactList(List<Contact> list) {
        contactList = list;
    }

    public List<Contact> getContactList() {
        return contactList;
    }
}
