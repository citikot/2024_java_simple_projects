package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.rules;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.Transaction;
import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB;

import static org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB.FRAUD_TRANSACTION_AMOUNT_THRESHOLD;

public class TransactionAmount implements FraudRule {

    FraudstersDB fraudstersDB = new FraudstersDB();

    public boolean isFraud(Transaction transaction) {
        return transaction.amount() > FRAUD_TRANSACTION_AMOUNT_THRESHOLD;
    }
}
