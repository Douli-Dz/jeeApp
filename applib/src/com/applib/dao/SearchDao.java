package com.applib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.applib.beans.Auteur;
import com.applib.beans.Livre;

public class SearchDao {

    Connection connection = Connection_db.connectdb();

    public ArrayList<Auteur> search_in_auteur( String search_about ) {

        ArrayList<Auteur> list_of_authers = new ArrayList<Auteur>();

        String select_auteur_statment = "SELECT * FROM  Auteur WHERE nom_auteur like '%" + search_about
                + "%' OR prenom_auteur LIKE '%" + search_about + "%' ";

        try {

            PreparedStatement preparestatement = connection.prepareStatement( select_auteur_statment );
            ResultSet result = preparestatement.executeQuery();

            while ( result.next() ) {
                Auteur auteur = new Auteur();

                auteur.setNum( result.getString( "num_auteur" ) );
                auteur.setNom( result.getString( "nom_auteur" ) );
                auteur.setPrenom( result.getString( "prenom_auteur" ) );
                auteur.setDateNaissance( result.getString( "date_n_auteur" ) );

                list_of_authers.add( auteur );
            }

            connection.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return list_of_authers;
    }

    public ArrayList<Livre> search_in_livre( String search_about ) {

        ArrayList<Livre> list_of_books = new ArrayList<Livre>();

        String select_livre_statment = "SELECT * FROM  Livre WHERE titre_livre like '%" + search_about + "%'  ";

        try {

            PreparedStatement preparestatement = connection.prepareStatement( select_livre_statment );
            ResultSet result = preparestatement.executeQuery();

            while ( result.next() ) {
                Livre livre = new Livre();

                livre.setIssn( result.getString( "issn_livre" ) );
                livre.setNumAuteur( result.getString( "num_auteur" ) );
                livre.setTitre( result.getString( "titre_livre" ) );
                livre.setResume( result.getString( "resume_livre" ) );
                livre.setNbPages( result.getInt( "nb_pages" ) );
                livre.setDomaine( result.getString( "domaine_livre" ) );

                list_of_books.add( livre );
            }

            connection.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return list_of_books;
    }

    public ArrayList<Livre> search_in_domaine( String search_about ) {

        ArrayList<Livre> list_of_books = new ArrayList<Livre>();

        String select_livre_statment = "SELECT * FROM  Livre WHERE domaine_livre like '%" + search_about + "%'  ";

        try {

            PreparedStatement preparestatement = connection.prepareStatement( select_livre_statment );
            ResultSet result = preparestatement.executeQuery();

            while ( result.next() ) {
                Livre livre = new Livre();

                livre.setIssn( result.getString( "issn_livre" ) );
                livre.setNumAuteur( result.getString( "num_auteur" ) );
                livre.setTitre( result.getString( "titre_livre" ) );
                livre.setResume( result.getString( "resume_livre" ) );
                livre.setNbPages( result.getInt( "nb_pages" ) );
                livre.setDomaine( result.getString( "domaine_livre" ) );

                list_of_books.add( livre );
            }

            connection.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return list_of_books;
    }
}
