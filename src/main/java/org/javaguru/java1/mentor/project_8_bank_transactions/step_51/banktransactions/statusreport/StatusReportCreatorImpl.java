package org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.statusreport;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.currentbalance.CurrentBalanceCalculator;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.depositamount.DepositAmountCalculator;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.domain.BankAccount;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.domain.Transaction;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.maxbalance.MaxBalanceCalculator;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.minbalance.MinBalanceCalculator;
import org.javaguru.java1.mentor.project_8_bank_transactions.step_51.banktransactions.withdrawalamount.WithdrawalAmountCalculator;

class StatusReportCreatorImpl implements StatusReportCreator {

    private CurrentBalanceCalculator currentBalanceCalculator;
    private DepositAmountCalculator depositAmountCalculator;
    private WithdrawalAmountCalculator withdrawalAmountCalculator;
    private MaxBalanceCalculator maxBalanceCalculator;
    private MinBalanceCalculator minBalanceCalculator;

    public StatusReportCreatorImpl(CurrentBalanceCalculator currentBalanceCalculator,
                                   DepositAmountCalculator depositAmountCalculator,
                                   WithdrawalAmountCalculator withdrawalAmountCalculator,
                                   MaxBalanceCalculator maxBalanceCalculator,
                                   MinBalanceCalculator minBalanceCalculator) {
        this.currentBalanceCalculator = currentBalanceCalculator;
        this.depositAmountCalculator = depositAmountCalculator;
        this.withdrawalAmountCalculator = withdrawalAmountCalculator;
        this.maxBalanceCalculator = maxBalanceCalculator;
        this.minBalanceCalculator = minBalanceCalculator;
    }

    @Override
    public String create(BankAccount bankAccount) {
        StringBuilder reportBuilder = new StringBuilder();
        createTransactionListSection(bankAccount, reportBuilder);
        createSummarySection(bankAccount, reportBuilder);
        return reportBuilder.toString();
    }

    private void createTransactionListSection(BankAccount bankAccount,
                                              StringBuilder reportBuilder) {
        reportBuilder.append("Transaction list:");
        reportBuilder.append(System.lineSeparator());

        for (Transaction transaction : bankAccount.getTransactions()) {
            reportBuilder.append(transaction.transactionType().name());
            reportBuilder.append(" ");
            reportBuilder.append(transaction.amount());
            reportBuilder.append(System.lineSeparator());
        }

        reportBuilder.append(System.lineSeparator());
    }

    private void createSummarySection(BankAccount bankAccount,
                                      StringBuilder reportBuilder) {
        reportBuilder.append("Summary:");
        reportBuilder.append("Starting balance: 0");

        int currentBalance = currentBalanceCalculator.calculate(bankAccount);
        reportBuilder.append("Current Balance: " + currentBalance);

        int depositAmount = depositAmountCalculator.calculate(bankAccount);
        reportBuilder.append("Deposit sum: " + depositAmount);
        reportBuilder.append(System.lineSeparator());

        int withdrawalAmount = withdrawalAmountCalculator.calculate(bankAccount);
        reportBuilder.append("Withdrawal sum: " + withdrawalAmount);
        reportBuilder.append(System.lineSeparator());

        int maxBalance = maxBalanceCalculator.calculate(bankAccount);
        reportBuilder.append("Max balance: " + maxBalance);
        reportBuilder.append(System.lineSeparator());

        int minBalance = minBalanceCalculator.calculate(bankAccount);
        reportBuilder.append("Min balance: " + minBalance);
        reportBuilder.append(System.lineSeparator());
    }

}
