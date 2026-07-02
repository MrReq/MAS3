package Models;

import java.util.ArrayList;
import java.util.List;

import Enums.TypeOfMilk;
import Enums.TemperatureOfTheService;
public class Milk extends Drink {
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addMilk" which adds instance of {@linkplain Milk} to extent collection</br>
     * <br>Private Static method "removeMilk" which removes instance of {@linkplain Milk} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Milk} line by line.</br>
     */
    @Override
    public String toString() {
        return "Milk: " + productName + ", id: " + super.toString();
    }
    private static List<Milk> extent = new ArrayList<>();
    private static void addMilk(Milk milk) {
        extent.add(milk);
    }
    private static void removeMilk(Milk milk) {
        extent.remove(milk);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Milk.class.getName());
        for (Milk milk : extent) {
            System.out.println(milk);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Simple, Single, Required, Object, Concrete Attribute "typeOfMilk" typed {@linkplain TypeOfMilk}
     */
    TypeOfMilk typeOfMilk;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public Milk(String name, float cost, boolean availability, String description, TemperatureOfTheService temperatureOfService) {
        super(name, cost, availability, description, temperatureOfService);
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START
    //METHODS SESSION END
}
