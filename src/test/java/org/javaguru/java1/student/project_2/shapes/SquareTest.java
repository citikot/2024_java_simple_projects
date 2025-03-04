package org.javaguru.java1.student.project_2.shapes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    Square square;

    @BeforeEach
    void init() {
        square = new Square("Square", 10);
    }

    @Test
    void shouldCalculateArea() {
        assertEquals(100, square.calculateArea(), 0.01);
    }

    @Test
    void shouldCalculatePerimeter() {
        assertEquals(40, square.calculatePerimeter(), 0.01);
    }
}
