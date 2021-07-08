package com.techy.nateshmbhat.contacto.presenter;
import com.techy.nateshmbhat.contacto.model.Counter;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Component;

public class CountPresenter {
    private Counter counter ;

    public void setView(View view) {
        this.view = view;
    }

    private View view ;

    @Inject
    public CountPresenter() {
        counter =  Counter.getInstance() ;
    }

    public void incrementCount(){
        counter.setCount(counter.getCount()+1);
        view.setCounterText(counter.toString());
    }

    public interface View {
        void setCounterText(String val) ;
    }
}
