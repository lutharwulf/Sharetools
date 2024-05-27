package com.example.sharetools;

import java.util.Date;

public class Outils {
    private int idOutils;
    private String Nom_Outils;
    private Date Date_ajout;


    public Outils(int idOutils, String Nom_Outils, int score, Date Date_ajout) {
        this.setIdOutils( idOutils );
        this.setNomOutils( Nom_Outils );
        this.setDateAjout( Date_ajout );
    }

    public int getIdOutils() {
        return idOutils;
    }

    public void setIdOutils(int idScore) {
        this.idOutils = idScore;
    }

    public String getNomOutils() {
        return Nom_Outils;
    }

    public void setNomOutils(String name) {
        this.Nom_Outils = name;
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
