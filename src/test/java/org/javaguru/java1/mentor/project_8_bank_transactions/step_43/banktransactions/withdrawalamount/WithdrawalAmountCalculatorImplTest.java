package org.javaguru.java1.mentor.project_8_bank_transactions.step_43.banktransactions.withdrawalamount;

import org.javaguru.java1.mentor.project_8_bank_transactions.step_43.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WithdrawalAmountCalculatorImplTest {

    private TransactionFactory factory = new TransactionFactory();
    private WithdrawalAmountCalculator calculator = new WithdrawalAmountCalculatorImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnWithdrawalSum() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                        factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldIgnoreDeposits() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                        factory.createDepositTransaction(100)
                }
        );
        assertEquals(100, calculator.calculate(bankAccount));
    }

}