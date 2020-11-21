package com.applib.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.applib.beans.Auteur;
import com.applib.dao.AuteurDao;
import com.applib.forms.CreationAuteurForm;

@WebServlet( "/CreationAuteur" )
public class CreationAuteur extends HttpServlet {

    public CreationAuteur() {
        super();
    }

    private static final long  serialVersionUID = 1L;
    public static final String ATT_AUTEUR       = "auteur";
    public static final String ATT_FORM         = "form";
    public static final String VUE_FORM         = "/WEB-INF/CreationAuteur.jsp";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CreationAuteurForm form = new CreationAuteurForm();

        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */
        Auteur autreur = form.creerAuteur( request );
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        if ( form.getErreurs().isEmpty() ) {
            request.setAttribute( ATT_AUTEUR, null );
            int insert_done = 0;
            AuteurDao auteurdao = new AuteurDao();
            // ajoute auteurr a db
            insert_done = auteurdao.ajouter_auteur_db( autreur );
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
            if ( insert_done == 1 ) {
                this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
            } else {
                form.setResultat( "Échec de la création du client db" );
                request.setAttribute( ATT_AUTEUR, autreur );
                request.setAttribute( ATT_FORM, form );
                this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
            }

        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            request.setAttribute( ATT_AUTEUR, autreur );
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );

        }
    }
}
