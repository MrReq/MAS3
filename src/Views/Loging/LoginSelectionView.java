package Views.Loging;


import javax.swing.*;
import java.awt.*;

public class LoginSelectionView extends JFrame {

    public LoginSelectionView() {

        setTitle("Coffee House - Logowanie");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Wybierz sposób logowania", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton clientButton = new JButton("Zaloguj jako klient");
        JButton employeeButton = new JButton("Zaloguj jako pracownik");
        JButton createBossButton = new JButton("Utwórz szefa");

        buttonsPanel.add(clientButton);
        buttonsPanel.add(employeeButton);
        buttonsPanel.add(createBossButton);

        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.CENTER);

        add(panel);

        // Obsługa przycisków

        clientButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Wybrano logowanie jako klient.");
            new ClientLoginView().setVisible(true);
        });

        employeeButton.addActionListener(e -> {
            dispose(); // zamyka aktualne okno
            new EmployeeRoleSelectionView().setVisible(true);
        });

        createBossButton.addActionListener(e -> {
            dispose();
            new CreateBossView().setVisible(true);
        });
    }
}