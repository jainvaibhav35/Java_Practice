package guri;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by linchpin on 20/6/18.
 */
public class NormalObject<T> {

    public  T createInstance(Class<T> classType,Object[] obj) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        return (T) classType.getConstructors()[0].newInstance(obj) ;
    }
}
