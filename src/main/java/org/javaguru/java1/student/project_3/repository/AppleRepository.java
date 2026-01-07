package org.javaguru.java1.student.project_3.repository;

import org.javaguru.java1.student.project_3.domain.Apple;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S1192")
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

    public List<Apple> getHeavyApples(int weight) {
        return getAllApples().stream()
                .filter(item -> item.weight() >= weight)
                .toList();
    }

    public List<Apple> getLightApples(int weight) {
        return getAllApples().stream()
                .filter(item -> item.weight() < weight)
                .toList();
    }

    public void addApple(Apple apple) {
        apples.add(apple);
    }

    public void removeApple(Apple apple) {
        apples.remove(apple);
    }

    public List<Apple> createAppleWarehouse() {
        List<Apple> items = new ArrayList<>();
        items.add(new Apple("type1", "green", 100));
        items.add(new Apple("type2", "red", 90));
        items.add(new Apple("type3", "yellow", 155));
        items.add(new Apple("type4", "red", 180));
        items.add(new Apple("type5", "green", 98));
        items.add(new Apple("type6", "red", 168));
        items.add(new Apple("type7", "yellow", 99));
        items.add(new Apple("type8", "red", 188));
        items.add(new Apple("type9", "green", 200));
        items.add(new Apple("type10", "red", 177));
        items.add(new Apple("type11", "yellow", 147));
        items.add(new Apple("type12", "red", 94));
        items.add(new Apple("type13", "green", 88));
        items.add(new Apple("type14", "red", 154));
        items.add(new Apple("type15", "yellow", 166));
        items.add(new Apple("type16", "red", 150));
        items.add(new Apple("type17", "green", 151));
        items.add(new Apple("type18", "red", 149));
        items.add(new Apple("type19", "yellow", 120));
        items.add(new Apple("type20", "red", 182));
        return items;
    }

}
