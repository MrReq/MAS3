package Views.Loging;


import javax.swing.*;
import java.awt.*;

public class EmployeeRoleSelectionView extends JFrame {

    public EmployeeRoleSelectionView() {

        setTitle("Logowanie pracownika");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10,10));

        JLabel title = new JLabel("Wybierz stanowisko", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel buttonsPanel = new JPanel(new GridLayout(2,1,10,10));

        JButton bossButton = new JButton("Szef");
        JButton employeeButton = new JButton("Podwładny");

        buttonsPanel.add(bossButton);
        buttonsPanel.add(employeeButton);

        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.CENTER);

        add(panel);

        bossButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Logowanie jako szef");
        });

        employeeButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Logowanie jako podwładny");
        });
    }
}

