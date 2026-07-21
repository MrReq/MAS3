package Models;

import Enums.OrderStatus;
import Enums.OrderType;
import SecondaryClasses.ObjectPlusPlus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order extends ObjectPlusPlus {
    private static final long serialVersionUID = 1L;

    private static int counter = 1;

    private final int orderID;
    private Preparation preparation;
    private float totalPrice;
    private final OrderType orderType;
    private OrderStatus orderStatus;
    private final LocalDateTime createdAt;
    private Client client;
    private Delivery delivery;
    private boolean shoppingCart = true;

    private final List<Product> products = new ArrayList<>();

    // EXTENT

    public static List<Order> getOrderExtent() {
        return getExtent(Order.class);
    }

    // CONSTRUCTOR

    public Order(Client client, OrderType orderType) {
        super();

        if (orderType == null) {
            throw new IllegalArgumentException("Order type cannot be null.");
        }

        this.orderID = counter++;
        this.client = client;
        this.orderType = orderType;
        this.orderStatus = OrderStatus.NEW;
        this.createdAt = LocalDateTime.now();

        if (client != null) {
            client.addOrder(this);
        }
    }

    // GETTERS

    public int getOrderID() {
        return orderID;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Client getClient() {
        return client;
    }

    public boolean isShoppingCart() {
        return shoppingCart;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Preparation getPreparation() {
        return preparation;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // SETTERS

    public void setShoppingCart(boolean shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setOrderStatus(OrderStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null.");
        }

        this.orderStatus = status;
    }

    public void setPreparation(Preparation preparation) {
        this.preparation = preparation;
    }

    public void setClient(Client client) {
        if (this.client == client) {
            return;
        }

        this.client = client;

        if (client != null) {
            client.addOrder(this);
        }
    }

    // BUSINESS METHODS

    public double countOrderValue() {
        return products.stream()
                .mapToDouble(Product::getProductCost)
                .sum();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }

        products.add(product);
    }

    public void removeProduct(Product product) {
        if (product == null) {
            return;
        }

        products.remove(product);
    }

    public void receivePayment() {
        System.out.println(orderStatus);

        if (orderStatus != OrderStatus.SERVED) {
            throw new IllegalStateException("Order must be SERVED.");
        }

        orderStatus = OrderStatus.PAID;

        System.out.println(orderStatus);
    }

    public void acceptOrder() {
        if (orderStatus != OrderStatus.NEW) {
            throw new IllegalStateException("Only NEW orders can be accepted.");
        }

        orderStatus = OrderStatus.ACCEPTED;
    }

    public void startPreparation(Barista barista) {
        if (orderStatus != OrderStatus.ACCEPTED) {
            throw new IllegalStateException("Only accepted orders can be prepared.");
        }

        orderStatus = OrderStatus.PREPARING;

        // preparation = new Preparation(barista, this);
    }

    public void markAsReady() {
        orderStatus = OrderStatus.READY;
    }

    public boolean isCompleted() {
        return orderStatus == OrderStatus.DELIVERED
                || orderStatus == OrderStatus.FINISHED;
    }

    // STATIC METHODS

    public static Order createOrder(Client client, OrderType type) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null.");
        }

        return new Order(client, type);
    }

    public static Order findById(int orderID) {
        System.out.println("Searching for order ID = " + orderID);
        System.out.println("Orders in extent: " + getOrderExtent().size());

        for (Order order : getOrderExtent()) {
            System.out.println("Found order: " + order.getOrderID());

            if (order.getOrderID() == orderID) {
                System.out.println("MATCH!");
                return order;
            }
        }

        System.out.println("NOT FOUND");
        return null;
    }

    public static void rebuildCounter() {
        int maxId = 0;

        for (Order order : getOrderExtent()) {
            if (order.getOrderID() > maxId) {
                maxId = order.getOrderID();
            }
        }

        counter = maxId + 1;
    }

    public static List<Order> getReadyOrders() {
        List<Order> result = new ArrayList<>();

        for (Order order : getOrderExtent()) {
            if (order.getOrderStatus() == OrderStatus.READY) {
                result.add(order);
            }
        }

        return result;
    }

    public static List<Order> getPaidOrders() {
        List<Order> result = new ArrayList<>();

        for (Order order : getOrderExtent()) {
            if (order.getOrderStatus() == OrderStatus.READY) {
                result.add(order);
            }
        }

        return result;
    }

    public static List<Order> getFinishedOrders() {
        List<Order> result = new ArrayList<>();

        for (Order order : getOrderExtent()) {
            if (order.getOrderStatus() == OrderStatus.FINISHED) {
                result.add(order);
            }
        }

        return result;
    }

    public static List<Order> getPreparingOrders() {
        return getOrderExtent().stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.PREPARING)
                .toList();
    }

    public static List<Order> getNewOrders() {
        return getOrderExtent().stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.NEW)
                .filter(o -> !o.getProducts().isEmpty())
                .toList();
    }

    public static List<Order> getAcceptedOrders() {
        return getOrderExtent().stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.ACCEPTED)
                .filter(o -> !o.getProducts().isEmpty())
                .toList();
    }

    public static List<Order> getServedOrders() {
        return getOrderExtent().stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.SERVED)
                .filter(o -> !o.getProducts().isEmpty())
                .toList();
    }

    public static List<Order> getCancelledOrders() {
        return getOrderExtent().stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.SERVED)
                .filter(o -> !o.getProducts().isEmpty())
                .toList();
    }

    public static List<Order> getCompletedOrders() {
        return getOrderExtent().stream()
                .filter(Order::isCompleted)
                .toList();
    }
}