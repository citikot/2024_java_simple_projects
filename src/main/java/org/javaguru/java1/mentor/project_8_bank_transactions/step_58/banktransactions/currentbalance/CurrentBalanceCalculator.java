package org.javaguru.java1.mentor.project_8_bank_transactions.step_58.banktransactions.currentbalance;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_58.banktransactions.domain.BankAccount;

public interface CurrentBalanceCalculator {

    int calculate(BankAccount bankAccount);

}