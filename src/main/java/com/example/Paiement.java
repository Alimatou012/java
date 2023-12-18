package com.example;


public class Paiement {
    private String numeroCarteIdentite;
    private String numeroTelephone;
    private String methodePaiement;

    // Constructeur
    public Paiement(String numeroCarteIdentite, String numeroTelephone, String methodePaiement) {
        this.numeroCarteIdentite = numeroCarteIdentite;
        this.numeroTelephone = numeroTelephone;
        this.methodePaiement = methodePaiement;
    }

    // Méthode pour obtenir les détails de paiement
    public String obtenirDetailsPaiement() {
        return "Numéro Carte d'Identité/Passeport: " + numeroCarteIdentite + "\n"
                + "Numéro de Téléphone: " + numeroTelephone + "\n"
                + "Méthode de Paiement: " + methodePaiement;
    }
}
