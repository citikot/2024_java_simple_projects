package org.javaguru.java1.mentor.project_8_bank_transactions.step_40.immutables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookTest {

    @Test
    public void shouldCreateBook() {
        Book book = ImmutableBook.of(
                "Vasja Pupkin",
                "How to build Java program?");
        assertNotNull(book);
        assertEquals(book.authorFullName(), "Vasja Pupkin");
        assertEquals(book.title(), "How to build Java program?");
    }

    @Test
    public void shouldBuildTransactionWithBuilder() {
        Book book = ImmutableBook.builder()
                .authorFullName("Vasja Pupkin")
                .title("How to build Java program?")
                .build();
        assertNotNull(book);
        assertEquals(book.authorFullName(), "Vasja Pupkin");
        assertEquals(book.title(), "How to build Java program?");
    }

}