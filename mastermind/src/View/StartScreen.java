package View;
import Controller.MastermindController;
import Model.MastermindGame;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.io.IOException;


public class StartScreen extends JFrame {

    public StartScreen() {
        super("Start");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0, 180, 216));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Charger et redimensionner l'image
        ImageIcon originalIcon = new ImageIcon("mastermind/src/View/Images/logo.png");
        Image image = originalIcon.getImage();
        Image newimg = image.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(newimg);

        JButton buttonStart = new JButton("Commencer");
        JButton buttonLeave = new JButton("Quitter");

        JLabel labelRounds = new JLabel("Nombre de manches");

        JSlider slideRounds = new JSlider();
        slideRounds.setBackground(Color.ORANGE);
        slideRounds.setMaximum(5);
        slideRounds.setMinimum(1);
        slideRounds.setValue(3);
        slideRounds.setPaintTicks(true);
        slideRounds.setPaintLabels(true);
        slideRounds.setMinorTickSpacing(1);
        slideRounds.setMajorTickSpacing(1);

        JLabel labelColorsNumber = new JLabel("Nombre de pions disponible");

        JSlider slideColorsNumber = new JSlider();
        slideColorsNumber.setBackground(Color.ORANGE);
        slideColorsNumber.setMaximum(8);
        slideColorsNumber.setMinimum(1);
        slideColorsNumber.setValue(8);
        slideColorsNumber.setPaintTicks(true);
        slideColorsNumber.setPaintLabels(true);
        slideColorsNumber.setMinorTickSpacing(1);
        slideColorsNumber.setMajorTickSpacing(1);

        JLabel labelHoleNumber = new JLabel("Nombre de pions d'une combinaison");

        JSlider slideHoleNumber = new JSlider();
        slideHoleNumber.setBackground(Color.ORANGE);
        slideHoleNumber.setMaximum(6);
        slideHoleNumber.setMinimum(1);
        slideHoleNumber.setValue(4);
        slideHoleNumber.setPaintTicks(true);
        slideHoleNumber.setPaintLabels(true);
        slideHoleNumber.setMinorTickSpacing(1);
        slideHoleNumber.setMajorTickSpacing(1);

        JLabel labelAttempts = new JLabel("Nombre de tentatives");

        JSlider slideAttempts = new JSlider();
        slideAttempts.setBackground(Color.ORANGE);
        slideAttempts.setMaximum(12);
        slideAttempts.setMinimum(1);
        slideAttempts.setValue(10);
        slideAttempts.setPaintTicks(true);
        slideAttempts.setPaintLabels(true);
        slideAttempts.setMinorTickSpacing(1);
        slideAttempts.setMajorTickSpacing(1);

        JLabel labelDifficulty = new JLabel("Difficulté");

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 2, 1);
        slider.setBackground(Color.ORANGE);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(1);

        Dictionary<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("Facile"));
        labelTable.put(1, new JLabel("Classique"));
        labelTable.put(2, new JLabel("Numérique"));
        slider.setLabelTable(labelTable);


        JButton buttonBack = new JButton("Retour");
        JButton buttonPlay = new JButton("Jouer");

        panel.add(new JLabel(icon), gbc);
        panel.add(buttonStart, gbc);
        panel.add(buttonLeave, gbc);

        buttonStart.addActionListener( actionEvent  -> {
            panel.removeAll();
            gbc.gridx = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            panel.add(new JLabel(icon), gbc);
            panel.add(labelRounds, gbc);
            panel.add(slideRounds, gbc);
            panel.add(labelColorsNumber, gbc);
            panel.add(slideColorsNumber, gbc);
            panel.add(labelHoleNumber, gbc);
            panel.add(slideHoleNumber, gbc);
            panel.add(labelAttempts, gbc);
            panel.add(slideAttempts, gbc);
            panel.add(labelDifficulty, gbc);
            panel.add(slider, gbc);

            gbc.gridwidth = 1;
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.NONE;

            // Bouton "Retour" à gauche
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(buttonBack, gbc);

            // Bouton "Jouer" à droite
            gbc.gridx = 2;
            gbc.weightx = 0;
            gbc.anchor = GridBagConstraints.EAST;
            panel.add(buttonPlay, gbc);

            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;

            panel.updateUI();
        });

        buttonLeave.addActionListener( actionEvent  -> {
            System.exit(0);
        });

        buttonBack.addActionListener( actionEvent ->{
            panel.removeAll();
            panel.add(new JLabel(icon), gbc);
            panel.add(buttonStart, gbc);
            panel.add(buttonLeave, gbc);
            panel.updateUI();
        });

        buttonPlay.addActionListener( actionEvent ->{
//            System.out.println("Slide colors : " + slideColorsNumber.getValue() + ", Slide rounds : " + slideRounds.getValue() + ", Slide hole number : " + slideHoleNumber.getValue());
            MastermindGame model = new MastermindGame(slideColorsNumber.getValue(), slideAttempts.getValue(), slideHoleNumber.getValue());
            MastermindController controller = new MastermindController(model);
            controller.startGame();
            StartScreen.this.dispose();
        });

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
