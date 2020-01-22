package com.example.myapplication.View.Controller;


import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.myapplication.Adapter.ContactAdapter;
import com.example.myapplication.Adapter.EventHandler;
import com.example.myapplication.Constants;
import com.example.myapplication.Model.Contact;
import com.example.myapplication.Permission.PermissionCallback;
import com.example.myapplication.Presenter.ContactActivityPresenter;
import com.example.myapplication.R;

import com.example.myapplication.Repository.ContactRepository;
import com.example.myapplication.Repository.ContactRepositoryImp;
import com.example.myapplication.View.ContactActivityView;
import com.example.myapplication.databinding.ContactRecylerListBinding;

import java.util.List;

import static android.app.Activity.RESULT_OK;


public class ContactListController extends Controller implements ContactActivityView, PermissionCallback, EventHandler {

    private ContactRecylerListBinding binding;

    private ContactAdapter mContactAdapter;
    private ContactActivityPresenter presenter;


    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.contact_recyler_list, container, false);
        View view = binding.getRoot();


        //Repository
        ContactRepository repository = new ContactRepositoryImp(getActivity());


        //presenter
        presenter = new ContactActivityPresenter(this, repository);
        presenter.requestPermission();

        binding.floatingActionButton.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            intent.putExtra("finishActivityOnSaveCompleted", true);
            startActivityForResult(intent, Constants.RESULT_NEW_CONTACT_SAVED);

        });


        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if the operation is successful
        if (resultCode == RESULT_OK) {

            Contact contact = presenter.getContact(data);
            presenter.addContactToList(contact);
            List<Contact> contactList = presenter.getContactlist();
            mContactAdapter.updateAdapter(contactList);

        }

    }

    @Override
    public void displayContact(List<Contact> contacts) {

        mContactAdapter = new ContactAdapter(getActivity());
        mContactAdapter.setEventHandler(this);
        mContactAdapter.updateAdapter(contacts);

        binding.recylerView.setHasFixedSize(true);
        binding.recylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recylerView.setAdapter(mContactAdapter);
    }

    @Override
    public void displayNoContacts() {
        Toast.makeText(getActivity(), "there is no Contact to display", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPermissionGrant() {
        presenter.loadContacts();
    }

    @Override
    public void onDeleteContactClicked(Contact contact) {
        presenter.deleteContact(contact);
        List<Contact> contactList = presenter.getContactlist();
        mContactAdapter.updateAdapter(contactList);

    }

    @Override
    public void onShowDetailClicked(Contact contact) {
        ContactDetailsController contactDetailsController = new ContactDetailsController();
        contactDetailsController.passContact(contact);
        contactDetailsController.passPresenter(presenter);

        getRouter().pushController(RouterTransaction.with(contactDetailsController));

    }


}
