package com.techy.nateshmbhat.contacto.model;

import androidx.annotation.NonNull;

public class Counter extends Model {
    int count = 0 ;
    private static Counter counter ;
    private Counter(){}
    public static Counter getInstance(){
        if(counter==null){
            counter = new Counter() ;
        }
        return counter ;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(count) ;
    }
}
