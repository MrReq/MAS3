package Views.Barista;
import Models.Cleaner;
import Views.Loging.*;
import Views.Cleaner.CleanerRoomsPanel;
import Views.Cleaner.CleanerSchedulePanel;
import Views.Cleaner.CleanerStatisticsPanel;
import Views.Cleaner.CleaningTasksPanel;
import javax.swing.*;
import java.awt.*;
public class CleanerDashboardView extends JFrame {
    private final Cleaner loggedCleaner;
    private JTabbedPane tabbedPane;
    public CleanerDashboardView(Cleaner cleaner) {
        this.loggedCleaner = cleaner;
        initializeFrame();
        initializeComponents();
        initializeLayout();
    }
    // FRAME
    private void initializeFrame() {
        setTitle("Coffee House Management System - Cleaner");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // COMPONENTS

    private void initializeComponents() {
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Cleaning Tasks", new CleaningTasksPanel(loggedCleaner));
        tabbedPane.addTab("Rooms", new CleanerRoomsPanel(loggedCleaner));
        tabbedPane.addTab("Schedule", new CleanerSchedulePanel(loggedCleaner));
        tabbedPane.addTab("Statistics", new CleanerStatisticsPanel(loggedCleaner));
    }
    // LAYOUT

    private void initializeLayout() {
        setLayout(new BorderLayout());
        add(createTopPanel(), BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }
    // TOP PANEL
    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Logged as: " + loggedCleaner.getPersonName() + " " + loggedCleaner.getPeronSurname());
        title.setFont(new Font("Arial", Font.BOLD, 22));
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            dispose();
            new LoginSelectionView().setVisible(true);
        });
        panel.add(title, BorderLayout.WEST);
        panel.add(logoutButton, BorderLayout.EAST);
        return panel;
    }
}