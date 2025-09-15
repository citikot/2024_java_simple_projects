package org.javaguru.java1.student.project_2.shapes;

import static java.lang.Math.PI;

public class Circle extends Shape {

    private double radius;

    public Circle(String title, double radius) {
        super(title);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
