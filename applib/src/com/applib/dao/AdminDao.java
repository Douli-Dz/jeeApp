package com.applib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.applib.beans.Admin;

public class AdminDao {

    public Admin checkLogin( String username, String password ) throws SQLException, ClassNotFoundException {

        String select_admin_statment = "SELECT * FROM Admin WHERE username = ? and password = ?";

        Connection connection = Connection_db.connectdb();
        PreparedStatement preparestatement = connection.prepareStatement( select_admin_statment );
        preparestatement.setString( 1, username );
        preparestatement.setString( 2, password );

        ResultSet result = preparestatement.executeQuery();

        Admin admin = null;

        if ( result.next() ) {
            admin = new Admin();
            admin.setFullname( result.getString( "fullname" ) );
            admin.setEmail( username );
        }

        connection.close();

        return admin;
    }
}