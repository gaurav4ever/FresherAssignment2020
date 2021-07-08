package com.techy.nateshmbhat.contacto.di;

import com.techy.nateshmbhat.contacto.presenter.CountPresenter;
import com.techy.nateshmbhat.contacto.view.MainActivity;

import dagger.Component;

@Component
public interface CountPresenterComponent {
    CountPresenter getCountPresenter() ;
    void inject(MainActivity mainActivity) ;
}