package org.javaguru.java1.mentor.project_2_geometry_shape.step_12.geometry.shapes;

import java.util.Random;

class ShapeUtil {

    private Random random = new Random();

    public Circle createRandomCircle() {
        double radius = random.nextDouble(10);
        return new Circle("Circle", radius);
    }

    public Square createRandomSquare() {
        double side = random.nextDouble(10);
        return new Square("Square", side);
    }

    public Rectangle createRandomRectangle() {
        double a = random.nextInt(10);
        double b = random.nextInt(10);
        return new Rectangle("Rectangle", a, b);
    }

    public Shape createRandomShape() {
        int randomNumber = random.nextInt(3);
        if (randomNumber == 0) {
            return createRandomCircle();
        } else if (randomNumber == 1) {
            return createRandomSquare();
        } else {
            return createRandomRectangle();
        }
    }

    public double calculateArea(Shape[] shapes){
        double areaSum = 0;
        for (Shape shape : shapes) {
            areaSum = areaSum + shape.calculateArea();
        }
        return areaSum;
    }


}
