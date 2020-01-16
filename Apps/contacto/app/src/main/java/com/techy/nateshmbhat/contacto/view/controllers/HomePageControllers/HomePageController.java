package com.techy.nateshmbhat.contacto.view.controllers.HomePageControllers;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.techy.nateshmbhat.contacto.R;
import com.techy.nateshmbhat.contacto.presenter.ListContactsPresenter;

public class HomePageController extends Controller {

    private static final String TAG = "HomePageController";

    Button addContactButton;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {

        View view ;
        view =inflater.inflate(R.layout.home_controller_layout, container , false) ;

        addContactButton = view.findViewById(R.id.btn_add_contact);
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRouter().pushController(RouterTransaction.with(new HomePageController())
                        .pushChangeHandler(new FadeChangeHandler()).
                        popChangeHandler(new FadeChangeHandler()));
            }
        });


        ListContactsPresenter presenter = new ListContactsPresenter();
        presenter.setRouter(getRouter());
        presenter.getContacts() ;

        return view ;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
}
