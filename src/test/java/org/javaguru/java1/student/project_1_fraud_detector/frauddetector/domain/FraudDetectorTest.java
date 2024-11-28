package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FraudDetectorTest {

    private static final FraudDetector fraudDetector = new FraudDetector();
    private static final List<Transaction> rawTransactions = new ArrayList<>();
    private static List<Trader> traders = new ArrayList<>();
    private static List<Boolean> chekedRulesPassed = new ArrayList<>();
    private static List<Boolean> chekedRulesFailed = new ArrayList<>();
    private static final int VALID_TRANSACTIONS = 3;

    @BeforeAll
    static void init() {
        traders = List.of(
                new Trader("John Dow", "New York"),
                new Trader("Mari Ell", "Minnesota"),
                new Trader("P Did", "Los Angeles"),
                new Trader("Jess Alba", "Hollywood"),
                new Trader("Emily Radkovsky", "Pasadena"),
                new Trader("Dominic Torrent", "Seattle"),
                new Trader("Pokemon", "Tokyo"),
                new Trader("Gerard Butler", "Sydney"),
                new Trader("Joe Peshi", "Sydney")
        );

        chekedRulesFailed = List.of(false, true, false, true); // some transactions are fraudulent
        chekedRulesPassed= List.of(false, false, false, false); // all transactions are good

        List<Integer> transactionAmounts = List.of( 1000, 5000, 1_100_000, 1, 50000, 1_999_999, 1, 150, 800);

        for (int i = 0; i < traders.size(); i++) {
            rawTransactions.add(new Transaction(traders.get(i), transactionAmounts.get(i)));
        }
    }

    @Test
    void testTraderIsFraudsterByName() {
        // given
        Trader trader = new Trader("Pokemon", "Tokyo");
        Transaction transaction = new Transaction(trader, 10000);

        // when
        boolean isFraudster = fraudDetector.isFraudByTraderName(transaction);

        // then
        assertTrue(isFraudster);
    }

    @Test
    void testTraderIsNotFraudsterByName() {
        // given
        Trader trader = new Trader("Ivan Bredford", "Chicago");
        Transaction transaction = new Transaction(trader, 1000);

        // when
        boolean isFraudster = fraudDetector.isFraudByTraderName(transaction);

        // then
        assertFalse(isFraudster);
    }

    @Test
    void testFraudulentTransactionByAmount() {
        // given
        Trader trader = new Trader("Ivan Bredford", "Chicago");
        Transaction transaction = new Transaction(trader, 1_000_000_000);

        // when
        boolean isFraudulent = fraudDetector.isFraudByTransactionAmount(transaction);

        // then
        assertTrue(isFraudulent);
    }

    @Test
    void testNotFraudulentTransactionByAmount() {
        // given
        Trader trader = new Trader("Ivan Bredford", "Chicago");
        Transaction transaction = new Transaction(trader, 1_000);

        // when
        boolean isFraudulent = fraudDetector.isFraudByTransactionAmount(transaction);

        // then
        assertFalse(isFraudulent);
    }

    @Test
    void testFraudulentTransactionByCity() {
        // given
        Trader trader = new Trader("Ivan Bredford", "Sydney");
        Transaction transaction = new Transaction(trader, 1_000);

        // when
        boolean isFraudulent = fraudDetector.isFraudByCity(transaction);

        // then
        assertTrue(isFraudulent);
    }

    @Test
    void testNotFraudulentTransactionByCity() {
        // given
        Trader trader = new Trader("Ivan Bredford", "Rammstein");
        Transaction transaction = new Transaction(trader, 1_000);

        // when
        boolean isFraudulent = fraudDetector.isFraudByCity(transaction);

        // then
        assertFalse(isFraudulent);
    }

    @Test
    void testAllCheckedRulesArePassed() {
        assertFalse(fraudDetector.checkFraudRules(chekedRulesPassed));
    }

    @Test
    void testCheckedRulesFailed() {
        assertTrue(fraudDetector.checkFraudRules(chekedRulesFailed));
    }

    @Test
    void testTransactionFilter() {
        List<Transaction> filteredTransactions = fraudDetector.filterTransactions(rawTransactions);
        assertEquals(VALID_TRANSACTIONS, filteredTransactions.size());
    }
}