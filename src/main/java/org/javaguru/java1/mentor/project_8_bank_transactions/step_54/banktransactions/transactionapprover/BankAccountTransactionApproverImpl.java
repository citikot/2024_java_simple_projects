package org.javaguru.java1.mentor.project_8_bank_transactions.step_54.banktransactions.transactionapprover;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_54.banktransactions.currentbalance.CurrentBalanceCalculator;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_54.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_54.banktransactions.domain.Transaction;

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
