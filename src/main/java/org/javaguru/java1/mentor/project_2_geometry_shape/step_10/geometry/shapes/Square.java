package org.javaguru.java1.mentor.project_2_geometry_shape.step_10.geometry.shapes;

class Square extends Shape {

    private double side;

    public Square(String title, double side) {
        super(title);
        this.side = side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

}