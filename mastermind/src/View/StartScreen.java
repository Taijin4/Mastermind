package View;
import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame {

    public StartScreen() {
        super("Start");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.ORANGE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Charger et redimensionner l'image
        ImageIcon originalIcon = new ImageIcon("mastermind/src/View/logo.png");
        Image image = originalIcon.getImage();
        Image newimg = image.getScaledInstance(400, 150, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(newimg);

        JButton buttonStart = new JButton("Commencer");
        JButton buttonLeave = new JButton("Quitter");

        JSlider slide = new JSlider();
        slide.setMaximum(12);
        slide.setMinimum(0);
        slide.setValue(6);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        slide.setMinorTickSpacing(1);
        slide.setMajorTickSpacing(1);
        slide.setPreferredSize(new Dimension(300,50));


        // Ajouter les composants au panel
        panel.add(new JLabel(icon), gbc);
        panel.add(buttonStart, gbc);
        panel.add(buttonLeave, gbc);

        buttonStart.addActionListener( actionEvent  -> {
            panel.remove(buttonLeave);
            panel.remove(buttonStart);

            panel.add(slide, gbc);

            panel.updateUI();
        });

        buttonLeave.addActionListener( actionEvent  -> {
            System.exit(0);
        });



        setContentPane(panel);
        setVisible(true);


    }


}
