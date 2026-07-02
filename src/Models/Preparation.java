package Models;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Preparation {
    //EXTENT SESSION
    @Override
    public String toString() {
        return "Preparation: " + preparationID;
    }
    private static List<Preparation> extent = new ArrayList<>();
    private static void addPreparation(Preparation preparation) {
        extent.add(preparation);
    }
    private static void removePreparation(Preparation preparation) {
        extent.remove(preparation);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Preparation.class.getName());
        for (Preparation preparation : extent) {
            System.out.println(preparation);
        }
    }
    private void write(DataOutputStream stream) throws IOException {
        stream.writeInt(preparationID);
    }
    private void read(DataInputStream stream) throws IOException {
        preparationID = stream.readInt();
    }
    public static void writeExtent(DataOutputStream stream) throws IOException {
        // Number of objects
        stream.writeInt(extent.size());
        for (Preparation preparation : extent) {
            preparation.write(stream);
        }
    }
    public static void readExtent(DataInputStream stream) throws IOException {
        Preparation preparation = null;
        // Get the number of written objects
        int objectCount = stream.readInt();
        // remove the current extent
        extent.clear();
        for (int i = 0; i < objectCount; i++) {
            preparation = new Preparation();
            preparation.read(stream);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION
    /**Simple, Single, Required, Object, Concrete Attribute "preparationID" typed {@linkplain Integer}
     */
    int preparationID;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public Preparation(int preparationID) {
        this.preparationID = preparationID;
    }
    public Preparation(){
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START

    //METHODS SESSION END
}
