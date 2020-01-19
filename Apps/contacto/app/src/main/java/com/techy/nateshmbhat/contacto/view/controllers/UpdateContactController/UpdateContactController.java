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
import com.techy.nateshmbhat.contacto.util.ContactWriteUtil;

public class UpdateContactController extends Controller implements UpdateContactContract.View {

    AddContactLayoutBinding binding ;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater , R.layout.add_contact_layout , container , false ) ;
        Contact contact = UpdateContactDataHolder.getInstance().getContact() ;
        binding.btnAddContact.setText("Update Contact") ;
        binding.phoneEditText.setText(contact.getMobileNumber());
        binding.emailEditText.setText(contact.getEmail());
        binding.nameEditText.setText(contact.getFullName());
        binding.companyInfoEditText.setText(contact.getCompanyInfo());
        binding.btnAddContact.setOnClickListener(v -> ContactWriteUtil.writeContactToDevice(contact , getView()));

        return binding.getRoot() ;
    }
}
