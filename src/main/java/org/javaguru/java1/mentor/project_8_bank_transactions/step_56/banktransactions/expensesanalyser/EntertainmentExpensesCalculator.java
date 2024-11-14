package org.javaguru.java1.mentor.project_8_bank_transactions.step_56.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_56.banktransactions.domain.ExpenseCategory;

class EntertainmentExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.ENTERTAINMENT;
    }
}
