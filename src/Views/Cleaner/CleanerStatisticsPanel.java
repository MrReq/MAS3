package Views.Cleaner;
import Models.Cleaner;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import Enums.OrderStatus;
import Models.Order;

public class CleanerStatisticsPanel extends JPanel {
    private final Cleaner cleaner;
    private JLabel completedTasksLabel;
    private JLabel pendingTasksLabel;
    private JLabel workedHoursLabel;
    private JLabel efficiencyLabel;
    private JLabel lastCleaningLabel;
    private JButton refreshButton;
    private CleanerDashboardView parent;
    public CleanerStatisticsPanel(Cleaner cleaner, CleanerDashboardView parent) {
        this.cleaner = cleaner;
        this.parent=parent;
        initializeComponents();
        initializeLayout();
        initializeListeners();
        refreshStatistics();
    }
    // COMPONENTS
    private void initializeComponents() {
        completedTasksLabel = new JLabel();
        pendingTasksLabel = new JLabel();
        workedHoursLabel = new JLabel();
        efficiencyLabel = new JLabel();
        lastCleaningLabel = new JLabel();
        refreshButton = new JButton("Refresh");
    }
    // LAYOUT

    private void initializeLayout() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Cleaner Statistics", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);
        JPanel statisticsPanel = new JPanel();
        statisticsPanel.setLayout(new GridLayout(6, 2, 10, 10));
        statisticsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        statisticsPanel.add(new JLabel("Cleaner:"));
        statisticsPanel.add(new JLabel(cleaner.getPersonName() + " " + cleaner.getPeronSurname()));
        statisticsPanel.add(new JLabel("Completed tasks:"));
        statisticsPanel.add(completedTasksLabel);
        statisticsPanel.add(new JLabel("Pending tasks:"));
        statisticsPanel.add(pendingTasksLabel);
        statisticsPanel.add(new JLabel("Worked hours:"));
        statisticsPanel.add(workedHoursLabel);
        statisticsPanel.add(new JLabel("Efficiency:"));
        statisticsPanel.add(efficiencyLabel);
        statisticsPanel.add(new JLabel("Last cleaning:"));
        statisticsPanel.add(lastCleaningLabel);
        add(statisticsPanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(refreshButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    // LISTENERS
    private void initializeListeners() {
        refreshButton.addActionListener(e -> refreshStatistics());
    }
    // REFRESH
    private void refreshStatistics() {
        completedTasksLabel.setText(String.valueOf(Order.getOrderExtent().stream()
                        .filter(o -> o.getOrderStatus() == OrderStatus.FINISHED)
                        .count()));
        pendingTasksLabel.setText(String.valueOf(Order.getOrderExtent().stream()
                        .filter(o -> o.getOrderStatus() == OrderStatus.PAID)
                        .count()));
        workedHoursLabel.setText(cleaner.getCurrentEmployment() != null
                        ? cleaner.getCurrentEmployment().getEmploymentPeriodText()
                        : "-");
        efficiencyLabel.setText("100 %");
        lastCleaningLabel.setText(LocalDate.now().toString());
    }
    public void reload(){
        refreshStatistics();
    }

}