package Models;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import SecondaryClasses.ObjectPlusPlus;

public class Delivery extends ObjectPlusPlus {
    private static final long serialVersionUID = 1L;

    // EXTENT
    public static List<Delivery> getDeliveryExtent() {
        return getExtent(Delivery.class);
    }

    private static int counter = 1;

    private final int deliveryID;

    // TODO (Etap 2 - ObjectPlusPlus Association)
    private final Order order;

    private String address;
    private String deliveryDate;

    // TODO (Etap 2 - ObjectPlusPlus Association)

    private Delivery(Order order, String address, String deliveryDate) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }

        this.deliveryID = counter++;
        this.order = order;
        this.address = address;
        this.deliveryDate = deliveryDate;
    }

    public static Delivery createDelivery(Order order, String address, String deliveryDate) {
        return new Delivery(order, address, deliveryDate);
    }

    public Waiter getWaiter() {
        try {
            return (Waiter) getLinks("waiter")[0];
        } catch (Exception e) {
            return null;
        }
    }


    public int getDeliveryID() {
        return deliveryID;
    }

    public Order getOrder() {
        return order;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public static void rebuildCounter(Collection<Order> orders) {
        int maxId = 0;

        for (Order order : orders) {
            Delivery delivery = order.getDelivery();

            if (delivery != null && delivery.deliveryID > maxId) {
                maxId = delivery.deliveryID;
            }
        }

        counter = maxId + 1;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + deliveryID +
                ", address='" + address + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                '}';
    }

}