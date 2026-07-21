package Models;

import Enums.TemperatureOfTheService;
import Enums.TypeOfMilk;

import java.util.List;

public class Milk extends Drink {
    private static final long serialVersionUID = 1L;

    // EXTENT

    public static List<Milk> getMilkExtent() {
        return getExtent(Milk.class);
    }

    // FIELDS

    private TypeOfMilk typeOfMilk;

    // CONSTRUCTORS

    public Milk(String name, float cost, boolean availability,
                String description,
                TemperatureOfTheService TemperatureOfTheService) {
        super(name, cost, availability, description, TemperatureOfTheService);
    }

    // GETTERS / SETTERS

    public TypeOfMilk getTypeOfMilk() {
        return typeOfMilk;
    }

    public void setTypeOfMilk(TypeOfMilk typeOfMilk) {
        this.typeOfMilk = typeOfMilk;
    }

    // METHODS

    @Override
    public String toString() {
        return "Milk{" +
                "name='" + productName + '\'' +
                ", typeOfMilk=" + typeOfMilk +
                '}';
    }
}