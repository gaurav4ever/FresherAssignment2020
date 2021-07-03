package com.example.myapplication.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Contact;
import com.example.myapplication.R;


class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView number;
    private LinearLayout editContact;
    private ImageView profileImage;
    private ImageView deleteContact;
    private EventHandler contactsHandler;

    public ContactViewHolder(@NonNull View itemView, EventHandler eventHandler) {
        super(itemView);
        this.contactsHandler = eventHandler;
        name = itemView.findViewById(R.id.name);
        number = itemView.findViewById(R.id.number);
        editContact = itemView.findViewById(R.id.editContact);
        profileImage = itemView.findViewById(R.id.contactImage);
        deleteContact = itemView.findViewById(R.id.deleteContact);

    }

    public void bind(final Contact contact) {

        name.setText(contact.getmFullName());
        number.setText(contact.getmContactNumber());

        profileImage.setImageURI(null);
        profileImage.setImageURI(contact.getmImageURI());


        deleteContact.setOnClickListener(v -> contactsHandler.onDeleteContactClicked(contact));

        editContact.setOnClickListener(v -> contactsHandler.onShowDetailClicked(contact));
    }
}
