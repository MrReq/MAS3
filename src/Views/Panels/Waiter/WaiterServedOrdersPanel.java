package Views.Panels.Waiter;

import Enums.OrderStatus;
import Models.Order;
import Models.Product;
import Models.Waiter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WaiterServedOrdersPanel extends JPanel {

    private JTable ordersTable;

    private DefaultTableModel tableModel;

    private JButton refreshButton;

    private final Waiter waiter;

    public WaiterServedOrdersPanel(Waiter waiter) {
        this.waiter = waiter;
        initializeComponents();

        initializeLayout();

        initializeListeners();

        refreshTable();

    }

    //=================================================
    // COMPONENTS
    //=================================================

    private void initializeComponents() {

        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(new String[]{

                "Order ID",
                "Client",
                "Table",
                "Products",
                "Value"

        });

        ordersTable = new JTable(tableModel);

        refreshButton = new JButton("Refresh");

    }

    //=================================================
    // LAYOUT
    //=================================================

    private void initializeLayout() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "Served Orders",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);

        add(new JScrollPane(ordersTable),
                BorderLayout.CENTER);

        JPanel bottom = new JPanel();

        bottom.add(refreshButton);

        add(bottom, BorderLayout.SOUTH);

    }

    //=================================================
    // LISTENERS
    //=================================================

    private void initializeListeners() {

        refreshButton.addActionListener(e -> refreshTable());

    }

    //=================================================
    // TABLE
    //=================================================

    private void refreshTable() {

        tableModel.setRowCount(0);

        for (Order order : Order.getOrderExtent()) {

            if (order.getOrderStatus() != OrderStatus.SERVED) {
                continue;
            }

            StringBuilder products = new StringBuilder();

            for (Product product : order.getProducts()) {

                if (products.length() > 0) {
                    products.append(", ");
                }

                products.append(product.getProductName());

            }

            String client = "-";

            if (order.getClient() != null) {

                client = order.getClient().getPersonName()
                        + " "
                        + order.getClient().getPeronSurname();

            }

            tableModel.addRow(new Object[]{

                    order.getOrderID(),
                    client,
                    products.toString(),
                    order.countOrderValue()

            });

        }

    }

    //=================================================
    // PUBLIC
    //=================================================

    public void reload() {

        refreshTable();

    }

}