package Views.Loging;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.TableRowSorter;
public class LoginOrRegisterView extends JFrame {
    private JButton loginButton;
    private JButton registerButton;
    private JButton backButton;
    public LoginOrRegisterView() {
        initializeFrame();
        initializeComponents();
        initializeLayout();
        initializeListeners();
    }
    // FRAME
    private void initializeFrame() {
        setTitle("Coffee House Management System (LoginOrRegisterView)");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    // COMPONENTS
    private void initializeComponents() {
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        backButton = new JButton("Back");
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        loginButton.setFont(buttonFont);
        registerButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
    }
    // LAYOUT
    private void initializeLayout() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("CLIENT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 70, 40, 70));
        centerPanel.add(loginButton);
        centerPanel.add(registerButton);
        centerPanel.add(backButton);
        add(centerPanel, BorderLayout.CENTER);
    }
    // LISTENERS
    private void initializeListeners() {
        loginButton.addActionListener(e -> {
            dispose();
            new ClientLoginView().setVisible(true);
        });
        registerButton.addActionListener(e -> {
            dispose();
            new CreateClientView().setVisible(true);
        });
        backButton.addActionListener(e -> {
            dispose();
            new LoginSelectionView().setVisible(true);
        });
    }
}