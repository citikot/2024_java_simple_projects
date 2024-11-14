package org.javaguru.java1.mentor.project_8_bank_transactions.step_49.banktransactions.domain;

class TransactionImpl implements Transaction {

    private int amount;

    private TransactionType transactionType;

    private ExpenseCategory expenseCategory;

    public TransactionImpl(int amount) {
        this.amount = amount;
        this.transactionType = TransactionType.DEPOSIT;
        this.expenseCategory = null;
    }

    public TransactionImpl(int amount, ExpenseCategory expenseCategory) {
        this.amount = amount;
        this.transactionType = TransactionType.WITHDRAWAL;
        this.expenseCategory = expenseCategory;
    }


    @Override
    public int amount() {
        return this.amount;
    }

    @Override
    public TransactionType transactionType() {
        return this.transactionType;
    }

    @Override
    public ExpenseCategory expenseCategory() {
        return this.expenseCategory;
    }

}
