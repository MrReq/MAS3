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
                    double pressure,
                    int extractionTime
                    ) {

        super(name, cost, availability, description, temperatureOfTheService, coffeeCountry);

        this.shotOfEspressoCount = shotOfEspressoCount;
        this.pressure = pressure;
        this.extractionTime = extractionTime;
    }

    // METHODS

    @Override
    public String toString() {
        return "Espresso: " + productName + ", id: " + super.toString();
    }

    @Override
    public String countPowerOfCoffee() {

        if (extractionTime == 0) {
            return "Cannot calculate coffee power (extraction time = 0).";
        }

        double power = shotOfEspressoCount * pressure / extractionTime;

        return "Power of this coffee is " + power;
    }

    @Override
    public void prepare() {
        System.out.println("Brewing Espresso...");
    }
}