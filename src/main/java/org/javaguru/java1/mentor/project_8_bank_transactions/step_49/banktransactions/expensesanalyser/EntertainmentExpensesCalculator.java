package org.javaguru.java1.mentor.project_8_bank_transactions.step_49.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_49.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_49.banktransactions.domain.ExpenseCategory;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_49.banktransactions.domain.Transaction;

import java.util.List;

class EntertainmentExpensesCalculator extends ExpensesCalculator {

    public int calculateExpensesAmount(BankAccount bankAccount) {
        Transaction[] transactions = bankAccount.getTransactions();
        List<Transaction> withdrawalTransactions = filterWithdrawalTransactions(transactions);
        List<Transaction> withdrawalFoodTransactions = filterTransactionsByExpenseCategory(withdrawalTransactions, ExpenseCategory.ENTERTAINMENT);
        return sumTransactionAmount(withdrawalFoodTransactions);
    }

}
