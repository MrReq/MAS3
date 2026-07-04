package Models;

import SecondaryClasses.ObjectPlus;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Employment extends ObjectPlus implements Serializable {

    private static final long serialVersionUID = 1L;

    //=========================================================
    // ATTRIBUTES OF ASSOCIATION
    //=========================================================

    private final Boss boss;

    private final Employee employee;

    /**
     * Attribute of the association.
     * Date when employee was hired by the boss.
     */
    private final LocalDate employmentDate;
    @SuppressWarnings("unchecked")
    public static List<Employment> getEmploymentExtent() {
        return (List<Employment>) (List<?>) ObjectPlus.getExtent(Employment.class);
    }

    //=========================================================
    // CONSTRUCTOR
    //=========================================================

    public Employment(Boss boss,
                      Employee employee,
                      LocalDate employmentDate) {

        if (boss == null) {
            throw new IllegalArgumentException("Boss cannot be null.");
        }

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        if (employmentDate == null) {
            throw new IllegalArgumentException("Employment date cannot be null.");
        }

        this.boss = boss;
        this.employee = employee;
        this.employmentDate = employmentDate;

        // automatic reverse links
        boss.addEmployment(this);
        employee.addEmployment(this);
    }

    //=========================================================
    // GETTERS
    //=========================================================

    public Boss getBoss() {
        return boss;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }
//METHODS

    @Override
    public String toString() {

        return "Employment{" +
                "boss=" + boss.getPersonName() + " " + boss.getPeronSurname() +
                ", employee=" + employee.getPersonName() + " " + employee.getPeronSurname() +
                ", employmentDate=" + employmentDate +
                '}';
    }
    public static void showEmployments() {
        if (getEmploymentExtent().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No employments found.", "Employments", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("========== EMPLOYMENTS ==========\n\n");
        for (Employment employment : getEmploymentExtent()) {
            sb.append("Boss: ")
                    .append(employment.getBoss().getPersonName())
                    .append(" ")
                    .append(employment.getBoss().getPeronSurname())
                    .append("\nEmployee: ")
                    .append(employment.getEmployee().getPersonName())
                    .append(" ")
                    .append(employment.getEmployee().getPeronSurname())
                    .append("\nEmployment date: ")
                    .append(employment.getEmploymentDate())
                    .append("\n\n");
        }
        JOptionPane.showMessageDialog(
                null,
                sb.toString(),
                "Employments",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}