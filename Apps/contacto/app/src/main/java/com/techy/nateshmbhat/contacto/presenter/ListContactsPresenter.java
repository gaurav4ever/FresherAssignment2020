package com.techy.nateshmbhat.contacto.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.core.content.PermissionChecker;

import com.bluelinelabs.conductor.Router;
import com.techy.nateshmbhat.contacto.model.Contact;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class ListContactsPresenter {
    private static final String TAG = "ListContactsPresenter";
    private Router router;

    public List<Contact> getContacts(){
        Activity view = router.getActivity() ;

        ContentResolver cr = view.getContentResolver() ;
        Cursor c = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.Contacts._ID,
                        ContactsContract.Contacts.NAME_RAW_CONTACT_ID,
                        ContactsContract.Contacts.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        ContactsContract.Contacts.PHOTO_THUMBNAIL_URI,
                        ContactsContract.RawContacts.ACCOUNT_TYPE},
                ContactsContract.RawContacts.ACCOUNT_TYPE + " <> 'google' ",
                null, null);
        List<Contact> contacts = parseContacts(c);
        for(Contact k : contacts){
            System.out.println(k);
        }
        return contacts ;
    }

    private List<Contact> parseContacts(final Cursor cur) {
            List<Contact> contactList = new ArrayList<>();
            try {
                int id = cur.getColumnIndex(ContactsContract.Contacts._ID);
                int name = cur.getColumnIndex(ContactsContract.Contacts.NAME_RAW_CONTACT_ID);
                int displayName = cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                int mobileNumber = cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                int thumbnail = cur.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI);
                while (cur.moveToNext()) {
                    Contact contact = new Contact();
                    contact.setId(cur.getString(id));
                    contact.setDisplayName(cur.getString(displayName));
                    contact.setFullName(cur.getString(name));
                    contact.setMobileNumber(cur.getString(mobileNumber));
                    contact.setImageUrl(cur.getString(thumbnail));
                    contactList.add(contact);
                }
            } finally {
                cur.close();
            }
            return contactList ;
    }

    public void setRouter(Router router) {
        this.router = router;
    }
}
