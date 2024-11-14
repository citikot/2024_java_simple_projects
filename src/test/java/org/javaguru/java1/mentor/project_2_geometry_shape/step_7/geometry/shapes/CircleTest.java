package org.javaguru.java1.mentor.project_2_geometry_shape.step_7.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    @Test
    public void shouldCalculateArea() {
        Circle circle = new Circle("A", 1);
        assertEquals(circle.calculateArea(), 3.14, 0.01);
    }

    @Test
    public void shouldCalculatePerimeter() {
        Circle circle = new Circle("A", 1);
        assertEquals(circle.calculatePerimeter(), 6.28, 0.01);
    }

}