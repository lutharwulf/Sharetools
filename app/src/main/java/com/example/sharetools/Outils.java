package com.example.sharetools;

import java.util.Date;

public class Outils {
    //private int idOutils;
    private String Nom_Outils;
    private Date Date_ajout;
    private String Descr_outils;

    public Outils() {
    }
    /*int idOutils,*/
    public Outils( String Nom_Outils, String Descr_outils, Date Date_ajout) {
        //this.setIdOutils( idOutils );
        setNomOutils( Nom_Outils );
        setDescroutils (Descr_outils);
        this.setDateAjout( Date_ajout );
    }

    //public int getIdOutils() {return idOutils;}

    //public void setIdOutils(int idScore) {this.idOutils = idScore;    }

    public String getNomOutils() {
        return Nom_Outils;
    }

    public void setNomOutils(String name) {
        this.Nom_Outils = name;
    }

    public String getDescroutils() {
        return Descr_outils;
    }

    public void setDescroutils(String Descr_outils) {
        this.Descr_outils = Descr_outils;
    }

    public Date getDateajout() {
        return Date_ajout;
    }

    public void setDateAjout(Date when) {
        this.Date_ajout = when;
    }

    /*@Override
    public String toString() {
        return idScore + ": " + name + " -> " + score + " at " + when.toString();
    }*/
}
