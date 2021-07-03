package com.example.myapplication.Permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication.Constants;

public class PermissionHandler {
    private Context context;

    public PermissionHandler(Context context) {
        this.context = context;
    }

    public void requestPermission() {
        //check if permission is granted or not
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            //request for the grant
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS}, Constants.MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show();
            ((PermissionCallback) context).onPermissionGrant();
        }
    }

}
