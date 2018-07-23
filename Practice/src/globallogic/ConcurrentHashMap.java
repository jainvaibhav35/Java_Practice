package globallogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by linchpin on 25/6/18.
 */
public class ConcurrentHashMap {



    public static void main(String[] args) {

        List<String> arrList = new ArrayList<>();
        arrList.add("sers");
        Iterator i = arrList.iterator();

        while (i.hasNext()){
            i.next();
            arrList.add("abc");
            arrList.add("def");
            arrList.remove("abc");
            arrList.add("ser");
        }

        System.out.println(arrList);
    }


}
