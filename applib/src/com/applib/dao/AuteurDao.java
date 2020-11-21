package com.applib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.applib.beans.Auteur;

public class AuteurDao {

    public int ajouter_auteur_db( Auteur auteur ) {

        String insert_auteur_statment = "INSERT INTO Auteur VALUES(?,?,?,?)";
        int result = 0;
        try {
            Connection connection = Connection_db.connectdb();
            PreparedStatement preparestatement = connection.prepareStatement( insert_auteur_statment );
            preparestatement.setString( 1, auteur.getNum() );
            preparestatement.setString( 2, auteur.getNom() );
            preparestatement.setString( 3, auteur.getPrenom() );
            preparestatement.setString( 4, auteur.getDateNaissance() );
            result = preparestatement.executeUpdate();

            connection.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return result;
    }
}
