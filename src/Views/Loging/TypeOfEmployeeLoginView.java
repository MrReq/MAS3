package Views.Loging;
import javax.swing.*;
import java.awt.*;
public class TypeOfEmployeeLoginView extends JFrame {
    private JButton waiterButton;
    private JButton baristaButton;
    private JButton cleanerButton;
    private JButton backButton;
    public TypeOfEmployeeLoginView() {
        initializeFrame();
        initializeComponents();
        initializeLayout();
        initializeListeners();
    }
    // FRAME
    private void initializeFrame() {
        setTitle("Coffee House Management System (TypeOfEmployeeLoginView)");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    // COMPONENTS
    private void initializeComponents() {
        waiterButton = new JButton("Waiter");
        baristaButton = new JButton("Barista");
        cleanerButton = new JButton("Cleaner");
        backButton = new JButton("Back");
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        waiterButton.setFont(buttonFont);
        baristaButton.setFont(buttonFont);
        cleanerButton.setFont(buttonFont);
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
        centerPanel.add(waiterButton);
        centerPanel.add(baristaButton);
        centerPanel.add(cleanerButton);
        centerPanel.add(backButton);
        add(centerPanel, BorderLayout.CENTER);
    }
    // LISTENERS
    private void initializeListeners() {
        waiterButton.addActionListener(e -> {
            dispose();
            new WaiterLoginView().setVisible(true);
        });
        baristaButton.addActionListener(e -> {
            dispose();
            new BaristaLoginView().setVisible(true);
        });
        cleanerButton.addActionListener(e -> {
            dispose();
            new CleanerLoginView().setVisible(true);
        });
        backButton.addActionListener(e -> {
            dispose();
            new LoginSelectionView().setVisible(true);
        });
    }
}