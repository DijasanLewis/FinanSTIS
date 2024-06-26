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

    public boolean addTransaction(Transaction transaction) {
        boolean success = databaseOperations.addTransaction(transaction);
        if (success) {
            return updateBalance(transaction.getBalanceId(), transaction.getAmount(), transaction.getType());
        }
        return false;
    }

    public boolean updateBalance(int balanceId, double amount, String transactionType) {
        return databaseOperations.updateBalance(balanceId, amount, transactionType);
    }

    public List<Balance> getAllBalances(int userId) {
        return databaseOperations.getAllBalances(userId);
    }

    public List<Transaction> getAllTransactions(int userId) {
        return databaseOperations.getAllTransactions(userId);
    }
    
    public List<Transaction> getTransactionsByPeriod(int userId, String period) {
        return databaseOperations.getTransactionsByPeriod(userId, period);
    }
    
    public int getBalanceIdByCategory(int userId, String category) {
        List<Balance> balances = getAllBalances(userId);
        for (Balance balance : balances) {
            if (balance.getCategory().equals(category)) {
                return balance.getId();
            }
        }
        return -1; // Return -1 if not found
    }
    
    public String getCategoryByBalanceId(int balanceId) {
        Balance balance = databaseOperations.getBalanceById(balanceId);
        return balance != null ? balance.getCategory() : "N/A";
    }

}