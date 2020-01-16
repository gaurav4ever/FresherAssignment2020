package com.techy.nateshmbhat.contacto.presenter.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.content.ContextCompat;

import com.bluelinelabs.conductor.Router;
import com.techy.nateshmbhat.contacto.constant.AppConstant;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class ContactPermissionManager {
    private static ContactPermissionManager contactPermissionManager  ;
    private boolean isPermitted = false ;

    public ContactPermissionManager getInstance(){
        if(contactPermissionManager==null){
            contactPermissionManager = new ContactPermissionManager() ;
        }
        return contactPermissionManager ;
    }

    public void managePermission(Router router){
        if(!isPermitted) requestPermission(router);
    }

    public  void requestPermission(Router router){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission( router.getActivity() , Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions( router.getActivity() , new String[]{Manifest.permission.READ_CONTACTS , Manifest.permission.WRITE_CONTACTS}, AppConstant.CONTACT_REQUEST_CODE);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
            isPermitted = true ;
        }
    }

    public  void onRequestPermissionResult(int requestCode  , int[]grantResults){
        if (requestCode == AppConstant.CONTACT_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                isPermitted = true ;
            }
            else {
                isPermitted = false ;
            }
        }
    }

    public boolean isPermitted(){
        return isPermitted ;
    }
}
