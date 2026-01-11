package org.javaguru.java1.student.project_4.service;

import org.javaguru.java1.student.project_4.domain.Transaction;

import java.util.List;

public class TransactionAnalysisService {

    public List<Transaction> findTransactionsByYear(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(transaction -> transaction.year() == year)
                .toList();
    }
}
