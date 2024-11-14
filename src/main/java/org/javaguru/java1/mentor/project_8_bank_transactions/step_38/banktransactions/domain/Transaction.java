package org.javaguru.java1.mentor.project_8_bank_transactions.step_38.banktransactions.domain;

import org.immutables.value.Value;

@Value.Immutable
public interface Transaction {

    @Value.Parameter
    int amount();

    @Value.Parameter
    TransactionType transactionType();

    @Value.Parameter
    ExpenseCategory expenseCategory();


    default boolean isDeposit() {
        return transactionType() == TransactionType.DEPOSIT;
    }

    default boolean isWithdrawal() {
        return transactionType() == TransactionType.WITHDRAWAL;
    }

}
