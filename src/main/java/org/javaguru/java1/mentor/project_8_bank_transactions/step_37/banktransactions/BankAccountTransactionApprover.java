package org.javaguru.java1.mentor.project_8_bank_transactions.step_37.banktransactions;

interface BankAccountTransactionApprover {

    boolean approve(BankAccount bankAccount, Transaction newTransaction);

}