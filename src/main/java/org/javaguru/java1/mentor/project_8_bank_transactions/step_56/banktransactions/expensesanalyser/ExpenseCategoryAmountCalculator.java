package org.javaguru.java1.mentor.project_8_bank_transactions.step_56.banktransactions.expensesanalyser;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_56.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_56.banktransactions.domain.ExpenseCategory;

import java.util.HashMap;
import java.util.Map;

class ExpenseCategoryAmountCalculator {

    public Map<ExpenseCategory, Integer> calculate(BankAccount bankAccount) {
        Map<ExpenseCategory, Integer> expensesByCategory = new HashMap<>();

        FoodExpensesCalculator foodExpensesCalculator = new FoodExpensesCalculator();
        int foodExpenseAmount = foodExpensesCalculator.calculateExpensesAmount(bankAccount);
        expensesByCategory.put(ExpenseCategory.FOOD, foodExpenseAmount);

        EntertainmentExpensesCalculator entertainmentExpensesCalculator = new EntertainmentExpensesCalculator();
        int entertainmentExpenseAmount = entertainmentExpensesCalculator.calculateExpensesAmount(bankAccount);
        expensesByCategory.put(ExpenseCategory.ENTERTAINMENT, entertainmentExpenseAmount);

        LoansExpensesCalculator loansExpensesCalculator = new LoansExpensesCalculator();
        int loansExpenseAmount = loansExpensesCalculator.calculateExpensesAmount(bankAccount);
        expensesByCategory.put(ExpenseCategory.LOANS, loansExpenseAmount);

        OthersExpensesCalculator othersExpensesCalculator = new OthersExpensesCalculator();
        int othersExpenseAmount = othersExpensesCalculator.calculateExpensesAmount(bankAccount);
        expensesByCategory.put(ExpenseCategory.OTHERS, othersExpenseAmount);

        CommunalPaymentsExpensesCalculator communalPaymentsExpensesCalculator = new CommunalPaymentsExpensesCalculator();
        int communalPaymentsExpenseAmount = communalPaymentsExpensesCalculator.calculateExpensesAmount(bankAccount);
        expensesByCategory.put(ExpenseCategory.COMMUNAL_PAYMENTS, communalPaymentsExpenseAmount);

        GamblingExpensesCalculator gamblingExpensesCalculator = new GamblingExpensesCalculator();
        int gamblingExpenseAmount = gamblingExpensesCalculator.calculateExpensesAmount(bankAccount);
        expensesByCategory.put(ExpenseCategory.GAMBLING, gamblingExpenseAmount);

        return expensesByCategory;
    }

}
