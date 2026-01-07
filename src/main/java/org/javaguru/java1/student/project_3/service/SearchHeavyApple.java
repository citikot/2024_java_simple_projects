package org.javaguru.java1.student.project_3.service;

import org.javaguru.java1.student.project_3.domain.Apple;

public class SearchHeavyApple implements AppleSearchCriteria {

    @Override
    public boolean test(Apple apple) {
        int weight = 150;
        return apple.weight() >= weight;
    }
}

