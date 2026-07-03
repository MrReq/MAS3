package Views.Loging;
import Enums.Citizenship;
import Enums.Sex;
import Models.Client;
import Models.Person;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class CreateClientView extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JSpinner birthDateSpinner;
    private JComboBox<Sex> sexComboBox;
    private JComboBox<Citizenship> citizenshipComboBox;
    private JCheckBox clubCardCheckBox;
    private JButton registerButton;
    private JButton backButton;
    public CreateClientView() {
        initializeFrame();
        initializeComponents();
        initializeLayout();
        initializeListeners();
    }
    private void initializeFrame() {
        setTitle("Coffee House - Client Registration (CreateClientView)");
        setSize(550, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    private void initializeComponents() {
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        birthDateSpinner = new JSpinner(new SpinnerDateModel());
        birthDateSpinner.setEditor(new JSpinner.DateEditor(birthDateSpinner, "yyyy-MM-dd"));
        sexComboBox = new JComboBox<>(Sex.values());
        citizenshipComboBox = new JComboBox<>(Citizenship.values());
        clubCardCheckBox = new JCheckBox("Issue club card");
        registerButton = new JButton("Register");
        backButton = new JButton("Back");
    }
    private void initializeLayout() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel title = new JLabel("CLIENT REGISTRATION");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title,gbc);
        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(new JLabel("Name:"),gbc);
        gbc.gridx = 1;
        panel.add(firstNameField,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Surname:"),gbc);
        gbc.gridx = 1;
        panel.add(lastNameField,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Date of birth:"),gbc);
        gbc.gridx = 1;
        panel.add(birthDateSpinner,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Sex:"),gbc);
        gbc.gridx = 1;
        panel.add(sexComboBox,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Citizenship:"),gbc);
        gbc.gridx = 1;
        panel.add(citizenshipComboBox,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(clubCardCheckBox,gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(registerButton,gbc);
        gbc.gridx = 1;
        panel.add(backButton,gbc);
        add(panel);
    }
    private void initializeListeners() {
        registerButton.addActionListener(e -> createClient());
        backButton.addActionListener(e -> {
            dispose();
            new ClientLoginView().setVisible(true);
        });
    }
    private void createClient() {
        String name = firstNameField.getText().trim();
        String surname = lastNameField.getText().trim();
        if(name.isBlank() || surname.isBlank()){
            JOptionPane.showMessageDialog(this, "Fill all required fields.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Date date = (Date) birthDateSpinner.getValue();
        LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Sex sex = (Sex) sexComboBox.getSelectedItem();
        Citizenship citizenship = (Citizenship) citizenshipComboBox.getSelectedItem();
        boolean hasClubCard = clubCardCheckBox.isSelected();
        for (Client client : Client.getClientExtent()) {
            if (client.getPersonName().equalsIgnoreCase(name) && client.getPeronSurname().equalsIgnoreCase(surname)
                    && client.getPersonSex().equals(sex) && client.hasClubCard() == hasClubCard)
                    {
                JOptionPane.showMessageDialog(this, "Client already exists!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        new Client(
                name,
                surname,
                birthDate,
                sex,
                hasClubCard,
                citizenship,
                Person.getCounter());
        JOptionPane.showMessageDialog(this, "Client has been successfully registered.");
        dispose();
        new ClientLoginView().setVisible(true);
    }
}