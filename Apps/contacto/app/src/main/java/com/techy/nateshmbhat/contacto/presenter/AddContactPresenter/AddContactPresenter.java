package com.techy.nateshmbhat.contacto.presenter.AddContactPresenter;

import android.Manifest;
import android.app.Activity;
import android.view.View;
import com.techy.nateshmbhat.contacto.model.Contact;
import com.techy.nateshmbhat.contacto.permission.ContactPermissionManager;
import com.techy.nateshmbhat.contacto.util.ContactAddUtil;
import com.techy.nateshmbhat.contacto.view.controllers.AddContactController.AddContactContract;
import pub.devrel.easypermissions.EasyPermissions;

public class AddContactPresenter implements AddContactContract.Presenter {

    final private View view ;

    public AddContactPresenter(View view) {
        this.view = view ;
    }

    @Override
    public void writeContactToDevice(Contact contact) {
        String[] perms = {Manifest.permission.WRITE_CONTACTS};
        if (EasyPermissions.hasPermissions( view.getContext() , perms)) {
            // Already have permission, do the thing
            ContactAddUtil.writeContactToDevice(contact,view.getContext());
        } else {
            // Do not have permissions, request them now
            ContactPermissionManager.getInstance().managePermission((Activity) view.getContext()) ;
        }
    }
}
