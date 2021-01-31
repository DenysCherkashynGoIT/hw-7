package main.java.figure;

//Calculate perimeter and square for rectangles
public class Rectangle extends EquilateralShape {

    private final double sideA;          // side A of the rectangle
    private final double sideB;          // side B of the rectangle

    public Rectangle (double sideA, double sideB){
        super(4, "Rectangle", (sideA+sideB)/2.0);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    //return area of figure
    @Override
    public double area() {
        return this.sideA * this.sideB;
    }

}
