package Models;
import SecondaryClasses.ObjectPlus;
import SecondaryClasses.ObjectPlusPlus;

import java.io.Serializable;
import java.util.List;

public class Address extends ObjectPlusPlus {
    public static List<Address> getAddressExtent() {
        return ObjectPlus.getExtent(Address.class);
    }
    private String street;
    private String city;
    private String postalCode;
    private String country;
    public Address(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getCountry() {
        return country;
    }
    @Override
    public String toString() {
        return street + ", " + city + ", " + postalCode + ", " + country;
    }
}