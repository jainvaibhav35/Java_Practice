package condulent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linchpin on 10/6/18.
 */
abstract public class Polygon {

    private List<Double> sides ;
    private Double side ;
    private Double sideOne ;


    abstract public double getArea() ;

    public List<Double> getSides(){
        return this.sides ;
    }

    public Polygon(Double side){
        this.side = side ;
        if(sides == null){
            sides = new ArrayList<>();
            sides.add(side);
        }
    }

    public Polygon(Double side,Double sideOne){
        this.side = side ;
        this.sideOne = sideOne;
        if(sides == null){
            sides = new ArrayList<>();
            sides.add(side);
            sides.add(sideOne);
        }
    }

    public Polygon(List<Double> sides){
        this.sides = sides ;
    }

}
