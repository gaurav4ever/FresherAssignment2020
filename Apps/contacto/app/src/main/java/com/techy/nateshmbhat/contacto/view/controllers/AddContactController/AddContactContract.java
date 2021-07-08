package com.techy.nateshmbhat.contacto.view.controllers.AddContactController;

import android.view.View;

import com.techy.nateshmbhat.contacto.model.Contact;

public interface AddContactContract {
    public interface View{
        Contact createContactFromView();
        android.view.View getView() ;
    }
    public  interface  Presenter {
        void addContact(Contact contact);
    }
}
