package org.javaguru.java1.student.project_2.shapes;

import java.util.Random;

public class ShapeUtil {

    private final Random random = new Random();

    public Circle createRandomCircle() {
        double radius = new Random(1).nextDouble(100);
        return new Circle("Random circle", radius);
    }

    public Square createRandomSquare() {
        double side = new Random(1).nextDouble(100);
        return new Square("Random square", side);
    }

    public Rectangle createRandomRectangle() {
        double width = new Random(1).nextDouble(100);
        double height = new Random(1).nextDouble(100);
        return new Rectangle("Random rectangle", width, height);
    }

    public Shape createRandomShape() {
        int randomChoice = getRandomNumber();
        return switch (randomChoice) {
            case 0 -> createRandomCircle();
            case 1 -> createRandomRectangle();
            default -> createRandomSquare();
        };
    }

    private int getRandomNumber() {
        return random.nextInt(3); // Генерирует числа от 0 до 2 включительно
    }
}
