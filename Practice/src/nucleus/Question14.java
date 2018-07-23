package nucleus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by linchpin on 20/4/18.
 */
public class Question14 {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
            Null b = null;


            if (b == null) {
                b.ehem();
                System.out.println("Value  " + b);

                ((Null) null).ehem();
                Null.ehem();
                System.out.println("Person");
            }

        }catch (NullPointerException | ArithmeticException e){

        }catch (RuntimeException e){

        }catch (Exception e){

        }
        }

}
