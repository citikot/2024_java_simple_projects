package org.javaguru.java1.student.project_3.service;

import org.javaguru.java1.student.project_3.domain.Apple;
import org.javaguru.java1.student.project_3.repository.AppleRepository;

import java.util.List;

public class AppleService {

    private final AppleRepository appleRepository = new AppleRepository();

    public void run() {

        System.out.println(findApples(new SearchHeavyApple()));
        System.out.println(findApples(new SearchLightApple()));
        System.out.println(findApples(new SearchGreenApple()));
        System.out.println(findApples(new SearchRedApple()));
        System.out.println(findApples(new SearchGreenHeavyApple()));

    }

    public List<Apple> findApples(AppleSearchCriteria searchCriteria) {
        return appleRepository.getAllApples().stream()
                .filter(searchCriteria::test)
                .toList();
    }
}
