package Views.Klient;

import Models.Client;


import Models.Client;
import Views.Loging.LoginSelectionView;

import javax.swing.*;
import java.awt.*;

public class ClientDashboardView extends JFrame {

    private final Client loggedClient;

    private JLabel welcomeLabel;

    private JButton logoutButton;

    private JTabbedPane tabbedPane;

    public ClientDashboardView(Client client) {

        this.loggedClient = client;

        initializeFrame();

        initializeComponents();

        initializeLayout();

        initializeListeners();

    }

    private void initializeFrame() {

        setTitle("Coffee House - Client Panel");

        setSize(1000,700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initializeComponents() {

        welcomeLabel = new JLabel(

                "Welcome " +

                        loggedClient.getPersonName() +

                        " " +

                        loggedClient.getPeronSurname()

        );

        welcomeLabel.setFont(new Font("Arial",Font.BOLD,20));

        logoutButton = new JButton("Logout");

        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Menu", new JPanel());

        tabbedPane.addTab("Shopping Cart", new JPanel());

        tabbedPane.addTab("My Orders", new JPanel());

        tabbedPane.addTab("Profile", new JPanel());

    }

    private void initializeLayout() {

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(welcomeLabel,BorderLayout.WEST);

        topPanel.add(logoutButton,BorderLayout.EAST);

        setLayout(new BorderLayout());

        add(topPanel,BorderLayout.NORTH);

        add(tabbedPane,BorderLayout.CENTER);

    }

    private void initializeListeners() {

        logoutButton.addActionListener(e->{

            dispose();

            new LoginSelectionView().setVisible(true);

        });

    }

}
