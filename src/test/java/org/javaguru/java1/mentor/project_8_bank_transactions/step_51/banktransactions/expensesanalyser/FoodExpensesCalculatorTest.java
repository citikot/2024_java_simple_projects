package org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.domain.ExpenseCategory;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.domain.Transaction;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.domain.TransactionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodExpensesCalculatorTest {

    private TransactionFactory factory = new TransactionFactory();
    private FoodExpensesCalculator calculator = new FoodExpensesCalculator();

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
                        factory.createWithdrawalTransaction(100, ExpenseCategory.FOOD),
                        factory.createWithdrawalTransaction(100, ExpenseCategory.FOOD)
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