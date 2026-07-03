package Models;
import SecondaryClasses.ObjectPlusPlus;
public class WaiterRole extends ObjectPlusPlus {
    private static final long serialVersionUID = 1L;
    public void serveTable() {
        System.out.println(
                "Serving table..."
        );
    }
    @Override
    public String toString() {
        return "WaiterRole";
    }
}
