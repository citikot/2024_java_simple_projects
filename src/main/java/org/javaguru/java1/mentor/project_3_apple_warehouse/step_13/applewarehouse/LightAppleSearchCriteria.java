package org.javaguru.java1.mentor.project_3_apple_warehouse.step_13.applewarehouse;

class LightAppleSearchCriteria implements AppleSearchCriteria {
    @Override
    public boolean test (Apple apple) {
        return apple.getWeight() < 150;
    }
}
