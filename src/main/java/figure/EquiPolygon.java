package main.java.figure;

//Calculate perimeter and square only for any equilateral polygon (equiPolygon)
public class EquiPolygon extends EquilateralShape {

    public EquiPolygon (double side, int num){
        super(num, "Equilateral polygon", side);
    }

    //return area of figure
    @Override
    public double area() {
       return ((double) super.num()) * Math.pow(super.getSide(), 2) / (4 * Math.tan(180.0/((double) super.num())));
    }
}
