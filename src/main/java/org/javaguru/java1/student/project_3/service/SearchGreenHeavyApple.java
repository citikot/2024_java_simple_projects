package org.javaguru.java1.student.project_3.service;

import org.javaguru.java1.student.project_3.domain.Apple;

public class SearchGreenHeavyApple implements AppleSearchCriteria {

    @Override
    public boolean test(Apple apple) {
        return apple.color().equals("GREEN".toLowerCase()) && apple.weight() >= 150;
    }
}
