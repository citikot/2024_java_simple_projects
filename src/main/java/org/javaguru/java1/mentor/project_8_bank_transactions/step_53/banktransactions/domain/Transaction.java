package org.javaguru.java1.mentor.project_8_bank_transactions.step_53.banktransactions.domain;

public interface Transaction {

    int amount();

    TransactionType transactionType();

    ExpenseCategory expenseCategory();

    default boolean isDeposit() {
        return transactionType() == TransactionType.DEPOSIT;
    }

    default boolean isWithdrawal() {
        return transactionType() == TransactionType.WITHDRAWAL;
    }

}
