package org.javaguru.java1.mentor.project_8_bank_transactions.step_21.banktransactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxBalanceCalculatorForImplTest {

    private MaxBalanceCalculator calculator = new MaxBalanceCalculatorForImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMaxForDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin",
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT)
                }
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMaxForWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin",
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL),
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL)
                }
        );
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMaxForDepositAndWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin",
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT),
                        ImmutableTransaction.of(50, TransactionType.DEPOSIT),
                        ImmutableTransaction.of(50, TransactionType.WITHDRAWAL)
                }
        );
        assertEquals(50, calculator.calculate(bankAccount));
    }

}