package Views.Panels;


import javax.swing.*;
import java.awt.*;

public class ClientsPanel extends JPanel {

    public ClientsPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Clients Management",
                SwingConstants.CENTER
        );

        label.setFont(new Font("Arial", Font.BOLD, 22));

        add(label, BorderLayout.CENTER);

    }

}