package com.applib.beans;

public class Livre {
    private String issn;
    private String numAuteur;
    private String titre;
    private String resume;
    private String domaine;
    private int    nbPages;

    public String getIssn() {
        return issn;
    }

    public void setIssn( String issn ) {
        this.issn = issn;
    }

    public String getNumAuteur() {
        return numAuteur;
    }

    public void setNumAuteur( String idauteur ) {
        this.numAuteur = idauteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre( String titre ) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume( String resume ) {
        this.resume = resume;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages( int nbPages ) {
        this.nbPages = nbPages;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine( String domaine ) {
        this.domaine = domaine;
    }

}
