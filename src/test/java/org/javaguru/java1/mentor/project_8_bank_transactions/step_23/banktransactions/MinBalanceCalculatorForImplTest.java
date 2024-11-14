package org.javaguru.java1.mentor.project_8_bank_transactions.step_23.banktransactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinBalanceCalculatorForImplTest {

    private MinBalanceCalculator calculator = new MinBalanceCalculatorForImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin",
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT)
                }
        );
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin",
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL),
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL)
                }
        );
        assertEquals(-200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForDepositAndWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin",
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT),
                        ImmutableTransaction.of(50, TransactionType.DEPOSIT),
                        ImmutableTransaction.of(50, TransactionType.WITHDRAWAL)
                }
        );
        assertEquals(-100, calculator.calculate(bankAccount));
    }

}