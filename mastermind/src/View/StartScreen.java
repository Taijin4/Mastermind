package View;
import javax.swing.*;
import java.awt.*;


public class StartScreen extends JFrame {

    public StartScreen() {
        super("Start");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton button1 = new JButton("Lancer une partie");
        JButton button3 = new JButton("Quitter");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0); // Des marges pour l'espacement

        // Ajouter les boutons au panel avec les contraintes
        panel.add(button1, gbc);
        panel.add(button3, gbc);

        setContentPane(panel);
        setVisible(true);
    }
}
