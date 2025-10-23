package org.javaguru.java1.student.project_2.shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ShapeUtil {

    private final Random random = new Random();

    public Circle createRandomCircle() {
        double radius = new Random().nextInt(200);
        return new Circle("Random circle", radius);
    }

    public Square createRandomSquare() {
        double side = new Random().nextInt(200);
        return new Square("Random square", side);
    }

    public Rectangle createRandomRectangle() {
        double width = new Random().nextInt(200);
        double height = new Random().nextInt(200);
        return new Rectangle("Random rectangle", width, height);
    }

    public Shape createRandomShape() {
        int randomChoice = generateRandomNumber();
        return switch (randomChoice) {
            case 0 -> createRandomCircle();
            case 1 -> createRandomRectangle();
            default -> createRandomSquare();
        };
    }

    public String shapeComparator() {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            shapes.add(createRandomShape());
        }
        Circle randomCircle = createRandomCircle();
        Rectangle randomRectangle = createRandomRectangle();
        Square randomSquare = createRandomSquare();
        List<Shape> foundCircles = findEquals(shapes, randomCircle);
        List<Shape> foundRectangles = findEquals(shapes, randomRectangle);
        List<Shape> foundSquares = findEquals(shapes, randomSquare);
        if (foundSquares.isEmpty() && foundRectangles.isEmpty() && foundCircles.isEmpty()) {
            return "Эквивалентных фигур не найдено";
        }
        return String.format("Найдено %d эквивалентных фигур", foundRectangles.size() + foundCircles.size() + foundSquares.size());
    }

    private List<Shape> findEquals(List<Shape> allShapes, Shape shapeToCompare) {
        return allShapes.stream().filter(shape -> isEqualShapes(shape, shapeToCompare)).toList();
    }

    private boolean isEqualShapes(Shape shape, Shape shapeToCompare) {
        return Objects.equals(shape.title, shapeToCompare.title) &&
                shape.calculateArea() == shapeToCompare.calculateArea() &&
                shape.calculatePerimeter() == shapeToCompare.calculatePerimeter();
    }

    private int generateRandomNumber() {
        return random.nextInt(3); // Генерирует числа от 0 до 2 включительно
    }

    public double calculateTotalArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calculateArea();
        }
        return sum;
    }

    public double calculateTotalPerimeter(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calculatePerimeter();
        }
        return sum;
    }
}
