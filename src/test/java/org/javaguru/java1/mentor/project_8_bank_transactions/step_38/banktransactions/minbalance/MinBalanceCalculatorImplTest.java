package org.javaguru.java1.mentor.project_8_bank_transactions.step_38.banktransactions.minbalance;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_38.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinBalanceCalculatorImplTest {

    private MinBalanceCalculator calculator = new MinBalanceCalculatorImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(-200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForDepositAndWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(50, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(50, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(-100, calculator.calculate(bankAccount));
    }

}