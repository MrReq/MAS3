package Models;

import SecondaryClasses.ObjectPlus;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CoffeeHouse extends ObjectPlus {
    private static final long serialVersionUID = 1L;
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

    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Simple, Single, Required, Object, Concrete Attribute "CoffeeHouseID" typed {@linkplain Integer}
     */
    private int coffeeHouseID;
    /**Simple, Single, Required, Object, Concrete Attribute "coffeeHouseName" typed {@linkplain String}
     */
    private String coffeeHouseName;
    /**Simple, Single, Required, Object, Concrete Attribute "coffeeHouseAddress" typed {@linkplain String}
     */
    private String coffeeHouseAddress;
    /**Complex, Repeatable, Optional, Object, Concrete Attribute "coffeeHousePhoneNumberList" typed {@linkplain List}
     */
    private List<Long> coffeeHousePhoneNumberList;
    /**Simple, Single, Required, Class, Concrete Attribute "openingTime" typed {@linkplain String}
     */
    public static String openingTime = "8:00";
    /**Simple, Single, Required, Class, Concrete Attribute "closingTime" typed {@linkplain String}
     */
    public static String closingTime = "20:00";
    /**Simple, Single, Required, Class, Concrete Attribute "howManyWorkersMax" typed {@linkplain Byte}
     */
    public static byte howManyWorkersMax = 9;
    public CoffeeHouse() {
        System.out.println("Its just default CoffeeHouse");
    }
    public CoffeeHouse(int coffeeHouseID, String coffeeHouseName, String coffeeHouseAddress, List<Long> coffeeHousePhoneNumberList) {
        this.coffeeHouseID = coffeeHouseID;
        this.coffeeHouseName = coffeeHouseName;
        this.coffeeHouseAddress = coffeeHouseAddress;
        this.coffeeHousePhoneNumberList = coffeeHousePhoneNumberList;
    }
    public int[] employeesIDs;
    private static ArrayList<CoffeeHouse> extentForBinaryAssociation = new ArrayList<>();
    private static Map<Integer, CoffeeHouse> extentMapForBinaryAssociation = new TreeMap<>();
    public CoffeeHouse(int coffeeHouseID, String coffeeHouseName, String coffeeHouseAddress, List<Long> coffeeHousePhoneNumberList
            , int[] employeesIDs) {
        this.coffeeHouseID = coffeeHouseID;
        this.coffeeHouseName = coffeeHouseName;
        this.coffeeHouseAddress = coffeeHouseAddress;
        this.coffeeHousePhoneNumberList = coffeeHousePhoneNumberList;
        this.employeesIDs = employeesIDs;
        extentForBinaryAssociation.add(this);
        extentMapForBinaryAssociation.put(coffeeHouseID,this);
    }
    private List<Employee> employees = new ArrayList<>();
    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.addCoffeeHouse(this);
        }
    }
    private List<Employment_CoffeeHouse_Employee> employments = new ArrayList<>();
    public void addEmployment(Employment_CoffeeHouse_Employee employment) {
        if (!employments.contains(employment)) {
            employments.add(employment);
        }
    }
    public String getCoffeeHouseName() {
        return coffeeHouseName;
    }

    public void removeEmployee(Employee employeeToRemove) {
        if(employees.contains(employeeToRemove)) {
            employees.remove(employeeToRemove);
            employeeToRemove.removeeCoffeeHouse(this);
        }
    }
}
