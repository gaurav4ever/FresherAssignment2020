package com.techy.nateshmbhat.contacto.presenter;

import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.util.ContactWriteUtil;
import com.techy.nateshmbhat.contacto.view.controllers.UpdateContactController.UpdateContactContract;

public class UpdateContactPresenter implements UpdateContactContract.Presenter {
    UpdateContactContract.View view ;

    public UpdateContactPresenter(UpdateContactContract.View view) {
        this.view = view ;
    }

    @Override
    public void updateContact(Contact contact) {
        ContactWriteUtil.writeContactToDevice(contact , view.getView());
    }
}
