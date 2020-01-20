package com.techy.nateshmbhat.contacto.presenter.AddContactPresenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.permission.ContactPermissionManager;
import com.techy.nateshmbhat.contacto.util.ContactUtil;
import com.techy.nateshmbhat.contacto.view.controllers.AddContactController.AddContactContract;
import pub.devrel.easypermissions.EasyPermissions;

public class AddContactPresenter implements AddContactContract.Presenter {

    final private AddContactContract.View view ;

    public AddContactPresenter(AddContactContract.View view) {
        this.view = view ;
    }

    @Override
    public void addContact(Contact contact) {
        Context context = view.getView().getContext() ;
        String[] perms = {Manifest.permission.WRITE_CONTACTS};
        if (EasyPermissions.hasPermissions( context , perms)) {
            // Already have permission, do the thing
            ContactUtil.addContact(context , contact);
        } else {
            // Do not have permissions, request them now
            ContactPermissionManager.getInstance().managePermission((Activity) context) ;
        }
    }
}
