package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Enums.Sex;

public class HighExperienced extends Employee {
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addHighExperienced" which adds instance of {@linkplain HighExperienced} to extent collection</br>
     * <br>Private Static method "removeHighExperienced" which removes instance of {@linkplain HighExperienced} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain HighExperienced} line by line.</br>
     */
    @Override
    public String toString() {
        return "HighExperienced: " + personName + ", id: " + super.toString();
    }
    private static List<HighExperienced> extent = new ArrayList<>();
    private static void addHighExperienced(HighExperienced highExperienced) {
        extent.add(highExperienced);
    }
    private static void removeHighExperienced(HighExperienced highExperienced) {
        extent.remove(highExperienced);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + HighExperienced.class.getName());
        for (HighExperienced highExperienced : extent) {
            System.out.println(highExperienced);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    String auto;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public HighExperienced(String name, String surname, LocalDate dateOfBirth, Sex sex, Float salary) {
        super(name, surname, dateOfBirth, sex, salary);
    }
    //DYNAMIC INHERITANCE START
    public HighExperienced(Employee employee, String auto) {
        super(employee.personName, employee.peronSurname, employee.personDateOfBirth, employee.personSex, employee.employeeSalary
        );
        this.auto = auto;
    }
    public String getPrivileges() {
        return "Company car: "
                + auto;
    }
    //DYNAMIC INHERITANCE END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START

    //METHODS SESSION END
}
