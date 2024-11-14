package org.javaguru.java1.mentor.project_8_bank_transactions.step_43.banktransactions.withdrawalamount;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_43.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_43.banktransactions.domain.Transaction;

import java.util.Arrays;

class WithdrawalAmountCalculatorImpl implements WithdrawalAmountCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        return Arrays.stream(bankAccount.getTransactions())
                .filter(Transaction::isWithdrawal)
                .map(Transaction::amount)
                .reduce(0, Integer::sum);
    }
}
