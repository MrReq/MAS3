package Models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CoffeeHouse {
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addCoffeeHouse" which adds instance of {@linkplain CoffeeHouse} to extent collection</br>
     * <br>Private Static method "removeCoffeeHouse" which removes instance of {@linkplain CoffeeHouse} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain CoffeeHouse} line by line.</br>
     */
    @Override
    public String toString() {
        return "CoffeeHouse: " + coffeeHouseName + ", id: " + coffeeHouseID + " , Address: " + coffeeHouseAddress
                + ", List of PhoneNumbers: "
                + coffeeHousePhoneNumberList + " Memory: "
                + super.toString();
    }
    private static List<CoffeeHouse> extent = new ArrayList<>();
    private static void addCoffeeHouse(CoffeeHouse coffeeHouse) {
        extent.add(coffeeHouse);
    }
    private static void removeCoffeeHouse(CoffeeHouse coffeeHouse) {
        extent.remove(coffeeHouse);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + CoffeeHouse.class.getName());
        for (CoffeeHouse coffeeHouse : extent) {
            System.out.println(coffeeHouse);
        }
    }
    private void write(DataOutputStream stream) throws IOException {
        stream.writeInt(coffeeHouseID);
        stream.writeUTF(coffeeHouseName);
        stream.writeUTF(coffeeHouseAddress);
    }
    private void read(DataInputStream stream) throws IOException {
        coffeeHouseID = stream.readInt();
        coffeeHouseName=stream.readUTF();
        coffeeHouseAddress=stream.readUTF();
    }
    public static void writeExtent(DataOutputStream stream) throws IOException {
        // Number of objects
        stream.writeInt(extent.size());
        for (CoffeeHouse coffeeHouse : extent) {
            coffeeHouse.write(stream);
        }
    }
    public static void readExtent(DataInputStream stream) throws IOException {
        CoffeeHouse coffeeHouse = null;
        // Get the number of written objects
        int objectCount = stream.readInt();
        // remove the current extent
        extent.clear();
        for (int i = 0; i < objectCount; i++) {
            coffeeHouse = new CoffeeHouse();
            coffeeHouse.read(stream);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Simple, Single, Required, Object, Concrete Attribute "CoffeeHouseID" typed {@linkplain Integer}
     */
    int coffeeHouseID;
    /**Simple, Single, Required, Object, Concrete Attribute "coffeeHouseName" typed {@linkplain String}
     */
    String coffeeHouseName;
    /**Simple, Single, Required, Object, Concrete Attribute "coffeeHouseAddress" typed {@linkplain String}
     */
    String coffeeHouseAddress;
    /**Complex, Repeatable, Optional, Object, Concrete Attribute "coffeeHousePhoneNumberList" typed {@linkplain List}
     */
    List<Long> coffeeHousePhoneNumberList;
    /**Simple, Single, Required, Class, Concrete Attribute "openingTime" typed {@linkplain String}
     */
    static String openingTime = "8:00";
    /**Simple, Single, Required, Class, Concrete Attribute "closingTime" typed {@linkplain String}
     */
    static String closingTime = "20:00";
    /**Simple, Single, Required, Class, Concrete Attribute "howManyWorkersMax" typed {@linkplain Byte}
     */
    static byte howManyWorkersMax = 9;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public CoffeeHouse() {
        addCoffeeHouse(this);
        System.out.println("Its just default CoffeeHouse");
    }
    public CoffeeHouse(int coffeeHouseID, String coffeeHouseName, String coffeeHouseAddress, List<Long> coffeeHousePhoneNumberList) {
        addCoffeeHouse(this);
        this.coffeeHouseID = coffeeHouseID;
        this.coffeeHouseName = coffeeHouseName;
        this.coffeeHouseAddress = coffeeHouseAddress;
        this.coffeeHousePhoneNumberList = coffeeHousePhoneNumberList;
    }
    public void setCoffeeHouseID(int coffeeHouseID) {
        this.coffeeHouseID = coffeeHouseID;
    }
    public void changeCoffeeHouseID(byte newID){
        this.setCoffeeHouseID(newID);
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START
    //METHODS SESSION END
    //BINARY ASSOCIATION
//    public ArrayList<Employee> hiredEmployees = new ArrayList<>();
    public int[] employeesIDs;
    private static ArrayList<CoffeeHouse> extentForBinaryAssociation = new ArrayList<>();
    private static Map<Integer, CoffeeHouse> extentMapForBinaryAssociation = new TreeMap<>();
    public CoffeeHouse(int coffeeHouseID, String coffeeHouseName, String coffeeHouseAddress, List<Long> coffeeHousePhoneNumberList
            , int[] employeesIDs) {
        addCoffeeHouse(this);
        this.coffeeHouseID = coffeeHouseID;
        this.coffeeHouseName = coffeeHouseName;
        this.coffeeHouseAddress = coffeeHouseAddress;
        this.coffeeHousePhoneNumberList = coffeeHousePhoneNumberList;
        this.employeesIDs = employeesIDs;
        extentForBinaryAssociation.add(this);
        extentMapForBinaryAssociation.put(coffeeHouseID,this);
    }
    public static CoffeeHouse findCoffeeHouse(int id) throws Exception {
        for(CoffeeHouse coffeeHouse : extentForBinaryAssociation) {
            if(coffeeHouse.coffeeHouseID == id) {
                return coffeeHouse;
            }
        }
        throw new Exception("Unable to find a CoffeeHouse with the coffeeHouseID = " + id);
    }
    private List<Employee> employees = new ArrayList<>();
    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.addCoffeeHouse(this); // 🔁 połączenie zwrotne
        }
    }
    /**ASSOCIATION WITH ATTRIBUTE
     */
    private List<Employment_CoffeeHouse_Employee> employments = new ArrayList<>();
    public void addEmployment(Employment_CoffeeHouse_Employee employment) {
        if (!employments.contains(employment)) {
            employments.add(employment);
        }
    }
    public String getCoffeeHouseName() {
        return coffeeHouseName;
    }
    public List<Employment_CoffeeHouse_Employee> getEmployments() {
        return employments;
    }
    //Removing connections
    public void removeEmployee(Employee employeeToRemove) {
        if(employees.contains(employeeToRemove)) {
            employees.remove(employeeToRemove);
            employeeToRemove.removeeCoffeeHouse(this);
        }
    }
}
