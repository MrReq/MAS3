package Models;

import Enums.Sex;
import SecondaryClasses.ObjectPlusPlus;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public abstract class Person extends ObjectPlusPlus {
    private static final long serialVersionUID = 1L;

    private static int counter = 1;

    public static LocalDate now = LocalDate.now();

    protected String personName;
    protected String peronSurname;
    protected LocalDate personDateOfBirth;
    protected Sex personSex;

    // CONSTRUCTORS

    public Person() {
        super();
    }

    public Person(String name, String surname) {
        super();
        this.personName = name;
        this.peronSurname = surname;
    }

    public Person(String name, String surname, LocalDate dateOfBirth, Sex sex) {
        super();
        this.personName = name;
        this.peronSurname = surname;
        this.personDateOfBirth = dateOfBirth;
        this.personSex = sex;
        counter++;
    }

    // EXTENT

    public static List<Person> getPersonExtent() {
        return getExtent(Person.class);
    }

    // GETTERS

    public static int getCounter() {
        return counter;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPeronSurname() {
        return peronSurname;
    }

    public LocalDate getPersonDateOfBirth() {
        return personDateOfBirth;
    }

    public Sex getPersonSex() {
        return personSex;
    }

    public static LocalDate getNow() {
        return now;
    }

    // DERIVED ATTRIBUTE

    public int getAge() {
        if (personDateOfBirth == null) {
            return 0;
        }

        return Period.between(personDateOfBirth, LocalDate.now()).getYears();
    }

    // METHODS

    public abstract String getPrivileges();

    @Override
    public String toString() {
        return personName + " " + peronSurname;
    }
}