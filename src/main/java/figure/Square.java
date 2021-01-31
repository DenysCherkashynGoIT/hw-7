package main.java.figure;

import java.lang.management.MemoryType;

//Calculate perimeter and square only for equilateral square
public class Square extends EquilateralShape {

    public Square(double side) {
        super(4, "Square", side);
    }

    //return area of figure
    @Override
    public double area() {
        return Math.pow(super.getSide(), 2);
    }
}
