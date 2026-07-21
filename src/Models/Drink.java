package Models;

import Enums.Size;
import Enums.TemperatureOfTheService;
import Interfaces.Preparable;

import java.util.List;

public class Drink extends Product implements Preparable {
    private static final long serialVersionUID = 1L;

    protected boolean coffeineContain;
    protected Size size;

    // CONSTRUCTORS

    public Drink() {
        super();
    }

    public Drink(String name, float cost, boolean availability, String description,
                 TemperatureOfTheService temperatureOfTheService) {
        super(name, cost, availability, description, temperatureOfTheService);
    }

    public Drink(String name, float cost, boolean availability, String description,
                 TemperatureOfTheService temperatureOfTheService,
                 boolean coffeineContain, Size size) {

        super(name, cost, availability, description, temperatureOfTheService);
        this.coffeineContain = coffeineContain;
        this.size = size;
    }

    // EXTENT

    public static List<Drink> getDrinkExtent() {
        return getExtent(Drink.class);
    }

    // METHODS

    @Override
    public String toString() {
        return "Drink: " + super.productName + super.toString() + " "
                + coffeineContain + " " + size;
    }

    @Override
    public void prepare() {
    }

    @Override
    public int getPreparationTime() {
        return 0;
    }
}