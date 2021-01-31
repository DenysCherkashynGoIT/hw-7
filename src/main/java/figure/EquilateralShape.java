package main.java.figure;

//define common fields and methods for equilateral shapes
public abstract class EquilateralShape extends Shape {
    private double side;                   // sides of the shape
    private double angle;                  // angles between sides of the shape (into apexes)

    public EquilateralShape(int num, String name, double side) {
        super (num, name);
        this.side = side;
        this.angle = 180.0 * (double)(num - 2.0)/(double) num;
    }

    //return angle value by index i
    @Override
    public double getAngle(int i) {
        return getAngle();
    }
    public double getAngle() {
        return this.angle;
    }

    //return side value by index i
    @Override
    public double getSide(int i) {
        return getSide();
    }
    public double getSide() {
        return this.side;
    }

    //return perimeters of figure
    @Override
    public double perimeter() {
        return this.side * (double) super.num();
    }
}
