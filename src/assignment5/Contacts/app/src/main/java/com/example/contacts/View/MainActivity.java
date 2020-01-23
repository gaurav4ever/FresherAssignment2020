package com.example.contacts.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.contacts.View.Controller.ContactListController;
import com.example.contacts.Presenter.Permissions.PermissionHandler;
import com.example.contacts.R;

public class MainActivity extends AppCompatActivity implements PermissionHandler.View {

    private PermissionHandler mPermissionHandler;
    private Router mRouter;
    private ContactListController mContactListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContactListController = new ContactListController();
        mRouter = Conductor.attachRouter(this, (ViewGroup) findViewById(R.id.controller_container),savedInstanceState);
        if(!mRouter.hasRootController()) {
            mRouter.setRoot(RouterTransaction.with(mContactListController));
        }
        mPermissionHandler = PermissionHandler.getInstance(this);
        mPermissionHandler.requestPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        mPermissionHandler.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
    @Override
    public void permissionGranted() {
        mContactListController.displayContacts();

    }
    @Override
    public Activity getViewActivity() {
        return this;
    }
    @Override
    public void onBackPressed() {
        if(!mRouter.handleBack())
        super.onBackPressed();

    }
}
