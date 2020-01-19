package com.techy.nateshmbhat.contacto.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import com.techy.nateshmbhat.contacto.model.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactReadUtil {
    private static final String TAG = "ContactReadUtil" ;
    final Context context ;

    public ContactReadUtil(Context context) {
        this.context = context ;
    }

    public List<Contact> getContacts() {
        Log.d(TAG, "getContactsUtil: " + Thread.currentThread());
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.Contacts._ID,
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        ContactsContract.Contacts.DISPLAY_NAME,
                        ContactsContract.Contacts.PHOTO_THUMBNAIL_URI,
                        ContactsContract.CommonDataKinds.Email.ADDRESS,
                        ContactsContract.CommonDataKinds.Organization.COMPANY ,
                        },
                null, null, null);
        return parseContacts(c);
    }

    private List<Contact> parseContacts(Cursor cur) {
        List<Contact> contactList = new ArrayList<>();
        try {
            int id = cur.getColumnIndex(ContactsContract.Contacts._ID);
            int mobileNumber = cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            int name = cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            int thumbnail = cur.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI);

            while (cur.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(cur.getString(id));
                contact.setDisplayName(cur.getString(name));
                contact.setFullName(cur.getString(name));
                contact.setMobileNumber(cur.getString(mobileNumber));
                contact.setImageUrl(cur.getString(thumbnail));
                contact.setEmail(getEmailOfContact(contact.getId()));
                contact.setCompanyInfo(getOrganizationInfoFromContact(contact.getId()));

                contactList.add(contact);
            }

        }
        catch (Exception e){
            e.getStackTrace() ;
        }
        finally {
            cur.close();
        }
        return contactList ;
    }

    private  String getEmailOfContact(String contactId){
        Cursor emails = context.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                new String[]{
                        ContactsContract.CommonDataKinds.Email.DATA,
                }, ContactsContract.Contacts._ID + " = " + contactId, null, null);
        String email  = null ;
        while (emails!= null && emails.moveToNext())
        {
            email = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
            break;
        }
        if(emails!=null) emails.close();
        return email ;
    }

    private  String getOrganizationInfoFromContact(String contactId){
        Cursor cur = context.getContentResolver().query(Uri.parse(ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE),
                new String[]{ContactsContract.CommonDataKinds.Organization.COMPANY},
                ContactsContract.Contacts._ID+ " = " + contactId, null, null);
        String company  = null ;
        while (cur!=null && cur.moveToNext())
        {
            company = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.COMPANY));
            break;
        }
        if(cur!=null) cur.close();
        return company ;
    }
}
