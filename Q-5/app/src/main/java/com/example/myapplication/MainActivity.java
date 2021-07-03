package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.myapplication.View.Controller.ContactListController;
import com.example.myapplication.Permission.PermissionCallback;
import com.example.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements PermissionCallback {

    private static final String TAG = "display ";
    private ActivityMainBinding binding;
    private ViewGroup container;
    private Router router;
    private ContactListController contactListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        container = binding.controllerContainer;

        contactListController = new ContactListController();


        router = Conductor.attachRouter(this, container, savedInstanceState);
        if (!router.hasRootController())
            router.setRoot(RouterTransaction.with(contactListController));


    }

    @Override
    public void onPermissionGrant() {
        contactListController.onPermissionGrant();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Log.e(TAG, "result permission");

        switch (requestCode) {
            case Constants.MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    contactListController.onPermissionGrant();
                    Log.e(TAG, "onRequestPermissionsResult: ");

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack())
            super.onBackPressed();
    }
}
