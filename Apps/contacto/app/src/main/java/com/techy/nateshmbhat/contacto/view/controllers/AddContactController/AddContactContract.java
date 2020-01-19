package com.techy.nateshmbhat.contacto.view.controllers.AddContactController;

import com.techy.nateshmbhat.contacto.model.Contact;

public interface AddContactContract {
    public interface View{
        Contact createContactFromView();
    }
    public  interface  Presenter {
        void addContact(Contact contact);
    }
}
