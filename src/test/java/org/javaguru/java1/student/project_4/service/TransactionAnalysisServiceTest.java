package org.javaguru.java1.student.project_4.service;

import org.javaguru.java1.student.project_4.domain.Trader;
import org.javaguru.java1.student.project_4.domain.Transaction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TransactionAnalysisServiceTest {

    @Test
    void shouldReturnCorrectListOfTransactionsForYear () {

        // given
        TransactionAnalysisService service = new TransactionAnalysisService();
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
        TransactionAnalysisService service = new TransactionAnalysisService();
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
        TransactionAnalysisService service = new TransactionAnalysisService();
        List<Transaction> transactions = getTransactions();
        int testYear = 2014;

        // when
        List<Transaction> expectedTransactions = service.findTransactionsByYear(transactions, testYear);

        // then
        assertEquals(0, expectedTransactions.size(), "The size of returned list for year 2014 should be 0");

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
