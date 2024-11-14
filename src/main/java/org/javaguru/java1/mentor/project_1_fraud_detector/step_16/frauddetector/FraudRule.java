package org.javaguru.java1.mentor.project_1_fraud_detector.step_16.frauddetector;

interface FraudRule {

    boolean isFraud(Transaction transaction);

    String getRuleName();

}
