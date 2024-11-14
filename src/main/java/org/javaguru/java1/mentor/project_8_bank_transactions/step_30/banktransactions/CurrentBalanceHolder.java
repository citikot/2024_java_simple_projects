package org.javaguru.java1.mentor.project_8_bank_transactions.step_30.banktransactions;

class CurrentBalanceHolder {
    private int currentBalance = 0;

    int applyTransaction(Transaction transaction) {
        if (transaction.isDeposit()) {
            currentBalance = currentBalance + transaction.amount();
        }
        if (transaction.isWithdrawal()) {
            currentBalance = currentBalance - transaction.amount();
        }
        return currentBalance;
    }

}
