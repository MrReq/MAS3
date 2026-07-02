package Models;

import Enums.CoffeeCountry;
import Enums.Sex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Barista extends Employee {
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addBarista" which adds instance of {@linkplain Barista} to extent collection</br>
     * <br>Private Static method "removeBarista" which removes instance of {@linkplain Barista} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Barista} line by line.</br>
     */
    @Override
    public String toString() {
        return "Barista: " + super.personName + ", id: " + employeeID + " "+ super.toString();
    }
    private static List<Barista> extent = new ArrayList<>();
    private static void addBarista(Barista barista) {
        extent.add(barista);
    }
    private static void removeBarista(Barista barista) {
        extent.remove(barista);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Barista.class.getName());
        for (Barista barista : extent) {
            System.out.println(barista);
        }
    }
    // SERIALIZATION (WRITE)
    protected void write(DataOutputStream stream) throws IOException {
        super.write(stream);
        stream.writeUTF(favouriteCoffee != null ? favouriteCoffee.toString() : "");
    }
    protected void read(DataInputStream stream) throws IOException {
        super.read(stream);
        String type = stream.readUTF();
        switch (type) {
            case "Americano":
                favouriteCoffee = new Americano();
                break;
            case "Latte":
                favouriteCoffee = new CafeLatte();
                break;
            default:
                throw new IOException("Unknown coffee type: " + type);
        }
        favouriteCoffee.read(stream);
    }
    public static void writeExtent(DataOutputStream stream) throws IOException {
        // Number of objects
        stream.writeInt(extent.size());
        for (Barista barista : extent) {
            barista.write(stream);
        }
    }
    public static void readExtent(DataInputStream stream) throws IOException {
        Barista barista = null;
        // Get the number of written objects
        int objectCount = stream.readInt();
        // remove the current extent
        extent.clear();
        for (int i = 0; i < objectCount; i++) {
            barista = new Barista();
            barista.read(stream);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Complex, Single, Required, Object, Concrete Attribute "favouriteCoffee" type {@linkplain Coffee}
     */
    Coffee favouriteCoffee;
    CoffeeCountry favouriteCoffeeCountry;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public Barista(String name, String surname, LocalDate dateOfBirth, Sex sex, Coffee favouriteCoffee, float salary) {
        super(name, surname, dateOfBirth, sex, salary);
        this.favouriteCoffee = favouriteCoffee;
    }
    public Barista(String name, String surname, LocalDate dateOfBirth, Sex sex, CoffeeCountry favouriteCoffeeCountry, float salary) {
        super(name, surname, dateOfBirth, sex, salary);
        this.favouriteCoffeeCountry = favouriteCoffeeCountry;
    }
    public Barista(){
        super();
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START
    public void makeCoffee(){
        System.out.println("I'm making coffee");
    }
    //METHODS SESSION END
}