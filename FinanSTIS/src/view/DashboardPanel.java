/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.ExpenseController;
import java.util.HashMap;
import model.Balance;
import model.Transaction;

import javax.swing.*;
import java.util.List;
import java.util.Map;

import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Yedija Lewi Suryadi (222212921 - 2KS1 - Politeknik Statistika STIS 2024)
 */
public class DashboardPanel extends javax.swing.JPanel {

    private ExpenseController expenseController;
    private int currentUserId;
    private FinanSTISApp mainApp;

    /**
     * Creates new form DashboardPanel
     */
    public DashboardPanel(ExpenseController expenseController, int currentUserId, FinanSTISApp mainApp) {
        this.expenseController = expenseController;
        this.currentUserId = currentUserId;
        this.mainApp = mainApp;
        initComponents();
        loadData("Hari Ini");
    }

    /**
     * Load data dari database dan perbarui tampilan.
     */
    public void loadData(String period) {
        System.out.println("Memuat saldo untuk user id: " + currentUserId);
        // Muat saldo
        List<Balance> balances = expenseController.getAllBalances(currentUserId);
        for (Balance balance : balances) {
            System.out.println("Saldo ditemukan: " + balance.getCategory() + " - " + balance.getAmount());
            switch (balance.getCategory()) {
                case "Tunai":
                    tunaiLabel.setText("  Tunai        : " + balance.getAmount());
                    break;
                case "Bank":
                    bankLabel.setText("  Bank         : " + balance.getAmount());
                    break;
                case "E-Money":
                    eMoneyLabel.setText("  E-Money   : " + balance.getAmount());
                    break;
                case "Lainnya":
                    lainnyaLabel.setText("  Lain-lain   : " + balance.getAmount());
                    break;
                default:
                    break;
            }
        }

        // Muat pengeluaran dan pemasukan
        List<Transaction> transactions = expenseController.getTransactionsByPeriod(currentUserId, period);
        double totalPengeluaran = 0;
        double totalPemasukan = 0;
        Map<String, Double> pengeluaranKategori = new HashMap<>();

        for (Transaction transaction : transactions) {
            if ("Pengeluaran".equals(transaction.getType())) {
                totalPengeluaran += transaction.getAmount();
                pengeluaranKategori.merge(transaction.getCategory(), transaction.getAmount(), Double::sum);
                System.out.println("Pengeluaran ditemukan: " + transaction.getAmount() + " pada kategori: " + transaction.getCategory());
            } else if ("Pemasukan".equals(transaction.getType())) {
                totalPemasukan += transaction.getAmount();
                System.out.println("Pemasukan ditemukan: " + transaction.getAmount() + " pada kategori: " + transaction.getCategory());
            }
        }

        pengeluaranLabel.setText("Total Pengeluaran: " + totalPengeluaran);

        // Setel ulang label
        resetCategoryLabels();

        // Update label berdasarkan kategori
        for (Map.Entry<String, Double> entry : pengeluaranKategori.entrySet()) {
            String kategori = entry.getKey();
            double totalKategori = entry.getValue();
            double persentase = (totalKategori / totalPengeluaran) * 100;
            String text = String.format("  %-14s: %10.2f (%6.2f%%)", kategori, totalKategori, persentase);

            switch (kategori) {
                case "Makanan":
                    makananLabel.setText(text);
                    break;
                case "Tagihan":
                    tagihanLabel.setText(text);
                    break;
                case "Transportasi":
                    transportasiLabel.setText(text);
                    break;
                case "Hiburan":
                    hiburanLabel.setText(text);
                    break;
                case "Kesehatan":
                    kesehatanLabel.setText(text);
                    break;
                case "Lainnya":
                    pengeluaranLainnyaLabel.setText(text);
                    break;
                case "Investasi":
                    investasiLabel.setText(text);
                    break;
                case "Sedekah":
                    sedekahLabel.setText(text);
                    break;
                case "Pendidikan":
                    pendidikanLabel.setText(text);
                    break;
                default:
                    break;
            }
        }
    }

    private void resetCategoryLabels() {
        makananLabel.setText("  Makanan        :");
        tagihanLabel.setText("  Tagihan          :");
        transportasiLabel.setText("  Transportasi   :");
        hiburanLabel.setText("  Hiburan          :");
        kesehatanLabel.setText("  Kesehatan      :");
        pengeluaranLainnyaLabel.setText("  Lain-lain          :");
        investasiLabel.setText("  Investasi         :");
        sedekahLabel.setText("  Sedekah          :");
        pendidikanLabel.setText("  Pendidikan     :");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        finanSTISPanel = new javax.swing.JPanel();
        finanSTISLabel = new javax.swing.JLabel();
        saldoPanel = new javax.swing.JPanel();
        saldoLabel = new javax.swing.JLabel();
        tunaiLabel = new javax.swing.JLabel();
        bankLabel = new javax.swing.JLabel();
        eMoneyLabel = new javax.swing.JLabel();
        lainnyaLabel = new javax.swing.JLabel();
        tambahSaldoButton = new javax.swing.JButton();
        transferSaldoButton = new javax.swing.JButton();
        pengeluaranPanel = new javax.swing.JPanel();
        pengeluaranLabel = new javax.swing.JLabel();
        makananLabel = new javax.swing.JLabel();
        tagihanLabel = new javax.swing.JLabel();
        transportasiLabel = new javax.swing.JLabel();
        hiburanLabel = new javax.swing.JLabel();
        kesehatanLabel = new javax.swing.JLabel();
        pengeluaranLainnyaLabel = new javax.swing.JLabel();
        investasiLabel = new javax.swing.JLabel();
        sedekahLabel = new javax.swing.JLabel();
        pendidikanLabel = new javax.swing.JLabel();
        periodePengeluaranComboBox = new javax.swing.JComboBox<>();
        tambahPengeluaranButton = new javax.swing.JButton();
        buatLaporanPanel = new javax.swing.JPanel();
        buatLaporanLabel = new javax.swing.JLabel();
        exportCSVButton = new javax.swing.JButton();

        finanSTISLabel.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        finanSTISLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finanSTISLabel.setText("FinanSTIS");

        saldoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saldoLabel.setText("Saldo");

        tunaiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tunaiLabel.setText("  Tunai        :");

        bankLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bankLabel.setText("  Bank         :");

        eMoneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        eMoneyLabel.setText("  E-Money   :");

        lainnyaLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lainnyaLabel.setText("  Lain-lain   :");

        tambahSaldoButton.setText("TAMBAH SALDO");
        tambahSaldoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahSaldoButtonActionPerformed(evt);
            }
        });

        transferSaldoButton.setText("TRANSFER SALDO");
        transferSaldoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferSaldoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout saldoPanelLayout = new javax.swing.GroupLayout(saldoPanel);
        saldoPanel.setLayout(saldoPanelLayout);
        saldoPanelLayout.setHorizontalGroup(
            saldoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saldoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(saldoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lainnyaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eMoneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bankLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tunaiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saldoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, saldoPanelLayout.createSequentialGroup()
                        .addComponent(tambahSaldoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transferSaldoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(109, 109, 109))
        );
        saldoPanelLayout.setVerticalGroup(
            saldoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saldoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saldoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tunaiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bankLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eMoneyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lainnyaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(saldoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahSaldoButton)
                    .addComponent(transferSaldoButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pengeluaranLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pengeluaranLabel.setText("Pengeluaran");

        makananLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        makananLabel.setText("  Makanan        :");

        tagihanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tagihanLabel.setText("  Tagihan          :");

        transportasiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        transportasiLabel.setText("  Transportasi   :");

        hiburanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hiburanLabel.setText("  Hiburan          :");

        kesehatanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kesehatanLabel.setText("  Kesehatan      :");

        pengeluaranLainnyaLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pengeluaranLainnyaLabel.setText("  Lain-lain          :");

        investasiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        investasiLabel.setText("  Investasi         :");

        sedekahLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sedekahLabel.setText("  Sedekah          :");

        pendidikanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pendidikanLabel.setText("  Pendidikan     :");

        periodePengeluaranComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hari Ini", "7 Hari", "30 hari" }));
        periodePengeluaranComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodePengeluaranComboBoxActionPerformed(evt);
            }
        });

        tambahPengeluaranButton.setText("TAMBAH PENGELUARAN");
        tambahPengeluaranButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahPengeluaranButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pengeluaranPanelLayout = new javax.swing.GroupLayout(pengeluaranPanel);
        pengeluaranPanel.setLayout(pengeluaranPanelLayout);
        pengeluaranPanelLayout.setHorizontalGroup(
            pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengeluaranPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(investasiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sedekahLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pendidikanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hiburanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transportasiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(makananLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tambahPengeluaranButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kesehatanLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pengeluaranLainnyaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pengeluaranPanelLayout.createSequentialGroup()
                        .addComponent(pengeluaranLabel)
                        .addGap(18, 18, 18)
                        .addComponent(periodePengeluaranComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tagihanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        pengeluaranPanelLayout.setVerticalGroup(
            pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengeluaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pengeluaranLabel)
                    .addComponent(periodePengeluaranComboBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makananLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tagihanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transportasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiburanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kesehatanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendidikanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sedekahLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(investasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pengeluaranLainnyaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tambahPengeluaranButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buatLaporanLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buatLaporanLabel.setText("Buat Laporan");

        exportCSVButton.setText("Ekspor ke CSV");
        exportCSVButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportCSVButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buatLaporanPanelLayout = new javax.swing.GroupLayout(buatLaporanPanel);
        buatLaporanPanel.setLayout(buatLaporanPanelLayout);
        buatLaporanPanelLayout.setHorizontalGroup(
            buatLaporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buatLaporanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buatLaporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buatLaporanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(exportCSVButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buatLaporanPanelLayout.setVerticalGroup(
            buatLaporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buatLaporanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buatLaporanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exportCSVButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout finanSTISPanelLayout = new javax.swing.GroupLayout(finanSTISPanel);
        finanSTISPanel.setLayout(finanSTISPanelLayout);
        finanSTISPanelLayout.setHorizontalGroup(
            finanSTISPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finanSTISPanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(finanSTISPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(finanSTISLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(buatLaporanPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pengeluaranPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saldoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        finanSTISPanelLayout.setVerticalGroup(
            finanSTISPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finanSTISPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finanSTISLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(pengeluaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buatLaporanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(finanSTISPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambahPengeluaranButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahPengeluaranButtonActionPerformed
        // TODO add your handling code here:
        mainApp.showView("pengeluaran");
    }//GEN-LAST:event_tambahPengeluaranButtonActionPerformed

    private void exportCSVButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportCSVButtonActionPerformed
        // TODO add your handling code here:
        exportToCSV();
    }//GEN-LAST:event_exportCSVButtonActionPerformed

    private void periodePengeluaranComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodePengeluaranComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedPeriod = (String) periodePengeluaranComboBox.getSelectedItem();
        System.out.println("Periode Pengeluaran Dipilih: " + selectedPeriod);
        loadData(selectedPeriod);
    }//GEN-LAST:event_periodePengeluaranComboBoxActionPerformed

    private void tambahSaldoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahSaldoButtonActionPerformed
        // TODO add your handling code here:
        mainApp.showView("pemasukan");
    }//GEN-LAST:event_tambahSaldoButtonActionPerformed

    private void transferSaldoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferSaldoButtonActionPerformed
        // TODO add your handling code here:
        mainApp.showView("transfer");
    }//GEN-LAST:event_transferSaldoButtonActionPerformed

    private void exportToCSV() {
        List<Transaction> transactions = expenseController.getAllTransactions(currentUserId);
        String filePath = "transaksi_" + currentUserId + ".csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Tipe,Tanggal,Kategori Pengeluaran,Jumlah,Deskripsi,Sumber\n");

            for (Transaction transaction : transactions) {
                String line = String.format("%s,%s,%s,%f,%s,%s\n",
                    transaction.getType(),
                    transaction.getDate(),
                    transaction.getCategory(),
                    transaction.getAmount(),
                    transaction.getDescription(),
                    expenseController.getCategoryByBalanceId(transaction.getBalanceId())
                );
                writer.write(line);
            }

            JOptionPane.showMessageDialog(this, "Transaksi berhasil diekspor ke " + filePath, "Ekspor Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mengekspor transaksi. Coba lagi.", "Ekspor Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bankLabel;
    private javax.swing.JLabel buatLaporanLabel;
    private javax.swing.JPanel buatLaporanPanel;
    private javax.swing.JLabel eMoneyLabel;
    private javax.swing.JButton exportCSVButton;
    private javax.swing.JLabel finanSTISLabel;
    private javax.swing.JPanel finanSTISPanel;
    private javax.swing.JLabel hiburanLabel;
    private javax.swing.JLabel investasiLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kesehatanLabel;
    private javax.swing.JLabel lainnyaLabel;
    private javax.swing.JLabel makananLabel;
    private javax.swing.JLabel pendidikanLabel;
    private javax.swing.JLabel pengeluaranLabel;
    private javax.swing.JLabel pengeluaranLainnyaLabel;
    private javax.swing.JPanel pengeluaranPanel;
    private javax.swing.JComboBox<String> periodePengeluaranComboBox;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JPanel saldoPanel;
    private javax.swing.JLabel sedekahLabel;
    private javax.swing.JLabel tagihanLabel;
    private javax.swing.JButton tambahPengeluaranButton;
    private javax.swing.JButton tambahSaldoButton;
    private javax.swing.JButton transferSaldoButton;
    private javax.swing.JLabel transportasiLabel;
    private javax.swing.JLabel tunaiLabel;
    // End of variables declaration//GEN-END:variables
}
