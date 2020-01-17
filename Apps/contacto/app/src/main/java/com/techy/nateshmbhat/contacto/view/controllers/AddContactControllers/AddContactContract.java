package com.techy.nateshmbhat.contacto.view.controllers.AddContactControllers;

import android.content.Context;
import com.techy.nateshmbhat.contacto.model.Contact;

public interface AddContactContract {
    public interface View{
        Contact createContactFromView();
    }
    public  interface  Presenter {
        void writeContactToDevice(Contact contact);
    }
}
