package com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.techy.nateshmbhat.contacto.R;
import com.techy.nateshmbhat.contacto.databinding.ContactItemBinding;
import com.techy.nateshmbhat.contacto.model.Contact;
import java.util.List;

public class ContactsListViewAdapter extends ArrayAdapter<Contact> {
    private ContactItemBinding binding= null ;

    public ContactsListViewAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact contact = getItem(position) ;

        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext()) ;
            binding = DataBindingUtil.inflate(inflater,R.layout.contact_item ,parent , false) ;
        }

        binding.contactListItemName.setText(contact.getDisplayName());
        binding.contactListItemMobile.setText(contact.getMobileNumber());
        if(contact.getImageUrl()!=null) binding.contactListItemImage.setImageURI(Uri.parse(contact.getImageUrl()));
        return binding.getRoot();
    }
}
