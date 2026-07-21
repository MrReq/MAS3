package Models;
import SecondaryClasses.ObjectPlusPlus;
import java.util.List;
public class Address extends ObjectPlusPlus {
    private static final long serialVersionUID = 1L;
    public static List<Address> getAddressExtent() {
        return getExtent(Address.class);
    }
    private String street;
    private String city;
    private String postalCode;
    private String country;
    public Address(String street, String city, String postalCode, String country) {
        super();
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