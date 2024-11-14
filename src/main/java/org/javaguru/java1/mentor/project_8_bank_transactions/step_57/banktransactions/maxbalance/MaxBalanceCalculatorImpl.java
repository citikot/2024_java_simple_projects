package org.javaguru.java1.mentor.project_8_bank_transactions.step_57.banktransactions.maxbalance;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_57.banktransactions.currentbalance.CurrentBalanceHolder;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_57.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_57.banktransactions.domain.Transaction;

class MaxBalanceCalculatorImpl implements MaxBalanceCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        int maxBalance = 0;
        CurrentBalanceHolder currentBalanceHolder = new CurrentBalanceHolder();
        for (Transaction transaction : bankAccount.getTransactions()) {
            int currentBalance = currentBalanceHolder.applyTransaction(transaction);
            if (currentBalance > maxBalance) {
                maxBalance = currentBalance;
            }
        }
        return maxBalance;
    }

}
