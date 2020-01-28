package com.example.contacts.view.controller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bluelinelabs.conductor.Controller;
import com.example.contacts.model.constants.Constants;
import com.example.contacts.model.Contact;
import com.example.contacts.presenter.ContactPresenter;
import com.example.contacts.R;
import com.example.contacts.databinding.ContactDetailsBinding;

public class ContactDetailsController extends Controller {
    private Contact mContact;
    private int mContactPosition;
    private ContactPresenter mContactPresenter;
    public static final String CONTACT_KEY = "contact";
    public static final String CONTACT_POSITION_KEY = "contact_position";
    private Activity mParentActivity;
    private ContactListController mContactListController;
    private ContactDetailsBinding mBinding;

    private ContactDetailsController(int position,Contact contact) {
        this(new BundleBuilder(new Bundle())
                .putParcelable(CONTACT_KEY, contact)
                .putInt(CONTACT_POSITION_KEY, position)
                .build());
    }
    public ContactDetailsController(Bundle args) {
        super(args);
        mContact = args.getParcelable(CONTACT_KEY);
        mContactPosition = args.getInt(CONTACT_POSITION_KEY);
    }
    public static ContactDetailsController getInstance(int position,Contact contact) {
        ContactDetailsController contactDetailsController = new ContactDetailsController( position, contact);
        return contactDetailsController;
    }
    public static ContactDetailsController getInstance(Bundle args) {
        ContactDetailsController contactDetailsController = new ContactDetailsController(args);
        return contactDetailsController;
    }


    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        mParentActivity = getActivity();

        Log.e("display contact", "onCreateView: "+ mContact.getmLookupKey() );
        View view = inflater.inflate(R.layout.contact_details,container,false);
        mBinding = ContactDetailsBinding.bind(view);
        mContactPresenter = new ContactPresenter(view.getContext());
        createView(view);
        return view;
    }
    public void update() {
        View view = getView();
        LinearLayout linearLayout = mBinding.contactNumbers;
        linearLayout.removeAllViewsInLayout();
        linearLayout = mBinding.contactEmails;
        linearLayout.removeAllViewsInLayout();
        createView(view);
    }

    @Override
    public boolean handleBack() {
        if(mContactListController!=null)
        {
            mContactListController.onUpdateItem(mContactPosition);
        }
        getRouter().popToRoot();
        return true;
    }

    private void createView(View view) {
        mBinding.contactName.setText(mContact.getmName());
        LinearLayout linearLayout = mBinding.contactNumbers;
        if(mContact.getmImage()!=null)
            mBinding.imageView.setImageURI(Uri.parse(mContact.getmImage()));
        if(!(mContact.getmPhoneNumbers().size()>0)) {
            mBinding.phoneTitle.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
        }
        else {
            for (String number : mContact.getmPhoneNumbers()) {
                TextView tv = new TextView(view.getContext());
                tv.setText(number);
                tv.setTextSize(25);
                tv.setPadding(0, 15, 0, 0);
                linearLayout.addView(tv);
            }
        }
        linearLayout = mBinding.contactEmails;
        if(!(mContact.getmEmail().size()>0)) {
            mBinding.emailTitle.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
        }
        else {
            for (String email : mContact.getmEmail()) {
                TextView tv = new TextView(view.getContext());
                tv.setPadding(0, 15, 0, 0);
                tv.setTextSize(25);
                tv.setText(email);
                linearLayout.addView(tv);
            }
        }
        if("".equals(mContact.getmCompanyInfo())) {
            mBinding.organizationTitle.setVisibility(View.GONE);
            mBinding.contactOrganization.setVisibility(View.GONE);
        }
        else
            mBinding.contactOrganization.setText(mContact.getmCompanyInfo());
        mBinding.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(Intent.ACTION_EDIT);
                Uri selectedContactUri = ContactsContract.Contacts.getLookupUri(mContact.getmId(), mContact.getmLookupKey());
                editIntent.setDataAndType(selectedContactUri, ContactsContract.Contacts.CONTENT_ITEM_TYPE);
                editIntent.putExtra("finishActivityOnSaveCompleted", true);
                startActivityForResult(editIntent, Constants.RESULT_CONTACT_EDITED);
            }
        });
        mBinding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContactPresenter.deleteContact(mContactPosition,mContact.getmLookupKey());
                getRouter().popCurrentController();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == mParentActivity.RESULT_OK) {
            if(requestCode==Constants.RESULT_CONTACT_EDITED) {
                String lookupKey = mContact.getmLookupKey();
                mContact = mContactPresenter.getUpdatedContact(mContactPosition,lookupKey);
                update();
            }
        }
    }

    public void setUpdateContactInListListener(ContactListController contactListController) {
        mContactListController=contactListController;
    }

    interface UpdateContactInListListener{
         void onUpdateItem(int i);
    }
}
