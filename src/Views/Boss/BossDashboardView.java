package Views.Boss;


import Models.Boss;
import Views.Loging.LoginSelectionView;
import Views.Panels.*;

import javax.swing.*;
import java.awt.*;

public class BossDashboardView extends JFrame {

    private final JTabbedPane tabbedPane;

    public BossDashboardView() {

        setTitle("Coffee House Management System - Owner Panel");
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Products", new BossProductsPanel());
        tabbedPane.addTab("Employees", new EmployeesPanel());
        tabbedPane.addTab("Clients", new ClientsPanel());
        tabbedPane.addTab("Orders", new OrdersPanel());
        tabbedPane.addTab("Statistics", new StatisticsPanel());
        tabbedPane.addTab("Extents", new ExtentsPanel());

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createTopPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Coffee House - Owner Dashboard");

        title.setFont(new Font("Arial", Font.BOLD, 22));

        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(e -> {

            dispose();

            new LoginSelectionView().setVisible(true);

        });

        panel.add(title, BorderLayout.WEST);
        panel.add(logoutButton, BorderLayout.EAST);

        return panel;
    }

}
