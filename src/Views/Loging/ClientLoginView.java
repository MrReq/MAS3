package Views.Loging;
import Enums.Sex;
import Models.Client;
import Views.Klient.ClientDashboardView;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class ClientLoginView extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JSpinner birthDateSpinner;
    private JComboBox<Sex> sexComboBox;
    private JCheckBox clubCardCheckBox;
    private JButton loginButton;
    private JButton backButton;

    public ClientLoginView() {
        initializeFrame();
        initializeComponents();
        initializeLayout();
        initializeListeners();
    }
    private void initializeFrame() {
        setTitle("Coffee House - Client Login (ClientLoginView)");
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    private void initializeComponents() {
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        birthDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(birthDateSpinner, "yyyy-MM-dd");
        birthDateSpinner.setEditor(editor);
        sexComboBox = new JComboBox<>(Sex.values());
        clubCardCheckBox = new JCheckBox("Client has club card");
        loginButton = new JButton("Login");
        backButton = new JButton("Back");
    }
    private void initializeLayout() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel title = new JLabel("CLIENT LOGIN");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);
        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        panel.add(firstNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Surname:"), gbc);
        gbc.gridx = 1;
        panel.add(lastNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Birth date:"), gbc);
        gbc.gridx = 1;
        panel.add(birthDateSpinner, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Sex:"), gbc);
        gbc.gridx = 1;
        panel.add(sexComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(clubCardCheckBox, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(loginButton, gbc);
        gbc.gridx = 1;
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(backButton, gbc);
        add(panel);
    }
    private void initializeListeners() {
        loginButton.addActionListener(e-> login());
        backButton.addActionListener(e -> {dispose();new LoginSelectionView().setVisible(true);});
    }

    private void login() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        Date date = (Date) birthDateSpinner.getValue();
        LocalDate birthDate =
                date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
        Sex sex = (Sex) sexComboBox.getSelectedItem();
        boolean hasClubCard = clubCardCheckBox.isSelected();
        for (Client client : Client.getClientExtent()) {
            if (client.getPersonName().equalsIgnoreCase(firstName)
                    && client.getPeronSurname().equalsIgnoreCase(lastName) && client.getPersonDateOfBirth().equals(birthDate)
                    && client.getPersonSex() == sex && client.hasClubCard() == hasClubCard) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new ClientDashboardView(client).setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Client not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}