package com.example;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationApp extends JPanel {
    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField emailTextField;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> villeDepartComboBox;
    private JComboBox<String> villeArriveeComboBox;
    private JDateChooser dateDepartChooser;
    private JComboBox<String> heureDepartComboBox;
    private JTextField numeroSiegeTextField;
    private JButton reserverButton;
    private JButton listeReservationsButton;
    private JTable table;
    private DefaultTableModel tableModel;

    private int numeroSiegeReserve;
    private List<Reservation> reservations;

    public ReservationApp() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        nomTextField = new JTextField(20);
        prenomTextField = new JTextField(20);
        emailTextField = new JTextField(20);
        typeComboBox = new JComboBox<>(new String[] { "", "Bus climatisé 37 places", "Bus climatisé 49 places",
                "Bus climatisé 55 places", "Bus non climatisé 20 places", "Bus non climatisé 28 places",
                "Bus climatisé 44 places", "Bus non climatisé 66 places" });
        villeDepartComboBox = new JComboBox<>(
                new String[] { "", "Thiès", "Dakar", "Saint Louis", "Kaolack", "Kolda", "Ziguinchor", "Matam",
                        "Diourbel", "Fatick", "Kaffrine", "Tambacounda", "Sédhiou", "Kédougou", "Louga" });
        villeArriveeComboBox = new JComboBox<>(
                new String[] { "", "Thiès", "Dakar", "Saint Louis", "Kaolack", "Kolda", "Ziguinchor", "Matam",
                        "Diourbel", "Fatick", "Kaffrine", "Tambacounda", "Sédhiou", "Kédougou", "Louga" });
        dateDepartChooser = new JDateChooser();
        heureDepartComboBox = new JComboBox<>(
                new String[] { "", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00",
                        "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00" });
        numeroSiegeTextField = new JTextField(20);
        reserverButton = new JButton("Réserver");
        listeReservationsButton = new JButton("Liste des réservations");

        // Initialisation du modèle de tableau
        String[] columnNames = { "Nom", "Prénom", "Email", "Type Bus", "Ville Départ", "Ville Arrivée", "Date Départ",
                "Heure Départ", "Numéro Siège" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Ajout des composants au panneau
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nom:"), gbc);
        gbc.gridx = 1;
        add(nomTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Prénom:"), gbc);
        gbc.gridx = 1;
        add(prenomTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        add(emailTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Type de Bus:"), gbc);
        gbc.gridx = 1;
        add(typeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Ville de départ:"), gbc);
        gbc.gridx = 1;
        add(villeDepartComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Ville d'arrivée:"), gbc);
        gbc.gridx = 1;
        add(villeArriveeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Date de départ:"), gbc);
        gbc.gridx = 1;
        add(dateDepartChooser, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Heure de départ:"), gbc);
        gbc.gridx = 1;
        add(heureDepartComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Numéro de siège:"), gbc);
        gbc.gridx = 1;
        add(numeroSiegeTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(reserverButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(listeReservationsButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(table), gbc);

        // Initialisation des actions des boutons
        reserverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserverButtonActionPerformed(e);
            }
        });

        listeReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherListeReservations();
            }
        });

        // Initialisation de la liste des réservations
        reservations = new ArrayList<>();
    }

    private void reserverButtonActionPerformed(ActionEvent e) {
        // Logique de réservation existante...

        // Ajout de la nouvelle réservation à la liste
        Reservation nouvelleReservation = new Reservation(
                nomTextField.getText(), prenomTextField.getText(), emailTextField.getText(),
                (String) typeComboBox.getSelectedItem(), (String) villeDepartComboBox.getSelectedItem(),
                (String) villeArriveeComboBox.getSelectedItem(), dateDepartChooser.getDate(),
                (String) heureDepartComboBox.getSelectedItem(), Integer.parseInt(numeroSiegeTextField.getText()));

        reservations.add(nouvelleReservation);

        // Afficher la liste mise à jour des réservations dans le tableau
        afficherListeReservations();
    }

    private void afficherListeReservations() {
        // Supprimer toutes les lignes actuelles du tableau
        tableModel.setRowCount(0);

        // Remplir le tableau avec les données des réservations
        for (Reservation reservation : reservations) {
            Object[] rowData = {
                    reservation.getNom(), reservation.getPrenom(), reservation.getEmail(),
                    reservation.getTypeBus(), reservation.getVilleDepart(), reservation.getVilleArrivee(),
                    new SimpleDateFormat("dd-MM-yyyy").format(reservation.getDateDepart()),
                    reservation.getHeureDepart(), reservation.getNumeroSiege()
            };
            tableModel.addRow(rowData);
        }
    }

    // Classe interne pour représenter une réservation
    private class Reservation {
        private String nom;
        private String prenom;
        private String email;
        private String typeBus;
        private String villeDepart;
        private String villeArrivee;
        private Date dateDepart;
        private String heureDepart;
        private int numeroSiege;

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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Application de Réservation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ReservationApp());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
