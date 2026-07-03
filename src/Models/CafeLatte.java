package Models;

import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;
import Enums.TypeOfMilk;
import Interfaces.Preparable;
import SecondaryClasses.ObjectPlus;

import java.util.ArrayList;
import java.util.List;

public class CafeLatte extends Coffee implements Preparable {
    private static final long serialVersionUID = 1L;
    public CafeLatte() {
    }
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addCafeLatte" which adds instance of {@linkplain CafeLatte} to extent collection</br>
     * <br>Private Static method "removeCafeLatte" which removes instance of {@linkplain CafeLatte} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain CafeLatte} line by line.</br>
     */
    // EXTENT
    public static List<CafeLatte> getCafeLatteExtent() {
        return (List<CafeLatte>) (List<?>) ObjectPlus.getExtent(CafeLatte.class);
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Complex, Single, Required, Object, Concrete Attribute "typeOfMilk" typed {@linkplain TypeOfMilk}
     */
    TypeOfMilk typeOfMilk;
    /**Simple, Single, Required, Object, Concrete Attribute "milkAmount" typed {@linkplain Double}
     */
    double milkAmount;
    /**Simple, Single, Required, Object, Concrete Attribute "milkFoamLevel" typed {@linkplain Double}
     */
    double milkFoamLevel;
    /**Simple, Single, Required, Object, Concrete Attribute "espressoShotCount" typed {@linkplain Integer}
     */
    int espressoShotCount;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    /**
     * @param name
     * @param cost
     * @param availability
     * @param description
     * @param temperatureOfService
     */
    public CafeLatte(String name, float cost, boolean availability, String description
            , TemperatureOfTheService temperatureOfService, CoffeeCountry coffeeCountry) {
        super(name, cost, availability, description, temperatureOfService, coffeeCountry);
    }

    public CafeLatte(String name, float cost, boolean availability, String description
            , TemperatureOfTheService temperatureOfService, CoffeeCountry coffeeCountry,TypeOfMilk typeOfMilk,
                     double milkAmount,double milkFoamLevel,int espressoShotCount) {
        super(name, cost, availability, description, temperatureOfService, coffeeCountry);
        this.typeOfMilk =typeOfMilk;
        this.milkAmount = milkAmount;
        this.milkFoamLevel = milkFoamLevel;
        this.espressoShotCount = espressoShotCount;

    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END

    //METHODS SESSION START
    @Override
    public String countPowerOfCoffee() {
        return "To kawa z mlekiem ona nie jest mocna ;)";
    }

    @Override
    public void prepare() {
        System.out.println("Steaming milk and preparing Cafe Latte...");
    }
    //METHODS SESSION END
}
