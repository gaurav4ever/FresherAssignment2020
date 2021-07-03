package com.example.myapplication.View.Controller;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.bluelinelabs.conductor.Controller;
import com.example.myapplication.Constants;
import com.example.myapplication.Model.Contact;
import com.example.myapplication.Presenter.ContactActivityPresenter;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ContactDetailsBinding;


import static android.app.Activity.RESULT_OK;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class ContactDetailsController extends Controller {

    private ContactDetailsBinding binding;
    private ContactActivityPresenter presenter;
    private Contact contact;


    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.contact_details, container, false);

        showContact();

        binding.editContactCD.setOnClickListener(c ->
        {
            presenter.deleteContactFromList(contact);
            Intent editIntent = new Intent(Intent.ACTION_EDIT);
            Uri selectedContactUri = ContactsContract.Contacts.getLookupUri(contact.getmContactID(), contact.getmLookupKey());

            editIntent.setDataAndType(selectedContactUri, ContactsContract.Contacts.CONTENT_ITEM_TYPE);
            editIntent.putExtra("finishActivityOnSaveCompleted", true);

            startActivityForResult(editIntent, Constants.RESULT_CONTACT_EDITED);

        });
        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Log.e(TAG, "onActivityResult: fsnmfdnff");
            this.contact = presenter.getContact(data);
            showContact();

        }
    }


    public void passPresenter(ContactActivityPresenter presenter) {

        this.presenter = presenter;
    }

    public void passContact(Contact contact) {
        this.contact = contact;

    }


    public void showContact() {

        clearCacheData();
        binding.contactImageCD.setImageURI(contact.getmImageURI());
        binding.nameCD.setText(contact.getmFullName());
        binding.numberCD.setText(contact.getmContactNumber());
    }

    private void clearCacheData() {
        binding.contactImageCD.setImageURI(null);
        binding.nameCD.setText("");
        binding.numberCD.setText("");
    }
}
