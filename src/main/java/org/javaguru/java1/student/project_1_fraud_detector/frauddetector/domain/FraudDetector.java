package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import java.util.List;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB;

class FraudDetector {

    FraudstersDB fraudstersDB = new FraudstersDB();

    boolean isFraud(Transaction transaction) {
        List<String> fraudstersNames = fraudstersDB.getFraudstersNames();
        boolean condition1 = fraudstersNames.contains(transaction.getTrader().getFullName());
        boolean fullCheck = condition1;
        return fullCheck;
    }

}
