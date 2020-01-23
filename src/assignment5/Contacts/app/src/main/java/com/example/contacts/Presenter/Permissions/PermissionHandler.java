package com.example.contacts.Presenter.Permissions;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.contacts.Model.Constants.Constants;

public class PermissionHandler {
    private static PermissionHandler mPermissionHandler=null;
    private View mView;
    private PermissionHandler(View view) {
        this.mView = view;
    }
    public static PermissionHandler getInstance(View view)
    {
        if (mPermissionHandler == null) {
                mPermissionHandler = new PermissionHandler(view);

        }
        return mPermissionHandler;
    }
    public void requestPermission() {

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(mView.getViewActivity(), Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED || ContextCompat.checkSelfPermission(mView.getViewActivity(), Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(
                            mView.getViewActivity(),
                            new String[]{Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS},
                            Constants.READ_CONTACT_REQUEST_CODE);
        }
        else {
            mView.permissionGranted();
        }
    }
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Constants.READ_CONTACT_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mView.permissionGranted();
                } else {
                    requestPermission();
                }
                return;
            }

        }
    }
    public interface View {
        Activity getViewActivity();
        void permissionGranted();
    }
 }
