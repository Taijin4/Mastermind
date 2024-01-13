package View;

import Controller.MastermindController;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends JFrame implements MastermindGameObserver {
    JButton[][] hintButtonsList;
    MastermindGame model;

    public GameScreen(MastermindController controller, MastermindGame model) {
        setTitle("Mastermind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1050);
        setLocationRelativeTo(null);
        setVisible(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.model = model;

        final JButton[] actualClickedColor = {new JButton()};
        hintButtonsList = new JButton[model.getNbTrys()][model.getNbHoleCombination()];

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new java.awt.Color(0, 180, 216));

        JPanel gamePanel = new JPanel(new GridLayout(1, 2));
        gamePanel.setBackground(new java.awt.Color(0, 180, 216));
        JPanel gameLinesPanel = new JPanel(new GridLayout(model.getNbTrys(), 1));
        gameLinesPanel.setBackground(new java.awt.Color(0, 180, 216));

        for (int i = 0; i < model.getNbTrys(); i++) {
            JPanel linePanel = new JPanel();
            linePanel.setBackground(new java.awt.Color(0, 180, 216));
            linePanel.setLayout(new FlowLayout()); // Aligne les boutons de chaque ligne verticalement
            for (int j = 0; j < model.getNbHoleCombination(); j++) {
                JButton button = new JButton(new ImageIcon(getClass().getResource("Images/circle.png")));
                button.setName(String.valueOf(i) + " - " + String.valueOf(j));
                button.setContentAreaFilled(false); // Supprime l'arrière-plan
                button.setBorderPainted(false); // Supprime la bordure
                button.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
                button.setOpaque(false);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!controller.isRoundEnd()) {
                            JButton clicked = (JButton) e.getSource();
                            if ((actualClickedColor[0].getIcon() != null) && Integer.parseInt(String.valueOf(clicked.getName().substring(0, 2)).trim()) == model.getNbTrys() - model.getActualTry()) {
                                clicked.setIcon(actualClickedColor[0].getIcon());
                                controller.addColorInCombination(Model.Color.valueOf(actualClickedColor[0].getName()), Integer.parseInt(String.valueOf(clicked.getName().charAt(clicked.getName().length() - 1))));
                            }
                        }
                    }
                });
                linePanel.add(button);
            }

            int nbColumns = model.getNbHoleCombination() % 2 != 0 ? (model.getNbHoleCombination() / 2 + 1) : (model.getNbHoleCombination() / 2);

            JPanel hintPanel = new JPanel(new GridLayout(2, nbColumns));
            hintPanel.setBackground(new java.awt.Color(0, 180, 216));
            int minusButton = 0;
            int nb = 0;
            for (int j = 0; j < 2; j++) {
                JPanel lineHintPanel = new JPanel();
                lineHintPanel.setBackground(new java.awt.Color(0, 180, 216));
                lineHintPanel.setLayout(new FlowLayout());
                for (int k = 0; k < nbColumns - minusButton; k++) {
                    JButton button = new JButton(new ImageIcon(getClass().getResource("Images/little_circle.png")));
                    button.setContentAreaFilled(false); // Supprime l'arrière-plan
                    button.setBorderPainted(false); // Supprime la bordure
                    button.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
                    button.setOpaque(false);
                    lineHintPanel.add(button);
                    hintButtonsList[i][nb] = button;
                    nb++;
                }
                hintPanel.add(lineHintPanel);
                if (model.getNbHoleCombination() % 2 != 0)
                    minusButton = 1;
            }

            linePanel.add(hintPanel);
            gameLinesPanel.add(linePanel);
        }
        gamePanel.add(gameLinesPanel);
        mainPanel.add(gamePanel, BorderLayout.CENTER);

        JButton red = new JButton(new ImageIcon(getClass().getResource("Images/red.png")));
        red.setName("RED");
        red.setContentAreaFilled(false); // Supprime l'arrière-plan
        red.setBorderPainted(false); // Supprime la bordure
        red.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        red.setOpaque(false);

        JButton blue = new JButton(new ImageIcon(getClass().getResource("Images/blue.png")));
        blue.setName("BLUE");
        blue.setContentAreaFilled(false); // Supprime l'arrière-plan
        blue.setBorderPainted(false); // Supprime la bordure
        blue.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        blue.setOpaque(false);

        JButton green = new JButton(new ImageIcon(getClass().getResource("Images/green.png")));
        green.setName("GREEN");
        green.setContentAreaFilled(false); // Supprime l'arrière-plan
        green.setBorderPainted(false); // Supprime la bordure
        green.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        green.setOpaque(false);

        JButton orange = new JButton(new ImageIcon(getClass().getResource("Images/orange.png")));
        orange.setName("ORANGE");
        orange.setContentAreaFilled(false); // Supprime l'arrière-plan
        orange.setBorderPainted(false); // Supprime la bordure
        orange.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        orange.setOpaque(false);

        JButton yellow = new JButton(new ImageIcon(getClass().getResource("Images/yellow.png")));
        yellow.setName("YELLOW");
        yellow.setContentAreaFilled(false); // Supprime l'arrière-plan
        yellow.setBorderPainted(false); // Supprime la bordure
        yellow.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        yellow.setOpaque(false);

        JButton pink = new JButton(new ImageIcon(getClass().getResource("Images/pink.png")));
        pink.setName("PINK");
        pink.setContentAreaFilled(false); // Supprime l'arrière-plan
        pink.setBorderPainted(false); // Supprime la bordure
        pink.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        pink.setOpaque(false);

        JButton purple = new JButton(new ImageIcon(getClass().getResource("Images/purple.png")));
        purple.setName("PURPLE");
        purple.setContentAreaFilled(false); // Supprime l'arrière-plan
        purple.setBorderPainted(false); // Supprime la bordure
        purple.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        purple.setOpaque(false);

        JButton gray = new JButton(new ImageIcon(getClass().getResource("Images/gray.png")));
        gray.setName("GRAY");
        gray.setContentAreaFilled(false); // Supprime l'arrière-plan
        gray.setBorderPainted(false); // Supprime la bordure
        gray.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        gray.setOpaque(false);

        List<JButton> buttonColorsList = new ArrayList<JButton>();
        buttonColorsList.add(red);
        buttonColorsList.add(blue);
        buttonColorsList.add(green);
        buttonColorsList.add(yellow);
        buttonColorsList.add(orange);
        buttonColorsList.add(pink);
        buttonColorsList.add(purple);
        buttonColorsList.add(gray);

        for (JButton colorButton : buttonColorsList) {
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Récupère le bouton cliqué
                    if (!controller.isRoundEnd()) {
                        JButton clickedButton = (JButton) e.getSource();
                        actualClickedColor[0] = clickedButton;
                    }
                }
            });
        }

        JPanel colorsPanel = new JPanel(new GridBagLayout());
        colorsPanel.setBackground(new java.awt.Color(0, 180, 216));
        JPanel colorsButtonPanel = new JPanel();
        colorsButtonPanel.setBackground(new java.awt.Color(0, 180, 216));
        colorsButtonPanel.setLayout(new BoxLayout(colorsButtonPanel, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < model.getNbColor(); i++) {
            colorsButtonPanel.add(buttonColorsList.get(i));
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        colorsPanel.add(colorsButtonPanel, gbc);

        mainPanel.add(colorsPanel, BorderLayout.WEST);

        // Utilisation de Box pour disposer les boutons verticalement avec une marge
        Box buttonBox = Box.createVerticalBox();
        JButton nextTurn = new JButton("Valider la tentative");
        nextTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!controller.isRoundEnd()) {
                    if (model.getPlayerCombination().isValid()) {
                        controller.submitTry();
                    }
                }
            }
        });
        JButton nextRound = new JButton("Prochaine manche");
        nextRound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.endRound();
                GameScreen.this.dispose();
            }
        });

        buttonBox.add(nextTurn);
        buttonBox.add(Box.createRigidArea(new Dimension(0, 10))); // Ajoute une marge de 10 pixels
        buttonBox.add(nextRound);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new java.awt.Color(0, 180, 216));

        // Centre les boutons horizontalement
        JPanel centeringPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeringPanel.setBackground(new java.awt.Color(0, 180, 216));
        centeringPanel.add(buttonBox);
        rightPanel.add(centeringPanel, BorderLayout.NORTH);

        mainPanel.add(rightPanel, BorderLayout.SOUTH); // Placer les boutons en bas

        setContentPane(mainPanel);
        revalidate(); // Force la mise à jour de la disposition des composants
        repaint();

        Font customFont = new Font("Helvetica", Font.BOLD, 16);
        java.awt.Color customTextColor = new java.awt.Color(0xCA, 0xF0, 0xF8); // Couleur bleu clair (CAF0F8 en hexadécimal)
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
    }

    @Override
    public void updateHint(Hint hint) {
        if (hint.isHintSuccessArray()) {
            for (int i = 0; i < hint.getSize(); i++) {
                HintSuccess hintSuccess = hint.getValueAtPosition(i);
                switch (hintSuccess) {
                    case RightPositionColor -> hintButtonsList[model.getNbTrys() - model.getActualTry()][i].setIcon(new ImageIcon(getClass().getResource("Images/circle_good_position.png")));
                    case RightColor -> hintButtonsList[model.getNbTrys() - model.getActualTry()][i].setIcon(new ImageIcon(getClass().getResource("Images/circle_good_color.png")));
                }
            }
        } else {
            hintButtonsList[model.getNbTrys() - model.getActualTry()][0].setIcon(null);
            hintButtonsList[model.getNbTrys() - model.getActualTry()][0].setText(String.valueOf(hint.getCorrectColorsAtCorrectPositions()));

            int i = model.getNbHoleCombination() / 2;
            if (model.getNbHoleCombination() % 2 != 0)
                i++;

            hintButtonsList[model.getNbTrys() - model.getActualTry()][i].setIcon(null);
            hintButtonsList[model.getNbTrys() - model.getActualTry()][i].setText(String.valueOf(hint.getCorrectColorsAtBadPositions()));
        }
    }
}
