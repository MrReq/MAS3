//package Views.Loging;
//
//import javax.swing.*;
//import java.awt.*;
//
//import Views.Loging.*;
//import Views.Loging.BaristaLoginView;
//import Views.Loging.EmployeeRoleSelectionView;
//import Views.Loging.WaiterLoginView;
//
//public class EmployeeTypeSelectionView extends JFrame {
//
//    private JButton baristaButton;
//    private JButton waiterButton;
//    private JButton backButton;
//
//    public EmployeeTypeSelectionView() {
//
//        initializeFrame();
//        initializeComponents();
//        initializeLayout();
//        initializeListeners();
//
//    }
//
//    //=========================================================
//    // FRAME
//    //=========================================================
//
//    private void initializeFrame() {
//
//        setTitle("Coffee House Management System");
//        setSize(500, 420);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
//
//    }
//
//    //=========================================================
//    // COMPONENTS
//    //=========================================================
//
//    private void initializeComponents() {
//
//        baristaButton = new JButton("☕  Barista");
//        waiterButton = new JButton("🍽  Waiter");
//        backButton = new JButton("← Back");
//
//        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
//
//        baristaButton.setFont(buttonFont);
//        waiterButton.setFont(buttonFont);
//        backButton.setFont(buttonFont);
//
//    }
//
//    //=========================================================
//    // LAYOUT
//    //=========================================================
//
//    private void initializeLayout() {
//
//        setLayout(new BorderLayout());
//
//        JLabel title = new JLabel(
//                "Select employee position",
//                SwingConstants.CENTER
//        );
//
//        title.setFont(new Font("Arial", Font.BOLD, 24));
//
//        add(title, BorderLayout.NORTH);
//
//        JPanel centerPanel = new JPanel();
//
//        centerPanel.setLayout(new GridLayout(4,1,15,15));
//
//        centerPanel.setBorder(
//                BorderFactory.createEmptyBorder(30,70,30,70)
//        );
//
//        centerPanel.add(baristaButton);
//        centerPanel.add(waiterButton);
//        centerPanel.add(backButton);
//
//        add(centerPanel, BorderLayout.CENTER);
//
//    }
//
//    //=========================================================
//    // LISTENERS
//    //=========================================================
//
//    private void initializeListeners() {
//
//        baristaButton.addActionListener(e -> {
//
//            dispose();
//
//            new BaristaLoginView().setVisible(true);
//
//        });
//
//        waiterButton.addActionListener(e -> {
//
//            dispose();
//
//            new WaiterLoginView().setVisible(true);
//
//        });
//
//
//
//        backButton.addActionListener(e -> {
//
//            dispose();
//
//            new EmployeeRoleSelectionView().setVisible(true);
//
//        });
//
//    }
//
//}