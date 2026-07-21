package Models;

import Enums.Doneness;
import Enums.TemperatureOfTheService;
import Enums.TypeOfMeal;

import java.util.List;

public class Food extends Product {
    private static final long serialVersionUID = 1L;

    // EXTENT

    public static List<Food> getFoodExtent() {
        return getExtent(Food.class);
    }

    protected double weight;
    protected TypeOfMeal typeOfMeal;
    protected Doneness doneness;

    // CONSTRUCTORS

    public Food(String name, float cost, boolean availability,
                String description,
                TemperatureOfTheService TemperatureOfTheService) {
        super(name, cost, availability, description, TemperatureOfTheService);
    }

    public Food(String name, float cost, boolean availability,
                String description,
                TemperatureOfTheService TemperatureOfTheService,
                double weight,
                TypeOfMeal typeOfMeal,
                Doneness doneness) {

        super(name, cost, availability, description, TemperatureOfTheService);

        this.weight = weight;
        this.typeOfMeal = typeOfMeal;
        this.doneness = doneness;
    }

    // METHODS

    @Override
    public String toString() {
        return "Food: " + productName + " " +
                super.toString() + " " +
                weight + " " +
                typeOfMeal + " " +
                doneness;
    }

    @Override
    public void prepare() {
    }

    @Override
    public int getPreparationTime() {
        return 0;
    }
}