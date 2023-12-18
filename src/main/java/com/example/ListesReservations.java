package com.example;
   

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ListesReservations extends JPanel {

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
    private JButton payerButton;
    private JButton listeReservationsButton;
    private JButton detailsBtn;
    private JButton modifierBtn;
    private JButton supprimerBtn;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField numeroCarteIdentiteTextField;
    private JTextField numeroTelephoneTextField;
    private JComboBox<String> methodePaiementComboBox;
    private List<Reservation> reservations;
    private Paiement paiement;

     private void afficherInformationsReservationEtPaiement() {
        tableModel.setRowCount(0);
        for (Reservation reservation : reservations) {
            JButton detailsBtn = createButton("Détails", reservation);
            JButton modifierBtn = createButton("Modifier", reservation);
            JButton supprimerBtn = createButton("Supprimer", reservation);

            Object[] rowData = {
                    reservation.getNom(), reservation.getPrenom(), reservation.getEmail(),
                    reservation.getTypeBus(), reservation.getVilleDepart(), reservation.getVilleArrivee(),
                    new SimpleDateFormat("dd-MM-yyyy").format(reservation.getDateDepart()),
                    reservation.getHeureDepart(), reservation.getNumeroSiege(),
                    numeroCarteIdentiteTextField.getText(),
                    numeroTelephoneTextField.getText(),
                    methodePaiementComboBox.getSelectedItem(),
                    detailsBtn,
                    modifierBtn,
                    supprimerBtn
            };
            tableModel.addRow(rowData);
        }
    }
    private void afficherInformationsReservationEtPaiement(Reservation reservation) {
        // Récupérez les informations de paiement à partir des champs correspondants
        Paiement paiement = reservation.getPaiement();
        
            String numeroCarteIdentite = numeroCarteIdentiteTextField.getText();
            String numeroTelephone = numeroTelephoneTextField.getText();
            String methodePaiement = (String) methodePaiementComboBox.getSelectedItem();
    
            // Ajoutez le code pour afficher les informations de réservation et paiement
            // Utilisez JOptionPane ou tout autre moyen pour afficher les informations
            String details = "Billet réservé pour " + reservation.getNom() + "\n" + reservation.getPrenom() + "\n"
                    + "Email: " + reservation.getEmail() + "\n"
                    + "Type Bus: " + reservation.getTypeBus() + "\n"
                    + "Ville Départ: " + reservation.getVilleDepart() + "\n"
                    + "Ville Arrivée: " + reservation.getVilleArrivee() + "\n"
                    + "Date Départ: " + new SimpleDateFormat("dd-MM-yyyy").format(reservation.getDateDepart()) + "\n"
                    + "Heure Départ: " + reservation.getHeureDepart() + "\n"
                    + "Numéro Siège: " + reservation.getNumeroSiege() + "\n"
                    + "Numéro Carte d'Identité/Passeport: " + numeroCarteIdentite + "\n"
                    + "Numéro de Téléphone: " + numeroTelephone + "\n"
                    + "Méthode de Paiement: " + methodePaiement; 
    
            // JOptionPane.showMessageDialog(this, details, "Détails de la réservation", JOptionPane.INFORMATION_MESSAGE);
    }    
    
    
        // private void afficherDetailsReservation(Reservation reservation) {
        //     // Implémentez l'affichage des détails de la réservation
        //     // Utilisez les informations de la réservation pour afficher les détails
        //     JOptionPane.showMessageDialog(ListesReservations.this, "Détails de la réservation : " + reservation.toString(), 
        //        }
    
        // private void modifierReservation(Reservation reservation) {
        //     // Implémentez la logique de modification de la réservation
        //     // Utilisez les informations de la réservation pour effectuer les modifications nécessaires
        //     JOptionPane.showMessageDialog(ListesReservations.this, "Modifier la réservation : " + reservation.toString(), "Modification", JOptionPane.INFORMATION_MESSAGE);
        // }
    
        // private void supprimerReservation(Reservation reservation) {
        //     // Implémentez la logique de suppression de la réservation
        //     // Utilisez les informations de la réservation pour supprimer l'élément de la liste
        //     reservations.remove(reservation);
        //     afficherListeReservations(); // Mettez à jour l'affichage après la suppression
        // }
    private JButton createButton(String text, Reservation reservation) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez ici le code à exécuter lorsque le bouton est cliqué
                // Vous pouvez utiliser l'objet "reservation" pour accéder aux données de la réservation associée
                if (text.equals("Détails")) {
                    // Code pour afficher les détails de la réservation
                } else if (text.equals("Modifier")) {
                    // Code pour modifier la réservation
                } else if (text.equals("Supprimer")) {
                    // Code pour supprimer la réservation
                }
            }
      });
    
        // Ajoutez un ClientProperty pour stocker la réservation associée
        button.putClientProperty("reservation", reservation);
    
        return button;
    
 }
    
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            int selectedRow = table.getSelectedRow();
    
            if (selectedRow != -1) {
                Reservation reservation = reservations.get(selectedRow);
    
                if (source.getText().equals("Détails")) {
                    // Affichez les informations de réservation et paiement ici
                    afficherInformationsReservationEtPaiement(reservation);
                } else if (source.getText().equals("Modifier")) {
                    // Code pour modifier la réservation
                } else if (source.getText().equals("Supprimer")) {
                    // Code pour supprimer la réservation
                }
            }
        }
    }
private class ButtonRenderer implements TableCellRenderer {
        private final JPanel panel;
        private final JButton detailsButton;
        private final JButton modifierButton;
        private final JButton supprimerButton;
    
        public ButtonRenderer() {
            panel = new JPanel();
            detailsButton = new JButton("Détails");
            modifierButton = new JButton("Modifier");
            supprimerButton = new JButton("Supprimer");
    
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Utilisation de BoxLayout
            panel.add(detailsButton);
            panel.add(modifierButton);
            panel.add(supprimerButton);
    
            detailsButton.addActionListener(new ButtonClickListener());
            modifierButton.addActionListener(new ButtonClickListener());
            supprimerButton.addActionListener(new ButtonClickListener());
        }
    
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Votre logique pour la couleur d'arrière-plan
            if (isSelected) {
                panel.setForeground(table.getSelectionForeground());
                panel.setBackground(table.getSelectionBackground());
            } else {
                panel.setForeground(table.getForeground());
                panel.setBackground(UIManager.getColor("Button.background"));
            }
    
            // Retournez le panneau contenant les boutons
            return panel;
        }
    }
    
    private class ButtonEditor extends DefaultCellEditor {
        private final JPanel panel;
        private final JButton detailsButton;
        private final JButton modifierButton;
        private final JButton supprimerButton;
    
        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            panel = new JPanel();
            detailsButton = new JButton("Détails");
            modifierButton = new JButton("Modifier");
            supprimerButton = new JButton("Supprimer");
    
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Utilisation de BoxLayout
            panel.add(detailsButton);
            panel.add(modifierButton);
            panel.add(supprimerButton);
    
            detailsButton.addActionListener(new ButtonClickListener());
            modifierButton.addActionListener(new ButtonClickListener());
            supprimerButton.addActionListener(new ButtonClickListener());
        }
    
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            // Votre logique pour la couleur d'arrière-plan
            if (isSelected) {
                panel.setForeground(table.getSelectionForeground());
                panel.setBackground(table.getSelectionBackground());
            } else {
                panel.setForeground(table.getForeground());
                panel.setBackground(table.getBackground());
            }
    
            // Retournez le panneau contenant les boutons
            return panel;
        }
    
        @Override
        public Object getCellEditorValue() {
            // Retournez la valeur appropriée
            return null;
        }
    }
    public ListesReservations() {
        // setLayout(new GridBagLayout());
        // GridBagConstraints gbc = new GridBagConstraints();
        // gbc.insets = new Insets(0, 5, 5, 5);

        // nomTextField = new JTextField(89);
        // prenomTextField = new JTextField(89);
        // emailTextField = new JTextField(89);
        // typeComboBox = new JComboBox<>(new String[]{"", "Bus climatisé 37 places", "Bus climatisé 49 places",
        //         "Bus climatisé 55 places", "Bus non climatisé 20 places", "Bus non climatisé 28 places",
        //         "Bus climatisé 44 places", "Bus non climatisé 66 places"});
        // villeDepartComboBox = new JComboBox<>(
        //         new String[]{"", "Thiès", "Dakar", "Saint Louis", "Kaolack", "Kolda", "Ziguinchor", "Matam",
        //                 "Diourbel", "Fatick", "Kaffrine", "Tambacounda", "Sédhiou", "Kédougou", "Louga"});
        // villeArriveeComboBox = new JComboBox<>(
        //         new String[]{"", "Thiès", "Dakar", "Saint Louis", "Kaolack", "Kolda", "Ziguinchor", "Matam",
        //                 "Diourbel", "Fatick", "Kaffrine", "Tambacounda", "Sédhiou", "Kédougou", "Louga"});
        // dateDepartChooser = new JDateChooser();
        // heureDepartComboBox = new JComboBox<>(
        //         new String[]{"", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00",
        //                 "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00"});
        // numeroSiegeTextField = new JTextField(89);
        // reserverButton = new JButton("Réserver");
        // payerButton = new JButton("Payer");
        // listeReservationsButton = new JButton("Liste des réservations");
        // numeroCarteIdentiteTextField = new JTextField(20);
        // numeroTelephoneTextField = new JTextField(20);
        // methodePaiementComboBox = new JComboBox<>(new String[]{"", "cp_Cash Paiement", "mp_Mobile Money"});

        detailsBtn = new JButton("Détails");
        modifierBtn = new JButton("Modifier");
        supprimerBtn = new JButton("Supprimer");

            
        // Initialisation du modèle de tableau
        String[] columnNames = {"Nom", "Prénom", "Email", "Type Bus", "Ville Départ", "Ville Arrivée", "Date Départ",
                "Heure Départ", "Numéro Siège", "Numéro Carte d'Identité/Passeport", "Numéro de Téléphone",
                "Méthode de Paiement", "Actions"};

        tableModel = new DefaultTableModel(columnNames, 0) {
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Retourner la classe JButton pour la colonne "Actions"
                if (columnIndex == getColumnCount() - 1) { // La dernière colonne est "Actions"
                    return JButton.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };

        table = new JTable(tableModel);
        int[] columnWidths = {300, 300, 400, 400, 400, 400, 400, 300, 300, 300, 300, 300, 1600};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        
        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // add(new JLabel("Nom:"), gbc);
        // gbc.gridx = 1;
        // add(nomTextField, gbc);

        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(new JLabel("Prénom:"), gbc);
        // gbc.gridx = 1;
        // add(prenomTextField, gbc);

        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(new JLabel("Email:"), gbc);
        // gbc.gridx = 1;
        // add(emailTextField, gbc);

        // typeComboBox.setPreferredSize(new Dimension(800, 25));gbc.gridx = 0;
        // gbc.gridy++;
        // add(new JLabel("Type de Bus:"), gbc);
        // gbc.gridx = 1;
        // add(typeComboBox, gbc);

        // villeDepartComboBox.setPreferredSize(new Dimension(800, 25));
        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(new JLabel("Ville de départ:"), gbc);
        // gbc.gridx = 1;
        // add(villeDepartComboBox, gbc);

        // villeArriveeComboBox.setPreferredSize(new Dimension(800, 25));
        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(new JLabel("Ville d'arrivée:"), gbc);
        // gbc.gridx = 1;
        // add(villeArriveeComboBox, gbc);

        // dateDepartChooser.setPreferredSize(new Dimension(800, 25));
        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(new JLabel("Date de départ:"), gbc);
        // gbc.gridx = 1;
        // add(dateDepartChooser, gbc);

        // heureDepartComboBox.setPreferredSize(new Dimension(800, 25));
        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(new JLabel("Heure de départ:"), gbc);
        // gbc.gridx = 1;
        // add(heureDepartComboBox, gbc);

        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(new JLabel("Numéro de siège:"), gbc);
        // gbc.gridx = 1;
        // add(numeroSiegeTextField, gbc);

        // gbc.gridx = 0;
        // gbc.gridy++;
        // gbc.gridwidth = 2;
        // add(reserverButton, gbc);

        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(payerButton, gbc);
        // payerButton.setPreferredSize(new Dimension(90, 25));

        // gbc.gridx = 0;
        // gbc.gridy++;
        // add(listeReservationsButton, gbc);
        // listeReservationsButton.setPreferredSize(new Dimension(1000, 25));
        
        table.setDefaultRenderer(JButton.class, new ButtonRenderer());
        table.setDefaultEditor(JButton.class, new ButtonEditor(new JCheckBox()));

        // Ajout des boutons dans la colonne "Actions"
        // gbc.gridx = 0;
        // gbc.gridy++;
        // gbc.gridwidth = 2;
        // gbc.weightx = 1.0;
        // gbc.weighty = 1.0;
        // gbc.fill = GridBagConstraints.BOTH;
        // JScrollPane scrollPane = new JScrollPane(table);
        // scrollPane.setPreferredSize(new Dimension(1000, 400));
        // add(scrollPane, gbc);

        // reserverButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         reserverButtonActionPerformed(e);
        //     }
        // });

        // payerButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         payerButtonActionPerformed(e);
        //     }
        // });

    //     listeReservationsButton.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             afficherListeReservations();
    //         }
    //     });
    //     reservations = new ArrayList<>();
    // }

    // private void reserverButtonActionPerformed(ActionEvent e) {
    //     Reservation nouvelleReservation = new Reservation(
    //             nomTextField.getText(), prenomTextField.getText(), emailTextField.getText(),
    //             (String) typeComboBox.getSelectedItem(), (String) villeDepartComboBox.getSelectedItem(),
    //             (String) villeArriveeComboBox.getSelectedItem(), dateDepartChooser.getDate(),
    //             (String) heureDepartComboBox.getSelectedItem(), Integer.parseInt(numeroSiegeTextField.getText()));

    //     reservations.add(nouvelleReservation);
    //     afficherListeReservations();

    //     // Vider le formulaire après la réservation
    //     nomTextField.setText("");
    //     prenomTextField.setText("");
    //     emailTextField.setText("");
    //     typeComboBox.setSelectedIndex(0);
    //     villeDepartComboBox.setSelectedIndex(0);
    //     villeArriveeComboBox.setSelectedIndex(0);
    //     dateDepartChooser.setDate(null);
    //     heureDepartComboBox.setSelectedIndex(0);
    //     numeroSiegeTextField.setText("");
    // }

    // private void payerButtonActionPerformed(ActionEvent e) {
    //     int option = JOptionPane.showConfirmDialog(this, createPaiementPanel(), "Paiement",
    //             JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    //     if (option == JOptionPane.OK_OPTION) {
    //         afficherInformationsReservationEtPaiement();
    //         numeroCarteIdentiteTextField.setText("");
    //         numeroTelephoneTextField.setText("");
    //         methodePaiementComboBox.setSelectedIndex(0);
    //     }
    // }

    // private JPanel createPaiementPanel() {
    //     JPanel panel = new JPanel(new GridBagLayout());
    //     GridBagConstraints gbc = new GridBagConstraints();
    //     gbc.insets = new Insets(5, 5, 5, 5);

    //     gbc.gridx = 0;
    //     gbc.gridy = 0;
    //     panel.add(new JLabel("Numéro Carte d'Identité/Passeport:"), gbc);
    //     gbc.gridx = 1;
    //     panel.add(numeroCarteIdentiteTextField, gbc);

    //     gbc.gridx = 0;
    //     gbc.gridy++;
    //     panel.add(new JLabel("Numéro de Téléphone:"), gbc);
    //     gbc.gridx = 1;
    //     panel.add(numeroTelephoneTextField, gbc);

    //     methodePaiementComboBox.setPreferredSize(new Dimension(180, 25));
    //     gbc.gridx = 0;
    //     gbc.gridy++;
    //     panel.add(new JLabel("Méthode de Paiement:"), gbc);
    //     gbc.gridx = 1;
    //     panel.add(methodePaiementComboBox, gbc);

    //     return panel;
    // }

    // private void afficherListeReservations() {
    //     tableModel.setRowCount(0);
    //     for (Reservation reservation : reservations) {
    //         Object[] rowData = {
    //                 reservation.getNom(), reservation.getPrenom(), reservation.getEmail(),
    //                 reservation.getTypeBus(), reservation.getVilleDepart(), reservation.getVilleArrivee(),
    //                 new SimpleDateFormat("dd-MM-yyyy").format(reservation.getDateDepart()),
    //                 reservation.getHeureDepart(), reservation.getNumeroSiege(),
    //                 numeroCarteIdentiteTextField.getText(),
    //                 numeroTelephoneTextField.getText(),
    //                 methodePaiementComboBox.getSelectedItem(),
    //         };
    //         tableModel.addRow(rowData);
    //     }
    // }

    
    
    
    
    
    
        //        public static void main(String[] args) {
        //     SwingUtilities.invokeLater(() -> {
        //         JFrame frame = new JFrame("Application de Réservation");
        //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //         frame.getContentPane().add(new ReservationApp());
        //         frame.pack();
        //         frame.setLocationRelativeTo(null);
        //         frame.setVisible(true);
        //     });
        // }
    }

}
