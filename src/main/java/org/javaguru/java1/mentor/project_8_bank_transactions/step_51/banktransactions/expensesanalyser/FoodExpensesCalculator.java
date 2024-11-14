package org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.domain.ExpenseCategory;

class FoodExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.FOOD;
    }
}
