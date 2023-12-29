package View;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {

    public GameScreen() {
        super( "Game Screen" );
        setSize( 400, 550 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible( true );

        JPanel gamePanel = new JPanel();
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


        JPanel colorsPanel = new JPanel();
        colorsPanel.setLayout( new FlowLayout());
        colorsPanel.add(red);
        colorsPanel.add(blue);
        colorsPanel.add(green);
        colorsPanel.add(yellow);
        colorsPanel.add(orange);
        colorsPanel.add(pink);
        colorsPanel.add(purple);
        colorsPanel.add(gray);

        setContentPane(colorsPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
