package guri;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by linchpin on 20/6/18.
 */
public class ReturnClass {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        NormalObject no = new NormalObject();
        Object[] obj = new Object[1];
        obj[0] = 12 ;
        CreateObject co = (CreateObject) no.createInstance(CreateObject.class,obj);
        co.callMethod();
    }

}
