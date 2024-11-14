package org.javaguru.java1.mentor.project_8_bank_transactions.step_52.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_52.banktransactions.domain.ExpenseCategory;

class CommunalPaymentsExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.COMMUNAL_PAYMENTS;
    }
}
