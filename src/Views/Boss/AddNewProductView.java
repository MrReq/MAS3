package Views.Boss;
import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;
import Models.*;
import javax.swing.*;
import java.awt.*;
public class AddNewProductView extends JFrame {
    // COMPONENTS
    private JComboBox<String> productComboBox;
    private JComboBox<String> descriptionComboBox;
    private JComboBox<Float> priceComboBox;
    private JCheckBox availabilityCheckBox;
    private JComboBox<TemperatureOfTheService> temperatureComboBox;
    private JComboBox<CoffeeCountry> coffeeCountryComboBox;
    private JButton createButton;
    private JButton cancelButton;
    // CONSTRUCTOR
    public AddNewProductView() {
        initializeFrame();
        initializeComponents();
        initializeLayout();
        initializeListeners();
    }
    // FRAME
    private void initializeFrame() {
        setTitle("Create Product  (AddNewProductView)");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);
    }
    // COMPONENTS
    private void initializeComponents() {
        productComboBox = new JComboBox<>();
        productComboBox.addItem("Espresso");
        productComboBox.addItem("Cafe Latte");
        productComboBox.addItem("Americano");
        productComboBox.addItem("Tea");
        productComboBox.addItem("Cheesecake");
        productComboBox.addItem("Water");
        productComboBox.addItem("Sandwich");
        descriptionComboBox = new JComboBox<>();
        descriptionComboBox.addItem("Coffee");
        descriptionComboBox.addItem("Cold Food");
        descriptionComboBox.addItem("Cold Drink");
        descriptionComboBox.addItem("Tea");
        descriptionComboBox.addItem("Dessert");
        priceComboBox = new JComboBox<>();
        priceComboBox.addItem(5f);
        priceComboBox.addItem(10f);
        priceComboBox.addItem(17f);
        priceComboBox.addItem(24f);
        availabilityCheckBox = new JCheckBox("Available", true);
        temperatureComboBox = new JComboBox<>(TemperatureOfTheService.values());
        coffeeCountryComboBox = new JComboBox<>(CoffeeCountry.values());
        createButton = new JButton("Create");
        cancelButton = new JButton("Cancel");
    }
    // LAYOUT
    private void initializeLayout() {
        JPanel panel = new JPanel(new GridBagLayout());
        setExtendedState(MAXIMIZED_BOTH);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Product name:"), gbc);
        gbc.gridx = 1;
        panel.add(productComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        panel.add(priceComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1;
        panel.add(descriptionComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Temperature:"), gbc);
        gbc.gridx = 1;
        panel.add(temperatureComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Product type:"), gbc);
        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(availabilityCheckBox, gbc);
        JPanel buttons = new JPanel();
        buttons.add(createButton);
        buttons.add(cancelButton);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(buttons, gbc);
        add(panel);
    }
    // LISTENERS
    private void initializeListeners() {
        createButton.addActionListener(e -> createProduct());
        cancelButton.addActionListener(e -> dispose());
    }
    // CREATE PRODUCT
    private void createProduct() {
        try {
            String name = (String) productComboBox.getSelectedItem();
            String description = (String) descriptionComboBox.getSelectedItem();
            float price = (Float) priceComboBox.getSelectedItem();
            boolean available = availabilityCheckBox.isSelected();
            TemperatureOfTheService temperature = (TemperatureOfTheService) temperatureComboBox.getSelectedItem();
            String type = (String) productComboBox.getSelectedItem();
            CoffeeCountry coffeeCountry = (CoffeeCountry) coffeeCountryComboBox.getSelectedItem();
            if(name.isBlank()){
                JOptionPane.showMessageDialog(this, "Product name cannot be empty.");
                return;
            }
            Product product = null;
            switch (type){
                case "Americano":
                    product = new Americano(name, price, available, description, temperature, coffeeCountry,0.1,2,0.5);
                    break;
                case "Cafe Latte":
                    product = new CafeLatte(name, price, available, description, temperature, coffeeCountry);
                    break;
                case "Espresso":
                    product = new Espresso(name, price, available, description, temperature, coffeeCountry);
                    break;
                case "Milk":
                    product = new Milk(name, price, available, description, temperature);
                    break;
            }
            JOptionPane.showMessageDialog(this, "Product created successfully.");
            dispose();
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Invalid price.");
        }
    }
}