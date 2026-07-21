package Models;

import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;

import java.util.List;

public abstract class Coffee extends Drink {
    private static final long serialVersionUID = 1L;

    // EXTENT

    public static List<Coffee> getCoffeeExtent() {
        return getExtent(Coffee.class);
    }

    protected CoffeeCountry coffeeCountry;
    protected double power;

    // CONSTRUCTORS

    public Coffee() {
        super();
    }

    public Coffee(String name, float cost, boolean availability, String description,
                  TemperatureOfTheService temperatureOfService,
                  CoffeeCountry coffeeCountry) {

        super(name, cost, availability, description, temperatureOfService);
        this.coffeeCountry = coffeeCountry;
    }

    // METHODS

    @Override
    public String toString() {
        return "Coffee: " + super.productName + ", id: " + super.toString();
    }

    public abstract Object countPowerOfCoffee();
}


