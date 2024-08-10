package org.gvp.dcs.shapes;

public class Cube {
    private double side;

    // Constructor to 
    public Cube(double side) {
        this.side = side;
    }

    // Method to calculate the volume of the cube
    public double calculateVolume() {
        return Math.pow(side, 3);
    }

    // Method to calculate the surface area of the cube
    public double calculateSurfaceArea() {
        return 6.0 * Math.pow(side, 2);
    }
}
