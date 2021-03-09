package com.example.contacts.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.example.contacts.model.constants.Constants;
import com.example.contacts.model.Contact;
import com.example.contacts.presenter.repository.ContactsRepository;

import java.util.ArrayList;
import java.util.Collections;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


public class ContactPresenter {
    public static ArrayList<Contact> sContacts = new ArrayList<Contact>();
    private Context mContext;
    private ContactsRepository mContactsRepository;
    private Observer<Boolean> mObserver;
    public ContactPresenter(Context context) {
        this.mContext = context;
        this.mContactsRepository = new ContactsRepository();
    }
    public void setmObserver(Observer<Boolean> observer) {
        mObserver = observer;
    }
    public void fetchContactList() {
        Subject<Contact> contactSubject = PublishSubject.create();
        contactSubject
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new Observer<Contact>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Contact contact) {
                        sContacts.add(contact);
                        mObserver.onNext(true);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mObserver.onComplete();
                    }
                });
        mContactsRepository.getContactList(mContext,contactSubject);
    }

    public void addToContacts(String lookupKey) {
        sContacts.add(mContactsRepository.getContact(lookupKey,mContext));
        Collections.sort(sContacts);
    }
    public Contact getUpdatedContact(int contactPosition,String lookupKey) {
        Contact contact = mContactsRepository.getContact(lookupKey,mContext);
        sContacts.set(contactPosition,contact);
        return contact;
    }
    public void deleteContact(int position,String lookupKey) {
        mContactsRepository.deleteContact(lookupKey,mContext);
        sContacts.remove(position);

    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == ((Activity) mContext).RESULT_OK) {
            if(requestCode== Constants.NEW_CONTACT_ADDED) {
                String lookupKey = getLookupKey(data.getDataString());
                addToContacts(lookupKey);
            }
        }
    }

    public String getLookupKey(String data) {
        String[] args = data.split("/");
        String lookupKey="";
        for(int i = 0; i<args.length;i++) {
            if("lookup".equals(args[i])) {
                lookupKey = args[i+1];
                break;
            }
        }
        return lookupKey;
    }

}
