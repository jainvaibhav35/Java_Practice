package condulent;

import java.util.List;

/**
 * Created by linchpin on 10/6/18.
 */
public class Square extends Rectangle{

    public Square(List<Double> sides) {
        super(sides);
    }

    public Square(Double side){
        super(10.0);
    }

    @Override
    public double getArea() {

        System.out.println(getSides().get(0) * getSides().get(0));

        return getSides().get(0) * getSides().get(0);
    }
}
