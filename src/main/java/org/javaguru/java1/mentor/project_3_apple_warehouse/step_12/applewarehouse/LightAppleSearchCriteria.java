package org.javaguru.java1.mentor.project_3_apple_warehouse.step_12.applewarehouse;

class LightAppleSearchCriteria implements AppleSearchCriteria {
    @Override
    public boolean test (Apple apple) {
        return apple.getWeight() < 150;
    }
}
