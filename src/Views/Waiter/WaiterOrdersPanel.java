package Views.Waiter;
import Enums.OrderStatus;
import Models.Order;
import Models.Waiter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class WaiterOrdersPanel extends JPanel {
    private final Waiter loggedWaiter;
    private JTable ordersTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton;
    private JButton serveButton;
    private JButton detailsButton;
    private WaiterDashboardView parent;

    public WaiterOrdersPanel(Waiter loggedWaiter, WaiterDashboardView parent  ) {
        this.loggedWaiter = loggedWaiter;
        this.parent = parent;
        initializeComponents();
        initializeLayout();
        initializeListeners();
        refreshTable();
    }
    // COMPONENTS
    private void initializeComponents() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Order ID", "Client", "Table", "Status", "Value"});
        ordersTable = new JTable(tableModel);
        ordersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refreshButton = new JButton("Refresh");
        serveButton = new JButton("Serve Order");
        detailsButton = new JButton("Details");
    }
    // LAYOUT
    private void initializeLayout() {
        setLayout(new BorderLayout());
        add(new JScrollPane(ordersTable), BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.add(refreshButton);
        bottom.add(detailsButton);
        bottom.add(serveButton);
        add(bottom, BorderLayout.SOUTH);
    }
    // LISTENERS

    private void initializeListeners() {
        refreshButton.addActionListener(e -> refreshTable());
        detailsButton.addActionListener(e -> showDetails());
        serveButton.addActionListener(e -> serveOrder());

    }
    // TABLE
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Order order : Order.getOrderExtent()) {
            if (order.getOrderStatus() != OrderStatus.READY)
                continue;
            String client = "-";
            if (order.getClient() != null) {
                client = order.getClient().getPersonName() + " " + order.getClient().getPeronSurname();
            }

            tableModel.addRow(new Object[]{
                    order.getOrderID(),
                    client,
                    order.getTableNumber(),
                    order.getOrderStatus(),
                    order.countOrderValue()
            });
        }
    }
    // DETAILS
    private void showDetails() {
        int row = ordersTable.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this,"Select order.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Order ID: " + tableModel.getValueAt(row,0)
                        + "\nClient: " + tableModel.getValueAt(row,1));
    }
    // SERVE
    private void serveOrder() {
        int row = ordersTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select order.");
            return;
        }
        int orderId = (Integer) tableModel.getValueAt(row, 0);
        Order order = Order.findById(orderId);
        loggedWaiter.serveOrder(order);
        parent.refreshAllPanels();
    }
    public void reload() {
        refreshTable();
    }
}