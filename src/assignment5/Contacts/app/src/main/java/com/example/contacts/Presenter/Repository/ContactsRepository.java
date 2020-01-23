package com.example.contacts.Presenter.Repository;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.contacts.Model.Contact;

import java.util.ArrayList;

import io.reactivex.subjects.Subject;

public class ContactsRepository {
    public void getContactList(Context context, Subject<Contact> subject) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null,ContactsContract.Contacts.DISPLAY_NAME + " ASC");
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            long id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String imageUri = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
            String lookupKey = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
            Cursor organizationCursor = contentResolver.query(ContactsContract.Data.CONTENT_URI, null, ContactsContract.CommonDataKinds.Organization.CONTACT_ID + " = ?", new String[]{id + ""}, null);
            organizationCursor.moveToNext();
            organizationCursor.moveToNext();
            String organizationName = "";//organizationCursor.getString(organizationCursor.getColumnIndex(ContactsContract.CommonDataKinds.Organization.DATA));
            organizationCursor.close();
            Cursor phoneCursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id + ""}, null);
            ArrayList<String> phoneNumbers = new ArrayList<String>();
            while (phoneCursor.moveToNext()) {
                phoneNumbers.add(phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
            }
            phoneCursor.close();
            Cursor emailCursor = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?", new String[]{id + ""}, null);
            ArrayList<String> emails = new ArrayList<String>();
            while (emailCursor.moveToNext()) {
                emails.add(emailCursor.getString(emailCursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA)));
            }
            emailCursor.close();
            Contact contact = new Contact(name, emails, organizationName, lookupKey, phoneNumbers, imageUri, id);
            subject.onNext(contact);
        }
        cursor.close();
        subject.onComplete();
    }
    public Contact getContact(String lookupKey,Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, ContactsContract.Contacts.LOOKUP_KEY + " = ?", new String[] {lookupKey}, null);
        cursor.moveToNext();
        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        long id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
        String imageUri = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
        Cursor organizationCursor = contentResolver.query(ContactsContract.Data.CONTENT_URI, null, ContactsContract.CommonDataKinds.Organization.CONTACT_ID + " = ?", new String[]{id + ""}, null);
        organizationCursor.moveToNext();
        organizationCursor.moveToNext();
        String organizationName = "";//organizationCursor.getString(organizationCursor.getColumnIndex(ContactsContract.CommonDataKinds.Organization.DATA));
        organizationCursor.close();
        Cursor phoneCursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id + ""}, null);
        ArrayList<String> phoneNumbers = new ArrayList<String>();
        while (phoneCursor.moveToNext()) {
            phoneNumbers.add(phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
        }
        phoneCursor.close();
        Cursor emailCursor = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?", new String[]{id + ""}, null);
        ArrayList<String> emails = new ArrayList<String>();
        while (emailCursor.moveToNext()) {
            emails.add(emailCursor.getString(emailCursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA)));
        }
        emailCursor.close();
        Contact contact = new Contact(name, emails, organizationName, lookupKey, phoneNumbers, imageUri, id);
        cursor.close();
        return contact;
    }
    public void deleteContact(String lookupKey, Context context)
    {
        Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, lookupKey);
        context.getContentResolver().delete(uri, null, null);
    }
}
