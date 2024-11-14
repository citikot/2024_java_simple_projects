package org.javaguru.java1.mentor.project_8_bank_transactions.step_32.banktransactions;

class BankAccountTransactionApproverImpl implements BankAccountTransactionApprover {

    private CurrentBalanceCalculator currentBalanceCalculator;

    public BankAccountTransactionApproverImpl(CurrentBalanceCalculator currentBalanceCalculator) {
        this.currentBalanceCalculator = currentBalanceCalculator;
    }

    @Override
    public boolean approve(BankAccount bankAccount,
                           Transaction newTransaction) {
        int currentBalance = currentBalanceCalculator.calculate(bankAccount);
        int totalAmountAllowedToWithdraw = currentBalance + bankAccount.getCreditLimit();
        return newTransaction.isDeposit()
                || (newTransaction.isWithdrawal()
                        && totalAmountAllowedToWithdraw >= newTransaction.amount());
    }

}
