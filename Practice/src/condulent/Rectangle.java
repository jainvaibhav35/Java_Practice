package condulent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linchpin on 10/6/18.
 */
public class Rectangle extends Polygon{

    public Rectangle(List<Double> sides) {
        super(sides);
    }

    public Rectangle(Double side) {
        super(side);
    }

    public Rectangle(Double side1, Double side2){
        super(side1,side2);
    }

    @Override
    public double getArea() {

        System.out.println(getSides().get(0) * getSides().get(1));

        return getSides().get(0) * getSides().get(1);
    }
}
