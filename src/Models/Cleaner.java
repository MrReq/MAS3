package Models;

import Enums.Sex;
import Enums.Shift;
import SecondaryClasses.ObjectPlus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cleaner extends Employee {
    private static final long serialVersionUID = 1L;
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addCleaner" which adds instance of {@linkplain Cleaner} to extent collection</br>
     * <br>Private Static method "removeCleaner" which removes instance of {@linkplain Cleaner} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Cleaner} line by line.</br>
     */
    @Override
    public String toString() {
        return "Cleaner: " + personName + ", id: " + super.toString();
    }
    @SuppressWarnings("unchecked")
    public static List<Cleaner> getCleanerExtent() {
        return (List<Cleaner>) (List<?>) ObjectPlus.getExtent(Cleaner.class);
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Complex, Single, Required, Object, Concrete Attribute "shift" typed {@linkplain Shift}
     */
    Shift shift;
    /**Simple, Single, Required, Object, Concrete Attribute "assignedArea" typed {@linkplain String}
     */
    String assignedArea;
    //CONSTRUCTORS
    public Cleaner(String name, String surname, LocalDate dateOfBirth, Sex sex, Shift shift, String assignedArea, float salary) {
        super(name, surname, dateOfBirth, sex, salary);
        this.shift = shift;
        this.assignedArea = assignedArea;
    }
    //GETERS
    public Shift getShift() {
        return shift;
    }
    public String getAssignedArea() {
        return assignedArea;
    }
    //SETERS
    public void setAssignedArea(String assignedArea) {
        this.assignedArea = assignedArea;
    }
    public void setShift(Shift shift) {
        this.shift = shift;
    }
}