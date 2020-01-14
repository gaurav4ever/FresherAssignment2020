package com.techy.nateshmbhat.contacto.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.techy.nateshmbhat.contacto.R;
import com.techy.nateshmbhat.contacto.di.DaggerCountPresenterComponent;
import com.techy.nateshmbhat.contacto.di.DaggerToastPresenterComponent;
import com.techy.nateshmbhat.contacto.presenter.CountPresenter;
import com.techy.nateshmbhat.contacto.presenter.ToastPresenter;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;

public class MainActivity extends AppCompatActivity implements CountPresenter.View, ToastPresenter.View {

    @Inject
    CountPresenter countPresenter;
    @Inject
    ToastPresenter toastPresenter;
    TextView countText;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countText = findViewById(R.id.text_count);

        DaggerToastPresenterComponent.create().inject(this);
        DaggerCountPresenterComponent.create().inject(this);
        countPresenter.setView(this);
        toastPresenter.setView(this) ;

        findViewById(R.id.button_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countPresenter.incrementCount();
            }
        });

        findViewById(R.id.button_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastPresenter.handleToastButtonClick();
            }
        });
    }

    @Override
    public void setCounterText(String val) {
        countText.setText(val);
    }

    @Override
    public void showToast(String text) {
        if (toast != null) toast.cancel();
        toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
