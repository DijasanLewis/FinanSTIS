/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import model.Balance;
import model.BalanceCategory;
import model.Transaction;

import java.util.List;


/**
 *
 * @author yedij
 */

public interface DatabaseOperations {
    void addBalanceCategory(BalanceCategory category);
    List<BalanceCategory> getAllBalanceCategories();
    void addBalance(Balance balance);
    boolean addTransaction(Transaction transaction);
    boolean updateBalance(int balanceId, double amount, String transactionType);
    List<Balance> getAllBalances(int userId);
    List<Transaction> getAllTransactions(int userId);
    List<Transaction> getTransactionsByPeriod(int userId, String period);
    Balance getBalanceById(int balanceId);
}