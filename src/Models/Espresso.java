package Models;

import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;
import Interfaces.Preparable;

import java.util.List;

public class Espresso extends Coffee implements Preparable {
    private static final long serialVersionUID = 1L;

    // EXTENT

    public static List<Espresso> getEspressoExtent() {
        return getExtent(Espresso.class);
    }

    protected int shotOfEspressoCount;
    protected int extractionTime;
    protected double pressure;

    // CONSTRUCTORS

    public Espresso(String name, float cost, boolean availability, String description,
                    TemperatureOfTheService temperatureOfTheService,
                    CoffeeCountry coffeeCountry) {
        super(name, cost, availability, description, temperatureOfTheService, coffeeCountry);
    }

    public Espresso(String name, float cost, boolean availability, String description,
                    TemperatureOfTheService temperatureOfTheService,
                    CoffeeCountry coffeeCountry,
                    int shotOfEspressoCount,
                    int extractionTime,
                    double pressure) {

        super(name, cost, availability, description, temperatureOfTheService, coffeeCountry);

        this.shotOfEspressoCount = shotOfEspressoCount;
        this.extractionTime = extractionTime;
        this.pressure = pressure;
    }

    // METHODS

    @Override
    public String toString() {
        return "Espresso: " + productName + ", id: " + super.toString();
    }

    @Override
    public String countPowerOfCoffee() {
        return "Power of this coffee is " +
                shotOfEspressoCount * pressure / extractionTime;
    }

    @Override
    public void prepare() {
        System.out.println("Brewing Espresso...");
    }
}