package org.javaguru.java1.mentor.project_8_bank_transactions.step_46.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_46.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_46.banktransactions.domain.ExpenseCategory;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_46.banktransactions.domain.Transaction;

import java.util.ArrayList;
import java.util.List;

class EntertainmentExpensesCalculator extends ExpensesCalculator {

    public int calculateExpensesAmount(BankAccount bankAccount) {
        Transaction[] transactions = bankAccount.getTransactions();
        List<Transaction> withdrawalTransactions = filterWithdrawalTransactions(transactions);
        List<Transaction> withdrawalFoodTransactions = filterFoodTransactions(withdrawalTransactions);
        return sumTransactionAmount(withdrawalFoodTransactions);
    }

    private List<Transaction> filterFoodTransactions(List<Transaction> transactions) {
        List<Transaction> withdrawalFoodTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.expenseCategory() == ExpenseCategory.ENTERTAINMENT) {
                withdrawalFoodTransactions.add(transaction);
            }
        }
        return withdrawalFoodTransactions;
    }

}
