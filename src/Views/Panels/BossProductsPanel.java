package Views.Panels;

import Models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BossProductsPanel extends JPanel {

    private JTable productsTable;

    private DefaultTableModel tableModel;

    private JButton addButton;

    private JButton editButton;

    private JButton deleteButton;

    private JButton refreshButton;

    private JTextArea descriptionArea;

    public BossProductsPanel() {

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

                "Name",

                "Price",

                "Available",

                "Temperature"

        });

        productsTable = new JTable(tableModel);

        productsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addButton = new JButton("Add Product");

        editButton = new JButton("Edit");

        deleteButton = new JButton("Delete");

        refreshButton = new JButton("Refresh");

        descriptionArea = new JTextArea();

        descriptionArea.setEditable(false);

        descriptionArea.setLineWrap(true);

        descriptionArea.setWrapStyleWord(true);

    }

    //=================================================
    // LAYOUT
    //=================================================

    private void initializeLayout() {

        setLayout(new BorderLayout());

        add(new JScrollPane(productsTable), BorderLayout.CENTER);

        JPanel south = new JPanel(new BorderLayout());

        JPanel buttons = new JPanel();

        buttons.add(addButton);

        buttons.add(editButton);

        buttons.add(deleteButton);

        buttons.add(refreshButton);

        south.add(buttons, BorderLayout.NORTH);

        south.add(new JScrollPane(descriptionArea),
                BorderLayout.CENTER);

        add(south, BorderLayout.SOUTH);

    }

    //=================================================
    // LISTENERS
    //=================================================

    private void initializeListeners() {

        refreshButton.addActionListener(e -> refreshTable());

        productsTable.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                showDescription();

            }

        });

        addButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(

                    this,

                    "Product dialog will be implemented."

            );

        });

        editButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(

                    this,

                    "Edit product dialog will be implemented."

            );

        });

        deleteButton.addActionListener(e -> deleteSelectedProduct());

    }

    //=================================================
    // TABLE
    //=================================================

    private void refreshTable() {

        tableModel.setRowCount(0);

        for (Product product : Product.getExtent()) {

            tableModel.addRow(new Object[]{

                    product.getProductName(),

                    product.getProductCost(),

                    product.isProductAvailability(),

                    product.getTemperatureOfTheService()

            });

        }

    }

    //=================================================
    // DESCRIPTION
    //=================================================

    private void showDescription() {

        int row = productsTable.getSelectedRow();

        if (row == -1) {

            descriptionArea.setText("");

            return;

        }

        Product product = Product.getExtent().get(row);

        descriptionArea.setText(

                product.getProductDescription()

        );

    }

    //=================================================
    // DELETE
    //=================================================

    private void deleteSelectedProduct() {

        int row = productsTable.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(

                    this,

                    "Select a product."

            );

            return;

        }

        Product product = Product.getExtent().get(row);

        JOptionPane.showMessageDialog(

                this,

                "Deleting "

                        + product.getProductName()

                        + " will be implemented."

        );

    }

}