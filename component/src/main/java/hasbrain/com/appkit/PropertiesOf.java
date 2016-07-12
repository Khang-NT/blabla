package hasbrain.com.appkit;

/**
 * Created by blackcat on 09/07/2016.
 */
public interface PropertiesOf<T> {
    String className = "PropertiesOf";

    T assignProperties(T input);
}
