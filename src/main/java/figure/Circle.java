package main.java.figure;

//Calculate length of circle and square
public class Circle extends Shape {

    private final double side;                        //sides value
    private static final double ANGLE = 360;          //angles value (degrees)
    private final double radius;                      //radius of circle

    public Circle(double radius) {
        super(1, "Circle");
        this.radius = radius;
        this.side = Math.PI * 2.0 * radius;
    }

    //return radius
    public double getRadius(){
        return this.radius;
    }

    //return diameter
    public double getDiameter(){
        return 2.0 * this.radius;
    }

    //return angle value by index i
    @Override
    public double getAngle(int i) {
        return getAngle();
    }
    public double getAngle() {
        return ANGLE;
    }


    //return side value by index i
    @Override
    public double getSide(int i) {
        return getAngle();
    }
    public double getSide() {
        return this.side;
    }

    //return length of the circle
    @Override
    public double perimeter() {
        return this.side;
    }

    //return area of figure
    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius,2);
    }
}
