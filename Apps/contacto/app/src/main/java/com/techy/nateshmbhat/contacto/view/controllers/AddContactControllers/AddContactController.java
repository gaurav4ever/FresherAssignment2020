package com.techy.nateshmbhat.contacto.view.controllers.AddContactControllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.bluelinelabs.conductor.Controller;
import com.techy.nateshmbhat.contacto.R;
import com.techy.nateshmbhat.contacto.databinding.AddContactLayoutBinding;
import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.presenter.AddContactPresenter.AddContactPresenter;
import pub.devrel.easypermissions.EasyPermissions;

public class AddContactController extends Controller implements AddContactContract.View {

    private AddContactLayoutBinding viewBinding;
    private AddContactPresenter presenter;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.add_contact_layout, container, false);
        presenter = new AddContactPresenter(viewBinding.getRoot());

        viewBinding.btnAddContact.setOnClickListener(v -> {
                    presenter.writeContactToDevice(
                           createContactFromView()
                    );
                }
        );
        return viewBinding.getRoot();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public Contact createContactFromView() {
        Contact contact = new Contact();
        contact.setFullName(viewBinding.nameEditText.getText().toString());
        contact.setDisplayName(viewBinding.companyInfoEditText.getText().toString());
        contact.setMobileNumber(viewBinding.phoneEditText.getText().toString());
        contact.setEmail(viewBinding.emailEditText.getText().toString());
        return contact ;
    }
}

