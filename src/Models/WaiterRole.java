package Models;

import SecondaryClasses.ObjectPlusPlus;

import java.util.List;

public class WaiterRole extends ObjectPlusPlus {
    private static final long serialVersionUID = 1L;

    // EXTENT

    public static List<WaiterRole> getWaiterRoleExtent() {
        return getExtent(WaiterRole.class);
    }

    // METHODS

    public void serveTable() {
        System.out.println("Serving table...");
    }

    @Override
    public String toString() {
        return "WaiterRole";
    }
}