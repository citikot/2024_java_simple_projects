package org.javaguru.java1.mentor.project_8_bank_transactions.step_33.banktransactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepositAmountCalculatorImplTest {

    private DepositAmountCalculator calculator = new DepositAmountCalculatorImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnDepositSum() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT)
                }
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldIgnoreWithdrawals() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT)
                }
        );
        assertEquals(100, calculator.calculate(bankAccount));
    }

}