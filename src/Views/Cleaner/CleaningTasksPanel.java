package Views.Cleaner;
import Models.Cleaner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
public class CleaningTasksPanel extends JPanel {
    private final Cleaner cleaner;
    private JTable tasksTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton;
    private JButton completeTaskButton;
    private JButton detailsButton;
    public CleaningTasksPanel(Cleaner cleaner) {
        this.cleaner = cleaner;
        initializeComponents();
        initializeLayout();
        initializeListeners();
        refreshTable();
    }
    // COMPONENTS
    private void initializeComponents() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Task ID", "Room", "Description", "Priority", "Status"});
        tasksTable = new JTable(tableModel);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        tasksTable.setRowSorter(sorter);
        tasksTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refreshButton = new JButton("Refresh");
        completeTaskButton = new JButton("Mark as completed");
        detailsButton = new JButton("Details");
    }
    // LAYOUT
    private void initializeLayout() {
        setLayout(new BorderLayout());
        add(new JScrollPane(tasksTable), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(refreshButton);
        bottomPanel.add(detailsButton);
        bottomPanel.add(completeTaskButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    // LISTENERS
    private void initializeListeners() {
        refreshButton.addActionListener(e -> refreshTable());
        detailsButton.addActionListener(e -> showDetails());
        completeTaskButton.addActionListener(e -> completeTask());
    }
    // TABLE
    private void refreshTable() {
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{1, "Kitchen", "Clean floor", "HIGH", "TODO"});
        tableModel.addRow(new Object[]{2, "Hall", "Wash tables", "MEDIUM", "DONE"});
    }
    // DETAILS

    private void showDetails() {
        int row = tasksTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Select a task first.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Task details will appear here.");
    }
    // COMPLETE TASK
    private void completeTask() {
        int row = tasksTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Select a task first.");
            return;
        }
        tableModel.setValueAt("DONE", row, 4);
        JOptionPane.showMessageDialog(this, "Task completed.");
    }
}