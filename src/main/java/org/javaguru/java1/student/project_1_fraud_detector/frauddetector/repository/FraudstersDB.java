package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.Trader;

import java.util.List;

public class FraudstersDB {

    public static final int FRAUD_TRANSACTION_AMOUNT_THRESHOLD = 1_000_000;

    List<String> prohibitedCities = List.of("Sydney");
    List<String> prohibitedCountries = List.of("Jamayka");

    List<Trader> fraudstersNames = List.of(
            new Trader("Pokemon", "Tokyo", "Japan"),
            new Trader("Jess Alba", "Hollywood", "USA"),
            new Trader("Bob Marley", "Jamajka", "Jamayka")
    );

    public List<Trader> getFraudstersNames() {
        return fraudstersNames;
    }

    public List<String> getProhibitedCities() {
        return prohibitedCities;
    }

    public List<String> getProhibitedCountries() {
        return prohibitedCountries;
    }
}
