package View;

import Controller.MastermindController;
import Model.MastermindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndScreen extends JFrame {

	public EndScreen(int score) {
		setTitle("Score");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(new Color(0, 180, 216));

		JPanel titlePanel = new JPanel(new GridLayout(3, 1));
		titlePanel.setBackground(new Color(0, 180, 216));

		JLabel title = createStyledLabel("GAME OVER", 48, Color.WHITE);
		JLabel desc = createStyledLabel("Félicitations ! Vous avez terminé toutes les manches.", 24, Color.WHITE);
		JLabel titleScore = createStyledLabel("Votre score final :", 36, Color.WHITE);

		JLabel scoreLabel = createStyledLabel(String.valueOf(score), 48, Color.WHITE);

		titlePanel.add(title);
		titlePanel.add(desc);
		titlePanel.add(titleScore);

		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(scoreLabel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(0, 180, 216));

		JButton restartButton = createStyledButton("Rejouer");
		JButton exitButton = createStyledButton("Quitter");

		restartButton.addActionListener( actionEvent -> {

			new StartScreen();
			EndScreen.this.dispose();
		});

		exitButton.addActionListener( actionEvent -> {
			System.exit(0);
		});

		buttonPanel.add(restartButton);
		buttonPanel.add(exitButton);

		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		setContentPane(mainPanel);
		setVisible(true);
	}

	private JLabel createStyledLabel(String text, int fontSize, Color textColor) {
			JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, fontSize));
		label.setForeground(textColor);
		return label;
	}

	private JButton createStyledButton(String text) {
		JButton button = new JButton(text);
		button.setFont(new Font("Arial", Font.PLAIN, 24));
		button.setBackground(new Color(0xCA, 0xF0, 0xF8)); // Couleur bleu clair (CAF0F8 en hexadécimal)
		button.setFocusPainted(false);
		return button;
	}
}