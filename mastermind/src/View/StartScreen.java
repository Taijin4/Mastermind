package View;
import Controller.MastermindController;
import Model.ClassicHint;
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
        setSize(1000, 1050);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0, 180, 216));

        Font customFont = new Font("Helvetica", Font.BOLD, 16);
        Color customTextColor = new Color(0xCA, 0xF0, 0xF8);
        UIManager.put("Label.font", customFont);
        UIManager.put("Label.foreground", customTextColor);
        UIManager.put("Button.font", customFont);
        UIManager.put("Slider.font", customFont);
        UIManager.put("Slider.foreground", customTextColor);
        UIManager.put("ComboBox.font", customFont);
        UIManager.put("ComboBox.foreground", customTextColor);
        UIManager.put("TextField.font", customFont);
        UIManager.put("TextField.foreground", customTextColor);
        UIManager.put("TextArea.font", customFont);
        UIManager.put("TextArea.foreground", customTextColor);
        UIManager.put("Menu.font", customFont);
        UIManager.put("Menu.foreground", customTextColor);
        UIManager.put("MenuItem.font", customFont);
        UIManager.put("MenuItem.foreground", customTextColor);
        UIManager.put("RadioButton.font", customFont);
        UIManager.put("RadioButton.foreground", customTextColor);
        UIManager.put("CheckBox.font", customFont);
        UIManager.put("CheckBox.foreground", customTextColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        ImageIcon originalIcon = new ImageIcon("mastermind/src/View/Images/logo.png");
        Image image = originalIcon.getImage();
        Image newimg = image.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(newimg);

        JButton buttonStart = createStyledButton("Commencer");
        JButton buttonLeave = createStyledButton("Quitter");

        JLabel labelRounds = new JLabel("Nombre de manches");
        JSlider slideRounds = createStyledSlider(1, 5, 3);

        JLabel labelColorsNumber = new JLabel("Nombre de pions disponibles");
        JSlider slideColorsNumber = createStyledSlider(1, 8, 8);

        JLabel labelHoleNumber = new JLabel("Nombre de pions d'une combinaison");
        JSlider slideHoleNumber = createStyledSlider(1, 6, 4);

        JLabel labelAttempts = new JLabel("Nombre de tentatives");
        JSlider slideAttempts = createStyledSlider(1, 12, 10);

        JLabel labelDifficulty = new JLabel("Difficulté");
        JSlider slider = createStyledSlider(0, 2, 1);

        Dictionary<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("Facile"));
        labelTable.put(1, new JLabel("Classique"));
        labelTable.put(2, new JLabel("Numérique"));
        slider.setLabelTable(labelTable);

        JButton buttonBack = createStyledButton("Retour");
        JButton buttonPlay = createStyledButton("Jouer");

        panel.add(new JLabel(icon), gbc);
        panel.add(buttonStart, gbc);
        panel.add(buttonLeave, gbc);

        buttonStart.addActionListener(actionEvent -> {
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

            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(buttonBack, gbc);

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

        buttonLeave.addActionListener(actionEvent -> {
            System.exit(0);
        });

        buttonBack.addActionListener(actionEvent -> {
            panel.removeAll();
            panel.add(new JLabel(icon), gbc);
            panel.add(buttonStart, gbc);
            panel.add(buttonLeave, gbc);
            panel.updateUI();
        });

        buttonPlay.addActionListener(actionEvent -> {
            MastermindGame model = new MastermindGame(slideColorsNumber.getValue(), slideRounds.getValue(), slideHoleNumber.getValue(), slideAttempts.getValue());
            MastermindController controller = new MastermindController(model, slider.getValue());
            controller.startGame();
            StartScreen.this.dispose();
        });

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        button.setBackground(new Color(0xCA, 0xF0, 0xF8));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 50)); // Largeur fixe
        return button;
    }

    private JSlider createStyledSlider(int min, int max, int value) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, value);
        slider.setBackground(new Color(0, 180, 216));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(1);
        return slider;
    }
}
