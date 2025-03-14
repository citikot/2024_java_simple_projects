package org.javaguru.java1.mentor.project_8_bank_transactions.step_24.banktransactions;

class MaxBalanceCalculatorForImpl implements MaxBalanceCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        int maxBalance = 0;
        int currentBalance = 0;
        Transaction[] transactions = bankAccount.getTransactions();
        for (int i = 0; i < transactions.length; i++) {
            Transaction transaction = transactions[i];
            if (transaction.isDeposit()) {
                currentBalance = currentBalance + transaction.amount();
            }
            if (transaction.isWithdrawal()) {
                currentBalance = currentBalance - transaction.amount();
            }
            if (currentBalance > maxBalance) {
                maxBalance = currentBalance;
            }
        }
        return maxBalance;
    }
}
