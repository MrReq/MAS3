package Models;

import Enums.AllPersonTypes;
import Enums.OrderStatus;
import Enums.Sex;

import java.time.LocalDate;
import java.util.*;

public class Waiter extends Employee {
    private static final long serialVersionUID = 1L;

    // ATTRIBUTES
    private float waitersTip;
    private int waitersGrade;
    private final List<Integer> waitersGrades = new ArrayList<>();
    private final EnumSet<AllPersonTypes> personKind = EnumSet.of(AllPersonTypes.Waiter);

    // CONSTRUCTORS

    public Waiter() {
        super();
    }

    public Waiter(String name, String surname, LocalDate birthDate, Sex sex, float salary) {
        super(name, surname, birthDate, sex, salary);
    }

    // EXTENT

    public static List<Waiter> getWaiterExtent() {
        return getExtent(Waiter.class);
    }

    // GETTERS

    public List<Integer> getWaitersGrade() {
        return waitersGrades;
    }

    public Collection<Delivery> getServedDeliveries() {
        try {
            return Arrays.stream(getLinks("deliveries"))
                    .map(link -> (Delivery) link)
                    .filter(delivery -> delivery.getOrder().getOrderStatus() == OrderStatus.SERVED)
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // BUSINESS METHODS

    @Override
    public String getPrivileges() {
        return "WAITER";
    }

    public void serveOrder(Order order) throws Exception {
        if (order == null)
            throw new IllegalArgumentException("Order cannot be null.");

        if (order.getOrderStatus() != OrderStatus.READY)
            throw new IllegalStateException("Order is not ready.");

        order.setOrderStatus(OrderStatus.SERVED);

        Delivery delivery = Delivery.createDelivery(
                order,
                "Delivery #" + order.getOrderID(),
                "dzisiaj"
        );
        System.out.println("Delivery extent size = " + Delivery.getDeliveryExtent().size());
        addLink("deliveries", "waiter", delivery);
        System.out.println("Order served.");
    }

    private int calculateAverageGrade() {
        if (waitersGrades.isEmpty())
            return 0;

        int sum = 0;

        for (Integer grade : waitersGrades)
            sum += grade;

        return Math.round((float) sum / waitersGrades.size());
    }

    @Override
    public String toString() {
        return String.format(
                "Waiter{id=%d, name='%s %s', salary=%.2f, grade=%d, tips=%.2f}",
                employeeID,
                personName,
                peronSurname,
                employeeSalary,
                waitersGrade,
                waitersTip
        );
    }

    public void setGrade(int satisfaction) {
        int average = 0;

        for (int a : waitersGrades)
            average += a;

        waitersGrade = average / waitersGrades.size();
    }



    public int countServedOrders() {
        return getServedDeliveries().size();
    }

    public void receivePayment(Order order) {
        if (order == null)
            throw new IllegalArgumentException("Order cannot be null.");

        order.receivePayment();
    }

    public double countTips() {
        return Order.getOrderExtent().stream()
                .filter(o -> o.getOrderStatus() == OrderStatus.PAID)
                .mapToDouble(o -> o.countOrderValue() * 0.10)
                .sum();
    }

    public double getAverageGrade() {
        if (waitersGrades.isEmpty())
            return 0.0;

        return waitersGrades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
}