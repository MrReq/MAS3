package Models;
import Enums.Sex;
import Enums.Shift;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class Cleaner extends Employee {
    private static final long serialVersionUID = 1L;
    private Shift shift;
    private String assignedArea;
    // CONSTRUCTORS
    public Cleaner(String name, String surname, LocalDate dateOfBirth, Sex sex,
                   Shift shift, String assignedArea, float salary) {
        super(name, surname, dateOfBirth, sex, salary);
        this.shift = shift;
        this.assignedArea = assignedArea;
    }
    // EXTENT
    public static List<Cleaner> getCleanerExtent() {
        return getExtent(Cleaner.class);
    }
    // GETTERS & SETTERS
    public Shift getShift() {
        return shift;
    }
    public void setShift(Shift shift) {
        this.shift = shift;
    }
    public String getAssignedArea() {
        return assignedArea;
    }
    public void setAssignedArea(String assignedArea) {
        this.assignedArea = assignedArea;
    }
    // METHODS
    @Override
    public String toString() {
        return "Cleaner: " + personName + ", id: " + super.toString();
    }
    public Collection<Order> getOrders() {
        try {
            return Arrays.stream(getLinks("orders"))
                    .map(link -> (Order) link)
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}