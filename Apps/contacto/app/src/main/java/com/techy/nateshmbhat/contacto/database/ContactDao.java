package com.techy.nateshmbhat.contacto.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.techy.nateshmbhat.contacto.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM Contact")
    List<Contact> getAll();

    @Query("SELECT * FROM Contact WHERE id IN (:userIds)")
    List<Contact> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Contact WHERE id LIKE :id LIMIT 1")
    Contact findById(String id);

    @Insert
    void insertAll(Contact... contacts);

    @Insert
    void insert(Contact contact);

    @Update
    void update(Contact contact) ;

    @Delete
    void delete(Contact contact);
}
