package com.techy.nateshmbhat.contacto.presenter;

import com.techy.nateshmbhat.contacto.model.Counter;

import javax.inject.Inject;
import javax.inject.Named;

public class ToastPresenter {
    View view ;
    Counter counter ;

    @Inject
    public ToastPresenter() {
        counter  = Counter.getInstance();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void handleToastButtonClick(){
        view.showToast(counter.toString());
    }

    public interface View{
        void showToast(String val) ;
    }
}
