package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB;

import static org.javaguru.java1.student.project_1_fraud_detector.frauddetector.repository.FraudstersDB.FRAUD_TRANSACTION_AMOUNT_THRESHOLD;

class FraudDetector {

    FraudstersDB fraudstersDB = new FraudstersDB();

    public List<Transaction> filterTransactions(List<Transaction> rawTransactions) {
        return rawTransactions.stream().filter(Predicate.not(this::isFraud)).toList();
    }

    boolean isFraud(Transaction transaction) {
        List<Boolean> checkedRules = new ArrayList<>();
        checkedRules.add(isFraudByTraderName(transaction));
        checkedRules.add(isFraudByTransactionAmount(transaction));
        checkedRules.add(isFraudByCity(transaction));
        checkedRules.add(isFraudByCountry(transaction));
        return checkFraudRules(checkedRules);
    }

    boolean isFraudByCity(Transaction transaction) {
        List<String> prohibitedCities = fraudstersDB.getProhibitedCities();
        return prohibitedCities.stream().anyMatch(city -> city.equals(transaction.trader().city()));
    }

    boolean isFraudByCountry(Transaction transaction) {
        List<String> prohibitedCities = fraudstersDB.getProhibitedCountries();
        return prohibitedCities.stream().anyMatch(country -> country.equals(transaction.trader().country()));
    }

    boolean isFraudByTraderName(Transaction transaction) {
        List<Trader> fraudstersNames = fraudstersDB.getFraudstersNames();
        return fraudstersNames.stream().anyMatch(trader -> trader.fullName().equals(transaction.trader().fullName()));
    }

    boolean isFraudByTransactionAmount(Transaction transaction) {
        return transaction.amount() > FRAUD_TRANSACTION_AMOUNT_THRESHOLD;
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
