package Models;

import java.util.ArrayList;
import java.util.List;

import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;
import Interfaces.Preparable;

public class Espresso extends Coffee  implements Preparable {
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addEspresso" which adds instance of {@linkplain Espresso} to extent collection</br>
     * <br>Private Static method "removeEspresso" which removes instance of {@linkplain Espresso} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Espresso} line by line.</br>
     */
    @Override
    public String toString() {
        return "Espresso: " + productName + ", id: " + super.toString();
    }
    private static List<Espresso> extent = new ArrayList<>();
    private static void addEspresso(Espresso espresso) {
        extent.add(espresso);
    }
    private static void removeEspresso(Espresso espresso) {
        extent.remove(espresso);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Espresso.class.getName());
        for (Espresso espresso : extent) {
            System.out.println(espresso);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION START

    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public Espresso(String name, float cost, boolean availability, String description
            , TemperatureOfTheService temperatureOfService, CoffeeCountry coffeeCountry) {
        super(name, cost, availability, description, temperatureOfService, coffeeCountry);
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START
    //METHODS SESSION END
}
