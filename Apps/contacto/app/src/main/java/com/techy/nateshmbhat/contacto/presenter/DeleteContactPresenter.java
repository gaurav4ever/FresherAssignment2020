package com.techy.nateshmbhat.contacto.presenter;

import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.util.ContactDeleteUtil;
import com.techy.nateshmbhat.contacto.view.controllers.DeteleContactsController.DeleteContactsContract;

public class DeleteContactPresenter implements DeleteContactsContract.Presenter {
    DeleteContactsContract.View view ;

    @Override
    public void deleteContact(Contact contact) {
        ContactDeleteUtil.deleteContactFromDevice(contact , view.getView().getContext());
    }
}
