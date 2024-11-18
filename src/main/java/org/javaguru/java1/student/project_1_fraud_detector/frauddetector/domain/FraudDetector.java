package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import java.util.List;
import java.util.function.Predicate;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB;

import static org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB.FRAUD_TRANSACTION_AMOUNT_THRESHOLD;

class FraudDetector {

    FraudstersDB fraudstersDB = new FraudstersDB();

    boolean isFraud(Transaction transaction) {
        List<Trader> fraudstersNames = fraudstersDB.getFraudstersNames();
        boolean fraudByName = fraudstersNames.stream().anyMatch(trader -> trader.fullName().equals(transaction.trader().fullName()));
        boolean fraudByTransactionAmount = transaction.amount() > FRAUD_TRANSACTION_AMOUNT_THRESHOLD;
        return fraudByName || fraudByTransactionAmount;
    }

    public List<Transaction> filterTransactions(List<Transaction> rawTransactions) {
        return rawTransactions.stream().filter(Predicate.not(this::isFraud)).toList();
    }
}
