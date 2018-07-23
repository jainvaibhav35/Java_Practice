package functionalinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by linchpin on 18/7/18.
 */
public class TraverseCommonList {

    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {



        new TraverseCommonList().traverseList();
    }

    public void traverseList(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

         list = Collections.unmodifiableList(list);

//        list.add(5);

//        for(int i = 0 ; i < list.size() ; i++){
//            list.add(4);
//        }

//        for(int i : list){
//            System.out.println("hello");
//            list.add(5);
//            System.out.println(list.size());
//            System.out.println(list.remove(i));
//        }

//        for(Iterator<Integer> i = list.iterator(); i.hasNext();){
//            System.out.println("Hello");
//            list.add(5);
//            System.out.println(list.size());
//            System.out.println(i.next());
//        }
//
        Iterator<Integer> it  =list.iterator() ;

        while (it.hasNext()){
            System.out.println("Hello");
            list.add(1);
            System.out.println(list.size());
            System.out.println(it.next());
        }


    }



}
