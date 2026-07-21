package Models;

import Enums.TemperatureOfTheService;
import Interfaces.Preparable;
import SecondaryClasses.ObjectPlusPlus;

import java.util.ArrayList;
import java.util.List;

public abstract class Product extends ObjectPlusPlus implements Preparable {
    private static final long serialVersionUID = 1L;

    // ATTRIBUTES

    protected static int staticProductID = 1;

    protected int productID;
    protected String productName;
    protected float productCost;
    protected boolean productAvailability;
    protected List<String> productIngredients;
    protected String productDescription;
    protected TemperatureOfTheService temperatureOfTheService;

    protected static List<Product> products;

    protected List<Product> productsExtent = getExtent(Product.class);

    // CONSTRUCTORS

    public Product() {
        super();
    }

    public Product(String name,
                   float cost,
                   boolean availability,
                   String description,
                   TemperatureOfTheService temperatureOfService) {

        super();

        this.productID = staticProductID++;
        this.productName = name;
        this.productCost = cost;
        this.productAvailability = availability;
        this.productDescription = description;
        this.temperatureOfTheService = temperatureOfService;
    }

    public Product(int productID,
                   String name,
                   float cost,
                   boolean availability,
                   String description,
                   TemperatureOfTheService temperatureOfService) {

        super();

        this.productID = productID;
        this.productName = name;
        this.productCost = cost;
        this.productAvailability = availability;
        this.productDescription = description;
        this.temperatureOfTheService = temperatureOfService;
    }

    // EXTENT

    public static List<Product> getProductExtent() {
        List<Product> result = new ArrayList<>();

        result.addAll(getExtent(Americano.class));
        result.addAll(getExtent(CafeLatte.class));
        result.addAll(getExtent(Espresso.class));

        return result;
    }

    // GETTERS / SETTERS

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductCost() {
        return productCost;
    }

    public void setProductCost(float productCost) {
        this.productCost = productCost;
    }

    public boolean isProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(boolean productAvailability) {
        this.productAvailability = productAvailability;
    }

    public List<String> getProductIngredients() {
        return productIngredients;
    }

    public void setProductIngredients(List<String> productIngredients) {
        this.productIngredients = productIngredients;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public TemperatureOfTheService getTemperatureOfTheService() {
        return temperatureOfTheService;
    }

    public void setTemperatureOfTheService(TemperatureOfTheService temperatureOfTheService) {
        this.temperatureOfTheService = temperatureOfTheService;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        Product.products = products;
    }

    public int getProductID() {
        return productID;
    }

    // BUSINESS METHODS

    @Override
    public String toString() {
        return "Product: " + productName;
    }

    public static void createListOfAllProducts() {
        System.out.println("that is the list of the productList");
        products.forEach(System.out::println);
    }

    public static List<Product> getAvailableProducts() {
        return getProductExtent()
                .stream()
                .filter(Product::isProductAvailability)
                .toList();
    }

    public double countOrderValue() {
        return products.stream()
                .mapToDouble(Product::getProductCost)
                .sum();
    }

    public void changePrice(float newPrice) {
        if (newPrice <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        productCost = newPrice;
    }

    public static Product findById(int id) {
        for (Product product : getProductExtent()) {
            if (product.getProductID() == id) {
                return product;
            }
        }

        return null;
    }

    public static void productRebuildCounter() {
        int maxId = 0;

        for (Product product : getProductExtent()) {
            if (product.getProductID() > maxId) {
                maxId = product.getProductID();
            }
        }

        staticProductID = maxId + 1;
    }
}