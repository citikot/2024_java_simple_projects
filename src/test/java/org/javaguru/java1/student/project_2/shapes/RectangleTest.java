package org.javaguru.java1.student.project_2.shapes;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    Rectangle rectangle;

    @BeforeEach
    void init() {
        rectangle = new Rectangle("Rectangle", 10.0, 15.0);
    }

    @Test
    void shouldCalculateArea() {
        assertEquals(150, rectangle.calculateArea(), 0.01);
    }

    @Test
    void shouldCalculatePerimeter() {
        assertEquals(50, rectangle.calculatePerimeter(), 0.01);
    }
}
