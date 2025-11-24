package com.revature.DAODemo.dao;

import com.revature.DAODemo.model.Contacts;
import com.revature.DAODemo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsJDBCImpl implements ContactDAO {
    Connection connection = null;
    Contacts contacts = null;
    public Contacts getContact(int id) {
        connection = ConnectionUtil.dbConnection();
        String getContact = "select * from contacts where contact_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getContact);
            preparedStatement.setInt(1, 3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contacts = new Contacts(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return contacts;
    }
}
