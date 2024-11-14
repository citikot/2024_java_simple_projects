package org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.domain.ExpenseCategory;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.domain.Transaction;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.domain.TransactionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntertainmentExpensesCalculatorTest {

    private TransactionFactory factory = new TransactionFactory();
    private EntertainmentExpensesCalculator calculator = new EntertainmentExpensesCalculator();

    @Test
    public void shouldReturnZeroForAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculateExpensesAmount(bankAccount));
    }

    @Test
    public void shouldFilterDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        factory.createDepositTransaction(100),
                        factory.createDepositTransaction(100)
                }
        );
        assertEquals(0, calculator.calculateExpensesAmount(bankAccount));
    }

    @Test
    public void shouldSumFoodExpenses() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        factory.createWithdrawalTransaction(100, ExpenseCategory.ENTERTAINMENT),
                        factory.createWithdrawalTransaction(100, ExpenseCategory.ENTERTAINMENT)
                }
        );
        assertEquals(200, calculator.calculateExpensesAmount(bankAccount));
    }

    @Test
    public void shouldFilterNotFoodExpenses() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                        factory.createWithdrawalTransaction(100, ExpenseCategory.COMMUNAL_PAYMENTS)
                }
        );
        assertEquals(0, calculator.calculateExpensesAmount(bankAccount));
    }

}