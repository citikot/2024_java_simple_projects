package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain.Trader;

import java.util.List;

public class FraudstersDB {

    List<Trader> fraudstersNames = List.of(new Trader("Pokemon", "Tokyo"));

    public List<Trader> getFraudstersNames() {
        return fraudstersNames;
    }
}
