package org.javaguru.java1.student.project_2.shapes;

public class Rectangle extends Shape {

    private double width;
    private double height;

    Rectangle(String title, double width, double height) {
        super(title);
        this.height = height;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (width + height);
    }
}
