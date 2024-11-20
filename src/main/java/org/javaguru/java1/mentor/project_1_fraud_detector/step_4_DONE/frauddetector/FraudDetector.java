package org.javaguru.java1.mentor.project_1_fraud_detector.step_4_DONE.frauddetector;

class FraudDetector {

    boolean isFraud(Transaction transaction) {
        Trader trader = transaction.getTrader();
        if (trader.getFullName().equals("Pokemon")) {
            return true;
        } else {
            return false;
        }
    }

}
