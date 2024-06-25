package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.ExpenseController;
import model.Balance;
import model.BalanceCategory;
import model.Transaction;

public class PrototypeFinanSTISApp extends JFrame {
    private ExpenseController controller;
    private JTextField dateField;
    private JTextField categoryField;
    private JTextField amountField;
    private JTextField descriptionField;
    private JTable transactionTable;
    private JComboBox<String> balanceCategoryComboBox;
    private JLabel cashLabel;
    private JLabel bankLabel;
    private JLabel eMoneyLabel;
    private JLabel investmentLabel;
    private JLabel otherLabel;

    public PrototypeFinanSTISApp() {
        controller = new ExpenseController();

        setTitle("FinanSTIS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        loadBalances();
        loadTransactions();
        loadBalanceCategories();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JPanel balancePanel = new JPanel();
        balancePanel.setLayout(new GridLayout(1, 5));
        balancePanel.setBorder(BorderFactory.createTitledBorder("Saldo"));

        cashLabel = new JLabel("Tunai: 0");
        bankLabel = new JLabel("Bank: 0");
        eMoneyLabel = new JLabel("E-money: 0");
        investmentLabel = new JLabel("Investasi: 0");
        otherLabel = new JLabel("Lain-lain: 0");

        balancePanel.add(cashLabel);
        balancePanel.add(bankLabel);
        balancePanel.add(eMoneyLabel);
        balancePanel.add(investmentLabel);
        balancePanel.add(otherLabel);

        mainPanel.add(balancePanel, BorderLayout.NORTH);

        transactionTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(transactionTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Transaksi"));

        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Transaksi Baru"));

        inputPanel.add(new JLabel("Tanggal:"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Kategori:"));
        categoryField = new JTextField();
        inputPanel.add(categoryField);

        inputPanel.add(new JLabel("Jumlah:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("Deskripsi:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Saldo:"));
        balanceCategoryComboBox = new JComboBox<>();
        inputPanel.add(balanceCategoryComboBox);

        JButton addButton = new JButton("Tambah");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });
        inputPanel.add(addButton);

        JButton addCategoryButton = new JButton("Tambah Kategori Saldo");
        addCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBalanceCategory();
            }
        });
        inputPanel.add(addCategoryButton);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);
    }

    private void addTransaction() {
        String date = dateField.getText();
        String category = categoryField.getText();
        double amount = Double.parseDouble(amountField.getText());
        String description = descriptionField.getText();
        String balanceCategory = (String) balanceCategoryComboBox.getSelectedItem();

        Transaction transaction = new Transaction();
        transaction.setDate(date);
        transaction.setCategory(category);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setType("Pengeluaran"); // atau "Pemasukan", tergantung input

        // Dapatkan id balance dari nama kategori saldo yang dipilih
        List<BalanceCategory> balanceCategories = controller.getAllBalanceCategories();
        for (BalanceCategory bc : balanceCategories) {
            if (bc.getName().equals(balanceCategory)) {
                transaction.setBalanceId(bc.getId());
                break;
            }
        }

        controller.addTransaction(transaction);
        loadTransactions();
        loadBalances();
    }

    private void addBalanceCategory() {
        String categoryName = JOptionPane.showInputDialog(this, "Masukkan nama kategori saldo baru:");
        if (categoryName != null && !categoryName.trim().isEmpty()) {
            BalanceCategory category = new BalanceCategory();
            category.setName(categoryName);
            controller.addBalanceCategory(category);
            loadBalanceCategories();
        }
    }

    private void loadBalances() {
        List<Balance> balances = controller.getAllBalances();
        for (Balance balance : balances) {
            switch (balance.getCategory()) {
                case "Tunai":
                    cashLabel.setText("Tunai: " + balance.getAmount());
                    break;
                case "Bank":
                    bankLabel.setText("Bank: " + balance.getAmount());
                    break;
                case "E-money":
                    eMoneyLabel.setText("E-money: " + balance.getAmount());
                    break;
                case "Investasi":
                    investmentLabel.setText("Investasi: " + balance.getAmount());
                    break;
                case "Lain-lain":
                    otherLabel.setText("Lain-lain: " + balance.getAmount());
                    break;
            }
        }
    }

    private void loadTransactions() {
        List<Transaction> transactions = controller.getAllTransactions();
        // Update table model with transactions data
        // You need to implement a custom table model to display transactions data
    }

    private void loadBalanceCategories() {
        balanceCategoryComboBox.removeAllItems();
        List<BalanceCategory> categories = controller.getAllBalanceCategories();
        for (BalanceCategory category : categories) {
            balanceCategoryComboBox.addItem(category.getName());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PrototypeFinanSTISApp app = new PrototypeFinanSTISApp();
            app.setVisible(true);
        });
    }
}
