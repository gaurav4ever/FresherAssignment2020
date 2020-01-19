package com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController;

import android.app.Activity;
import android.view.View;

import com.techy.nateshmbhat.contacto.model.Contact;

import java.util.List;

public interface ListContactsContract {
    public interface View {
        void setAndUpdateContactListView(List<Contact> list) ;
        void showToast(String msg) ;
        android.view.View getView() ;
        void showDeleteConfirmationDialog(Contact contact) ;
    }
    public interface Presenter{
        void fetchContactsAndPopulateListView(Activity activity) ;
        void deleteContact(Contact contact) ;
    }
}
