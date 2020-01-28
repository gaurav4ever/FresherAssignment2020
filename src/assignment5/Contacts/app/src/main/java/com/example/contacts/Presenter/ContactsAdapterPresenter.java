package com.example.contacts.presenter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contacts.model.Contact;
import com.example.contacts.R;
import com.example.contacts.view.ContactsAdapterViewHolder;

import java.util.ArrayList;

public class ContactsAdapterPresenter extends RecyclerView.Adapter<ContactsAdapterViewHolder> {
    private ArrayList<Contact> mContacts;
    private ContactsAdapterViewHolder.ListItemEvenHandler mEvenHandler;
    public ContactsAdapterPresenter(ArrayList<Contact> contacts, ContactsAdapterViewHolder.ListItemEvenHandler evenHandler) {
        mContacts = contacts;
        this.mEvenHandler = evenHandler;
    }
    @Override
    public void onBindViewHolder(@NonNull ContactsAdapterViewHolder holder, int position) {
        final Contact contact = mContacts.get(position);
        holder.setName(contact.getmName());
        String phoneNumber="";
        if(contact.getmPhoneNumbers().size()>0) {
            phoneNumber = contact.getmPhoneNumbers().get(0);
        }
        holder.setNumber(phoneNumber);

        holder.setImage(R.drawable.user_icon);
        if((contact.getmImage()!=null)) {
            holder.setImage(null);
            holder.setImage(Uri.parse(contact.getmImage()));
        }
        holder.setViewClickListener(position,contact);

    }
    @NonNull
    @Override
    public ContactsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //get list of all the views in the contact_view layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.contact_view, parent, false);
        ContactsAdapterViewHolder viewHolder = ContactsAdapterViewHolder.getInstance(listItem, mEvenHandler);
        return viewHolder;
    }
    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
