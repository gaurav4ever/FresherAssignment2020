package com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController;

import android.content.pm.PackageManager;
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
import com.techy.nateshmbhat.contacto.permission.ContactPermissionManager;
import com.techy.nateshmbhat.contacto.view.controllers.AddContactControllers.AddContactController;

import java.util.ArrayList;
import java.util.List;

public class ListContactsController extends Controller  implements ListContactsContract.View{
    private static final String TAG = "ListContactsController";
    private ListContactsLayoutBinding viewBinding;
    private ContactsListViewAdapter contactsArrayAdapter;
    private ListContactsPresenter presenter ;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.list_contacts_layout, container, false);
        viewBinding.btnAddContact.setOnClickListener(v ->
                getRouter().pushController(RouterTransaction.with(new AddContactController())
                        .pushChangeHandler(new HorizontalChangeHandler())
                        .popChangeHandler(new HorizontalChangeHandler())
                )
        );
        contactsArrayAdapter = new ContactsListViewAdapter(viewBinding.getRoot().getContext() , R.layout.contact_item , new ArrayList<Contact>());
        viewBinding.listviewContacts.setAdapter(contactsArrayAdapter);

        presenter = new ListContactsPresenter();
        presenter.setView(this) ;
        presenter.fetchContactsAndPopulateListView(getActivity());
        return viewBinding.getRoot();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == AppConstant.CONTACT_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                presenter.fetchContactsAndPopulateListView(getActivity());
            }
            else {
                showToast("Please give permission to read and write contacts");
            }
        }
    }

    @Override
    public void setAndUpdateContactListView(List<Contact> list) {
        contactsArrayAdapter.clear();
        contactsArrayAdapter.addAll(list);
        contactsArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext() , msg , Toast.LENGTH_SHORT).show();
    }
}
