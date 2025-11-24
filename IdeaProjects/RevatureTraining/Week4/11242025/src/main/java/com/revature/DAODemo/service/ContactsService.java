package com.revature.DAODemo.service;

import com.revature.DAODemo.model.Contacts;

import java.util.List;

public interface ContactsService {
    public default List<Contacts> getAllContacts() {
        return null;
    }

    public default Contacts getContact(int id) {
        return null;
    }
    public default void save(Contacts contacts) {

    }
    public default Contacts update(int id) {
        return null;
    }
    public default void delete(int id) {

    }
}
