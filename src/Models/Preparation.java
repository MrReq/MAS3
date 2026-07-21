package Models;

import SecondaryClasses.ObjectPlusPlus;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Preparation extends ObjectPlusPlus implements Serializable {
    private static final long serialVersionUID = 1L;

    // FIELDS

    private Barista barista;
    private Order order;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // CONSTRUCTORS

    public Preparation(Barista barista, Order order) {
        super();

        System.out.println("NEW PREPARATION -> Order " + order.getOrderID());

        if (barista == null) {
            throw new IllegalArgumentException("Barista cannot be null.");
        }

        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }

        this.barista = barista;
        this.order = order;

        order.setPreparation(this);
        barista.addPreparation(this);

        this.startTime = LocalDateTime.now();
    }

    // EXTENT

    public static List<Preparation> getPreparationExtent() {
        return getExtent(Preparation.class);
    }

    // BUSINESS METHODS

    public void finishPreparation() {
        endTime = LocalDateTime.now();
    }

    public Duration getPreparationTime() {
        if (endTime == null) {
            return Duration.between(startTime, LocalDateTime.now());
        }

        return Duration.between(startTime, endTime);
    }

    // GETTERS

    public Barista getBarista() {
        return barista;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Preparation{" +
                "barista=" + barista.getPersonName() +
                ", order=" + order.getOrderID() +
                ", started=" + startTime +
                ", finished=" + endTime +
                '}';
    }
}