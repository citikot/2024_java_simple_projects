package org.javaguru.java1.mentor.project_2_geometry_shape.step_15.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeUtilTest {

    @Test
    public void shouldCalculateArea() {
        Shape[] shapes = {
                new Circle("A", 4.0),
                new Square("B", 1.0),
                new Rectangle("C", 2.0, 3.0)
        };
        ShapeUtil shapeUtil = new ShapeUtil();
        var area = shapeUtil.calculateArea(shapes);
        assertEquals(57.2654824, area, 0.001);
    }

    @Test
    public void shouldCalculatePerimeter() {
        Shape[] shapes = {
                new Circle("A", 4.0),
                new Square("B", 1.0),
                new Rectangle("C", 2.0, 3.0)
        };
        ShapeUtil shapeUtil = new ShapeUtil();
        var perimeter = shapeUtil.calculatePerimeter(shapes);
        assertEquals(39.132741228, perimeter, 0.001);
    }

}