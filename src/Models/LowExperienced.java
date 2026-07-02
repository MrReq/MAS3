package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Enums.Sex;
import Enums.TypeOfMeal;
import Enums.TypeOfMilk;
public class LowExperienced extends Employee {
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addLowExperienced" which adds instance of {@linkplain LowExperienced} to extent collection</br>
     * <br>Private Static method "removeLowExperienced" which removes instance of {@linkplain LowExperienced} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain LowExperienced} line by line.</br>
     */
    @Override
    public String toString() {
        return "LowExperienced: " + personName + ", id: " + super.toString();
    }
    private static List<LowExperienced> extent = new ArrayList<>();
    private static void addLowExperienced(LowExperienced lowExperienced) {
        extent.add(lowExperienced);
    }
    private static void removeLowExperienced(LowExperienced lowExperienced) {
        extent.remove(lowExperienced);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + LowExperienced.class.getName());
        for (LowExperienced lowExperienced : extent) {
            System.out.println(lowExperienced);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Complex, Single, Required, Object, Concrete Attribute "favouriteCoffee" typed {@linkplain TypeOfMilk}
     */
    float maxBonusValue;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public LowExperienced(String name, String surname, LocalDate dateOfBirth, Sex sex, Float salary, float maxBonusValue) {
        super(name, surname, dateOfBirth, sex, salary);
        this.maxBonusValue = maxBonusValue;
    }
    //DYNAMIC INHERITANCE START
    public LowExperienced(Employee employee, float maxBonusValue) {
        super(employee.personName, employee.peronSurname, employee.personDateOfBirth, employee.personSex, employee.employeeSalary);
        this.maxBonusValue = maxBonusValue;
    }
    public String getPrivileges() {
        return "Maximum bonus: "
                + maxBonusValue;
    }
    //DYNAMIC INHERITANCE START
    public float getMaxBonusValue() {
        return maxBonusValue;
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    //METHODS SESSION START
    //METHODS SESSION END
}
