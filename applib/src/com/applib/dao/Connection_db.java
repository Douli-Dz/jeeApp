package com.applib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_db {

    public static Connection connectdb() {
        Connection connection;
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/bdd_jee";
            String dbUser = "java";
            String dbPassword = "java";

            Class.forName( "com.mysql.jdbc.Driver" );
            connection = DriverManager.getConnection( jdbcURL, dbUser, dbPassword );
            System.out.println( "connected with database" );
            return connection;
        } catch ( ClassNotFoundException cnfe ) {
            System.out.println( "no connect " + cnfe.getMessage() );
            return null;
        } catch ( SQLException sql ) {
            System.out.println( "SQLException: " + sql.getMessage() );
            System.out.println( "SQLState: " + sql.getSQLState() );
            System.out.println( "Erro: " + sql.getErrorCode() );
            System.out.println( "StackTrace: " + sql.getStackTrace() );
            return null;
        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
            return null;
        }
    }

}
