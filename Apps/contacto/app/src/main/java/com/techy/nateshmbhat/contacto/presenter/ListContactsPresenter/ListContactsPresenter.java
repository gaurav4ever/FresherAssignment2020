package com.techy.nateshmbhat.contacto.presenter.ListContactsPresenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;
import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.permission.ContactPermissionManager;
import com.techy.nateshmbhat.contacto.util.ContactReadUtil;
import com.techy.nateshmbhat.contacto.util.ContactWriteUtil;
import com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController.ListContactsContract;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ListContactsPresenter implements ListContactsContract.Presenter {
    private static final String TAG = "ListContactsPresenter";
    private ListContactsContract.View view;

    public void setView(ListContactsContract.View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchContactsAndPopulateListView(Activity activity) {
        Observable.just(activity)
                .subscribeOn(Schedulers.io())
                .map(context-> new ContactReadUtil(context).getContacts())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((contacts) -> {
                            view.setAndUpdateContactListView(contacts);
                        }, (e) -> {
                            ContactPermissionManager.getInstance().managePermission(activity);
                            Toast.makeText(activity, "Please give permission to see the contacts.", Toast.LENGTH_LONG).show();
                        });
    }

    @Override
    public void deleteContact(Contact contact) {
        ContactWriteUtil.deleteContactFromDevice(contact , view.getView());
    }
}
