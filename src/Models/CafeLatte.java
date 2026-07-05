package Models;
import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;
import Enums.TypeOfMilk;
import Interfaces.Preparable;
import SecondaryClasses.ObjectPlus;
import java.util.List;
public class CafeLatte extends Coffee implements Preparable {
    private static final long serialVersionUID = 1L;
    public CafeLatte() {}
    // EXTENT
    public static List<CafeLatte> getCafeLatteExtent() {
        return (List<CafeLatte>) (List<?>) ObjectPlus.getExtent(CafeLatte.class);
    }
    TypeOfMilk typeOfMilk;
    double milkAmount;
    double milkFoamLevel;
    int espressoShotCount;
    //CONSTRUCTORS
    public CafeLatte(String name, float cost, boolean availability, String description
                    ,TemperatureOfTheService temperatureOfService, CoffeeCountry coffeeCountry) {
        super(name, cost, availability, description, temperatureOfService, coffeeCountry);
    }
    public CafeLatte(String name, float cost, boolean availability, String description
                    ,TemperatureOfTheService temperatureOfService, CoffeeCountry coffeeCountry,TypeOfMilk typeOfMilk,
                     double milkAmount,double milkFoamLevel,int espressoShotCount) {
        super(name, cost, availability, description, temperatureOfService, coffeeCountry);
        this.typeOfMilk =typeOfMilk;
        this.milkAmount = milkAmount;
        this.milkFoamLevel = milkFoamLevel;
        this.espressoShotCount = espressoShotCount;

    }
    //METHODS
    @Override
    public String countPowerOfCoffee() {
        return "To kawa z mlekiem ona nie jest mocna ;)";
    }
    @Override
    public void prepare() {
        System.out.println("Steaming milk and preparing Cafe Latte...");
    }
}
