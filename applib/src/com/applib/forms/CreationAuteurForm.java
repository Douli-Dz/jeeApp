package com.applib.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.applib.beans.Auteur;

public class CreationAuteurForm {
    private static final String CHAMP_NUM            = "numAuteur";
    private static final String CHAMP_NOM            = "nomAuteur";
    private static final String CHAMP_PRENOM         = "prenomAuteur";
    private static final String CHAMP_DATE_NAISSANCE = "dateNaissanceAuteur";

    private String              resultat;
    private Map<String, String> erreurs              = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String res ) {
        resultat = res;
    }

    public Auteur creerAuteur( HttpServletRequest request ) {
        String num = getValeurChamp( request, CHAMP_NUM );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String dateNaissance = getValeurChamp( request, CHAMP_DATE_NAISSANCE );

        Auteur auteur = new Auteur();

        try {
            validationNum( num );
        } catch ( Exception e ) {
            setErreur( CHAMP_NUM, e.getMessage() );
        }
        auteur.setNum( num );

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        auteur.setNom( nom );

        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        auteur.setPrenom( prenom );

        try {
            validationDateNaissance( dateNaissance );
        } catch ( Exception e ) {
            setErreur( CHAMP_DATE_NAISSANCE, e.getMessage() );
        }
        auteur.setDateNaissance( dateNaissance );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création du auteur.";
        } else {
            resultat = "Échec de la création du auteur.";
        }

        return auteur;
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {

            if ( nom.length() < 2 ) {
                throw new Exception( "Le nom d'auteur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un nom d'auteur ." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom == null ) {
            throw new Exception( "Merci d'entrer un prénom d'auteur ." );

        }
    }

    private void validationDateNaissance( String dateNaissnace ) throws Exception {
        if ( dateNaissnace == null ) {
            throw new Exception( "Merci d'entrer une dateNaissnace  d'auteur." );
        }
    }

    private void validationNum( String num ) throws Exception {
        if ( num != null ) {
            if ( !num.matches( "^\\d+$" ) ) {
                throw new Exception( "Le numéro de auteur doit uniquement contenir des chiffres." );
            } else if ( num.length() < 5 ) {
                throw new Exception( "Le numéro de auteur doit contenir 5 chiffres." );
            }
        } else {
            throw new Exception( "Merci d'entrer un numéro de auteur." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

}
