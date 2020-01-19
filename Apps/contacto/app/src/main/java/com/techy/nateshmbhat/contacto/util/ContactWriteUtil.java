package com.techy.nateshmbhat.contacto.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;

import com.techy.nateshmbhat.contacto.model.Contact;

public class ContactWriteUtil {
    private static View view ;
    private ContactWriteUtil(){}

    private static void insertContactDisplayName(Uri addContactsUri, long rawContactId, String displayName)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);

        // Each contact must has an mime type to avoid java.lang.IllegalArgumentException: mimetype is required error.
        contentValues.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);

        // Put contact display name value.
        contentValues.put(ContactsContract.Contacts.DISPLAY_NAME , displayName);

        view.getContext().getContentResolver().insert(addContactsUri, contentValues);
    }

    private static void insertContactEmail(Uri addContactsUri, long rawContactId, String email)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);

        // Each contact must has an mime type to avoid java.lang.IllegalArgumentException: mimetype is required error.
        contentValues.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);

        contentValues.put(ContactsContract.CommonDataKinds.Email.ADDRESS , email);

        view.getContext().getContentResolver().insert(addContactsUri, contentValues);
    }


    private static void insertContactPhoneNumber(Uri addContactsUri, long rawContactId, String phoneNumber, String phoneTypeStr)
    {
        // Create a ContentValues object.
        ContentValues contentValues = new ContentValues();

        // Each contact must has an id to avoid java.lang.IllegalArgumentException: raw_contact_id is required error.
        contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);

        // Each contact must has an mime type to avoid java.lang.IllegalArgumentException: mimetype is required error.
        contentValues.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);

        // Put phone number value.
        contentValues.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phoneNumber);

        // Calculate phone type by user selection.
        int phoneContactType = ContactsContract.CommonDataKinds.Phone.TYPE_HOME;

        if("home".equalsIgnoreCase(phoneTypeStr))
        {
            phoneContactType = ContactsContract.CommonDataKinds.Phone.TYPE_HOME;
        }else if("mobile".equalsIgnoreCase(phoneTypeStr))
        {
            phoneContactType = ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE;
        }else if("work".equalsIgnoreCase(phoneTypeStr))
        {
            phoneContactType = ContactsContract.CommonDataKinds.Phone.TYPE_WORK;
        }
        // Put phone type value.
        contentValues.put(ContactsContract.CommonDataKinds.Phone.TYPE, phoneContactType);

        // Insert new contact data into phone contact list.
        view.getContext().getContentResolver().insert(addContactsUri, contentValues);
    }

    private static long getRawContactId()
    {
        // Inser an empty contact.
        ContentValues contentValues = new ContentValues();
        Uri rawContactUri = view.getContext().getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, contentValues);
        // Get the newly created contact raw id.
        long ret = ContentUris.parseId(rawContactUri);
        return ret;
    }

    public static void writeContactToDevice(Contact contact, View viewContext){
        view = viewContext ;
        if(contact.getId()==null){
            contact.setId(String.valueOf(getRawContactId()));
        }

        Uri addContactsUri = ContactsContract.Data.CONTENT_URI ;

        // Add an empty contact and get the generated id.
        long rawContactId = getRawContactId();
        insertContactDisplayName(addContactsUri , rawContactId , contact.getFullName());
        insertContactEmail(addContactsUri , rawContactId , contact.getEmail());
        insertContactPhoneNumber(addContactsUri , rawContactId , contact.getMobileNumber() , "work");
    }


    public static void deleteContactFromDevice(Contact contact, View viewContext){
            Uri contactUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(contact.getMobileNumber()));
            ContentResolver cr = viewContext.getContext().getContentResolver() ;
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
