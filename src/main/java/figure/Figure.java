package main.java.figure;

public interface Figure {
    //any geometrical figure must have next behaviour:

    String name();                      //return figure name

    int num();                          //return num of sides/apexes

    double getSide(int i);              //return side value by index i

    double getAngle(int i);             //return angle value by index i

    double perimeter();                 //return perimeters of figure or length (for circle)

    double area();                      //return area of figure

}

