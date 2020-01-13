package com.techy.nateshmbhat.contacto.presenter;

import com.techy.nateshmbhat.contacto.model.Counter;

public class ToastPresenter {
    View view ;
    Counter counter ;

    public ToastPresenter(View view) {
        this.view = view;
        counter  = Counter.getInstance();
    }

    public void handleToastButtonClick(){
        view.showToast(counter.toString());
    }

    public interface  View{
        void showToast(String val) ;
    }
}
