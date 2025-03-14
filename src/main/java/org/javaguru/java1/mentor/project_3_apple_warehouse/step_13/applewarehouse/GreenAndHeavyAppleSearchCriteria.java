package org.javaguru.java1.mentor.project_3_apple_warehouse.step_13.applewarehouse;

class GreenAndHeavyAppleSearchCriteria implements AppleSearchCriteria {

    private GreenAppleSearchCriteria greenApples = new GreenAppleSearchCriteria();
    private HeavyAppleSearchCriteria heavyApples = new HeavyAppleSearchCriteria();

    @Override
    public boolean test(Apple apple) {
        return greenApples.test(apple) && heavyApples.test(apple);
    }

}