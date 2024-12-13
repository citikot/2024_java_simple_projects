package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.rules.City;
import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.rules.Country;
import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.rules.TraderName;
import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.rules.TransactionAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class FraudDetector {

    public List<Transaction> filterTransactions(List<Transaction> rawTransactions) {
        return rawTransactions.stream().filter(Predicate.not(this::isFraud)).toList();
    }

    boolean isFraud(Transaction transaction) {
        List<Boolean> checkedRules = new ArrayList<>();
        checkedRules.add(new City().isFraud(transaction));
        checkedRules.add(new Country().isFraud(transaction));
        checkedRules.add(new TraderName().isFraud(transaction));
        checkedRules.add(new TransactionAmount().isFraud(transaction));
        return checkFraudRules(checkedRules);
    }

    boolean checkFraudRules(List<Boolean> checkedRules) {
        for (boolean item : checkedRules) {
            if (item) {
                return true;
            }
        }
        return false;
    }
}
