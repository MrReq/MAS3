package Models;

import Enums.AllPersonTypes;
import Enums.Sex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

class Waiter extends Employee {
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addWaiter" which adds instance of {@linkplain Waiter} to extent collection</br>
     * <br>Private Static method "removeWaiter" which removes instance of {@linkplain Waiter} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Waiter} line by line.</br>
     */
    @Override
    public String toString() {
        return "Waiter: " + personName + " "+peronSurname ;
    }
    private static List<Waiter> extent = new ArrayList<>();
    private static void addWaiter(Waiter waiter) {
        extent.add(waiter);
    }
    private static void removeWaiter(Waiter waiter) {
        extent.remove(waiter);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Waiter.class.getName());
        for (Waiter waiter : extent) {
            System.out.println(waiter);
        }
    }
    protected void write(DataOutputStream stream) throws IOException {
        super.write(stream);
        stream.writeFloat(waitersTip);
        stream.writeInt(waitersGrade);
        stream.writeInt(waitersGrades.size());
        for(Integer a : waitersGrades ){
            stream.writeUTF(String.valueOf(a));
        }
    }
    protected void read(DataInputStream stream) throws IOException {
        super.read(stream);
        waitersTip = stream.readFloat();
        waitersGrade = stream.readInt();
        int size = stream.readInt();
        waitersGrades = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String waitersGradesString = stream.readUTF();
            waitersGrades.add(Integer.valueOf(waitersGradesString));
        }
    }
    public static void writeExtent(DataOutputStream stream) throws IOException {
        // Number of objects
        stream.writeInt(extent.size());
        for (Waiter waiter : extent) {
            waiter.write(stream);
        }
    }
    public static void readExtent(DataInputStream stream) throws IOException {
        Waiter waiter = null;
        // Get the number of written objects
        int objectCount = stream.readInt();
        // remove the current extent
        extent.clear();
        for (int i = 0; i < objectCount; i++) {
            waiter = new Waiter();
            waiter.read(stream);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Simple, Single, Required, Object, Concrete Attribute "waitersTip" typed {@linkplain Float}
     */
    float waitersTip;
    /**Simple, Single, Required, Object, Concrete Attribute "waitersGrade" typed {@linkplain Integer}
     */
    int waitersGrade;
    /**Complex, Repeatable, Optional, Object, Concrete Attribute "waitersGrades" typed {@linkplain List}
     */
    List<Integer> waitersGrades = new ArrayList<>();
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public Waiter(String name, String surname, LocalDate dateOfBirth, Sex sex, float salary) {
        super(name, surname, dateOfBirth, sex, salary);
        addWaiter(this);
    }
    public Waiter() {
    }
    /**Public method "setGrade" as a setter
     * @param grade
     * @return : None
     */
    public void setGrade(int grade) {
        this.waitersGrade = countAverageGrade();
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START
    /**Private object method "countAverageGrade"
     * @param : None
     * @return : average from all grades
     */
    private int countAverageGrade() {
        if (waitersGrades == null || waitersGrades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Integer number : waitersGrades) {
            sum += number; // zakładam enum/int
        }
        return sum / waitersGrades.size();
    }
    public void serveTable() {
        System.out.println(
                "I'm Serving table"
        );
    }
    //METHODS SESSION END
    //OVERLAPPING
    private EnumSet<AllPersonTypes> personKind =  EnumSet.of(AllPersonTypes.Waiter);
}
