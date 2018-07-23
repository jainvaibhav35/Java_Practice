package map;

import java.util.Set;
import java.util.TreeMap;

/**
 * Created by linchpin on 13/7/18.
 */
public class MainImple {

    public static void main(String a[]){
        //By using name comparator (String comparison)
        TreeMap<Empl,String> tm = new TreeMap<Empl, String>();
        tm.put(new Empl("Ram",3000), "RAM");
        tm.put(new Empl("John",6000), "JOHN");
        tm.put(new Empl("Crish",2000), "CRISH");
        tm.put(new Empl("Tom",2400), "TOM");
        Set<Empl> keys = tm.keySet();
        for(Empl key:keys){
            System.out.println(key+" ==> "+tm.get(key));
        }
        System.out.println("===================================");

    }

}
