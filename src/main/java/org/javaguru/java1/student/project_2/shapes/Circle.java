package org.javaguru.java1.student.project_2.shapes;

import static java.lang.Math.PI;

public class Circle extends Shape {

    private double radius;

    Circle(String title, double radius) {
        super(title);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
