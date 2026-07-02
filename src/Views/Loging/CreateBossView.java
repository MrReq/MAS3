package Views.Loging;

import Models.Boss;
import Enums.Sex;
import SecondaryClasses.ObjectPlus;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CreateBossView extends JFrame {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField passwordField;

    public CreateBossView() {

        setTitle("Utwórz konto szefa");
        setSize(420, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tytuł
        JLabel title = new JLabel("Tworzenie konta szefa", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Imię
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Imię:"), gbc);

        gbc.gridx = 1;
        firstNameField = new JTextField(15);
        panel.add(firstNameField, gbc);

        // Nazwisko
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nazwisko:"), gbc);

        gbc.gridx = 1;
        lastNameField = new JTextField(15);
        panel.add(lastNameField, gbc);

        // Hasło
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Hasło:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        // Przycisk
        JButton createButton = new JButton("Utwórz konto");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        panel.add(createButton, gbc);

        add(panel);

        createButton.addActionListener(e -> createBoss());
    }

    private void createBoss() {

        String name = firstNameField.getText().trim();
        String surname = lastNameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (name.isBlank() || surname.isBlank() || password.isBlank()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Fill all fields!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        //========================================================
        // CHECK IF BOSS ALREADY EXISTS
        //========================================================

        for (Boss boss : Boss.getBossExtent()) {

            if (boss.getPersonName().equalsIgnoreCase(name)
                    &&
                    boss.getPeronSurname().equalsIgnoreCase(surname)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Boss already exists!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }
        }

        //========================================================
        // CREATE NEW BOSS
        //========================================================

        Boss boss = new Boss(

                name,

                surname,

                password

        );
        System.out.println(ObjectPlus.getExtent(Boss.class).size());

        JOptionPane.showMessageDialog(

                this,

                "Boss has been created successfully."

        );

        dispose();

        new BossLoginView().setVisible(true);

    }
}