package map;

import java.util.Comparator;

/**
 * Created by linchpin on 13/7/18.
 */
public class MyNameComp implements Comparator<Empl> {

    @Override
    public int compare(Empl e1, Empl e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
