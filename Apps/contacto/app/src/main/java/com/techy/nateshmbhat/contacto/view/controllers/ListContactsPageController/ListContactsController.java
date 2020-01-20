package com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController;

import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler;
import com.techy.nateshmbhat.contacto.R;
import com.techy.nateshmbhat.contacto.constant.AppConstant;
import com.techy.nateshmbhat.contacto.databinding.ListContactsLayoutBinding;
import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.presenter.ListContactsPresenter.ListContactsPresenter;
import com.techy.nateshmbhat.contacto.util.ViewUtil;
import com.techy.nateshmbhat.contacto.view.controllers.AddContactController.AddContactController;
import com.techy.nateshmbhat.contacto.view.controllers.UpdateContactController.UpdateContactController;
import com.techy.nateshmbhat.contacto.view.controllers.UpdateContactController.UpdateContactDataHolder;

import java.util.ArrayList;
import java.util.List;

public class ListContactsController extends Controller implements ListContactsContract.View  {
    private static final String TAG = "ListContactsController";
    private ListContactsLayoutBinding viewBinding;
    private ContactsListViewAdapter contactsArrayAdapter;
    private ListContactsPresenter presenter;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        presenter = new ListContactsPresenter(this);
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.list_contacts_layout, container, false);
        viewBinding.btnAddContact.setOnClickListener(v ->
                getRouter().pushController(RouterTransaction.with(new AddContactController())
                        .pushChangeHandler(new HorizontalChangeHandler())
                        .popChangeHandler(new HorizontalChangeHandler())
                )
        );

        contactsArrayAdapter = new ContactsListViewAdapter(viewBinding.getRoot().getContext(), R.layout.contact_item, new ArrayList<Contact>());
        viewBinding.listviewContacts.setAdapter(contactsArrayAdapter);
        viewBinding.listviewContacts.setOnItemClickListener((parent, view, position, id) -> {
            UpdateContactDataHolder.getInstance().setContact(contactsArrayAdapter.getItem(position));
            getRouter().pushController(RouterTransaction.with(new UpdateContactController())
                    .pushChangeHandler(new HorizontalChangeHandler())
                    .popChangeHandler(new HorizontalChangeHandler())
            );
        });

        viewBinding.listviewContacts.setOnItemLongClickListener((parent, view, position, id) -> {
            showDeleteConfirmationDialog(contactsArrayAdapter.getItem(position));
            return false;
        });

        return viewBinding.getRoot();
    }

    @Override
    protected void onAttach(@NonNull View view) {
        presenter.fetchContactsAndPopulateListView(getActivity());
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == AppConstant.CONTACT_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                presenter.fetchContactsAndPopulateListView(getActivity());
            } else {
                showToast("Please give permission to read and write contacts");
            }
        }
    }

    @Override
    public void setAndUpdateContactListView(List<Contact> list) {
        contactsArrayAdapter = new ContactsListViewAdapter(getView().getContext() , R.layout.contact_item , list ) ;
        viewBinding.listviewContacts.setAdapter(contactsArrayAdapter);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDeleteConfirmationDialog(Contact contact) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getView().getContext());

        //Setting message manually and performing action on button click
        builder.setTitle("Delete this contact ?")
                .setMessage("Are you sure that you wish to delete the contact with name : " + contact.getDisplayName() + " number : " + contact.getMobileNumber() + "  ?")
                .setCancelable(true)
                .setPositiveButton("Yes", (dialog, id) -> {
                    presenter.deleteContact(contact);
                    ViewUtil.showShortToast(getApplicationContext(), contact.getDisplayName() + " deleted.");
                })
                .setNegativeButton("No", (dialog, id) -> {
                    //  Action for 'NO' Button
                    dialog.dismiss();
                })
                .setOnDismissListener((obj)->{
                    presenter.fetchContactsAndPopulateListView(getActivity());
                });


        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.show();
    }
}
