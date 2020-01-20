package com.techy.nateshmbhat.contacto.presenter.ListContactsPresenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.permission.ContactPermissionManager;
import com.techy.nateshmbhat.contacto.util.ContactUtil;
import com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController.ListContactsContract;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ListContactsPresenter implements ListContactsContract.Presenter {
    private static final String TAG = "ListContactsPresenter";
    private ListContactsContract.View view;

    public ListContactsPresenter(@NonNull  ListContactsContract.View view) {
        this.view = view;
    }

    public void setView(ListContactsContract.View view) {
        this.view = view;
    }


    @Override
    public void fetchContactsAndPopulateListView(Activity activity) {
        ContactUtil.readContacts(view.getView().getContext())
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(contacts -> {
                            view.setAndUpdateContactListView(contacts);
                        },
                        e -> {
                            ContactPermissionManager.getInstance().managePermission(activity);
                            Toast.makeText(activity, "Please give permission to see the contacts.", Toast.LENGTH_LONG).show();
                        }
                );
        ;
    }

    @Override
    public void deleteContact(Contact contact) {
        ContactUtil.deleteContact(view.getView().getContext(), contact);
    }
}
