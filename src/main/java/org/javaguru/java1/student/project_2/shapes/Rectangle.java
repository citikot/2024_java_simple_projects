package org.javaguru.java1.student.project_2.shapes;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(String title, double width, double height) {
        super(title);
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
