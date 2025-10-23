package org.javaguru.java1.student.project_2.shapes;

abstract class Shape {

    public String title;

    Shape(String title) {
        this.title = title;
    }

    abstract double calculateArea();

    abstract double calculatePerimeter();

}
