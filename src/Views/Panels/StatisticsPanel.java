package Views.Panels;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {

    public StatisticsPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Statistics",
                SwingConstants.CENTER
        );

        label.setFont(new Font("Arial", Font.BOLD, 22));

        add(label, BorderLayout.CENTER);

    }

}