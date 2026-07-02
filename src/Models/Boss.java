package Models;

import Enums.Sex;
import Models.Person;
import SecondaryClasses.ObjectPlus;

import java.time.LocalDate;
import java.util.List;

public class Boss extends Person {

    private String password;

    public Boss() {
        super();
    }

    public Boss(String name,
                String surname,
                String password) {

        super(name, surname);

        this.password = password;
    }

    public Boss(String name,
                String surname,
                LocalDate birthDate,
                Sex sex,
                String password) {

        super(name, surname, birthDate, sex);

        this.password = password;
    }

    @SuppressWarnings("unchecked")
    public static List<Boss> getBossExtent() {
        return (List<Boss>)(List<?>) ObjectPlus.getExtent(Boss.class);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getPrivileges() {
        return "ALL";
    }
}