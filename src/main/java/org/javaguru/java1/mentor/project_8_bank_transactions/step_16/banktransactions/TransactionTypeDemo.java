package org.javaguru.java1.mentor.project_8_bank_transactions.step_16.banktransactions;

public class TransactionTypeDemo {

    public static void main(String[] args) {
        introduceVariableOfEnumType();
        assignValueToVariableOfEnumType();
        compareVariableOfEnumType();
    }

    private static void introduceVariableOfEnumType() {
        TransactionType deposit = TransactionType.DEPOSIT;
        TransactionType withdrawal = TransactionType.WITHDRAWAL;
        TransactionType transactionType = TransactionType.WITHDRAWAL;
    }

    private static void assignValueToVariableOfEnumType() {
        TransactionType transactionType = TransactionType.WITHDRAWAL;
        transactionType = TransactionType.DEPOSIT;
    }

    private static void compareVariableOfEnumType() {
        TransactionType transactionType = TransactionType.WITHDRAWAL;
        if (transactionType == TransactionType.WITHDRAWAL) {
            System.out.println("This transaction is withdrawal transaction!");
        }
        transactionType = TransactionType.DEPOSIT;
        if (transactionType == TransactionType.DEPOSIT) {
            System.out.println("This transaction is deposit transaction!");
        }
    }

}
