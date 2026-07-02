package Views.Panels;


import Models.Client;
import Models.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyOrdersPanel extends JPanel {

    private final Client client;

    private JTable ordersTable;

    private DefaultTableModel tableModel;

    private JButton refreshButton;

    public MyOrdersPanel(Client client) {

        this.client = client;

        initializeComponents();

        initializeLayout();

        initializeListeners();

        refreshTable();

    }

    private void initializeComponents() {

        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(new String[]{

                "Order ID",

                "Price",

                "Status"

        });

        ordersTable = new JTable(tableModel);

        refreshButton = new JButton("Refresh");

    }

    private void initializeLayout() {

        setLayout(new BorderLayout());

        add(new JScrollPane(ordersTable),BorderLayout.CENTER);

        JPanel south = new JPanel();

        south.add(refreshButton);

        add(south,BorderLayout.SOUTH);

    }

    private void initializeListeners() {

        refreshButton.addActionListener(e->refreshTable());

    }

    private void refreshTable() {

        tableModel.setRowCount(0);

        for(Order order : client.getOrders()) {

            tableModel.addRow(new Object[]{

                    order.getOrderID(),

                    order.getTotalPrice(),

                    order.getOrderStatus()

            });

        }

    }

}
