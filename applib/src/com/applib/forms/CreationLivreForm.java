package com.applib.forms;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.applib.beans.Livre;

public class CreationLivreForm {
    private static final String CHAMP_ISSN       = "issnLivre";
    private static final String CHAMP_NUM_AUTEUR = "numAuteurLivre";
    private static final String CHAMP_TITRE      = "titreLivre";
    private static final String CHAMP_RESUME     = "resumeLivre";
    private static final String CHAMP_NB_PAGES   = "nbPagesLivre";
    private static final String CHAMP_DOMAINE    = "domaineLivre";

    private String              resultat;
    private Map<String, String> erreurs          = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String res ) {
        resultat = res;
    }

    public Livre creerLivre( HttpServletRequest request ) {
        String issn = getValeurChamp( request, CHAMP_ISSN );
        String numAuteur = getValeurChamp( request, CHAMP_NUM_AUTEUR );
        String titre = getValeurChamp( request, CHAMP_TITRE );
        String resume = getValeurChamp( request, CHAMP_RESUME );
        String nbPages = getValeurChamp( request, CHAMP_NB_PAGES );
        String domaine = getValeurChamp( request, CHAMP_DOMAINE );

        Livre livre = new Livre();

        try {
            validationIssn( issn );
        } catch ( Exception e ) {
            setErreur( CHAMP_ISSN, e.getMessage() );
        }
        livre.setIssn( issn );

        try {
            validationNumAuteur( numAuteur );
        } catch ( Exception e ) {
            setErreur( CHAMP_NUM_AUTEUR, e.getMessage() );
        }
        livre.setNumAuteur( numAuteur );

        try {
            validationTitre( titre );
        } catch ( Exception e ) {
            setErreur( CHAMP_TITRE, e.getMessage() );
        }
        livre.setTitre( titre );

        try {
            validationResume( resume );
        } catch ( Exception e ) {
            setErreur( CHAMP_RESUME, e.getMessage() );
        }
        livre.setResume( resume );

        int valeurNbPages = 0;

        try {
            valeurNbPages = validationNbPages( nbPages );
        } catch ( Exception e ) {
            setErreur( CHAMP_NB_PAGES, e.getMessage() );
        }
        livre.setNbPages( valeurNbPages );

        try {
            validationDomaine( domaine );
        } catch ( Exception e ) {
            setErreur( CHAMP_DOMAINE, e.getMessage() );
        }
        livre.setDomaine( domaine );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création du livre.";
        } else {
            resultat = "Échec de la création du livre.";
        }

        return livre;
    }

    private void validationIssn( String issn ) throws Exception {
        if ( issn != null ) {
            if ( issn.length() < 5 ) {
                throw new Exception( "Le ISSN doit contenir au moins 5 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer issn de livre" );
        }
    }

    private void validationNumAuteur( String numAuteur ) throws Exception {
        if ( numAuteur != null ) {
            if ( !numAuteur.matches( "^\\d+$" ) ) {
                throw new Exception( "Le numéro d'auteur doit uniquement contenir des chiffres." );
            } else if ( numAuteur.length() < 4 ) {
                throw new Exception( "Le numéro d'auteur doit  contenir au moins 5 chiffres." );
            }
        } else {
            throw new Exception( "Merci d'entrer un Numéro d'auteur." );
        }
    }

    private void validationTitre( String titre ) throws Exception {
        if ( titre == null ) {
            throw new Exception( "Merci d'entrer le titre de livre." );
        }
    }

    private void validationResume( String resume ) throws Exception {
        if ( resume != null ) {
            int countOfTokens = new StringTokenizer( resume ).countTokens();

            if ( countOfTokens < 3 ) {
                throw new Exception( "le resume doit contenir au moins 3 mot ." );
            }
        } else {
            throw new Exception( "Merci d'entrer le resume de livre." );
        }
    }

    private int validationNbPages( String nbPages ) throws Exception {
        int temp;
        if ( nbPages != null ) {
            try {
                temp = Integer.parseInt( nbPages );

            } catch ( NumberFormatException e ) {
                throw new Exception( "Le nombre des pages doit être un nombre." );
            }
        } else {
            throw new Exception( "Merci d'entrer Le nombre des pages." );
        }
        return temp;
    }

    private void validationDomaine( String domaine ) throws Exception {
        if ( domaine != null ) {

            if ( domaine.length() < 5 ) {
                throw new Exception( "le domaine doit contenir au moins 5 caractères ." );
            }
        } else {
            throw new Exception( "Merci d'entrer le domaine de livre." );
        }
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
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
