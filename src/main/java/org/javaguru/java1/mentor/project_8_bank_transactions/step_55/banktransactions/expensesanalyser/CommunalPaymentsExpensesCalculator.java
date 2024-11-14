package org.javaguru.java1.mentor.project_8_bank_transactions.step_55.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_55.banktransactions.domain.ExpenseCategory;

class CommunalPaymentsExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.COMMUNAL_PAYMENTS;
    }
}