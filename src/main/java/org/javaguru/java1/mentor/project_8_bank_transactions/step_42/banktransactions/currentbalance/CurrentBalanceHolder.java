package org.javaguru.java1.mentor.project_8_bank_transactions.step_42.banktransactions.currentbalance;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_42.banktransactions.domain.Transaction;

public class CurrentBalanceHolder {
    private int currentBalance = 0;

    public int applyTransaction(Transaction transaction) {
        if (transaction.isDeposit()) {
            currentBalance = currentBalance + transaction.amount();
        }
        if (transaction.isWithdrawal()) {
            currentBalance = currentBalance - transaction.amount();
        }
        return currentBalance;
    }

}
