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
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setVisible(true);


        this.model = model;

        final JButton[] actualClickedColor = {new JButton()};
        hintButtonsList = new JButton[model.getNbTrys()][model.getNbHoleCombination()];

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new java.awt.Color(0, 180, 216));

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setContentPane(scrollPane);


        JPanel gamePanel = new JPanel(new GridLayout(1, 2));
        gamePanel.setBackground(new java.awt.Color(0, 180, 216));
        JPanel gameLinesPanel = new JPanel(new GridLayout(model.getNbTrys(), 1));
        gameLinesPanel.setBackground(new java.awt.Color(0, 180, 216));

        for (int i = 0; i < model.getNbTrys(); i++) {
            JPanel linePanel = new JPanel();
            linePanel.setBackground(new java.awt.Color(0, 180, 216));
            linePanel.setLayout(new FlowLayout());
            for (int j = 0; j < model.getNbHoleCombination(); j++) {
                JButton button = new JButton(new ImageIcon("Images/circle.png"));
                button.setName(String.valueOf(i) + " - " + String.valueOf(j));
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                button.setFocusPainted(false);
                button.setOpaque(false);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!controller.isRoundEnd()) {
                            JButton clicked = (JButton) e.getSource();
                            System.out.println("-------------------");
                            System.out.println(Integer.parseInt(String.valueOf(clicked.getName().substring(0, 2)).trim()));
                            System.out.println(model.getNbTrys() - model.getActualTry());
                            System.out.println("--------------------");
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
                    JButton button = new JButton(new ImageIcon("Images/little_circle.png"));
                    button.setContentAreaFilled(false);
                    button.setBorderPainted(false);
                    button.setFocusPainted(false);
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

        JButton red = new JButton(new ImageIcon("Images/red.png"));
        red.setName("RED");
        red.setContentAreaFilled(false);
        red.setBorderPainted(false);
        red.setFocusPainted(false);
        red.setOpaque(false);

        JButton blue = new JButton(new ImageIcon("Images/blue.png"));
        blue.setName("BLUE");
        blue.setContentAreaFilled(false);
        blue.setBorderPainted(false);
        blue.setFocusPainted(false);
        blue.setOpaque(false);

        JButton green = new JButton(new ImageIcon("Images/green.png"));
        green.setName("GREEN");
        green.setContentAreaFilled(false);
        green.setBorderPainted(false);
        green.setFocusPainted(false);
        green.setOpaque(false);

        JButton orange = new JButton(new ImageIcon("Images/orange.png"));
        orange.setName("ORANGE");
        orange.setContentAreaFilled(false);
        orange.setBorderPainted(false);
        orange.setFocusPainted(false);
        orange.setOpaque(false);

        JButton yellow = new JButton(new ImageIcon("Images/yellow.png"));
        yellow.setName("YELLOW");
        yellow.setContentAreaFilled(false);
        yellow.setBorderPainted(false);
        yellow.setFocusPainted(false);
        yellow.setOpaque(false);

        JButton pink = new JButton(new ImageIcon("Images/pink.png"));
        pink.setName("PINK");
        pink.setContentAreaFilled(false);
        pink.setBorderPainted(false);
        pink.setFocusPainted(false);
        pink.setOpaque(false);

        JButton purple = new JButton(new ImageIcon("Images/purple.png"));
        purple.setName("PURPLE");
        purple.setContentAreaFilled(false);
        purple.setBorderPainted(false);
        purple.setFocusPainted(false);
        purple.setOpaque(false);

        JButton gray = new JButton(new ImageIcon("Images/gray.png"));
        gray.setName("GRAY");
        gray.setContentAreaFilled(false);
        gray.setBorderPainted(false);
        gray.setFocusPainted(false);
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
        buttonBox.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonBox.add(nextRound);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new java.awt.Color(0, 180, 216));

        // Centre les boutons horizontalement
        JPanel centeringPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeringPanel.setBackground(new java.awt.Color(0, 180, 216));
        centeringPanel.add(buttonBox);
        rightPanel.add(centeringPanel, BorderLayout.NORTH);

        mainPanel.add(rightPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        revalidate();
        repaint();

        Font customFont = new Font("Helvetica", Font.BOLD, 16);
        java.awt.Color customTextColor = new java.awt.Color(0xCA, 0xF0, 0xF8);
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
                    case RightPositionColor -> hintButtonsList[model.getNbTrys() - model.getActualTry()][i].setIcon(new ImageIcon("Images/circle_good_position.png"));
                    case RightColor -> hintButtonsList[model.getNbTrys() - model.getActualTry()][i].setIcon(new ImageIcon("Images/circle_good_color.png"));
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
