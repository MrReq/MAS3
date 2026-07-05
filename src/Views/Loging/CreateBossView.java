package Views.Loging;
import Models.Boss;
import javax.swing.*;
import java.awt.*;
public class CreateBossView extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField passwordField;
    public CreateBossView() {
        setTitle("Create Boss Account");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // TITLE
        JLabel title = new JLabel("Create Boss Account", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);
        gbc.gridwidth = 1;
        // FIRST NAME
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("First name:"), gbc);
        gbc.gridx = 1;
        firstNameField = new JTextField(20);
        panel.add(firstNameField, gbc);
        // LAST NAME
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Last name:"), gbc);
        gbc.gridx = 1;
        lastNameField = new JTextField(20);
        panel.add(lastNameField, gbc);
        // PASSWORD
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);
        // BUTTONS
        JButton createButton = new JButton("Create account");
        JButton backButton = new JButton("Back");
        gbc.gridy = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(createButton, gbc);
        gbc.gridy = 5;
        panel.add(backButton, gbc);
        add(panel);
        createButton.addActionListener(e -> createBoss());
        backButton.addActionListener(e -> {
            dispose();
            new LoginSelectionView().setVisible(true);
        });
    }
    // CREATE BOSS
    private void createBoss() {
        String name = firstNameField.getText().trim();
        String surname = lastNameField.getText().trim();
        String password = new String(passwordField.getPassword());
        // REQUIRED FIELDS
        if (name.isBlank() || surname.isBlank() || password.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Missing data",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        // PASSWORD VALIDATION
        if (!isPasswordValid(password)) {
            JOptionPane.showMessageDialog(
                    this,
                    """
                    Password must contain:
                    • at least 8 characters
                    • one uppercase letter
                    • one digit
                    • one special character
                    """, "Invalid password", JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        // CHECK DUPLICATE
        for (Boss boss : Boss.getBossExtent()) {
            if (boss.getPersonName().equalsIgnoreCase(name) && boss.getPeronSurname().equalsIgnoreCase(surname)) {
                JOptionPane.showMessageDialog(this, "Boss already exists.", "Duplicate",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }
        // CREATE NEW BOSS
        new Boss(name, surname, password);
        JOptionPane.showMessageDialog(this, "Boss account has been created successfully.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new BossLoginView().setVisible(true);
    }
    // PASSWORD VALIDATION
    private boolean isPasswordValid(String password) {
        if (password == null)
            return false;
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }
}