package org.javaguru.java1.student.project_3.service;

import org.javaguru.java1.student.project_3.domain.Apple;

public class SearchGreenApple implements AppleSearchCriteria {

    @Override
    public boolean test(Apple apple) {
        String COLOR = "GREEN";
        return apple.color().equals(COLOR.toLowerCase());
    }
}
