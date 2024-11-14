package org.javaguru.java1.mentor.project_8_bank_transactions.step_30.banktransactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountTransactionApproverImplTest {

    private CurrentBalanceCalculator currentBalanceCalculator = new CurrentBalanceCalculatorStreamApiImpl();
    private BankAccountTransactionApproverImpl approver = new BankAccountTransactionApproverImpl(currentBalanceCalculator);

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceIsZero() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        Transaction newTransaction = ImmutableTransaction.of(100, TransactionType.WITHDRAWAL);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowDepositWhenBalanceIsZero() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        Transaction newTransaction = ImmutableTransaction.of(100, TransactionType.DEPOSIT);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceGoesBelowZero() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{
                ImmutableTransaction.of(100, TransactionType.DEPOSIT)
        });
        Transaction newTransaction = ImmutableTransaction.of(200, TransactionType.WITHDRAWAL);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowWithdrawalWhenBalanceNotGoesBelowZeroWhenCreditLimitZero() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{
                ImmutableTransaction.of(100, TransactionType.DEPOSIT)
        });
        Transaction newTransaction = ImmutableTransaction.of(50, TransactionType.WITHDRAWAL);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowDepositWhenBalanceAboveZero() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{
                ImmutableTransaction.of(100, TransactionType.DEPOSIT)
        });
        Transaction newTransaction = ImmutableTransaction.of(100, TransactionType.DEPOSIT);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowWithdrawalWhenBalanceGoesBelowZeroAndCreditLimitAllowsIt() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 100, new Transaction[]{
                ImmutableTransaction.of(100, TransactionType.DEPOSIT)
        });
        Transaction newTransaction = ImmutableTransaction.of(150, TransactionType.WITHDRAWAL);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceGoesBelowZeroAndCreditLimitNotAllowsIt() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 100, new Transaction[]{
                ImmutableTransaction.of(100, TransactionType.DEPOSIT)
        });
        Transaction newTransaction = ImmutableTransaction.of(250, TransactionType.WITHDRAWAL);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowWithdrawalWhenBalanceZeroAndCreditLimitAllowsIt() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 100, new Transaction[]{});
        Transaction newTransaction = ImmutableTransaction.of(50, TransactionType.WITHDRAWAL);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceZeroAndCreditLimitNotAllowsIt() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 100, new Transaction[]{});
        Transaction newTransaction = ImmutableTransaction.of(150, TransactionType.WITHDRAWAL);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

}