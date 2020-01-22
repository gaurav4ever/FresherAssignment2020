package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Constants;
import com.example.myapplication.Model.Contact;
import com.example.myapplication.Permission.PermissionCallback;
import com.example.myapplication.Permission.PermissionHandler;
import com.example.myapplication.Presenter.ContactActivityPresenter;
import com.example.myapplication.R;
import com.example.myapplication.Repository.ContactRepository;
import com.example.myapplication.Repository.ContactRepositoryImp;
import com.example.myapplication.Adapter.ContactAdapter;
import com.example.myapplication.Adapter.ContactsHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactActivityView, PermissionCallback, ContactsHandler {

    private static final String TAG = "display ";
    private RecyclerView mRecylerView;
    private FloatingActionButton mAddNewContact;
    private ContactAdapter mContactAdapter;
    private ContactActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecylerView = findViewById(R.id.recylerView);
        mAddNewContact = findViewById(R.id.floating_action_button);

        //Repository
        ContactRepository repository = new ContactRepositoryImp(this);

        //presenter
        presenter = new ContactActivityPresenter(this, repository);

        //Permission
        PermissionHandler permissionHandler = new PermissionHandler(this);
        permissionHandler.requestPermission();


        //Adding new contact
        mAddNewContact.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            intent.putExtra("finishActivityOnSaveCompleted", true);
            startActivityForResult(intent, Constants.RESULT_NEW_CONTACT_SAVED);

        });


    }

    /**
     * permission callback
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case Constants.MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    presenter.loadContacts();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    /**
     * Intent result call back
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the operation is successful
        if (resultCode == RESULT_OK) {
            
            presenter.addContactToList(data);
            List<Contact> contactList = presenter.getContactlist();
            mContactAdapter.updateAdapter(contactList);

        }


    }


    @Override
    public void displayContact(List<Contact> contacts) {

        mContactAdapter = new ContactAdapter(this);
        mContactAdapter.setContactsHandler(this);
        mContactAdapter.updateAdapter(contacts);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        mRecylerView.setAdapter(mContactAdapter);

    }

    @Override
    public void displayNoContacts() {
        Toast.makeText(this, "there is no Contact to display", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPermissionGrant() {
        presenter.loadContacts();
    }


    @Override
    public void onDeleteContactClicked(Contact contact) {
        presenter.deleteContact(contact);
        List<Contact> contactList = presenter.getContactlist();
        mContactAdapter.updateAdapter(contactList);
    }

    @Override
    public void onEditContactClicked(Contact contact) {

        presenter.deleteContactFromList(contact);
        Intent editIntent = new Intent(Intent.ACTION_EDIT);
        Uri selectedContactUri = ContactsContract.Contacts.getLookupUri(contact.getmContactID(), contact.getmLookupKey());
        Log.e(TAG, "before editing" + selectedContactUri);
        editIntent.setDataAndType(selectedContactUri, ContactsContract.Contacts.CONTENT_ITEM_TYPE);
        editIntent.putExtra("finishActivityOnSaveCompleted", true);

        startActivityForResult(editIntent, Constants.RESULT_CONTACT_EDITED);
    }
}
