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
import com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController.ListContactsContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class ListContactsPresenter implements ListContactsContract.Presenter {
    private static final String TAG = "ListContactsPresenter";
    private ListContactsContract.View view;

    private List<Contact> getContactsUtil(Activity activity) {
        Log.d(TAG, "getContactsUtil: " + Thread.currentThread());
        ContentResolver cr = activity.getContentResolver();
        Cursor c = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.Contacts._ID,
                        ContactsContract.Contacts.NAME_RAW_CONTACT_ID,
                        ContactsContract.Contacts.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        ContactsContract.Contacts.PHOTO_THUMBNAIL_URI,
                        ContactsContract.CommonDataKinds.Email.ADDRESS,
                        ContactsContract.RawContacts.ACCOUNT_TYPE},
                null, null, null);
        return parseContacts(c);
    }

    private List<Contact> parseContacts(Cursor cur) {
            List<Contact> contactList = new ArrayList<>();
            try {
                int id = cur.getColumnIndex(ContactsContract.Contacts._ID);
                int name = cur.getColumnIndex(ContactsContract.Contacts.NAME_RAW_CONTACT_ID);
                int displayName = cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                int mobileNumber = cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                int thumbnail = cur.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI);
                int email = cur.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);
                while (cur.moveToNext()) {
                    Contact contact = new Contact();
                    contact.setId(cur.getString(id));
                    contact.setDisplayName(cur.getString(displayName));
                    contact.setFullName(cur.getString(name));
                    contact.setMobileNumber(cur.getString(mobileNumber));
                    contact.setImageUrl(cur.getString(thumbnail));
                    contact.setEmail(cur.getString(email));
                    contactList.add(contact);
                }
            } finally {
                cur.close();
            }
            return contactList ;
    }

    public void setView(ListContactsContract.View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchContactsAndPopulateListView(Activity activity) {
        Observable.just(activity)
                .subscribeOn(Schedulers.io())
                .map(context->getContactsUtil(context))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((contacts) -> {
                            view.setAndUpdateContactListView(contacts);
                        }
                        , (e) -> {
                            ContactPermissionManager.getInstance().managePermission(activity);
                            Toast.makeText(activity, "Please give permission to see the contacts.", Toast.LENGTH_LONG).show();
                        });
        ;
    }
}
