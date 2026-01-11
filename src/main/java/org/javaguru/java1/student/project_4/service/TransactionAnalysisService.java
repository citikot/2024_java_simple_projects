package org.javaguru.java1.student.project_4.service;

import org.javaguru.java1.student.project_4.domain.Transaction;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionAnalysisService {

    public List<Transaction> findTransactionsByYear(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(transaction -> transaction.year() == year)
                .toList();
    }

    public List<Transaction> sortTransactionsASC(List<Transaction> transactions) {
        return transactions.stream()
                .sorted(Comparator.comparingInt(Transaction::value))
                .toList();
    }

    public List<Transaction> sortTransactionsDESC(List<Transaction> transactions) {
        return transactions.stream()
                .sorted(Comparator.comparingInt(Transaction::value).reversed())
                .toList();
    }

    public List<Transaction> findByYearAndSortAsc(List<Transaction> transactions, int year) {
        return findTransactionsByYear(transactions, year).stream()
                .sorted(Comparator.comparingInt(Transaction::value))
                .toList();
    }

    public Set<Integer> findUniqueYears(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::year)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    public Set<String> findUniqueNames(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.trader().name())
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    public Set<String> findUniqueCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.trader().city())
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    public Set<String> findUniqueNamesFromCities(List<Transaction> transactions, String city) {
        return transactions.stream()
                .filter(transaction -> transaction.trader().city().equals(city))
                .map(transaction -> transaction.trader().name())
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }
}
