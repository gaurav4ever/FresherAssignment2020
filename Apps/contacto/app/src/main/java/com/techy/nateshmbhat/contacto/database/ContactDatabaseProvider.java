package com.techy.nateshmbhat.contacto.database;

import android.content.Context;

import androidx.room.Room;

public class ContactDatabaseProvider {
    private  static  ContactDatabase db ;

    private ContactDatabaseProvider() {}

    public static ContactDatabase getInstance(Context context){
        if(db==null) {
            db = Room.databaseBuilder(context, ContactDatabase.class, "contacto").build();
        }
        return db ;
    }
}
