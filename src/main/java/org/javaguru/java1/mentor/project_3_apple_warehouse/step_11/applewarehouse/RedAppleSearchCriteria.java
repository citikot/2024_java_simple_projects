package org.javaguru.java1.mentor.project_3_apple_warehouse.step_11.applewarehouse;

class RedAppleSearchCriteria implements AppleSearchCriteria {
    @Override
    public boolean test (Apple apple) {
        return "red".equals(apple.getColor());
    }
}
