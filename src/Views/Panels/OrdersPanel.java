package Views.Panels;

import javax.swing.*;
import java.awt.*;

public class OrdersPanel extends JPanel {

    public OrdersPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Orders Management",
                SwingConstants.CENTER
        );

        label.setFont(new Font("Arial", Font.BOLD, 22));

        add(label, BorderLayout.CENTER);

    }

}