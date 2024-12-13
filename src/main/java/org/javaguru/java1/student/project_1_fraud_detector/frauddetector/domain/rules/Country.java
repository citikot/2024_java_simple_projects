package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.rules;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.Transaction;
import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB;

import java.util.List;

public class Country implements FraudRule {

    FraudstersDB fraudstersDB = new FraudstersDB();

    public boolean isFraud(Transaction transaction) {
        List<String> prohibitedCities = fraudstersDB.getProhibitedCountries();
        return prohibitedCities.stream().anyMatch(country -> country.equals(transaction.trader().country()));
    }
}
