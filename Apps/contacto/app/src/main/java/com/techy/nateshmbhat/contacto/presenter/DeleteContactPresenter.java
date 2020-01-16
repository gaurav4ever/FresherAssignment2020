package com.techy.nateshmbhat.contacto.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class DeleteContactPresenter {
    public  void execute(){

        List<Integer> arr = new ArrayList<>() ;
        Observable<List<Integer>> observable = Observable.fromArray(arr) ;

        Observable.just(1,2,3,4,5,6,7,8,9)
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(x->x*x)
                .subscribe((x)-> Log.d(TAG, "execute: " + x)) ;
    }
}
