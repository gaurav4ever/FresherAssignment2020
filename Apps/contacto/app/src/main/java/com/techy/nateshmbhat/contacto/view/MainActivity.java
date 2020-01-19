package com.techy.nateshmbhat.contacto.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.techy.nateshmbhat.contacto.R;
import com.techy.nateshmbhat.contacto.view.controllers.ListContactsPageController.ListContactsController;

import android.view.ViewGroup;


//TODO : handle backbuttonpress in controller
//TODO : how to use observable to make a DS reactive
//TODO : how to design controllers in relation with Activity
//TODO : Fix screen jitter issue
//TODO : Fix contact fields getting the same column index


public class MainActivity extends AppCompatActivity {
    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ViewGroup container = findViewById(R.id.controller_container);

        router = Conductor.attachRouter(this, container, savedInstanceState);
        if (!router.hasRootController())
            router.setRoot(RouterTransaction.with(new ListContactsController()));
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(router.getBackstackSize()==1){
           super.onBackPressed();
        }
        router.popCurrentController() ;
    }
}
