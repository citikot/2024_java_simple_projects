package org.javaguru.java1.mentor.project_8_bank_transactions.step_55.banktransactions.maxbalance;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_55.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxBalanceCalculatorImplTest {

    private TransactionFactory factory = new TransactionFactory();
    private MaxBalanceCalculator calculator = new MaxBalanceCalculatorImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMaxForDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                factory.createDepositTransaction(100),
                factory.createDepositTransaction(100)
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMaxForWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS)
        );
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMaxForDepositAndWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                factory.createDepositTransaction(100),
                factory.createDepositTransaction(50),
                factory.createWithdrawalTransaction(50, ExpenseCategory.OTHERS)
        );
        assertEquals(50, calculator.calculate(bankAccount));
    }

}