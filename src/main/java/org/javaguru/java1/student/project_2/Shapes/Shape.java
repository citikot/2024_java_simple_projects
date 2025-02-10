package org.javaguru.java1.student.project_2.Shapes;

abstract class Shape {

    private String title;

    Shape(String title) {
        this.title = title;
    }

    abstract Double calculateSquare();

    abstract double calculatePerimeter();

}
