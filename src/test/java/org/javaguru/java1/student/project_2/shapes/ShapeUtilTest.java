package org.javaguru.java1.student.project_2.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeUtilTest {

    @Test
    void calculateArea() {

        //given
        ShapeUtil util = new ShapeUtil();
        Circle circle = new Circle("circle", 1);
        Rectangle rectangle = new Rectangle("rectangle", 1, 1);
        Square square = new Square("square", 1);
        Shape[] shapes = {circle, rectangle, square};

        // when
        double area = util.calculateArea(shapes);

        // then
        assertEquals(5.14, area, 0.1);
    }

    @Test
    void calculatePerimeter() {
        //given
        ShapeUtil util = new ShapeUtil();
        Circle circle = new Circle("circle", 1);
        Rectangle rectangle = new Rectangle("rectangle", 1, 1);
        Square square = new Square("square", 1);
        Shape[] shapes = {circle, rectangle, square};

        // when
        double area = util.calculatePerimeter(shapes);

        // then
        assertEquals(14.28, area, 0.1);
    }
}