package org.javaguru.java1.mentor.project_8_bank_transactions.step_16.banktransactions;

import java.util.Arrays;
import java.util.stream.Stream;

class CurrentBalanceCalculatorStreamApiImpl implements CurrentBalanceCalculator {

    @Override
    public int calculate(BankAccount bankAccount) {
        int depositSum = filterByType(bankAccount.getTransactions(), TransactionType.DEPOSIT)
                .map(Transaction::amount)
                .reduce(0, Integer::sum);

        int withdrawalSum = filterByType(bankAccount.getTransactions(), TransactionType.WITHDRAWAL)
                .map(Transaction::amount)
                .reduce(0, Integer::sum);

        return depositSum - withdrawalSum;
    }

    private Stream<Transaction> filterByType(Transaction[] transactions,
                                             TransactionType type) {
        return Arrays.stream(transactions)
                .filter(transaction -> transaction.transactionType() == type);
    }

}
