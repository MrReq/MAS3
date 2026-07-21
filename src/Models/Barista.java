package Models;
import Enums.CoffeeCountry;
import Enums.OrderStatus;
import Enums.Sex;
import java.time.LocalDate;
import java.util.*;
public class Barista extends Employee {
    private static final long serialVersionUID = 1L;
    private CoffeeCountry favouriteCoffeeCountry;
    private final Map<Integer, Order> orders = new HashMap<>();
    public Barista() {
        super();
    }
    public Barista(String name, String surname, LocalDate dateOfBirth, Sex sex, float salary, CoffeeCountry favouriteCoffeeCountry) {
        super(name, surname, dateOfBirth, sex, salary);
        this.favouriteCoffeeCountry = favouriteCoffeeCountry;
    }
    public Collection<Preparation> getPreparations() {
        try {
            return Arrays.stream(getLinks("preparations"))
                    .map(p -> (Preparation) p)
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
    // EXTENT
    public static List<Barista> getBaristaExtent() {
        return getExtent(Barista.class);
    }
    // GETTERS
    public CoffeeCountry getFavouriteCoffeeCountry() {
        return favouriteCoffeeCountry;
    }
    @Override
    public String getPrivileges() {
        return "BARISTA";
    }
    //METHODS
    @Override
    public String toString() {
        return String.format(
                "Barista{id=%d, name='%s %s', salary=%.2f, favouriteCoffeeCountry=%s}", employeeID, personName, peronSurname,
                employeeSalary, favouriteCoffeeCountry);
    }
    public void startPreparing(Order order){
        order.setOrderStatus(OrderStatus.PREPARING);
    }
    public void markOrderAsReady(Order order) {
        if(order == null)
            throw new IllegalArgumentException("Order cannot be null.");
        order.markAsReady();
    }
    public int countNewOrders() {
        return (int) Order.getOrderExtent().stream().filter(a->a.getOrderStatus() == OrderStatus.NEW)
                .filter(o->!o.getProducts().isEmpty())
                .count();
    }
    public void acceptOrder(Order order) {
        if (order == null)
            throw new IllegalArgumentException("Order cannot be null.");
        if (order.getPreparation() != null) {
            throw new IllegalStateException("Order is already assigned to another Barista.");
        }
        for (Product product : order.getProducts()) {
            if (!product.isProductAvailability())
                throw new IllegalStateException("Some products are unavailable.");
        }
        new Preparation(this, order);
        order.acceptOrder();
    }
    public int countAcceptedOrders() {
        return (int) getPreparations().stream()
                .filter(p -> p.getBarista() == this)
                .filter(p -> p.getOrder().getOrderStatus() == OrderStatus.ACCEPTED)
                .count();
    }
    public int countPreparingOrders() {
        return (int) getPreparations().stream()
                .filter(p -> p.getBarista() == this)
                .filter(p -> p.getOrder().getOrderStatus() == OrderStatus.PREPARING)
                .count();
    }
    public int countReadyOrders() {
        return (int) getPreparations()
                .stream()
                .filter(p -> p.getBarista() == this)
                .filter(p -> p.getOrder().getOrderStatus() == OrderStatus.READY)
                .count();
    }

}