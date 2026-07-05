package Views.Cleaner;
import Models.Cleaner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
public class CleanerRoomsPanel extends JPanel {
    private final Cleaner cleaner;
    private JTable scheduleTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton;
    public CleanerRoomsPanel(Cleaner cleaner) {
        this.cleaner = cleaner;
        initializeComponents();
        initializeLayout();
        initializeListeners();
        refreshTable();
    }
    // COMPONENTS
    private void initializeComponents() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Day", "Shift", "Start", "End", "Assigned Area"});
        scheduleTable = new JTable(tableModel);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        scheduleTable.setRowSorter(sorter);
        scheduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refreshButton = new JButton("Refresh");
    }
    // LAYOUT
    private void initializeLayout() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Work Schedule", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);
        add(new JScrollPane(scheduleTable), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(refreshButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    // LISTENERS
    private void initializeListeners() {
        refreshButton.addActionListener(e -> refreshTable());
    }
    // TABLE
    private void refreshTable() {
        tableModel.setRowCount(0);
        /*
            Docelowo:
            for(Shift shift : cleaner.getSchedule())
        */
        tableModel.addRow(new Object[]{"Monday", "Morning", "06:00", "14:00", "Kitchen"});
        tableModel.addRow(new Object[]{"Tuesday", "Morning", "06:00", "14:00", "Main Hall"});
        tableModel.addRow(new Object[]{"Wednesday", "Afternoon", "14:00", "22:00", "Terrace"});
        tableModel.addRow(new Object[]{"Thursday", "Morning", "06:00", "14:00", "Kitchen"});
        tableModel.addRow(new Object[]{"Friday", "Afternoon", "14:00", "22:00", "Toilets"});
    }
}