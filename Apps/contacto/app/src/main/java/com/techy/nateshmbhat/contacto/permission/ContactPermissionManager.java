package com.techy.nateshmbhat.contacto.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;

import com.bluelinelabs.conductor.Router;
import com.techy.nateshmbhat.contacto.constant.AppConstant;

import static androidx.core.app.ActivityCompat.requestPermissions;


public class ContactPermissionManager {
    private static ContactPermissionManager contactPermissionManager  ;
    private boolean isPermitted = false ;

    public static ContactPermissionManager getInstance(){
        if(contactPermissionManager==null){
            contactPermissionManager = new ContactPermissionManager() ;
        }
        return contactPermissionManager ;
    }

    public void managePermission(Activity context){
        if(!isPermitted) requestPermission(context);
    }

    private void requestPermission(Activity context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission( context , Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(context , new String[]{Manifest.permission.READ_CONTACTS , Manifest.permission.WRITE_CONTACTS}, AppConstant.CONTACT_REQUEST_CODE);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
            isPermitted = true ;
        }
    }

    public boolean isPermitted(){
        return isPermitted ;
    }
}
