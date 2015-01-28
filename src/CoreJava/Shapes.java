package CoreJava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dheeraj on 27/1/15.
 */
public class Shapes {

    private static abstract class Shape{
        abstract double getArea(double dim);private static class Circle extends Shape{
            public double getArea(double dim){
                return dim  * dim;
            }
        }
    }

    private static class Circle extends Shape{
        public double getArea(double dim){
            return dim  * dim*3.14;
        }
    }

    private static class Square extends Shape{
        public double getArea(double dim){
            return dim  * dim;
        }
    }


    public static void main(String[] args){

        List<Shape> shapeList = new ArrayList<Shape>();
        shapeList.add(new Circle());
        shapeList.add(new Square());

        System.out.println(shapeList.get(0).getArea(9.0));
    }
}
