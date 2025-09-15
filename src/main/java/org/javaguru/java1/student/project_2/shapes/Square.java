package org.javaguru.java1.student.project_2.shapes;

public class Square extends Shape {

    private double side;

    public Square(String title, double side) {
        super(title);
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return Math.pow(side, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
