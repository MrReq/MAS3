package Views.Panels;

import javax.swing.*;
import java.awt.*;

public class EmployeesPanel extends JPanel {

    public EmployeesPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Employees Management",
                SwingConstants.CENTER
        );

        label.setFont(new Font("Arial", Font.BOLD, 22));

        add(label, BorderLayout.CENTER);

    }

}