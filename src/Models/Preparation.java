package Models;

import SecondaryClasses.ObjectPlusPlus;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Preparation extends ObjectPlusPlus implements Serializable {
    private static final long serialVersionUID = 1L;

    // FIELDS
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
        this.startTime = LocalDateTime.now();

        barista.addLink("preparations", "barista", this);

        order.setPreparation(this);
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
        try {
            return (Barista) getLinks("barista")[0];
        } catch (Exception e) {
            return null;
        }
    }
    public Order getOrder() {
        try {
            return (Order) getLinks("order")[0];
        } catch (Exception e) {
            return null;
        }
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
                "barista=" + getBarista().getPersonName() +
                ", order=" + getOrder().getOrderID() +
                ", started=" + startTime +
                ", finished=" + endTime +
                '}';
    }
}