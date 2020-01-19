package com.techy.nateshmbhat.contacto.view.controllers.UpdateContactController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import com.bluelinelabs.conductor.Controller;
import com.techy.nateshmbhat.contacto.R;
import com.techy.nateshmbhat.contacto.databinding.AddContactLayoutBinding;
import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.presenter.UpdateContactPresenter;

public class UpdateContactController extends Controller implements UpdateContactContract.View {

    AddContactLayoutBinding binding ;
    UpdateContactPresenter presenter ;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater , R.layout.add_contact_layout , container , false ) ;
        Contact contact = UpdateContactDataHolder.getInstance().getContact() ;
        presenter = new UpdateContactPresenter(this) ;
        binding.btnAddContact.setText("Update Contact") ;
        binding.phoneEditText.setText(contact.getMobileNumber());
        binding.emailEditText.setText(contact.getEmail());
        binding.nameEditText.setText(contact.getDisplayName());
        binding.companyInfoEditText.setText(contact.getCompanyInfo());

        binding.btnAddContact.setOnClickListener(v -> {

            Contact newContact = new Contact() ;
            newContact.setDisplayName(binding.nameEditText.getText().toString());
            newContact.setMobileNumber(binding.phoneEditText.getText().toString());
            newContact.setEmail(binding.emailEditText.getText().toString());
            newContact.setCompanyInfo(binding.companyInfoEditText.getText().toString());

            presenter.updateContact(contact , newContact) ;
                }
        );

        return binding.getRoot() ;
    }
}
