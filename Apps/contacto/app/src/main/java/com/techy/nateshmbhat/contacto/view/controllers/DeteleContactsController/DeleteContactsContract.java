package com.techy.nateshmbhat.contacto.view.controllers.DeteleContactsController;

import android.content.Context;
import android.view.View;

import com.techy.nateshmbhat.contacto.model.Contact;

public interface DeleteContactsContract {
    interface View{
        android.view.View getView() ;
    }
    interface Presenter{
       void deleteContact(Contact contact )  ;

    }
}
