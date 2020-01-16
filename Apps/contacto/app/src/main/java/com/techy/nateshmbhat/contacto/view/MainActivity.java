package com.techy.nateshmbhat.contacto.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.techy.nateshmbhat.contacto.R;
import com.techy.nateshmbhat.contacto.view.controllers.HomePageControllers.HomePageController;
import android.view.ViewGroup;

import io.reactivex.Observable;


public class MainActivity extends AppCompatActivity {
    private Router router ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup container = (ViewGroup) findViewById(R.id.controller_container);

        router = Conductor.attachRouter(this, container, savedInstanceState);
        if (!router.hasRootController())
            router.setRoot(RouterTransaction.with(new HomePageController()));
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
