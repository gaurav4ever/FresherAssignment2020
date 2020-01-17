package com.techy.nateshmbhat.contacto.util;

import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;

import com.techy.nateshmbhat.contacto.model.Contact;

public class ContactUtil {
    private static View view ;
    private ContactUtil(){}

    private static void insertContactDisplayName(Uri addContactsUri, long rawContactId, String displayName)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);

        // Each contact must has an mime type to avoid java.lang.IllegalArgumentException: mimetype is required error.
        contentValues.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);

        // Put contact display name value.
        contentValues.put(ContactsContract.Contacts.NAME_RAW_CONTACT_ID , displayName);

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

}
