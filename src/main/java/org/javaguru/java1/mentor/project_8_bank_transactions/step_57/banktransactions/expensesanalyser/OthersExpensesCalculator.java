package org.javaguru.java1.mentor.project_8_bank_transactions.step_57.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_57.banktransactions.domain.ExpenseCategory;

class OthersExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.OTHERS;
    }
}

