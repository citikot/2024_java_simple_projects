package org.javaguru.java1.student.project_2;

import org.javaguru.java1.student.project_2.shapes.ShapeUtil;

public class ShapesManager {

    public static void main(String[] args) {

        ShapeUtil shapeUtil = new ShapeUtil();
        for (int i = 0; i < 100000; i++) {
            System.out.println(shapeUtil.shapeComparator());
        }
    }
}
