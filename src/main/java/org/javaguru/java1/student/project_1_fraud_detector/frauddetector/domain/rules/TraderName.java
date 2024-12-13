package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.rules;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.Trader;
import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.Transaction;
import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB;

import java.util.List;

public class TraderName implements FraudRule {

    FraudstersDB fraudstersDB = new FraudstersDB();

    public boolean isFraud(Transaction transaction) {
        List<Trader> fraudstersNames = fraudstersDB.getFraudstersNames();
        return fraudstersNames.stream().anyMatch(trader -> trader.fullName().equals(transaction.trader().fullName()));
    }
}
