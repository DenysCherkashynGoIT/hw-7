package main.java.figure;

//Calculate perimeter and square only for equilateral triangle
public class Triangle extends EquilateralShape {


    public Triangle (double side){
        super(3, "Triangle", side);
    }

    //return area of figure
    @Override
    public double area() {
        return Math.pow(super.getSide(),2) * Math.sqrt(3) / 4.0;
    }
}
