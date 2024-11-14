package org.javaguru.java1.mentor.project_8_bank_transactions.step_36.banktransactions;

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
