package com.techy.nateshmbhat.contacto.presenter;
import com.techy.nateshmbhat.contacto.model.Counter;

public class CountPresenter {
    private Counter counter = Counter.getInstance() ;
    private final View view ;

    public CountPresenter(View view) {
        this.view = view;
    }

    public void incrementCount(){
        counter.setCount(counter.getCount()+1);
        view.setCounterText(counter.toString());
    }

    public interface View {
        void setCounterText(String val) ;
    }
}
