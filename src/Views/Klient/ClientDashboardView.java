package Views.Klient;
import Models.Client;
import Models.Address;
import Views.Loging.LoginSelectionView;
import javax.swing.*;
import java.awt.*;
public class ClientDashboardView extends JFrame {
    private final Client loggedClient;
    private JLabel welcomeLabel;
    private JButton logoutButton;
    private JTabbedPane tabbedPane;
    private ClientMenuPanel clientmenuPanel;
    private ClientShoppingCartView clientShoppingCartView;
    private ClientProfileView clientProfileView;
    private ClientOrderHistoryPanel clientOrderHistoryView;
    private JButton editAddressButton;

    public ClientDashboardView(Client client) {
        this.loggedClient = client;
        clientmenuPanel = new ClientMenuPanel(loggedClient,this);
        clientShoppingCartView = new ClientShoppingCartView(loggedClient,this);
        clientProfileView = new ClientProfileView(loggedClient);
        clientOrderHistoryView = new ClientOrderHistoryPanel(loggedClient);
        initializeFrame();
        initializeComponents();
        initializeLayout();
        initializeListeners();
    }
    private void initializeFrame() {
        setTitle("Coffee House - Client Panel (ClientDashboardView)");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initializeComponents() {
        welcomeLabel = new JLabel("Welcome " + loggedClient.getPersonName() + " " + loggedClient.getPeronSurname());
        welcomeLabel.setFont(new Font("Arial",Font.BOLD,20));
        logoutButton = new JButton("Logout");
        editAddressButton = new JButton("Set Adress");
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Menu", clientmenuPanel);
        tabbedPane.addTab("Shopping Cart", clientShoppingCartView);
        tabbedPane.addTab("My Orders", clientOrderHistoryView);
        tabbedPane.addTab("Profile", clientProfileView);
    }
    private void initializeLayout() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(welcomeLabel,BorderLayout.WEST);
        topPanel.add(logoutButton,BorderLayout.EAST);
        topPanel.add(editAddressButton,BorderLayout.CENTER);
        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(tabbedPane,BorderLayout.CENTER);
    }
    private void initializeListeners() {
        logoutButton.addActionListener(e->{
            dispose();
            new LoginSelectionView().setVisible(true);
        });
        editAddressButton.addActionListener(e -> {editAddress();});
    }
    public void refreshAllPanels() {
        clientmenuPanel.reload();
        clientShoppingCartView.reload();
        clientProfileView.reload();
        clientOrderHistoryView.reload();
    }
    private void editAddress() {
        JTextField streetField = new JTextField();
        JTextField cityField = new JTextField();
        JTextField postalField = new JTextField();
        JTextField countryField = new JTextField();
        if (loggedClient.getAddress() != null) {
            streetField.setText(loggedClient.getAddress().getStreet());
            cityField.setText(loggedClient.getAddress().getCity());
            postalField.setText(loggedClient.getAddress().getPostalCode());
            countryField.setText(loggedClient.getAddress().getCountry());
        }
        JPanel panel = new JPanel(new GridLayout(4,2));
        panel.add(new JLabel("Street:"));
        panel.add(streetField);
        panel.add(new JLabel("City:"));
        panel.add(cityField);
        panel.add(new JLabel("Postal code:"));
        panel.add(postalField);
        panel.add(new JLabel("Country:"));
        panel.add(countryField);
        int result = JOptionPane.showConfirmDialog(this, panel, "Edit address", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(result == JOptionPane.OK_OPTION){
            loggedClient.setAddress(new Address(streetField.getText(), cityField.getText(), postalField.getText(),
                            countryField.getText()));
            refreshAllPanels();
            JOptionPane.showMessageDialog(this, "Address saved successfully.");
        }
    }
}
