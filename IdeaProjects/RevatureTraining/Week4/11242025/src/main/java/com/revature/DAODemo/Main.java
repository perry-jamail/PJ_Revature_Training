package com.revature.DAODemo;

import com.revature.DAODemo.dao.ContactDAO;
import com.revature.DAODemo.dao.ContactsJDBCImpl;
import com.revature.DAODemo.model.Contacts;
import com.revature.DAODemo.service.ContactsService;
import com.revature.DAODemo.service.ContactsServiceImpl;

public class Main {
    static void main(String[] args) {
        ContactsService contactsService = new ContactsServiceImpl();
        Contacts contact = contactsService.getContact(2);

//        ContactDAO contactDAO = new ContactsJDBCImpl();
//        Contacts contact = contactDAO.getContact(2);
        System.out.println(contact);
    }
}
