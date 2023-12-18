package View;
import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame {

    public StartScreen() {
        super("Start");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.ORANGE); // Définir le fond en jaune

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0); // Des marges pour l'espacement

        // Charger et redimensionner l'image
        ImageIcon originalIcon = new ImageIcon("mastermind/src/View/logo.png");
        Image image = originalIcon.getImage();
        Image newimg = image.getScaledInstance(400, 150, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(newimg);

        JButton button2 = new JButton("Commencer");
        JButton button3 = new JButton("Quitter");

        // Ajouter les composants au panel
        panel.add(new JLabel(icon), gbc);
        panel.add(button2, gbc);
        panel.add(button3, gbc);

        button3.addActionListener( actionEvent  -> {
            System.exit(0);
        });

        setContentPane(panel);
        setVisible(true);


    }


}
