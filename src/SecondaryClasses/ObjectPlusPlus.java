package SecondaryClasses;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;
public abstract class ObjectPlusPlus extends ObjectPlus implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * role -> qualifier -> object
     */
    private Map<String, Map<Object, ObjectPlusPlus>> links = new Hashtable<>();
    /**
     * Stores all composition parts.
     */
    private static Set<ObjectPlusPlus> allParts =
            new HashSet<>();
    protected ObjectPlusPlus() {
        super();
    }
    /**
     * Internal method for creating bidirectional links.
     */
    private void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier, int counter) {
        if (counter < 1)
            return;
        if (roleName == null ||
                reverseRoleName == null ||
                targetObject == null ||
                qualifier == null) {
            throw new IllegalArgumentException();
        }
        Map<Object, ObjectPlusPlus> objectLinks;
        if (links.containsKey(roleName)) {
            objectLinks = links.get(roleName);
        } else {
            objectLinks = new HashMap<>();
            links.put(roleName, objectLinks);
        }
        if (!objectLinks.containsKey(qualifier)) {
            objectLinks.put(qualifier, targetObject);
            targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }
    public void removeAllLinks(String roleName) {
        if (!links.containsKey(roleName)) {
            return;
        }
        links.get(roleName).clear();
    }

    /**
     * Ordinary association.
     */
    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) {
        addLink(roleName, reverseRoleName, targetObject, targetObject);
    }
    /**
     * Qualified association.
     */
    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier) {
        addLink(roleName, reverseRoleName, targetObject, qualifier, 2);
    }
    /**
     * Composition.
     */
    public void addPart(String roleName, String reverseRoleName, ObjectPlusPlus partObject) throws Exception {
        if (partObject == null)
            throw new IllegalArgumentException();
        if (allParts.contains(partObject))
            throw new Exception("The part is already connected to a whole!");
        addLink(roleName, reverseRoleName, partObject);
        allParts.add(partObject);
    }
    /**
     * Returns all linked objects for given role.
     */
    public ObjectPlusPlus[] getLinks(String roleName)
            throws Exception {
        if (!links.containsKey(roleName)) {
            throw new Exception("No links for the role: " + roleName);
        }
        Collection<ObjectPlusPlus> values =
                links.get(roleName).values();
        return values.toArray(new ObjectPlusPlus[0]);
    }
    public void showLinks(String roleName, PrintStream stream) throws Exception {
        if (!links.containsKey(roleName))
            throw new Exception("No links for the role: " + roleName);
        stream.println(getClass().getSimpleName() + " links, role '" + roleName + "':");
        for (Object obj : links.get(roleName).values())
            stream.println("   " + obj);
    }
    public ObjectPlusPlus getLinkedObject(String roleName, Object qualifier) throws Exception {
        if (!links.containsKey(roleName))
            throw new Exception("No links for the role: " + roleName);
        Map<Object, ObjectPlusPlus> objectLinks =
                links.get(roleName);
        if (!objectLinks.containsKey(qualifier))
            throw new Exception("No link for qualifier: " + qualifier);
        return objectLinks.get(qualifier);
    }
    public boolean anyLink(String roleName) {
        return links.containsKey(roleName)
                && !links.get(roleName).isEmpty();
    }
}