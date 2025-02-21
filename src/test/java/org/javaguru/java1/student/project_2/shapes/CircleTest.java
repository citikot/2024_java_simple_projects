package org.javaguru.java1.student.project_2.shapes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    Circle circle;

    @BeforeEach
    void init() {
        circle = new Circle("A", 1);
    }
    @Test
    void shouldCalculateArea() {
        assertEquals(circle.calculateArea(), 3.14, 0.01);
    }

    @Test
    void shouldCalculatePerimeter() {
        assertEquals(circle.calculatePerimeter(), 6.28, 0.01);
    }
}
