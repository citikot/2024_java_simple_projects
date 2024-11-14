package org.javaguru.java1.mentor.project_8_bank_transactions.step_35.banktransactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionTest {

    @Test
    public void shouldCreateTransaction() {
        Transaction transaction = ImmutableTransaction.of(
                100,
                TransactionType.DEPOSIT);
        assertNotNull(transaction);
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.DEPOSIT);
    }

    @Test
    public void shouldBuildTransactionWithBuilder() {
        Transaction transaction = ImmutableTransaction.builder()
                .amount(100)
                .transactionType(TransactionType.DEPOSIT)
                .build();
        assertNotNull(transaction);
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.DEPOSIT);
    }

}