package com.techy.nateshmbhat.contacto.util;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.techy.nateshmbhat.contacto.database.ContactDatabaseProvider;
import com.techy.nateshmbhat.contacto.model.Contact;

import java.util.List;

import io.reactivex.Observable;

public class ContactUtil {
    private static final String TAG = "ContactUtil";

    public static void addContact(Context context, Contact contact) {
        new Thread(() -> {
            ContactDatabaseProvider.getInstance(context).contactDao().insert(contact);
            ;
        }).start();
    }

    public static Observable<List<Contact>> readContacts(Context context) {
        return Observable.just(ContactDatabaseProvider.getInstance(context))
                .map(obj -> {
                    Log.d(TAG, "readContacts: " + Thread.currentThread().getName());
                    return obj.contactDao().getAll();
                });
    }

    public static void updateContact(Context context, Contact newContact) {
        new Thread(() -> {
            ContactDatabaseProvider.getInstance(context).contactDao().update(newContact);
        }).start();
    }

    public static void deleteContact(Context context, Contact contact) {
        new Thread(() -> {
            ContactDatabaseProvider.getInstance(context).contactDao().delete(contact);
        }).start();
    }

    public static Observable<Contact> searchContactById(Context context, String id) {
        return Observable.just(ContactDatabaseProvider.getInstance(context))
                .map(obj -> {
                    Log.d(TAG, "searchContactById: " + Thread.currentThread().getName());
                    return obj.contactDao().findById(id);
                });
    }
}
