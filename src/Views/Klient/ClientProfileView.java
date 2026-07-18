package Views.Klient;
import Models.Client;
import javax.swing.*;
import java.awt.*;
public class ClientProfileView extends JPanel {
    private final Client loggedClient;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel birthDateLabel;
    private JLabel sexLabel;
    private JLabel clubCardLabel;
    private JLabel ordersLabel;
    private JLabel ageLabel;
    private JButton refreshButton;
    private JButton editButton;
    private JLabel addressLabel;
    private JLabel addressValueLabel;
    public ClientProfileView(Client loggedClient) {
        this.loggedClient = loggedClient;
        initializeComponents();
        initializeLayout();
        initializeListeners();
        refreshData();
    }
    // COMPONENTS
    private void initializeComponents() {
        nameLabel = new JLabel();
        surnameLabel = new JLabel();
        birthDateLabel = new JLabel();
        sexLabel = new JLabel();
        clubCardLabel = new JLabel();
        ordersLabel = new JLabel();
        ageLabel = new JLabel();
        addressValueLabel = new JLabel("-");
        refreshButton = new JButton("Refresh");
        editButton = new JButton("Edit profile");
    }
    // LAYOUT
// LAYOUT
    private void initializeLayout() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("CLIENT PROFILE", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(title, BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(loggedClient.getPersonName()), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Surname:"), gbc);
        gbc.gridx = 3;
        panel.add(new JLabel(loggedClient.getPeronSurname()), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Birth date:"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(loggedClient.getPersonDateOfBirth().toString()), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 3;
        panel.add(new JLabel(String.valueOf(loggedClient.getAge())), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Sex:"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(loggedClient.getPersonSex().toString()), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Club card:"), gbc);
        gbc.gridx = 3;
        panel.add(new JLabel(loggedClient.hasClubCard() ? "Yes" : "No"), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Orders:"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(String.valueOf(loggedClient.countRealOrdersDone())), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 3;
        panel.add(new JLabel(loggedClient.getAddress() != null
                        ? loggedClient.getAddress().toString()
                        : "Not set"), gbc);
        add(panel, BorderLayout.CENTER);
    }
    // LISTENERS
    private void initializeListeners() {
        refreshButton.addActionListener(e -> refreshData());
        editButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Profile editing will be implemented soon."));
    }
    // REFRESH
    private void refreshData() {
        nameLabel.setText(loggedClient.getPersonName());
        surnameLabel.setText(loggedClient.getPeronSurname());
        birthDateLabel.setText(loggedClient.getPersonDateOfBirth().toString());
        sexLabel.setText(loggedClient.getPersonSex().toString());
        clubCardLabel.setText(loggedClient.hasClubCard() ? "Yes" : "No");
        ordersLabel.setText(String.valueOf(loggedClient.countOrders()));
        ageLabel.setText(String.valueOf(loggedClient.getAge()));
        if (loggedClient.getAddress() == null)
            addressValueLabel.setText("-");
        else {
            addressValueLabel.setText("<html>" + loggedClient.getAddress().getStreet() + "<br>"
                    + loggedClient.getAddress().getPostalCode() + " " + loggedClient.getAddress().getCity()
                    + "<br>" + loggedClient.getAddress().getCountry() + "</html>"
            );
        }
    }
    public void reload(){
        refreshData();
    }
}