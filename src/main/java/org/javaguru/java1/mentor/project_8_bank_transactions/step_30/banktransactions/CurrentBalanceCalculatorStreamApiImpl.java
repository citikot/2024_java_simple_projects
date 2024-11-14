package org.javaguru.java1.mentor.project_8_bank_transactions.step_30.banktransactions;

import java.util.Arrays;

class CurrentBalanceCalculatorStreamApiImpl implements CurrentBalanceCalculator {

    @Override
    public int calculate(BankAccount bankAccount) {
        int depositSum = calculateSum(bankAccount, TransactionType.DEPOSIT);
        int withdrawalSum = calculateSum(bankAccount, TransactionType.WITHDRAWAL);
        return depositSum - withdrawalSum;
    }

    private int calculateSum(BankAccount bankAccount, TransactionType transactionType) {
        return Arrays.stream(bankAccount.getTransactions())
                .filter(transaction -> transaction.transactionType() == transactionType)
                .map(Transaction::amount)
                .reduce(0, Integer::sum);
    }

}
