package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.Trader;

import java.util.List;

public class FraudstersDB {

    public static final int FRAUD_TRANSACTION_AMOUNT_THRESHOLD = 1_000_000;

    List<Trader> fraudstersNames = List.of(
            new Trader("Pokemon", "Tokyo"),
            new Trader("Jess Alba", "Hollywood")
    );

    public List<Trader> getFraudstersNames() {
        return fraudstersNames;
    }
}
