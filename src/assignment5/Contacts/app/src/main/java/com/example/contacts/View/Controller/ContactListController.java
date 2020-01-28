package com.example.contacts.view.controller;

import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.contacts.model.constants.Constants;
import com.example.contacts.model.Contact;
import com.example.contacts.presenter.ContactPresenter;
import com.example.contacts.presenter.ContactsAdapterPresenter;
import com.example.contacts.R;
import com.example.contacts.view.ContactsAdapterViewHolder;
import com.example.contacts.databinding.ContactListBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ContactListController extends Controller implements ContactsAdapterViewHolder.ListItemEvenHandler, ContactDetailsController.UpdateContactInListListener {
    private ContactsAdapterPresenter mContactsAdapterPresenter;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mAddContactButton;
    private final String TAG = "ContactListController";
    private ContactPresenter mContactPresenter;
    private ProgressBar mProgressBar;
    private ContactListBinding mBinding;

    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.contact_list, container, false);
        attachAdapter(view, this);
        mContactPresenter = new ContactPresenter(view.getContext());
        return view;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        updateAdapter();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mContactPresenter.onActivityResult(requestCode, resultCode, data);
        updateAdapter();
    }

    public void attachAdapter(View view, ContactsAdapterViewHolder.ListItemEvenHandler evenHandler) {
        mBinding = ContactListBinding.bind(view);

        mRecyclerView = mBinding.recyclerView;
        mContactsAdapterPresenter = new ContactsAdapterPresenter(ContactPresenter.sContacts, evenHandler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(mContactsAdapterPresenter);
        mAddContactButton = mBinding.addContactButton;
        mProgressBar = mBinding.progressBar;
        mProgressBar.setVisibility(View.GONE);
        mAddContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra("finishActivityOnSaveCompleted", true);
                startActivityForResult(intent, Constants.NEW_CONTACT_ADDED);
            }
        });

    }

    public void updateAdapter() {
        mContactsAdapterPresenter.notifyDataSetChanged();

    }

    public void displayContacts() {
        Log.e(TAG, "displayContacts: " + "inside display contacts");
        mProgressBar.setVisibility(View.VISIBLE);

        Observable<Boolean> observable = new Observable<Boolean>() {
            @Override
            protected void subscribeActual(Observer<? super Boolean> observer) {
                mContactPresenter.setmObserver((Observer<Boolean>) observer);
                mContactPresenter.fetchContactList();


            }

        };

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (aBoolean)
                            updateAdapter();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mProgressBar.setVisibility(View.GONE);

                    }
                });

    }

    @Override
    public void onContactClicked(int position, Contact contact) {
        ContactDetailsController instance = ContactDetailsController.getInstance(position, contact);
        instance.setUpdateContactInListListener(this);
        getRouter().pushController(RouterTransaction.with(instance));
    }

    @Override
    public void onUpdateItem(int contactPosition) {
        mContactsAdapterPresenter.notifyItemChanged(contactPosition);
    }
}
