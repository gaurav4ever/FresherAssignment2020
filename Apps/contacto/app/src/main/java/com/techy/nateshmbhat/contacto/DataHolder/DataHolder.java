package com.techy.nateshmbhat.contacto.DataHolder  ;

import com.techy.nateshmbhat.contacto.model.Contact;
import java.util.List;

public class DataHolder {

    private List<Contact> contactList ;
    private DataHolder(){}

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }
}
