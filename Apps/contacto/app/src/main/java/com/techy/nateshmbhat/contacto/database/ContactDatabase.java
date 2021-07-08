package com.techy.nateshmbhat.contacto.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.techy.nateshmbhat.contacto.model.Contact;

@Database(entities = {Contact.class}, version = 1 , exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
}
