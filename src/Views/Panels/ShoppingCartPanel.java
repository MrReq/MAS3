package Views.Panels;

import Models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPanel extends JPanel {

    private JTable cartTable;
    private DefaultTableModel tableModel;

    private JButton removeButton;
    private JButton clearButton;
    private JButton createOrderButton;

    private JLabel totalLabel;

    private final List<Product> cart = new ArrayList<>();

    public ShoppingCartPanel() {

        initializeComponents();
        initializeLayout();
        initializeListeners();

        refreshTable();

    }

    private void initializeComponents() {

        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(new String[]{

                "Product",

                "Price"

        });

        cartTable = new JTable(tableModel);

        cartTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        removeButton = new JButton("Remove");

        clearButton = new JButton("Clear");

        createOrderButton = new JButton("Create Order");

        totalLabel = new JLabel("Total: 0.00 PLN");

    }

    private void initializeLayout() {

        setLayout(new BorderLayout());

        add(new JScrollPane(cartTable), BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());

        JPanel buttons = new JPanel();

        buttons.add(removeButton);
        buttons.add(clearButton);
        buttons.add(createOrderButton);

        southPanel.add(totalLabel, BorderLayout.WEST);
        southPanel.add(buttons, BorderLayout.EAST);

        add(southPanel, BorderLayout.SOUTH);

    }

    private void initializeListeners() {

        removeButton.addActionListener(e -> removeSelectedProduct());

        clearButton.addActionListener(e -> clearCart());

        createOrderButton.addActionListener(e -> createOrder());

    }

    //==================================================

    public void addProduct(Product product) {

        cart.add(product);

        refreshTable();

    }

    //==================================================

    private void removeSelectedProduct() {

        int row = cartTable.getSelectedRow();

        if(row == -1)
            return;

        cart.remove(row);

        refreshTable();

    }

    //==================================================

    private void clearCart() {

        cart.clear();

        refreshTable();

    }

    //==================================================

    private void refreshTable() {

        tableModel.setRowCount(0);

        double total = 0;

        for(Product product : cart){

            tableModel.addRow(new Object[]{

                    product.getProductName(),

                    product.getProductCost()

            });

            total += product.getProductCost();

        }

        totalLabel.setText(String.format("Total: %.2f PLN", total));

    }

    //==================================================

    private void createOrder() {

        if(cart.isEmpty()){

            JOptionPane.showMessageDialog(

                    this,

                    "Shopping cart is empty."

            );

            return;

        }

        JOptionPane.showMessageDialog(

                this,

                "Order will be created here."

        );

        // tutaj stworzymy Order

    }

}
