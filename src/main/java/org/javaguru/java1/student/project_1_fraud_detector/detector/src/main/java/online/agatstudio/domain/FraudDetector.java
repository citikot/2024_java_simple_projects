package online.agatstudio.domain;

import java.util.List;

import online.agatstudio.repository.FraudstersDB;

class FraudDetector {

    FraudstersDB fraudstersDB = new FraudstersDB();

    boolean isFraud(Transaction transaction) {
        List<String> fraudstersNames = fraudstersDB.getFraudstersNames();
        boolean condition1 = fraudstersNames.contains(transaction.getTrader().getFullName());
        boolean fullCheck = condition1;
        return fullCheck;
    }

}
