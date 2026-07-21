package Models;

import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;
import Enums.TypeOfMilk;
import Interfaces.Preparable;

import java.util.List;

public class CafeLatte extends Coffee implements Preparable {
    private static final long serialVersionUID = 1L;

    TypeOfMilk typeOfMilk;
    double milkAmount;
    double milkFoamLevel;
    int espressoShotCount;

    // CONSTRUCTORS

    public CafeLatte() {
    }

    public CafeLatte(String name, float cost, boolean availability, String description,
                     TemperatureOfTheService temperatureOThefService, CoffeeCountry coffeeCountry) {
        super(name, cost, availability, description, temperatureOThefService, coffeeCountry);
    }

    public CafeLatte(String name, float cost, boolean availability, String description,
                     TemperatureOfTheService temperatureOThefService, CoffeeCountry coffeeCountry,
                     TypeOfMilk typeOfMilk, double milkAmount,
                     double milkFoamLevel, int espressoShotCount) {

        super(name, cost, availability, description, temperatureOThefService, coffeeCountry);

        this.typeOfMilk = typeOfMilk;
        this.milkAmount = milkAmount;
        this.milkFoamLevel = milkFoamLevel;
        this.espressoShotCount = espressoShotCount;
    }

    // EXTENT

    public static List<CafeLatte> getCafeLatteExtent() {
        return getExtent(CafeLatte.class);
    }

    // METHODS

    @Override
    public String countPowerOfCoffee() {
        return "To kawa z mlekiem ona nie jest mocna ;)";
    }

    @Override
    public void prepare() {
        System.out.println("Steaming milk and preparing Cafe Latte...");
    }
}