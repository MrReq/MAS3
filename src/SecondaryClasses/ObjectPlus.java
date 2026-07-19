package SecondaryClasses;
import java.io.*;
import java.util.*;
public abstract class ObjectPlus implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Map<Class<? extends ObjectPlus>,
            List<ObjectPlus>> extents = new HashMap<>();
    protected ObjectPlus() {
        Class<? extends ObjectPlus> clazz = getClass();
        extents.computeIfAbsent(clazz, c -> new ArrayList<>());
        extents.get(clazz).add(this);
    }
    @SuppressWarnings("unchecked")
    public static List<ObjectPlus> getExtent(Class<?> clazz) {
        return Collections.unmodifiableList(extents.getOrDefault(clazz, new ArrayList<>()));
    }

    
    public static void showExtent(Class<? extends ObjectPlus> clazz) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("Extent of " + clazz.getSimpleName());
        System.out.println("========================================");
        List<? extends ObjectPlus> list = getExtent(clazz);
        if(list.isEmpty()){
            System.out.println("No objects.");
            return;
        }
        for(ObjectPlus object : list)
            System.out.println(object);
    }
    protected void removeFromExtent(){
        Class<? extends ObjectPlus> clazz = getClass();
        List<ObjectPlus> list = extents.get(clazz);
        if(list != null)
            list.remove(this);
    }
    public static void saveExtents(String fileName) throws IOException {
        System.out.println("=== SAVING EXTENTS ===");
        System.out.println("Classes: " + extents.keySet());
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(extents);
            System.out.println("Saved successfully!");
        }
    }
    @SuppressWarnings("unchecked")
    public static void loadExtents(String fileName)
            throws IOException, ClassNotFoundException {
        System.out.println("=== LOADING EXTENTS ===");
        File file = new File(fileName);
        if(!file.exists()){
            System.out.println("File doesn't exist!");
            return;
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            extents = (Map<Class<? extends ObjectPlus>, List<ObjectPlus>>) in.readObject();
            System.out.println("Loaded!");
            System.out.println(extents.keySet());
        }
    }
    public static void clearExtents(){
        extents.clear();
    }
    public static Set<Class<? extends ObjectPlus>> getRegisteredClasses() {
        return extents.keySet();
    }
}