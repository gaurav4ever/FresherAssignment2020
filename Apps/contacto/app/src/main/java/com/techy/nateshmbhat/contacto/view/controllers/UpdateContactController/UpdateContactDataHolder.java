package com.techy.nateshmbhat.contacto.view.controllers.UpdateContactController;

import com.techy.nateshmbhat.contacto.model.Contact;

public class UpdateContactDataHolder {
    private Contact contact ;
    private UpdateContactDataHolder(){} ;
    private static UpdateContactDataHolder instance ;

    public static UpdateContactDataHolder getInstance(){
        if(instance==null){
            instance= new UpdateContactDataHolder() ;
        }
        return instance ;
    }

    public  Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact ;
    }
}