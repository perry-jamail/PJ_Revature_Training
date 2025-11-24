package com.revature.DAODemo.dao;

import com.revature.DAODemo.model.Contacts;

import java.util.List;

public interface ContactDAO {

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
