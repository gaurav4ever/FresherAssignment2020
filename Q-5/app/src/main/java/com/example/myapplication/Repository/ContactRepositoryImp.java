package com.example.myapplication.Repository;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.example.myapplication.Model.Contact;
import com.example.myapplication.R;


import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImp implements ContactRepository {

    private Context context;
    List<Contact> contactList;

    public ContactRepositoryImp(Context context) {
        contactList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public Contact getContactFromPhone(Intent data) {

        String lookup = extractLookupFromURI(data.getDataString());

        Cursor newContactCourser = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY + " = ?",
                new String[]{lookup},
                null);

        newContactCourser.moveToNext();

        Contact contact = getContactDataFromCursor(newContactCourser);

        return contact;
    }

    @Override
    public void deleteContactFromPhone(Contact contact) {
        Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, contact.getmLookupKey());
        context.getContentResolver().delete(uri, null, null);
    }

    private String extractLookupFromURI(String dataString) {

        int startIndex = dataString.indexOf("lookup/") + 7;
        int endIndex = dataString.indexOf("/", startIndex);
        return dataString.substring(startIndex, endIndex);

    }

    @Override
    public List<Contact> getContactListFromPhone() {

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor contactsCursor = context.getContentResolver().query(uri, null, null,
                null, null);

        try {
            while (contactsCursor.moveToNext()) {
                Contact contact = getContactDataFromCursor(contactsCursor);
                contactList.add(contact);
            }
        } finally {
            contactsCursor.close();
        }
        return contactList;
    }


    private Contact getContactDataFromCursor(Cursor currentContact) {

        //get name phoneNumber imageUri
        String name = currentContact.getString(currentContact.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        String phoneNumber = currentContact.getString(currentContact.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        String image = (currentContact.getString(currentContact.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI)));
        Uri imageUri;
        if (image == null)
            imageUri = Uri.parse("android.resource://com.example.myapplication/" + R.drawable.user);
        else
            imageUri = Uri.parse(image);


        //get the contact id and lookupKey for editing
        int lookupKeyIndex = currentContact.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY);
        String currentLookupKey = currentContact.getString(lookupKeyIndex);
        int idIndex = currentContact.getColumnIndex(ContactsContract.Contacts._ID);
        long contactId = currentContact.getLong(idIndex);


        //add the contact's attribute to contact object
        Contact contact = new Contact();
        contact.setmFullName(name);
        contact.setmContactNumber(phoneNumber);
        contact.setmContactID(contactId);
        contact.setmLookupKey(currentLookupKey);
        contact.setmImageURI(imageUri);

        return contact;
    }


}
