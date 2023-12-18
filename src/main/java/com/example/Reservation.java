package com.example;

import java.util.Date;

public class Reservation {
    private String nom;
    private String prenom;
    private String email;
    private String typeBus;
    private String villeDepart;
    private String villeArrivee;
    private Date dateDepart;
    private String heureDepart;
    private int numeroSiege;
    private Paiement paiement;

    public Reservation(String nom, String prenom, String email, String typeBus, String villeDepart,
                       String villeArrivee, Date dateDepart, String heureDepart, int numeroSiege) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.typeBus = typeBus;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepart = dateDepart;
        this.heureDepart = heureDepart;
        this.numeroSiege = numeroSiege;
    }

    // Getters (et éventuellement des setters) pour accéder aux propriétés
    // Assurez-vous de générer ces méthodes dans votre IDE ou les écrire manuellement.
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTypeBus() {
        return typeBus;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public int getNumeroSiege() {
        return numeroSiege;
    }
    public Paiement getPaiement() {
        return paiement;
    }
    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
}

