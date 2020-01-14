package com.techy.nateshmbhat.contacto.di;

import com.techy.nateshmbhat.contacto.presenter.ToastPresenter;
import com.techy.nateshmbhat.contacto.view.MainActivity;

import dagger.Component;

@Component
public interface ToastPresenterComponent {
    ToastPresenter getToastPresenter() ;
    void inject(MainActivity mainActivity) ;
}
