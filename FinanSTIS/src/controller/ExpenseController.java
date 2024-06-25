package controller;

import model.Balance;
import model.BalanceCategory;
import model.Transaction;

import java.util.List;

/**
 * Controller untuk mengelola pengeluaran.
 */
public class ExpenseController {
    private DatabaseOperations databaseOperations;

    public ExpenseController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void addBalanceCategory(BalanceCategory category) {
        databaseOperations.addBalanceCategory(category);
    }

    public List<BalanceCategory> getAllBalanceCategories() {
        return databaseOperations.getAllBalanceCategories();
    }

    public void addBalance(Balance balance) {
        databaseOperations.addBalance(balance);
    }

    public void addTransaction(Transaction transaction) {
        databaseOperations.addTransaction(transaction);
    }

    public List<Balance> getAllBalances(int userId) {
        return databaseOperations.getAllBalances(userId);
    }

    public List<Transaction> getAllTransactions(int userId) {
        return databaseOperations.getAllTransactions(userId);
    }
}
