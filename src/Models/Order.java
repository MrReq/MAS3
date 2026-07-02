package Models;

import Enums.OrderStatus;
import Enums.OrderType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    //=========================================================
    // EXTENT
    //=========================================================

    private static final List<Order> extent = new ArrayList<>();

    private static void addOrder(Order order) {
        extent.add(order);
    }

    private static void removeOrder(Order order) {
        extent.remove(order);
    }

    public static List<Order> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static void showExtent() {

        System.out.println("Extent of " + Order.class.getSimpleName());

        extent.forEach(System.out::println);

    }

    //=========================================================
    // FIELDS
    //=========================================================

    private static int counter = 1;

    private final int orderID;

    private final OrderType orderType;

    private OrderStatus status;

    private final LocalDateTime createdAt;

    private OrderStatus orderStatus;

    //=========================================================
    // ASSOCIATIONS
    //=========================================================

    // Qualified Association

    private Client client;

    // Association Order -> Product

    private final List<Product> products = new ArrayList<>();

    // Composition

    private final List<Delivery> deliveries = new ArrayList<>();

    //=========================================================
    // CONSTRUCTOR
    //=========================================================

    public Order(OrderType orderType) {

        this.orderID = counter++;

        this.orderType = orderType;

        this.status = OrderStatus.NEW;

        this.createdAt = LocalDateTime.now();

        addOrder(this);

    }

    //=========================================================
    // PRODUCTS
    //=========================================================

    public void addProduct(Product product) {

        if (product == null)
            return;

        products.add(product);

    }

    public void removeProduct(Product product) {

        products.remove(product);

    }

    public List<Product> getProducts() {

        return Collections.unmodifiableList(products);

    }

    //=========================================================
    // PRICE
    //=========================================================

    public float getTotalPrice() {

        float total = 0;

        for (Product product : products) {

            total += product.getProductCost();

        }

        return total;

    }

    //=========================================================
    // CLIENT
    //=========================================================

    public Client getClient() {

        return client;

    }

    public void setClient(Client client) {

        if (this.client == client)
            return;

        this.client = client;

        if (client != null) {

            client.addOrder(this);

        }

    }

    //=========================================================
    // DELIVERY (COMPOSITION)
    //=========================================================

    public Delivery addDelivery() {

        Delivery delivery = Delivery.create(this);

        deliveries.add(delivery);

        return delivery;

    }

    public void addDelivery(Delivery delivery) {

        if (delivery.getOrder() != null &&
                delivery.getOrder() != this) {

            throw new IllegalStateException(
                    "Delivery already belongs to another order."
            );

        }

        if (!deliveries.contains(delivery)) {

            deliveries.add(delivery);

            delivery.setOrder(this);

        }

    }

    public void removeDelivery(Delivery delivery) {

        if (deliveries.remove(delivery)) {

            delivery.setOrder(null);

        }

    }

    public List<Delivery> getDeliveries() {

        return Collections.unmodifiableList(deliveries);

    }

    //=========================================================
    // GETTERS
    //=========================================================

    public int getOrderID() {

        return orderID;

    }

    public OrderType getOrderType() {

        return orderType;

    }

    public OrderStatus getStatus() {

        return status;

    }

    public LocalDateTime getCreatedAt() {

        return createdAt;

    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    //=========================================================
    // STATUS
    //=========================================================

    public void setStatus(OrderStatus status) {

        this.status = status;

    }

    //=========================================================
    // toString()
    //=========================================================

    @Override
    public String toString() {

        return "Order{" +
                "id=" + orderID +
                ", type=" + orderType +
                ", status=" + status +
                ", price=" + getTotalPrice() +
                ", products=" + products.size() +
                '}';

    }

}