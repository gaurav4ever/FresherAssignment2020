package com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController;

import android.app.Activity;

import com.techy.nateshmbhat.contacto.model.Contact;

import java.util.List;

public interface ListContactsContract {
    public interface View {
        void setAndUpdateContactListView(List<Contact> list) ;
        void showToast(String msg) ;
    }
    public interface Presenter{
        void fetchContactsAndPopulateListView(Activity activity) ;
    }
}
