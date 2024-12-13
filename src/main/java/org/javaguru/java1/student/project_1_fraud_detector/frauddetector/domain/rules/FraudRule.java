package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.rules;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.Transaction;

public interface FraudRule {
    boolean isFraud(Transaction t);
}
