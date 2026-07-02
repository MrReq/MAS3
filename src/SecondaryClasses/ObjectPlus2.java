package SecondaryClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ObjectPlus2
        implements Serializable {
    private static final Map<Class<?>,
            List<ObjectPlus2>> extents =
            new HashMap<>();
    public ObjectPlus2() {

        Class<?> cls = getClass();

        extents.computeIfAbsent(
                cls,
                k -> new ArrayList<>()
        );
        extents.get(cls).add(this);
    }
    public static List<ObjectPlus2>
    getExtent(Class<?> cls) {

        return extents.getOrDefault(
                cls,
                new ArrayList<>()
        );
    }
    public static void showExtent(
            Class<?> cls
    ) {
        System.out.println(
                "Extent of: "
                        + cls.getSimpleName()
        );
        for(ObjectPlus2 obj :
                getExtent(cls)) {
            System.out.println(obj);
        }
    }
}
