package org.javaguru.java1.mentor.project_8_bank_transactions.step_58.banktransactions.minbalance;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_58.banktransactions.currentbalance.CurrentBalanceHolder;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_58.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_58.banktransactions.domain.Transaction;

class MinBalanceCalculatorImpl implements MinBalanceCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        int minBalance = 0;
        CurrentBalanceHolder currentBalanceHolder = new CurrentBalanceHolder();
        for (Transaction transaction : bankAccount.getTransactions()) {
            int currentBalance = currentBalanceHolder.applyTransaction(transaction);
            if (currentBalance < minBalance) {
                minBalance = currentBalance;
            }
        }
        return minBalance;
    }

}
