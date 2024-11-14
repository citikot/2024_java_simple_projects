package org.javaguru.java1.mentor.project_8_bank_transactions.step_41.banktransactions.transactionapprover;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_41.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_41.banktransactions.domain.Transaction;

public interface BankAccountTransactionApprover {

    boolean approve(BankAccount bankAccount, Transaction newTransaction);

}