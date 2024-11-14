package org.javaguru.java1.mentor.project_8_bank_transactions.step_48.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_48.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_48.banktransactions.domain.ExpenseCategory;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_48.banktransactions.domain.Transaction;

import java.util.List;

class FoodExpensesCalculator extends ExpensesCalculator {

    public int calculateExpensesAmount(BankAccount bankAccount) {
        Transaction[] transactions = bankAccount.getTransactions();
        List<Transaction> withdrawalTransactions = filterWithdrawalTransactions(transactions);
        List<Transaction> withdrawalFoodTransactions = filterTransactionsByExpenseCategory(withdrawalTransactions, ExpenseCategory.FOOD);
        return sumTransactionAmount(withdrawalFoodTransactions);
    }

}
