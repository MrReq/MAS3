package Models;
import Enums.AllPersonTypes;
import Enums.Citizenship;
import Enums.OrderType;
import Enums.Sex;
import SecondaryClasses.ObjectPlus;
import java.time.LocalDate;
import java.util.*;

public class Client extends Person {
    private static final long serialVersionUID = 1L;
    // ====================================================ATTRIBUTES====================================================
    private int clientID;
    private Order shoppingCart;
    private boolean hasClubCard;
    private int satisfactionOfTheService;
    private Citizenship citizenship;
    private final Map<Integer, Order> orders =
            new TreeMap<>();

//====================================================CONSTRUCTORS====================================================

    public Client() {
        super();
    }

    public Client(String name,
                  String surname,
                  LocalDate dateOfBirth,
                  Sex sex,
                  boolean hasClubCard) {

        super(name, surname, dateOfBirth, sex);

        this.clientID = Person.getCounter();

        this.hasClubCard = hasClubCard;
        shoppingCart = Order.createOrder(this, OrderType.Liquid);
    }

    public Client(String name,
                  String surname,
                  LocalDate dateOfBirth,
                  Sex sex,
                  boolean hasClubCard,
                  Citizenship citizenship,
                  int clientID) {

        super(name, surname, dateOfBirth, sex);

        this.clientID = clientID;

        this.hasClubCard = hasClubCard;

        this.citizenship = citizenship;
        shoppingCart = Order.createOrder(this, OrderType.Liquid);
    }


//==================================================== EXTENT====================================================


    @SuppressWarnings("unchecked")
    public static List<Client> getClientExtent() {
        return (List<Client>)(List<?>) ObjectPlus.getExtent(Client.class);
    }
    /**
     * Checks whether identical client already exists.
     */
    public static boolean clientExists(String name,
                                       String surname,
                                       LocalDate birthDate,
                                       Sex sex,
                                       Citizenship citizenship) {
        for (Client client : getClientExtent()) {
            if (client.getPersonName().equalsIgnoreCase(name)
                    &&
                    client.getPeronSurname().equalsIgnoreCase(surname)
                    &&
                    client.getPersonDateOfBirth().equals(birthDate)
                    &&
                    client.getPersonSex() == sex
                    &&
                    Objects.equals(
                            client.getCitizenship().orElse(null),
                            citizenship)) {
                return true;
            }
        }
        return false;
    }
    // ====================================================GETTERS====================================================

    public boolean hasClubCard() {
        return hasClubCard;
    }


    public Optional<Citizenship> getCitizenship() {
        return Optional.ofNullable(citizenship);
    }

    public Collection<Order> getOrders() {
        return Collections.unmodifiableCollection(
                orders.values()
        );
    }
    @Override
    public String getPrivileges() {
        return "CLIENT";
    }
    public void giveSatisfactionLevel(Waiter waiter,
                                      int satisfaction) {
        Objects.requireNonNull(waiter);
        setSatisfactionOfTheService(satisfaction);
        waiter.getWaitersGrades().add(satisfaction);
        waiter.setGrade(satisfaction);
    }
    // ====================SETTERS=================

    public void setSatisfactionOfTheService(int satisfaction) {
        if (satisfaction < 1 || satisfaction > 5) {
            throw new IllegalArgumentException(
                    "Satisfaction must be between 1 and 5."
            );
        }
        this.satisfactionOfTheService = satisfaction;
    }

    public void addOrder(Order order) {
        Objects.requireNonNull(order);
        if (orders.containsKey(order.getOrderID()))
            return;
        orders.put(order.getOrderID(), order);
        order.setClient(this);
    }

    @Override
    public String toString() {
        return String.format(
                "Client{id=%d, name='%s %s', clubCard=%s, citizenship=%s}",
                clientID,
                personName,
                peronSurname,
                hasClubCard,
                citizenship
        );
    }

    public Order getShoppingCart() {
        return shoppingCart;
    }
    public void createNewShoppingCart() {
        shoppingCart = Order.createOrder(
                this,
                OrderType.Liquid
        );
    }
    public int countOrders() {
        return getOrders().size() - 1;
    }
}