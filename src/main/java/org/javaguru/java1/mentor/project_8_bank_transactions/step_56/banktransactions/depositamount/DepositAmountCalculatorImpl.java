package org.javaguru.java1.mentor.project_8_bank_transactions.step_56.banktransactions.depositamount;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_56.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_56.banktransactions.domain.Transaction;

import java.util.Arrays;

class DepositAmountCalculatorImpl implements DepositAmountCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        return Arrays.stream(bankAccount.getTransactions())
                .filter(Transaction::isDeposit)
                .map(Transaction::amount)
                .reduce(0, Integer::sum);
    }
}
