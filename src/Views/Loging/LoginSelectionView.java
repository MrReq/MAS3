package Views.Loging;
import SecondaryClasses.ObjectPlus;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.TableRowSorter;
public class LoginSelectionView extends JFrame {
    private JTabbedPane tabbedPane;
    public LoginSelectionView() {
        setTitle("Coffee House - Logowanie (LoginSelectionView)");
        setSize(400, 250);
        setMinimumSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        JLabel title = new JLabel("Wybierz sposób logowania", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1, 10, 10));
        JButton clientButton = new JButton("Zaloguj jako klient");
        JButton employeeButton = new JButton("Zaloguj jako pracownik");
        JButton createBossButton = new JButton("Utwórz szefa");
        JButton clearextensionButton = new JButton("Wyczyśc całą ekstensję");
        JButton exitProgram = new JButton("Wyłącz Program");
        buttonsPanel.add(clientButton);
        buttonsPanel.add(employeeButton);
        buttonsPanel.add(createBossButton);
        buttonsPanel.add(clearextensionButton);
        buttonsPanel.add(exitProgram);
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Login", panel);

        tabbedPane.addTab("Project Description", new ProjectDescriptionPanel());

        tabbedPane.addTab("Extension",new JOptionPane("Here is the message about extension.\n" +
                "There are 2 main classes for extension.\n" +
                "The most native class is ObjectPlusPlus it has these elements:\n" +
                "private Map<String, Map<Object, ObjectPlusPlus>> links = new Hashtable<>();\n" +
                "private static Set<ObjectPlusPlus> allParts = new HashSet<>();\n" +
                "protected ObjectPlusPlus() { super();}\n" +
                "private void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier, int counter)\n" +
                "public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject)\n" +
                "public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier)\n" +
                "public void addPart(String roleName, String reverseRoleName, ObjectPlusPlus partObject) throws Exception\n" +
                "public ObjectPlusPlus[] getLinks(String roleName) throws Exception\n" +
                "public void showLinks(String roleName, PrintStream stream) throws Exception\n" +
                "public ObjectPlusPlus getLinkedObject(String roleName, Object qualifier) throws Exception\n" +
                "public boolean anyLink(String roleName) \n" +
                "The second class is ObjectPlus which extends ObjectPlusPlus. Here are properties:\n" +
                "private static Map<Class, List> allExtents = new HashMap<>(); \n" +
                "protected ObjectPlus()\n" +
                "public static <T extends ObjectPlus> List<T> getExtent(Class<T> type)\n" +
                "public static void showExtent(Class type)\n" +
                "public void removeFromExtent()\n" +
                "public static void saveExtents(String fileName) throws IOException\n" +
                "public static void loadExtents(String fileName) throws IOException, ClassNotFoundException\n" +
                "public static void clearExtents()\n" +
                "public static Set<Class> getRegisteredClasses()\n",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Extension – durability", new JOptionPane("<html>" +
                                "The project implements an extent persistence mechanism, whose purpose is to preserve all created objects between subsequent executions of the application.<br>" +
                                "The solution is implemented in the ObjectPlus class, which serves as the superclass for all domain classes that require extent management.<br><br>" +
                                "Whenever a new object is created, it is automatically added to its corresponding extent by the constructor of the ObjectPlus class.<br>" +
                                "All extents are stored in a static map named allExtents, where the key represents the object's class and the value is a list containing all instances of that class.<br><br>" +
                                "The persistence mechanism is based on Java serialization using ObjectOutputStream.<br>" +
                                "The saveExtents(String fileName) method serializes the entire allExtents structure and stores it in the specified file.<br>" +
                                "As a result, every object together with its current state can be restored after restarting the application.<br><br>" +
                                "Loading previously saved data is performed by the loadExtents(String fileName) method, which uses ObjectInputStream.<br>" +
                                "If the persistence file exists, the serialized data are deserialized and assigned back to the allExtents map, restoring all previously saved extents.<br><br>" +
                                "In this project, extent persistence covers all classes inheriting from ObjectPlus, including:<br><br>" +
                                "• Barista<br>" +
                                "• Boss<br>" +
                                "• Cleaner<br>" +
                                "• Client<br>" +
                                "• WorkingClient<br>" +
                                "• Order<br>" +
                                "• Preparation<br>" +
                                "• Employment<br>" +
                                "• Delivery<br>" +
                                "• Address<br>" +
                                "• Americano<br>" +
                                "• CafeLatte<br>" +
                                "• Espresso<br>" +
                                "• Milk<br><br>" +
                                "As a result, after restarting the application, there is no need to recreate domain objects manually.<br>" +
                                "All previously stored objects are automatically restored from the persistence file.<br><br>" +
                                "This solution ensures consistency of the object model and fulfills the extent persistence requirement defined by the Modeling and Systems Analysis (MAS) methodology." +
                                "</html>", JOptionPane.INFORMATION_MESSAGE)
        );

        tabbedPane.addTab("Composite attribute", new JOptionPane(
                        "<html>" +
                                "A composite attribute is an attribute that consists of multiple logically related sub-attributes.<br>" +
                                "Instead of storing all values directly in one class, they are grouped into a separate class representing a single concept.<br><br>" +
                                "In this project, the composite attribute is implemented as <b>Address address</b>.<br>" +
                                "The Address class groups information such as street, house number, city, postal code and country into one reusable object.<br>" +
                                "This improves readability, reusability. " +
                                "</html>", JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Optional attribute", new JOptionPane(
                "Optional attribute\n" +
                        "An optional attribute is an attribute that is not required to have a value.\n"
                        + "Unlike required attributes, it is acceptable for an optional attribute to be missing.\n"
                        + "In Java, optional attributes are usually implemented using reference types that can store the value null.\n"
                        + "Before using such an attribute, the program should always check whether a value is present to avoid runtime errors such as NullPointerException.\n"
                        + "In this project, the customer's address (Address address) is an example of an optional attribute.\n"
                        + "A customer can be created without providing an address.\n"
                        + "This means that the address reference may remain null until it is assigned later.",
                JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Repeatable attribute", new JOptionPane(
                "Repeatable attribute\n" +
                        "A repeatable attribute allows an object to store multiple values of the same type.\n" +
                        "In this project, the repeatable attribute is the products field in the Order class.\n" +
                        "It is implemented as a List<Product>, which allows one order to contain multiple products.\n" +
                        "This means that a customer can order several different products within a single order.\n" +
                        "For example, one order may include many Espresso, Cafe Latte, Americano.",
                JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Class attribute", new JOptionPane(
                "Class attribute\n" +
                        "A class attribute is shared by all objects of the same class.\n"
                        + "Unlike object attributes, only one copy of a class attribute exists in memory.\n"
                        + "In Java, class attributes are implemented using the static keyword.\n"
                        + "Every object accesses the same value instead of having its own separate copy.\n"
                        + "In this project, the opening time of the coffee house (public static LocalTime start) is an example of a class attribute.\n"
                        + "The opening time is the same for all objects of this class, so it is shared rather than stored individually in each object.",
                JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Derived attribute", new JOptionPane(
                "Derived attribute\n" +
                        "A derived attribute is an attribute whose value is calculated from other attributes instead of being stored directly.\n"
                        + "Its value is obtained whenever it is needed, which prevents storing redundant or outdated data.\n"
                        + "In Java, derived attributes are usually implemented as getter methods that perform the required calculations.\n"
                        + "This approach ensures that the value is always consistent with the current state of the object.\n"
                        + "In this project, the person's age is a derived attribute.\n"
                        + "The age is calculated from the person's date of birth using the getAge() method instead of being stored as a separate field.",
                JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Class method", new JOptionPane(
                "Class method\n" +
                        "A class method is a method that belongs to the class rather than to a specific object.\n"
                        + "In Java, class methods are declared using the static keyword.\n"
                        + "They can be called directly using the class name without creating an instance of the class.\n"
                        + "Class methods are commonly used to perform operations that are shared by all objects or that do not depend on the state of a particular object.\n"
                        + "In this project, the manageProducts() method is an example of a class method.\n"
                        + "It is declared as static and is used to manage products without requiring an instance of the class.\n" +
                        "This method displays the most expensive product",
                JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Method overriding",
                new JOptionPane(
                        "Method overriding is implemented in the Coffee hierarchy.\n" +
                                "The abstract Coffee class declares the abstract method countPowerOfCoffee().\n" +
                                "Each subclass provides its own implementation of this method,\n" +
                                "calculating the coffee strength according to the specific coffee type.\n" +
                                "This demonstrates runtime polymorphism, where the same method call\n" +
                                "executes different implementations depending on the actual object type.\n" +
                                "Method overriding allows subclasses to customize inherited behavior\n" +
                                "while keeping the same method signature.\n",
                        JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Method overloading",
                new JOptionPane(
                        "Method overloading\n" +
                                "Method overloading is implemented in the Employee class.\n" +
                                "The method findEmployeesWithLowerSalaryThan() exists in two versions.\n" +
                                "The first version searches for employees whose salary is lower than the specified amount.\n" +
                                "The overloaded version accepts an additional parameter (firstLetter),\n" +
                                "allowing the search to be further filtered by the first letter of the employee's name.\n" +
                                "Both methods have the same name but differ in the number of parameters,\n" +
                                "which is the definition of method overloading in object-oriented programming.\n",
                        JOptionPane.INFORMATION_MESSAGE));


        tabbedPane.addTab("Binary association", new JOptionPane("Here is the message about Binary association",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Association with an attribute", new JOptionPane("Here is the message about Association with an attribute",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Disjoint", new JOptionPane("Here is the message about Disjoint",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Abstract class", new JOptionPane("Here is the message about Abstract class",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Polymorphic method call", new JOptionPane("Here is the message about Polymorphic method call",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Overlapping", new JOptionPane("Here is the message about Overlapping",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Multiple inheritance", new JOptionPane("Here is the message about Multiple inheritance",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Multifaceted inheritance", new JOptionPane("Here is the message about Multifaceted inheritance",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Dictionary", new JOptionPane("Here is the message about Dictionary." +
                "Aggregation – a specific type of association representing a whole-part relationship, in which the subordinate element can exist independently of the parent object.\n" +
                "Actor – A person or technical entity performing actions involving the system.\n" +
                "Association – a relationship between classes defining a connection between their objects.\n" +
                "Attribute – a characteristic of an object that stores a specific value describing the object's state.\n" +
                "Diagram – A graphical representation of dependencies; a schematic.\n" +
                "Inheritance – an object-oriented programming mechanism enabling the creation of classes that specialize more general classes.\n" +
                "Class extension – the set of all objects belonging to a given class that exist within the system.\n" +
                "Figma – a tool for creating mockups.\n" +
                "GUI – Graphical User Interface.\n" +
                "Implementation – the method or methodology for deploying technical solutions to achieve a specific goal.\n" +
                "Interface – a construct defining a set of operations that must be implemented by classes realizing that interface.\n" +
                "Java – One of the most popular programming languages.\n" +
                "Class – a set of rules and characteristics defining objects.\n" +
                "LucidChart – a web-based application for creating UML diagrams.\n" +
                "MAS – Modeling and Analysis of Information Systems.\n" +
                "Mockup – a realistic visualization of a design.\n" +
                "Relationship – A connection, dependency, or interaction between objects.\n" +
                "Serialization – the process of saving objects to a file to preserve data between application executions.\n" +
                "UML – Unified Modeling Language.\n" +
                "<<extend>> – an indication that a given action may follow a preceding one.\n" +
                "<<include>> – an indication that a given action must follow a preceding one.",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("User requirements", new JOptionPane("Here is the message about User requirements." +
                "A café owner wants a system to support the daily management of the establishment. The system should enable registration and login for customers, managers, and the owner, while storing their basic data.\n" +
                "1. Data is stored for all individuals in the system, including: first name, last name, date of birth, gender, and age (calculated based on the date of birth and the current date).\n" +
                "2. Two subclasses are derived from the `Person` class: `Employee` and `Client`, as well as `Boss` (since the owner holds a position above all employees).\n" +
                "3. For the `Boss`, the following attributes are stored: `Password`, `OpeningTime` (defaulting to 8:00), `ClosingTime` (defaulting to 20:00)—which are currently fixed but may change in the future—and a list of `Employments`.\n" +
                "4. For the `Employee`, the following attributes are stored: `ID`, `EmployeeSalary`, `PreviousExperience` (optional, repeatable), and `Level` (seniority level).\n" +
                "5. For the `Client`: `clientID`, `hasClubCard` (loyalty card status), `satisfactionOfTheService`, `Citizenship`, and an optional `Address`.\n" +
                "6. It should be noted that an employee can also be a customer.\n" +
                "7. Employees are categorized as `Waiter`, `Barista`, or `Cleaner`. They cannot perform their duties simultaneously.\n" +
                "8. For the `Waiter`, the following are stored: `Tip`, a list of `WaitersGrades`, and a rating calculated as the average of the `WaitersGrades` list.\n" +
                "9. The `Barista` has a `favouriteCoffeeCountry` (preferred coffee bean origin), a list of orders, and a list of preparations. A barista can: accept orders for processing, prepare an order, mark an order as completed, and tally orders with various statuses (e.g., `countReadyOrders()`).\n" +
                "10. Cleaner – A cleaner has an assigned shift and an assigned work area (`AssignedArea`). A cleaner can clean up after a paid order and view their own statistics." +
                "11. The manager offers and sells various products. For Products, we need to track: an identifier (`productID`), a name (`productName`), a cost (`productCost`), and a description (`productDescription`).\n" +
                "12. Products are categorized by type: Food and Drink. This classification is mutually exclusive and exhaustive. For Food, we track weight (`Weight`), meal type (`TypeOfMeal`), and doneness (`Doneness`). For Drink, we track caffeine content (`CoffeineContains`) and size (`Size`).\n" +
                "13. The Drink category is subdivided into Coffee and Milk based on the drink type. This classification is exhaustive and mutually exclusive. Coffee includes attributes for bean origin (`CoffeeCountry`) and strength (`power`). The class features an abstract method: `countPowerOfCoffee`.\n" +
                "14. There are three types of Coffee: Espresso (`ShotCount`, `ExtractionTime`, `Pressure`), Americano (`WaterAmount`, `EspressoShotCount`, `WaterToCoffeeRatio`), and Cafe Latte (`TypeOfMilk`, `MilkAmount`, `MilkFoamLevel`, `EspressoShotCount`). Each Coffee instance implements the abstract `CountPowerOfCoffee` method in a different way.\n" +
                "15. A customer can place multiple orders into a shopping cart. The cart can contain multiple products. Customers can remove added products.\n" +
                "16. The `Order` class has an `orderID`, preparation details, `OrderType`, `orderStatus`, `createdAt` timestamp, and delivery information.\n" +
                "15. When a Barista accepts an order, a `Preparation` object is created. This association class stores the following attributes: the Barista performing the preparation, the Order being prepared, and the start and end times of the preparation.",JOptionPane.INFORMATION_MESSAGE));


        ImageIcon icon1 = new ImageIcon("src/images/Actors Inheritance.png");
        ImageIcon icon2 = new ImageIcon("src/images/UseCase Diagram.png");
        System.out.println(icon1.getIconWidth() + " x " + icon1.getIconHeight());
        System.out.println(icon2.getIconWidth() + " x " + icon2.getIconHeight());
        JLabel label1 = new JLabel(icon1);
        JLabel label2 = new JLabel(icon2);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(label1);
        panel2.add(Box.createVerticalStrut(20));
        panel2.add(label2);
        panel2.revalidate();
        panel2.repaint();
        JScrollPane scroll = new JScrollPane(panel2);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        tabbedPane.addTab("Use case diagram", scroll);


        tabbedPane.addTab("Non-functional requirements as a list", new JOptionPane("Here is the message about Non-functional requirements as a list",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Analysis class diagram", new JOptionPane("Here is the message about Analysis class diagram",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Design class diagram", new JOptionPane("Here is the message about Design class diagram",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Use case scenario", new JOptionPane("Here is the message about Dynamic  inheritance",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Activity diagram for a use case", new JOptionPane("Here is the message about Activity diagram for a use case",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("State diagram for a class", new JOptionPane("Here is the message about State diagram for a class",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("GUI Design", new JOptionPane("Here is the message about GUI Design",JOptionPane.INFORMATION_MESSAGE));

        tabbedPane.addTab("Overview of design decisions and the results of dynamic analysis", new JOptionPane("Here is the message about Overview of design decisions and the results of dynamic analysis",JOptionPane.INFORMATION_MESSAGE));
        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.CENTER);
        add(tabbedPane);
        clientButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Wybrano logowanie jako klient.");
            new LoginOrRegisterView().setVisible(true);
        });
        employeeButton.addActionListener(e -> {
            dispose();
            new EmployeeRoleSelectionView().setVisible(true);
        });
        createBossButton.addActionListener(e -> {
            dispose();
            new CreateBossView().setVisible(true);
        });
        clearextensionButton.addActionListener(e -> {
            ObjectPlus.clearExtents();
        });
        exitProgram.addActionListener(e-> {
            exitApplication();
        });
    }
    private void exitApplication() {
        int option = JOptionPane.showConfirmDialog(this, "Do you really want to exit the application?",
                "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}