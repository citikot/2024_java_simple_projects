package org.javaguru.java1.mentor.project_8_bank_transactions.step_38.banktransactions.currentbalance;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_38.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrentBalanceCalculatorStreamApiImplTest {

    private CurrentBalanceCalculator calculator = new CurrentBalanceCalculatorStreamApiImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(-200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumDepositAndWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(50, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(50, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(0, calculator.calculate(bankAccount));
    }


}