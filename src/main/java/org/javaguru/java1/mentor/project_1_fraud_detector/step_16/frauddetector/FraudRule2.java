package org.javaguru.java1.mentor.project_1_fraud_detector.step_16.frauddetector;

class FraudRule2 implements FraudRule {
    @Override
    public boolean isFraud(Transaction transaction) {
        return transaction.getAmount() > 1000000;
    }

    @Override
    public String getRuleName() {
        return "FraudRule2";
    }

}
