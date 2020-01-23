package com.example.contacts.View;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contacts.Model.Contact;
import com.example.contacts.R;
import com.example.contacts.databinding.ContactDetailsBinding;
import com.example.contacts.databinding.ContactDetailsBindingImpl;

public class ContactsAdapterViewHolder extends RecyclerView.ViewHolder {
    private TextView mContactName, mContactNumber;
    private ImageView mContactImage;
    private LinearLayout mContactView;
    private ListItemEvenHandler mEventHandler;

    private ContactsAdapterViewHolder(@NonNull View view, ListItemEvenHandler eventHandler) {
        super(view);
        mContactName = (TextView) view.findViewById(R.id.contactName);
        mContactNumber = (TextView) view.findViewById(R.id.contactNumber);
        mContactImage = view.findViewById(R.id.contactImage);
        mContactView = view.findViewById(R.id.contactView);
        this.mEventHandler = eventHandler;
    }
    public static ContactsAdapterViewHolder getInstance(@NonNull View view, ListItemEvenHandler eventHandler) {
        ContactsAdapterViewHolder contactsAdapterViewHolder = new ContactsAdapterViewHolder(view, eventHandler);
        return contactsAdapterViewHolder;

    }
    public void setName(String name) {
        mContactName.setText(name);
    }
    public void setNumber (String number) {
        mContactNumber.setText(number);
    }
    public void setImage(Uri uri) {
        mContactImage.setImageURI(uri);
    }
    public void setImage(int id) {
        mContactImage.setImageResource(id);
    }
    public void setViewClickListener(final int position,final Contact contact) {
        mContactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventHandler.onContactClicked(position,contact);
            }
        });
    }
    public interface ListItemEvenHandler {
        public void onContactClicked(int position,Contact contact);
    }
}
