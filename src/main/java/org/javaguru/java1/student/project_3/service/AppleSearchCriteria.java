package org.javaguru.java1.student.project_3.service;

import org.javaguru.java1.student.project_3.domain.Apple;

@FunctionalInterface
public interface AppleSearchCriteria {
    boolean test(Apple apple);
}
