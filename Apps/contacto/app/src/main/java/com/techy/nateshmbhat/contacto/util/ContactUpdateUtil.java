package com.techy.nateshmbhat.contacto.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import com.techy.nateshmbhat.contacto.model.Contact;

import static pub.devrel.easypermissions.RationaleDialogFragment.TAG;

public class ContactUpdateUtil {
    private static long getRawContactIdByName(String displayName, Context context)
    {
        ContentResolver contentResolver =  context.getContentResolver();

        // Query raw_contacts table by display name field ( given_name family_name ) to get raw contact id.

        // Create query column array.
        String queryColumnArr[] = {ContactsContract.RawContacts._ID};

        // Create where condition clause.
        String whereClause = ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY + " = '" + displayName + "'";

        // Query raw contact id through RawContacts uri.
        Uri rawContactUri = ContactsContract.RawContacts.CONTENT_URI;

        // Return the query cursor.
        Cursor cursor = contentResolver.query(rawContactUri, queryColumnArr, whereClause, null, null);

        long rawContactId = -1;

        if(cursor!=null)
        {
            // Get contact count that has same display name, generally it should be one.
            int queryResultCount = cursor.getCount();
            // This check is used to avoid cursor index out of bounds exception. android.database.CursorIndexOutOfBoundsException
            if(queryResultCount > 0)
            {
                // Move to the first row in the result cursor.
                cursor.moveToFirst();
                // Get raw_contact_id.
                rawContactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.RawContacts._ID));
            }
        }

        return rawContactId;
    }

    public static void updateContactByName( Contact oldContact , Contact newContact , Context context)
    {
        int ret = 0;

        ContentResolver contentResolver = context.getContentResolver();

        // Get raw contact id by display name.
        long rawContactId = getRawContactIdByName(oldContact.getDisplayName() , context);

        if(rawContactId>-1){
            ContactAddUtil.writeContactToDevice(newContact , context );
        }
        else{
            Log.d(TAG, "updateContactByName: " + "Contact with " + oldContact + " not found !" );
        }
    }
}
