package com.example.dao;

import com.example.models.Contact;

import java.util.List;

/**
 * Created by toktar on 08.07.2016.
 */

public abstract class AbstractDBDao {

    public abstract void deleteElement(Contact contact);
    public abstract void addElement(Contact contact);
    public abstract List<Contact> getList();


}
