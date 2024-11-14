package org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.domain.ExpenseCategory;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_45.banktransactions.domain.Transaction;

import java.util.ArrayList;
import java.util.List;

class FoodExpensesCalculator {

    public int calculateExpensesAmount(BankAccount bankAccount) {
        Transaction[] transactions = bankAccount.getTransactions();
        List<Transaction> withdrawalTransactions = filterWithdrawalTransactions(transactions);
        List<Transaction> withdrawalFoodTransactions = filterFoodTransactions(withdrawalTransactions);
        return sumTransactionAmount(withdrawalFoodTransactions);
    }

    private List<Transaction> filterWithdrawalTransactions(Transaction[] transactions) {
        List<Transaction> withdrawalTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.isWithdrawal()) {
                withdrawalTransactions.add(transaction);
            }
        }
        return withdrawalTransactions;
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

    private int sumTransactionAmount(List<Transaction> transactions) {
        int foodExpensesAmount = 0;
        for (Transaction transaction : transactions) {
            foodExpensesAmount = foodExpensesAmount + transaction.amount();
        }
        return foodExpensesAmount;
    }

}
