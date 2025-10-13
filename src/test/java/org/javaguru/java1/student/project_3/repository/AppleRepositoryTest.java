package org.javaguru.java1.student.project_3.repository;

import org.javaguru.java1.student.project_3.domain.Apple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppleRepositoryTest {

    private final AppleRepository repository = new AppleRepository();
    List<Apple> apples = new ArrayList<>();

    @BeforeEach
    void setUp() {
        apples = repository.createAppleWarehouse();
    }

    @Test
    void shouldFindFiveGreenApples() {
        // given
        String COLOR = "green";
        int expectedCount = 5;

        // when
            int count = repository.getApplesByColor(COLOR).size();

        // then
        assertEquals(expectedCount, count, "Green apples count should be 5");
    }
}