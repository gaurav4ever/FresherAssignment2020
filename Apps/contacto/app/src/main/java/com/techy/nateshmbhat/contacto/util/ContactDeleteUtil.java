package com.techy.nateshmbhat.contacto.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.techy.nateshmbhat.contacto.model.Contact;

public class ContactDeleteUtil {
    public static void deleteContactFromDevice(Contact contact, Context context){
        Uri contactUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(contact.getMobileNumber()));
        ContentResolver cr = context.getContentResolver() ;
        Cursor cur = cr.query(contactUri, null, null, null, null);
        try {
            if (cur.moveToFirst()) {
                do {
                    if (cur.getString(cur.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME)).equalsIgnoreCase(contact.getDisplayName())) {
                        String lookupKey = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
                        Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, lookupKey);
                        cr.delete(uri, null, null);
                    }
                } while (cur.moveToNext());
            }

        } catch (Exception e) {
            e.printStackTrace() ;
        } finally {
            cur.close();
        }
    }
}
