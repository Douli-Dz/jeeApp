package com.applib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.applib.beans.Livre;

public class LivreDao {

    public int ajouter_livre_db( Livre livre ) {

        String insert_livre_statment = "INSERT INTO Livre VALUES(?,?,?,?,?,?)";
        int result = 0;
        try {
            Connection connection = Connection_db.connectdb();
            PreparedStatement preparestatement = connection.prepareStatement( insert_livre_statment );
            preparestatement.setString( 1, livre.getIssn() );
            preparestatement.setString( 2, livre.getNumAuteur() );
            preparestatement.setString( 3, livre.getTitre() );
            preparestatement.setString( 4, livre.getResume() );
            preparestatement.setInt( 5, livre.getNbPages() );
            preparestatement.setString( 6, livre.getDomaine() );
            result = preparestatement.executeUpdate();

            connection.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return result;
    }

}
