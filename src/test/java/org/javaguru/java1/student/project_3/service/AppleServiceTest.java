package org.javaguru.java1.student.project_3.service;

import org.javaguru.java1.student.project_3.domain.Apple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AppleServiceTest {

    AppleService appleService = new AppleService();

    @Test
    void shouldFindGreenApples() {

        int expectedLength = 5;
        int actualLength = appleService.findApples(new SearchGreenApple()).size();
        assertEquals(expectedLength, actualLength, "There should be 5 green apples");
    }

    @Test
    void shouldNotFindGreenApples() {

        int expectedLength = 4;
        int actualLength = appleService.findApples(new SearchGreenApple()).size();
        assertNotEquals(expectedLength, actualLength, "There should be 5 green apples");
    }
}
