package org.javaguru.java1.mentor.project_8_bank_transactions.step_53.banktransactions.transactionapprover;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_53.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_53.banktransactions.domain.Transaction;

public interface BankAccountTransactionApprover {

    boolean approve(BankAccount bankAccount, Transaction newTransaction);

}