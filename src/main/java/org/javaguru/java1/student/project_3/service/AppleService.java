package org.javaguru.java1.student.project_3.service;

import org.javaguru.java1.student.project_3.domain.Apple;
import org.javaguru.java1.student.project_3.repository.AppleRepository;

import java.util.List;

public class AppleService {

    private final AppleRepository appleRepository = new AppleRepository();
    private final int WEIGHT_THRESHOLD = 150;

    public void run() {

        List<Apple> apples = appleRepository.getAllApples();
        apples.forEach(System.out::println);

        System.out.println("------- HEAVY APPLES -------");
        apples = appleRepository.getHeavyApples(WEIGHT_THRESHOLD);
        apples.forEach(System.out::println);

        System.out.println("------- LIGHT APPLES -------");
        apples = appleRepository.getLightApples(WEIGHT_THRESHOLD);
        apples.forEach(System.out::println);

    }

    public List<Apple> getApplesByColor(String color) {
        return appleRepository.getApplesByColor(color);
    }

    public List<Apple> getHeavyApples(int weight) {
        return appleRepository.getHeavyApples(weight);
    }

    public List<Apple> getLightApples(int weight) {
        return appleRepository.getHeavyApples(weight);
    }
}
