package Models;

import SecondaryClasses.ObjectPlusPlus;

public class WaiterRole
        extends ObjectPlusPlus {
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
