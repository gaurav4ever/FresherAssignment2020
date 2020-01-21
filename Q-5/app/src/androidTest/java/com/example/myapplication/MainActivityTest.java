package com.example.myapplication;

import com.example.myapplication.Model.Contact;
import com.example.myapplication.Presenter.ContactActivityPresenter;
import com.example.myapplication.Repository.ContactRepository;
import com.example.myapplication.View.ContactActivityView;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainActivityTest {


    /**
     * test to send data to the view and display it
     */
    @Test
    public void shouldPassContactToView() {

        //given
        ContactActivityView view = new MockView();
        ContactRepository repository = new MockContactRepository(true);
        //when
        ContactActivityPresenter presenter = new ContactActivityPresenter(view, repository);
        presenter.loadContacts();
        //then
        Assert.assertEquals(true, ((MockView) view).contactDisplayed);

    }

    @Test
    public void shouldPassNoContactToView() {
        //given
        ContactActivityView view = new MockView();
        ContactRepository repository = new MockContactRepository(false);

        //when
        ContactActivityPresenter presenter = new ContactActivityPresenter(view, repository);
        presenter.loadContacts();
        //then
        Assert.assertEquals(true, ((MockView) view).noContactDisplayed);
    }

    private class MockView implements ContactActivityView {

        boolean contactDisplayed;
        boolean noContactDisplayed;

        @Override
        public void displayContact(List<Contact> contacts) {
            if (contacts.size() >= 3)
                contactDisplayed = true;
        }

        @Override
        public void displayNoContacts() {
            noContactDisplayed = true;
        }
    }

    private class MockContactRepository implements ContactRepository {
        private boolean ret;

        public MockContactRepository(boolean ret) {
            this.ret = ret;
        }

        @Override
        public List<Contact> getContactListFromPhone() {
            if (ret)
                return Arrays.asList(new Contact(), new Contact(), new Contact());
            else
                return Arrays.asList();
        }
    }

}