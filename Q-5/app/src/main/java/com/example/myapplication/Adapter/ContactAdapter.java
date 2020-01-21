package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Contact;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> mContacts;
    private Context mContext;
    private ContactsHandler contactsHandler;

    /**
     * constructor
     */
    public ContactAdapter(Context context) {
        this.mContacts = new ArrayList<>();
        this.mContext = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //get list of all the views in the item_view layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_view, parent, false);
        ContactViewHolder viewHolder = new ContactViewHolder(listItem, contactsHandler);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bind(mContacts.get(position));
    }


    public void updateAdapter(List<Contact> contactDetails) {
        this.mContacts.clear();
        this.mContacts.addAll(contactDetails);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public void setContactsHandler(ContactsHandler contactsHandler) {
        this.contactsHandler = contactsHandler;
    }


}
