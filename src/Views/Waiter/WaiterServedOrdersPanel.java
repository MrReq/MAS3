package Views.Waiter;
import Enums.OrderStatus;
import Models.Order;
import Models.Delivery;
import Models.Product;
import Models.Waiter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class WaiterServedOrdersPanel extends JPanel {
    private JTable ordersTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton;
    private JButton showDeliveriesButton;
    private final Waiter waiter;
    public WaiterServedOrdersPanel(Waiter waiter) {
        this.waiter = waiter;
        initializeComponents();
        initializeLayout();
        initializeListeners();
        refreshTable();
    }
    // COMPONENTS
    private void initializeComponents() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Order ID", "Client", "Products", "Value", "Status"
        });
        ordersTable = new JTable(tableModel);
        refreshButton = new JButton("Refresh");
        showDeliveriesButton = new JButton("Show Deliveries");
    }
    // LAYOUT
    private void initializeLayout() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Served Orders", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);
        add(new JScrollPane(ordersTable), BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.add(refreshButton);
        bottom.add(showDeliveriesButton);
        add(bottom, BorderLayout.SOUTH);
    }
    // LISTENERS

    private void initializeListeners() {
        refreshButton.addActionListener(e -> refreshTable());
        showDeliveriesButton.addActionListener(e -> showDeliveries());
    }
    // TABLE
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Order order : Order.getOrderExtent()) {
            if (order.getOrderStatus() != OrderStatus.SERVED)
                continue;
            StringBuilder products = new StringBuilder();
            for (Product product : order.getProducts()) {
                if (products.length() > 0)
                    products.append(", ");
                products.append(product.getProductName());
            }
            String client = "-";
            if (order.getClient() != null) {
                client = order.getClient().getPersonName() + " " + order.getClient().getPeronSurname();
            }
            tableModel.addRow(new Object[]{order.getOrderID(), client, products.toString(), order.countOrderValue(),
            order.getOrderStatus()});
        }
    }
    private void showDeliveries() {
        StringBuilder sb = new StringBuilder();
        for (Order order : Order.getOrderExtent()) {
            for (Delivery delivery : order.getDeliveries()) {
                sb.append("Order ID: ")
                        .append(order.getOrderID())
                        .append("    Delivery ID: ")
                        .append(delivery.getDeliveryID())
                        .append("\n");
            }
        }
        if (sb.length() == 0)
            sb.append("No deliveries found.");
        JOptionPane.showMessageDialog(this, sb.toString(), "Deliveries", JOptionPane.INFORMATION_MESSAGE);
    }
    public void reload() {
        refreshTable();
    }
}