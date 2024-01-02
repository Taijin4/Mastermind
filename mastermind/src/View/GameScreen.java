package View;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {

    public GameScreen(int nbPionsCombinaisons) {
        setTitle("Panel divisé en trois parties");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 1000));
        setVisible(true);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel gamePanel = new JPanel(new GridLayout(1, 2));
        JPanel gameLinesPanel = new JPanel(new GridLayout(10, 1));

        for (int i = 0; i < 10; i++) {
            JPanel linePanel = new JPanel();
            linePanel.setLayout(new FlowLayout()); // Aligne les boutons de chaque ligne verticalement
            for (int j = 0; j < nbPionsCombinaisons; j++) {
                JButton button = new JButton(new ImageIcon("mastermind/src/View/Images/circle.png"));
                button.setContentAreaFilled(false); // Supprime l'arrière-plan
                button.setBorderPainted(false); // Supprime la bordure
                button.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
                button.setOpaque(false);
                linePanel.add(button);
            }
            JPanel hintPanel = new JPanel(new GridLayout(2, nbPionsCombinaisons/2));
            for (int j = 0; j < 2; j++) {
                JPanel lineHintPanel = new JPanel();
                lineHintPanel.setLayout(new FlowLayout());
                for (int k = 0; k < nbPionsCombinaisons/2; k++) {
                    JButton button = new JButton(new ImageIcon("mastermind/src/View/Images/little_circle.png"));
                    button.setContentAreaFilled(false); // Supprime l'arrière-plan
                    button.setBorderPainted(false); // Supprime la bordure
                    button.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
                    button.setOpaque(false);
                    lineHintPanel.add(button);
                }
                hintPanel.add(lineHintPanel);
            }
            linePanel.add(hintPanel);
            gameLinesPanel.add(linePanel);
        }
        gamePanel.add(gameLinesPanel);
        mainPanel.add(gamePanel, BorderLayout.CENTER);

        JButton red = new JButton(new ImageIcon("mastermind/src/View/Images/red.png"));
        red.setContentAreaFilled(false); // Supprime l'arrière-plan
        red.setBorderPainted(false); // Supprime la bordure
        red.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        red.setOpaque(false);

        JButton blue = new JButton(new ImageIcon("mastermind/src/View/Images/blue.png"));
        blue.setContentAreaFilled(false); // Supprime l'arrière-plan
        blue.setBorderPainted(false); // Supprime la bordure
        blue.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        blue.setOpaque(false);

        JButton green = new JButton(new ImageIcon("mastermind/src/View/Images/green.png"));
        green.setContentAreaFilled(false); // Supprime l'arrière-plan
        green.setBorderPainted(false); // Supprime la bordure
        green.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        green.setOpaque(false);

        JButton orange = new JButton(new ImageIcon("mastermind/src/View/Images/orange.png"));
        orange.setContentAreaFilled(false); // Supprime l'arrière-plan
        orange.setBorderPainted(false); // Supprime la bordure
        orange.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        orange.setOpaque(false);

        JButton yellow = new JButton(new ImageIcon("mastermind/src/View/Images/yellow.png"));
        yellow.setContentAreaFilled(false); // Supprime l'arrière-plan
        yellow.setBorderPainted(false); // Supprime la bordure
        yellow.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        yellow.setOpaque(false);

        JButton pink = new JButton(new ImageIcon("mastermind/src/View/Images/pink.png"));
        pink.setContentAreaFilled(false); // Supprime l'arrière-plan
        pink.setBorderPainted(false); // Supprime la bordure
        pink.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        pink.setOpaque(false);

        JButton purple = new JButton(new ImageIcon("mastermind/src/View/Images/purple.png"));
        purple.setContentAreaFilled(false); // Supprime l'arrière-plan
        purple.setBorderPainted(false); // Supprime la bordure
        purple.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        purple.setOpaque(false);

        JButton gray = new JButton(new ImageIcon("mastermind/src/View/Images/gray.png"));
        gray.setContentAreaFilled(false); // Supprime l'arrière-plan
        gray.setBorderPainted(false); // Supprime la bordure
        gray.setFocusPainted(false); // Supprime la mise en évidence lorsqu'il est sélectionné
        gray.setOpaque(false);


        JPanel colorsPanel = new JPanel(new BorderLayout());
        JPanel colorsButtonPanel = new JPanel(new FlowLayout());
        colorsButtonPanel.add(red);
        colorsButtonPanel.add(blue);
        colorsButtonPanel.add(green);
        colorsButtonPanel.add(yellow);
        colorsButtonPanel.add(orange);
        colorsButtonPanel.add(pink);
        colorsButtonPanel.add(purple);
        colorsButtonPanel.add(gray);

        colorsPanel.add(colorsButtonPanel, BorderLayout.CENTER);
        mainPanel.add(colorsPanel, BorderLayout.SOUTH);


        setContentPane(mainPanel);
        revalidate(); // Force la mise à jour de la disposition des composants
        repaint();
    }

}
