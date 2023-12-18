package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceAccueil {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Voyagez en Bus MICDAVoyages");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Panel principal avec un BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel de navigation à gauche avec des boutons d'action et des icônes
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
        // Bordure noire de largeur 1

        // Ajout d'un espace vide pour augmenter l'espacement
        navPanel.add(Box.createVerticalStrut(30));

        // Ajout du texte "Menu"
        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        navPanel.add(menuLabel);
        navPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Ajout du bouton "Ajouter une réservation" avec une icône
        ImageIcon addIcon = createResizedIcon("img2.png", 30, 30);
        JButton addReservationButton = new JButton("Ajouter une réservation", addIcon);
        addReservationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addReservationButton.setMaximumSize(new Dimension(250, 50));
        navPanel.add(addReservationButton);

        // Ajout d'un espace vide supplémentaire
        navPanel.add(Box.createVerticalStrut(40));

        // Ajout du bouton "Mes réservations" avec une icône
        ImageIcon myReservationsIcon = createResizedIcon("img1.png", 30, 30);
        JButton myReservationsButton = new JButton("Liste des réservations ", myReservationsIcon);
        myReservationsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        myReservationsButton.setMaximumSize(new Dimension(250, 50));
        navPanel.add(myReservationsButton);

        navPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        mainPanel.add(navPanel, BorderLayout.WEST); // Ajout du panneau de navigation à gauche

        // Ajout d'un espace rigide en bas pour déplacer les composants vers le bas
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Panel pour le formulaire de réservation (partie droite de l'interface)
        JPanel reservationPanel = new JPanel();
        mainPanel.add(reservationPanel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);

        // Ajout d'un ActionListener au bouton "Ajouter une réservation"
        addReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir le formulaire de réservation dans le panel de droite
                SwingUtilities.invokeLater(() -> {
                    ReservationApp reservationApp = new ReservationApp();
                    reservationPanel.removeAll();
                    reservationPanel.add(reservationApp);
                    frame.revalidate();
                    frame.repaint();
                });
            }
        });
    }

    // Méthode pour redimensionner une icône
    private static ImageIcon createResizedIcon(String imagePath, int width, int height) {
        try {
            Image originalImage = new ImageIcon(imagePath).getImage();
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
