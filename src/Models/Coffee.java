package Models;

import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;
import Interfaces.Preparable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public abstract class Coffee extends Drink  {
    private static final long serialVersionUID = 1L;
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addCoffee" which adds instance of {@linkplain Coffee} to extent collection</br>
     * <br>Private Static method "removeCoffee" which removes instance of {@linkplain Coffee} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Coffee} line by line.</br>
     */
    @Override
    public String toString() {
        return "Coffee: " + super.productName + ", id: " + super.toString();
    }
    CoffeeCountry coffeeCountry;
    double power;
    public Coffee() {
        super();
    }
    public Coffee(String name, float cost, boolean availability, String description,
                  TemperatureOfTheService temperatureOfService, CoffeeCountry coffeeCountry) {
        super(name, cost, availability, description, temperatureOfService);
        this.coffeeCountry=coffeeCountry;

    }
    public abstract String countPowerOfCoffee();

}
