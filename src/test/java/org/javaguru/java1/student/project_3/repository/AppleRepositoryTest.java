package org.javaguru.java1.student.project_3.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppleRepositoryTest {

    AppleRepository appleRepository = new AppleRepository();

    @Test
    void shouldFindAllApples() {
        // given
        int expectedLength = 20;

        // when
        int actualLength = appleRepository.getAllApples().size();

        // then
        assertEquals(expectedLength, actualLength, "The size of the list should be 20");
    }
}
