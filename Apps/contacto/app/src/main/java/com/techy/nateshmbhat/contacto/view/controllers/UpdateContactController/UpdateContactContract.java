package com.techy.nateshmbhat.contacto.view.controllers.UpdateContactController;
import com.techy.nateshmbhat.contacto.model.Contact;

public interface UpdateContactContract {
    interface View{
        android.view.View getView()  ;
    }
    interface Presenter{
        void updateContact(Contact oldContact , Contact newContact) ;
    }
}
