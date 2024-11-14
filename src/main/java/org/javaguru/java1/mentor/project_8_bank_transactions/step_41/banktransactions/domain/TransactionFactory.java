package org.javaguru.java1.mentor.project_8_bank_transactions.step_41.banktransactions.domain;

public class TransactionFactory {

    public Transaction createDepositTransaction(int amount) {
        return new TransactionImpl(amount);
    }

    public Transaction createWithdrawalTransaction(int amount,
                                                   ExpenseCategory expenseCategory) {
        return new TransactionImpl(amount, expenseCategory);
    }

}
