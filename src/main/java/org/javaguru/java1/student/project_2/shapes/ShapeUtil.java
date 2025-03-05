package org.javaguru.java1.student.project_2.shapes;

import java.util.Random;

public class ShapeUtil {

    public Circle createRandomCircle() {
        return new Circle("Random circle", new Random(1).nextDouble(100));
    }
}
