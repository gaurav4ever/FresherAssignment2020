package com.example.contacts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.contacts.view.controller.ContactListController;
import com.example.contacts.presenter.permissions.PermissionHandler;
import com.example.contacts.R;
import com.example.contacts.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements PermissionHandler.View {

    private PermissionHandler mPermissionHandler;
    private Router mRouter;
    private ContactListController mContactListController;
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mContactListController = new ContactListController();
        mRouter = Conductor.attachRouter(this, mBinding.controllerContainer,savedInstanceState);
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
