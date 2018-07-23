package iris;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by linchpin on 7/7/18.
 */
public class MainClass {



    public static void main(String[] args) {

        final StudentPojo sp = new StudentPojo();

        Map<String,String> map = new LinkedHashMap<>();

        sp.setId(1);

        System.out.println(sp.getId());;

    }

}
