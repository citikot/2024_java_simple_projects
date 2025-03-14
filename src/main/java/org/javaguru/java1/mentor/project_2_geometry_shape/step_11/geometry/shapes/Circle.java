package org.javaguru.java1.mentor.project_2_geometry_shape.step_11.geometry.shapes;

class Circle extends Shape {

    private double radius;

    Circle(String title, double radius) {
        super(title);
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }
    @Override
    public double calculateArea(){
        return Math.PI * (radius * radius);
    }

}