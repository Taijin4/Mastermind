package View;

import javax.swing.*;
import java.awt.*;

public class EndScreen extends JFrame {

	public EndScreen(int score) {
		setTitle("Score");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(810, 1000));
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		String text =  String.valueOf(score);

		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel titlePanel = new JPanel(new GridLayout(2, 1));
		JPanel scorePanel = new JPanel(new BorderLayout());

		JLabel title = new JLabel("Bravo, vous avez finis toutes les manches !", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 36)); // Taille de police 36
		title.setForeground(Color.black);
		titlePanel.add(title);

		JLabel titleScore = new JLabel("Votre score est de : ", SwingConstants.CENTER);
		titleScore.setFont(new Font("Arial", Font.PLAIN, 36)); // Taille de police 36
		titleScore.setForeground(Color.black);
		titlePanel.add(titleScore);

		JLabel scoreLabel = new JLabel(text, SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 36)); // Taille de police 36
		scoreLabel.setForeground(Color.black);
		scorePanel.add(scoreLabel);

		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(scorePanel, BorderLayout.CENTER);

		setVisible(true);
		setContentPane(mainPanel);
	}

}
