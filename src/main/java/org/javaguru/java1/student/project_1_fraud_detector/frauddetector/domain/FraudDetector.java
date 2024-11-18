package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import java.util.List;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB;

class FraudDetector {

    FraudstersDB fraudstersDB = new FraudstersDB();

    boolean isFraud(Transaction transaction) {
        List<Trader> fraudstersNames = fraudstersDB.getFraudstersNames();
        return fraudstersNames.stream().
                anyMatch(trader -> trader.getFullName().equals(transaction.getTrader().getFullName()));
    }

}
