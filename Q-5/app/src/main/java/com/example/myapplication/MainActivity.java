package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "display ";
    private RecyclerView mRecylerView;
    private List<ContactDetails> mContacts;
    private FloatingActionButton mAddNewContact;
    private ContactAdapter mContactAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContacts = new ArrayList<>();
        mRecylerView = findViewById(R.id.recylerView);
        mAddNewContact = findViewById(R.id.floating_action_button);

        mAddNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra("finishActivityOnSaveCompleted", true);
                startActivityForResult(intent, Constants.RESULT_NEW_CONTACT_SAVED);


            }
        });


        //request for the permission to read and write contact
        check_and_requestPermission();


    }

    private void addContactToList(Cursor cursor) {

        String name = cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        String phoneNumber = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));

        //get the contact id and lookupKey for editing
        int lookupKeyIndex = cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY);
        String currentLookupKey = cursor.getString(lookupKeyIndex);
        int idIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID);
        long contactId = cursor.getLong(idIndex);


        ContactDetails contact = new ContactDetails();
        contact.setmFullName(name);
        contact.setmContactNumber(phoneNumber);
        contact.setmContactID(contactId);
        contact.setmLookupKey(currentLookupKey);


        mContacts.add(contact);
    }

    /**
     * method to read contacts
     */

    private void readContact() {
        Uri uri = Phone.CONTENT_URI;

        Cursor contactsCursor = getContentResolver().query(uri, null, null,
                null, null);
        String name, phoneNumber, email, companyInformation;
        ContactDetails contact;
        try {
            while (contactsCursor.moveToNext()) {
                addContactToList(contactsCursor);
            }
        } finally {
            contactsCursor.close();
        }

        mContactAdapter = new ContactAdapter(mContacts, this);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        mRecylerView.setAdapter(mContactAdapter);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the operation is successful
        if (resultCode == RESULT_OK) {

            // if the operation performed is ADD NEW CONTACT
            if (requestCode == Constants.RESULT_NEW_CONTACT_SAVED) {
                //once the new contact is added we need to update the recylerView with new Contact
                // split the intent data to just get the lokup
                String lookup = extractLookupFromIntent(data.getDataString());

                Cursor newContactCourser = getContentResolver().query(Phone.CONTENT_URI,
                        null,
                        Phone.LOOKUP_KEY + " = ?",
                        new String[]{lookup},
                        null);
                newContactCourser.moveToNext();
                addContactToList(newContactCourser);
                mContactAdapter.notifyDataSetChanged();
            }

            // if the operation performed is EDIT CONTACT
            //TODO:get the
        }

    }

    private String extractLookupFromIntent(String dataString) {
        int startIndex = dataString.indexOf("lookup/") + 7;
        int endIndex = dataString.indexOf("/", dataString.indexOf("lookup/") + 7);
        return dataString.substring(startIndex, endIndex);
    }

    /**
     * method to check and request permission from user
     */

    private void check_and_requestPermission() {
        //check if permission is granted or not
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            //request for the grant
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, Constants.MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            readContact();
        }
    }


    /**
     * method to handle the requestPermission
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Constants.MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContact();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }
}
