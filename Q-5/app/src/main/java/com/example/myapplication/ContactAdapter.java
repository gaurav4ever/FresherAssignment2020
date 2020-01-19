package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.ContentValues.TAG;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<ContactDetails> mContacts;
    private Context mContext;

    /**
     * constructor
     */
    public ContactAdapter(List<ContactDetails> contacts, Context context) {
        this.mContacts = contacts;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //get list of all the views in the item_view layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ContactDetails contact = mContacts.get(position);
        holder.name.setText(contact.getmFullName());
        holder.number.setText(contact.getmContactNumber());
        holder.editContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(Intent.ACTION_EDIT);

                Log.e(TAG, "onClick: contact.getmLookupKey()" + contact.getmLookupKey());

                Uri selectedContactUri = ContactsContract.Contacts.getLookupUri(contact.getmContactID(), contact.getmLookupKey());
                editIntent.setDataAndType(selectedContactUri, ContactsContract.Contacts.CONTENT_ITEM_TYPE);
                editIntent.putExtra("finishActivityOnSaveCompleted", true);
                Log.e(TAG, "onClick: " + selectedContactUri);
                ((Activity) mContext).startActivityForResult(editIntent, Constants.RESULT_CONTACT_EDITED);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView number;
        public LinearLayout editContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
            editContact = itemView.findViewById(R.id.editContact);
        }
    }
}
