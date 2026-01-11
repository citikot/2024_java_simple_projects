package org.javaguru.java1.student.project_4.service;

import org.javaguru.java1.student.project_4.domain.Trader;
import org.javaguru.java1.student.project_4.domain.Transaction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TransactionAnalysisServiceTest {

    TransactionAnalysisService service = new TransactionAnalysisService();

    @Test
    void shouldReturnCorrectListOfTransactionsForYear () {

        // given
        List<Transaction> transactions = getTransactions();
        int testYear = 2012;

        // when
        List<Transaction> expectedTransactions = service.findTransactionsByYear(transactions, testYear);

        // then
        assertEquals(4, expectedTransactions.size(), "The size of returned list for year 2012 should be 4");

    }

    @Test
    void shouldReturnIncorrectListOfTransactionsForYear () {

        // given
        List<Transaction> transactions = getTransactions();
        int testYear = 2012;

        // when
        List<Transaction> expectedTransactions = service.findTransactionsByYear(transactions, testYear);

        // then
        assertNotEquals(3, expectedTransactions.size(), "The size of returned list for year 2012 should be 4");

    }

    @Test
    void shouldReturnEmptyListOfTransactionsForAbsentYear () {

        // given
        List<Transaction> transactions = getTransactions();
        int testYear = 2014;

        // when
        List<Transaction> expectedTransactions = service.findTransactionsByYear(transactions, testYear);

        // then
        assertEquals(0, expectedTransactions.size(), "The size of returned list for year 2014 should be 0");

    }

    @Test
    void shouldReturnSortedTransactionsListAsc () {

        // given
        List<Transaction> transactions = getTransactions();
        int expectedValue = 300;

        // when
        List<Transaction> sortedTransactions = service.sortTransactionsASC(transactions);

        // then
        assertEquals(expectedValue, sortedTransactions.get(0).value());
    }

    @Test
    void shouldReturnSortedTransactionsListDesc () {

        // given
        List<Transaction> transactions = getTransactions();
        int expectedValue = 1000;

        // when
        List<Transaction> sortedTransactions = service.sortTransactionsDESC(transactions);

        // then
        assertEquals(expectedValue, sortedTransactions.get(0).value());
    }

    @Test
    void shouldReturnSortedTransactionsListForYear () {

        // given
        List<Transaction> transactions = getTransactions();
        int testYear = 2011;
        int expectedValue = 300;

        // when
        List<Transaction> sortedTransactions = service.findByYearAndSortAsc(transactions, testYear);

        // then
        assertEquals(expectedValue, sortedTransactions.get(0).value());
    }

    @Test
    void shouldReturnCorrectSetOfYears () {

        // given
        List<Transaction> transactions = getTransactions();
        Set<Integer> expectedYears = Set.of(2011, 2012);
        // when
        Set<Integer> actualYears = service.findUniqueYears(transactions);

        // then
        assertEquals(expectedYears, actualYears, "The set of years should be 2011 and 2012");
    }

    @Test
    void shouldReturnCorrectSetOfNames () {

        // given
        List<Transaction> transactions = getTransactions();
        Set<String> expectedNames = Set.of("Raoul", "Mario", "Alan", "Brian");
        // when
        Set<String> actualNames = service.findUniqueNames(transactions);

        // then
        assertEquals(expectedNames, actualNames, "The set of names should be Raoul, Mario, Alan and Brian");
    }

    @Test
    void shouldReturnCorrectSetOfCites () {

        // given
        List<Transaction> transactions = getTransactions();
        Set<String> expectedCities = Set.of("Cambridge", "Milan");
        // when
        Set<String> actualCities = service.findUniqueCities(transactions);

        // then
        assertEquals(expectedCities, actualCities, "The set of cities should be Cambridge and Milan");
    }

    @Test
    void shouldReturnCorrectSetOfNamesFromSelectedCity () {

        // given
        List<Transaction> transactions = getTransactions();
        Set<String> expectedNames = Set.of("Mario");
        String expectedCity = "Milan";
        // when
        Set<String> actualNames = service.findUniqueNamesFromCities(transactions, expectedCity);

        // then
        assertEquals(expectedNames, actualNames, "The set of names should be Mario");
    }

    public static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
}
