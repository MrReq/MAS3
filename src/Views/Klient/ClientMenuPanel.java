package Views.Klient;
import Models.Client;
import Models.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
public class ClientMenuPanel extends JPanel {
    private final Client loggedClient;
    private JTable productsTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton;
    private JButton addToCartButton;
    private JButton addManyToCartButton;
    private ClientDashboardView parent;
    public ClientMenuPanel(Client loggedClient, ClientDashboardView parent) {
        this.loggedClient = loggedClient;
        this.parent = parent;
        initializeComponents();
        initializeLayout();
        initializeListeners();
        refreshTable();
    }
    // COMPONENTS
    private void initializeComponents() {
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Price", "Temperature", "Available"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        productsTable = new JTable(tableModel);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        productsTable.setRowSorter(sorter);
        productsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        refreshButton = new JButton("Refresh");
        addToCartButton = new JButton("Add to cart");
        addManyToCartButton = new JButton("Add Many to cart");
    }
    // LAYOUT
    private void initializeLayout() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("MENU", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);
        add(new JScrollPane(productsTable), BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.add(refreshButton);
        bottom.add(addToCartButton);
        bottom.add(addManyToCartButton);
        add(bottom, BorderLayout.SOUTH);
    }
    // LISTENERS
    private void initializeListeners() {
        refreshButton.addActionListener(e -> refreshTable());
        addToCartButton.addActionListener(e -> addToCart());
        addManyToCartButton.addActionListener(e -> addManyToCart());
    }
    // TABLE
    public void refreshTable() {
        System.out.println(Product.getProductExtent().size());
        tableModel.setRowCount(0);
        for (Product product : Product.getProductExtent()) {
            tableModel.addRow(new Object[]{product.getProductID(), product.getProductName(), product.getProductCost(),
                    product.getTemperatureOfTheService(), product.isProductAvailability()
            });
        }
    }
    // ADD TO CART
    private void addToCart() {
        int row = productsTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select product.","Error",0);
            return;
        }
        int modelRow = productsTable.convertRowIndexToModel(row);
        int productID = (Integer) tableModel.getValueAt(modelRow, 0);
        Product selectedProduct = Product.findById(productID);
        if (selectedProduct == null) {
            JOptionPane.showMessageDialog(this, "Product not found.","Error",0);
            return;
        }
        if (!selectedProduct.isProductAvailability()) {
            JOptionPane.showMessageDialog(this, "Product is unavailable.","Error",0);
            return;
        }
        loggedClient.getShoppingCart().addProduct(selectedProduct);
        JOptionPane.showMessageDialog(this, "Product added to shopping cart.","Accepted",
                JOptionPane.INFORMATION_MESSAGE);
        parent.refreshAllPanels();
    }

    private void addManyToCart() {
        int counter = 0;
        int[] rows = productsTable.getSelectedRows();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(this, "Select at least one product.","Error",0);
            return;
        }
        for (int row : rows){
            int modelRow = productsTable.convertRowIndexToModel(row);
            int productID = (Integer) tableModel.getValueAt(modelRow, 0);
            Product selectedProduct = Product.findById(productID);
            if (selectedProduct == null) {
                JOptionPane.showMessageDialog(this, "Product not found.","Error",0);
                return;
            }
            if (!selectedProduct.isProductAvailability()) {
                JOptionPane.showMessageDialog(this, "Product is unavailable.","Error",0);
                return;
            }
            loggedClient.getShoppingCart().addProduct(selectedProduct);
            counter++;
        }
        JOptionPane.showMessageDialog(this, counter + " Products added to shopping cart.","Accepted",
                JOptionPane.INFORMATION_MESSAGE);
        parent.refreshAllPanels();
    }
    public void reload() {
        refreshTable();
    }
}