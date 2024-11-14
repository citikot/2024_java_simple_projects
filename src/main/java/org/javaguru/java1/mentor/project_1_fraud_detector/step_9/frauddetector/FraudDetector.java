package org.javaguru.java1.mentor.project_1_fraud_detector.step_9.frauddetector;

class FraudDetector {

    boolean isFraud(Transaction transaction) {
        Trader trader = transaction.getTrader();
        if (trader.getFullName().equals("Pokemon")) {
            return true;
        }

        if (transaction.getAmount() > 1000000) {
            return true;
        }

        if (trader.getCity().equals("Sydney")) {
            return true;
        }

        if (trader.getCountry().equals("Jamaica")) {
            return true;
        }

        if (trader.getCountry().equals("Germany")
            && transaction.getAmount() > 1000) {
            return true;
        }

        return false;
    }

}
