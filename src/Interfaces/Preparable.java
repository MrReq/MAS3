package Interfaces;
/** Interface {@linkplain Preparable}
 * <br>Has 2 abstract methods</br>
 * <br>public void prepare() - for the classes who can prepare</br>
 * <br>public int getPreparationTime() - for the classes of created prepared objects</br>
 */
public interface Preparable {
    public void prepare();
    public int getPreparationTime();
}
