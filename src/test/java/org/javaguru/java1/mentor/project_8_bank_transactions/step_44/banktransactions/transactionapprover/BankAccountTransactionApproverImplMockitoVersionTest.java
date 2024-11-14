package org.javaguru.java1.mentor.project_8_bank_transactions.step_44.banktransactions.transactionapprover;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_44.banktransactions.currentbalance.CurrentBalanceCalculator;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_44.banktransactions.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankAccountTransactionApproverImplMockitoVersionTest {

    private TransactionFactory factory = new TransactionFactory();

    @Mock
    private CurrentBalanceCalculator currentBalanceCalculator;
    @InjectMocks
    private BankAccountTransactionApproverImpl approver;

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceIsZero() {
        BankAccount bankAccount = mock(BankAccount.class);
        Transaction newTransaction = factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(0);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowDepositWhenBalanceIsZero() {
        BankAccount bankAccount = mock(BankAccount.class);;
        Transaction newTransaction = factory.createDepositTransaction(100);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(0);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceGoesBelowZero() {
        BankAccount bankAccount = mock(BankAccount.class);
        Transaction newTransaction = factory.createWithdrawalTransaction(200, ExpenseCategory.OTHERS);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(100);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowWithdrawalWhenBalanceNotGoesBelowZero() {
        BankAccount bankAccount = mock(BankAccount.class);
        Transaction newTransaction = factory.createWithdrawalTransaction(50, ExpenseCategory.OTHERS);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(100);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowDepositWhenBalanceAboveZero() {
        BankAccount bankAccount = mock(BankAccount.class);
        Transaction newTransaction = factory.createDepositTransaction(100);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(50);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowWithdrawalWhenBalanceGoesBelowZeroAndCreditLimitAllowsIt() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 100, new Transaction[]{
                factory.createDepositTransaction(100)
        });
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(100);
        Transaction newTransaction = factory.createWithdrawalTransaction(150, ExpenseCategory.OTHERS);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceGoesBelowZeroAndCreditLimitNotAllowsIt() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 100, new Transaction[]{
                factory.createDepositTransaction(100)
        });
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(100);
        Transaction newTransaction = factory.createWithdrawalTransaction(250, ExpenseCategory.OTHERS);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowWithdrawalWhenBalanceZeroAndCreditLimitAllowsIt() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 100, new Transaction[]{});
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(0);
        Transaction newTransaction = factory.createWithdrawalTransaction(50, ExpenseCategory.OTHERS);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceZeroAndCreditLimitNotAllowsIt() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 100, new Transaction[]{});
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(0);
        Transaction newTransaction = factory.createWithdrawalTransaction(150, ExpenseCategory.OTHERS);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

}