package org.javaguru.java1.mentor.project_8_bank_transactions.step_17.banktransactions;

import org.immutables.value.Value;

@Value.Immutable
interface Transaction {

    @Value.Parameter
    int amount();

    @Value.Parameter
    TransactionType transactionType();

}
