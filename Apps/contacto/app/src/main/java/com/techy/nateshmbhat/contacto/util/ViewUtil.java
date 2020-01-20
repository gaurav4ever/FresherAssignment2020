package com.techy.nateshmbhat.contacto.util;

import android.content.Context;
import android.widget.Toast;

public class ViewUtil {
    public static void showShortToast(Context context , String msg){
        Toast.makeText(context , msg , Toast.LENGTH_SHORT).show();
    }
}
