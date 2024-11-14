package org.javaguru.java1.mentor.project_8_bank_transactions.step_47.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_47.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_47.banktransactions.domain.ExpenseCategory;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_47.banktransactions.domain.Transaction;

import java.util.ArrayList;
import java.util.List;

class FoodExpensesCalculator extends ExpensesCalculator {

    public int calculateExpensesAmount(BankAccount bankAccount) {
        Transaction[] transactions = bankAccount.getTransactions();
        List<Transaction> withdrawalTransactions = filterWithdrawalTransactions(transactions);
        List<Transaction> withdrawalFoodTransactions = filterFoodTransactions(withdrawalTransactions);
        return sumTransactionAmount(withdrawalFoodTransactions);
    }

    private List<Transaction> filterFoodTransactions(List<Transaction> transactions) {
        List<Transaction> withdrawalFoodTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.expenseCategory() == ExpenseCategory.FOOD) {
                withdrawalFoodTransactions.add(transaction);
            }
        }
        return withdrawalFoodTransactions;
    }

}
