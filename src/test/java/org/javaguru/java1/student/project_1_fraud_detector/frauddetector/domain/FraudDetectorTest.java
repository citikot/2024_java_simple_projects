package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FraudDetectorTest {

    private static final FraudDetector fraudDetector = new FraudDetector();

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