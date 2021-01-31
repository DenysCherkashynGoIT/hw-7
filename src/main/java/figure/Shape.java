package main.java.figure;

public abstract class Shape implements Figure {
    // Define specific parameter for all shapes.
    private int i;                        // quantity of sides
    private String name;                    // shape name

    //define polygon by the apexes, whith name
    public Shape (int num, String name) {
        this.name = name;
        this.i = num;
    }

    //return name of shape
    @Override
    public String name() {
            return this.name;
    }

    //return num of sides/apexes
    @Override
    public int num(){
        return this.i;
    }
}
