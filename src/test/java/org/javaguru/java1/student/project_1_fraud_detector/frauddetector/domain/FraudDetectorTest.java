package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FraudDetectorTest {

    private static final FraudDetector fraudDetector = new FraudDetector();
    private static final List<Transaction> rawTransactions = new ArrayList<>();
    private static List<Trader> traders = new ArrayList<>();

    @BeforeAll
    static void init() {
        traders = List.of(
                new Trader("John Dow", "New York"),
                new Trader("Mari Ell", "Minnesota"),
                new Trader("P Did", "Los Angeles"),
                new Trader("Jess Alba", "Hollywood"),
                new Trader("Emily Radkovsky", "Pasadena"),
                new Trader("Dominic Torrent", "Seattle"),
                new Trader("Pokemon", "Tokyo")
        );

        List<Integer> transactionAmounts = List.of( 1000, 5000, 1000000, 2000000, 50000, 999999, 1);

        for (int i = 0; i < traders.size(); i++) {
            rawTransactions.add(new Transaction(traders.get(i), transactionAmounts.get(i)));
        }
    }

    @Test
    void testTransactionTradersIsFraudster() {
        // given
        Trader trader = new Trader("Pokemon", "Tokyo");
        Transaction transaction = new Transaction(trader, 10000);

        // when
        boolean isFraudster = fraudDetector.isFraud(transaction);

        // then
        assertTrue(isFraudster);
    }

    @Test
    void testTransactionTradersIsNotFraudster() {
        // given
        Trader trader = new Trader("Ivan Bredford", "Chicago");
        Transaction transaction = new Transaction(trader, 1000);

        // when
        boolean isFraudster = fraudDetector.isFraud(transaction);

        // then
        assertFalse(isFraudster);
    }
}