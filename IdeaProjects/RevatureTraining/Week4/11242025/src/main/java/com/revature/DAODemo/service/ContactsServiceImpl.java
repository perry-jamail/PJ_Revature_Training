package com.revature.DAODemo.service;

import com.revature.DAODemo.dao.ContactDAO;
import com.revature.DAODemo.dao.ContactsJDBCImpl;
import com.revature.DAODemo.model.Contacts;

public class ContactsServiceImpl implements ContactsService {
    public Contacts getContact(int id) {
        ContactDAO contactDAO = new ContactsJDBCImpl();
        if (id > 0) {
            Contacts contacts = contactDAO.getContact(id);
            return contacts;
        } else {
            return null;
        }
    }
}
