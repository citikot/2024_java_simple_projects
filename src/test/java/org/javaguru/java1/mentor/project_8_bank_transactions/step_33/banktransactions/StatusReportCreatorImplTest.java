package org.javaguru.java1.mentor.project_8_bank_transactions.step_33.banktransactions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatusReportCreatorImplTest {

    @Mock private CurrentBalanceCalculator currentBalanceCalculator;
    @Mock private DepositAmountCalculator depositAmountCalculator;
    @Mock private WithdrawalAmountCalculator withdrawalAmountCalculator;
    @Mock private MaxBalanceCalculator maxBalanceCalculator;
    @Mock private MinBalanceCalculator minBalanceCalculator;

    @InjectMocks
    private StatusReportCreatorImpl reportCreator;

    @Test
    public void shouldCreateReport() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT),
                        ImmutableTransaction.of(50, TransactionType.WITHDRAWAL)
                }
        );
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(50);
        when(depositAmountCalculator.calculate(bankAccount)).thenReturn(100);
        when(withdrawalAmountCalculator.calculate(bankAccount)).thenReturn(50);
        when(maxBalanceCalculator.calculate(bankAccount)).thenReturn(100);
        when(minBalanceCalculator.calculate(bankAccount)).thenReturn(0);

        String report = reportCreator.create(bankAccount);

        assertTrue(report.contains("Transaction list:"));
        assertTrue(report.contains("DEPOSIT 100"));
        assertTrue(report.contains("WITHDRAWAL 50"));

        assertTrue(report.contains("Summary:"));
        assertTrue(report.contains("Starting balance: 0"));
        assertTrue(report.contains("Current Balance: 50"));
        assertTrue(report.contains("Deposit sum: 100"));
        assertTrue(report.contains("Withdrawal sum: 50"));
        assertTrue(report.contains("Max balance: 100"));
        assertTrue(report.contains("Min balance: 0"));
    }

}