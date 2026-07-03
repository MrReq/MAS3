package Models;
import Enums.CoffeeCountry;
import Enums.TemperatureOfTheService;
import Interfaces.Preparable;
import SecondaryClasses.ObjectPlus;

import java.util.ArrayList;
import java.util.List;
public class Americano extends Coffee implements Preparable {
    private static final long serialVersionUID = 1L;
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addAmericano" which adds instance of {@linkplain Americano} to extent collection</br>
     * <br>Private Static method "removeAmericano" which removes instance of {@linkplain Americano} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Americano} line by line.</br>
     */
    // EXTENT
    @SuppressWarnings("unchecked")
    public static List<Americano> getBaristaExtent() {
        return (List<Americano>) (List<?>) ObjectPlus.getExtent(Americano.class);
    }
    @Override
    public String toString() {
        return "Americano: " + super.productName + ", id: " + super.toString();
    }
    /**Simple, Single, Required, Object, Concrete, Attribute "waterAmount" typed {@linkplain Double}
     */
    double waterAmount;
    /**Simple, Single, Required, Object, Concrete, Attribute "espressoShotCount" typed {@linkplain Integer}
     */
    int espressoShotCount;
    /**Simple, Single, Required, Object, Concrete, Attribute "waterToCoffeeRatio" typed {@linkplain Double}
     */
    double waterToCoffeeRatio;
    /**Simple, Single, Required, Object, Concrete, Attribute "power" typed {@linkplain Double}
     */
    double power;
//    public Americano() {
//        super();
//    }
    public Americano(String name, float cost, boolean availability, String description
            , TemperatureOfTheService temperatureOfService, CoffeeCountry coffeeCountry) {
        super(name, cost, availability, description, temperatureOfService, coffeeCountry);
    }
    /**
     * Public object method "countPowerOfCoffee"
     * @param : none
     * @return : power of the coffee which depends on {@linkplain CoffeeCountry}
     */
    public String countPowerOfCoffee(){
        if (this.coffeeCountry== CoffeeCountry.Arabia){
            this.power =  (1 - waterToCoffeeRatio + 0.3);
        }else if(this.coffeeCountry== CoffeeCountry.Kenia){
            this.power =  (1 - waterToCoffeeRatio + 0.38);
        }else {
            this.power =  (1 - waterToCoffeeRatio + 0.17);
        }
        return "Power of the coffee is "+power;
    }
    @Override
    public void prepare() {
        System.out.println("Brewing Americano...");
    }

}