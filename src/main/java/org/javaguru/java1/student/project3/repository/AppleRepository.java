package org.javaguru.java1.student.project3.repository;

import org.javaguru.java1.student.project3.domain.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleRepository {

    List<Apple> apples = createAppleWarehouse();

    public List<Apple> getAllApples() {
        return apples;
    }

    public List<Apple> getApplesByColor(String color) {
        return getAllApples().stream()
                .filter(item -> item.color().equals(color))
                .toList();
    }

    public void addApple(Apple apple) {
        apples.add(apple);
    }

    public void removeApple(Apple apple) {
        apples.remove(apple);
    }

    public List<Apple> createAppleWarehouse() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("type1", "green", 100));
        apples.add(new Apple("type2", "red", 90));
        apples.add(new Apple("type3", "yellow", 155));
        apples.add(new Apple("type4", "red", 180));
        apples.add(new Apple("type5", "green", 98));
        apples.add(new Apple("type6", "red", 168));
        apples.add(new Apple("type7", "yellow", 99));
        apples.add(new Apple("type8", "red", 188));
        apples.add(new Apple("type9", "green", 200));
        apples.add(new Apple("type10", "red", 177));
        apples.add(new Apple("type11", "yellow", 147));
        apples.add(new Apple("type12", "red", 94));
        apples.add(new Apple("type13", "green", 88));
        apples.add(new Apple("type14", "red", 154));
        apples.add(new Apple("type15", "yellow", 166));
        apples.add(new Apple("type16", "red", 150));
        apples.add(new Apple("type17", "green", 151));
        apples.add(new Apple("type18", "red", 149));
        apples.add(new Apple("type19", "yellow", 120));
        apples.add(new Apple("type20", "red", 182));
        return apples;
    }

}
