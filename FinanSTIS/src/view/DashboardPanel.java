/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

/**
 *
 * @author Yedija Lewi Suryadi (222212921 - 2KS1 - Politeknik Statistika STIS 2024)
 */
public class DashboardPanel extends javax.swing.JPanel {

    /**
     * Creates new form DashboardPanel
     */
    public DashboardPanel() {
        initComponents();
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
        exportPDFButton = new javax.swing.JButton();

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

        transferSaldoButton.setText("TRANSFER SALDO");

        javax.swing.GroupLayout saldoPanelLayout = new javax.swing.GroupLayout(saldoPanel);
        saldoPanel.setLayout(saldoPanelLayout);
        saldoPanelLayout.setHorizontalGroup(
            saldoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saldoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(saldoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lainnyaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eMoneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bankLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tunaiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saldoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, saldoPanelLayout.createSequentialGroup()
                        .addComponent(tambahSaldoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(transferSaldoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                .addContainerGap())
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
        makananLabel.setText("Makanan        :");

        tagihanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tagihanLabel.setText("Tagihan          :");

        transportasiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        transportasiLabel.setText("Transportasi   :");

        hiburanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hiburanLabel.setText("Hiburan          :");

        kesehatanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kesehatanLabel.setText("Kesehatan      :");

        pengeluaranLainnyaLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pengeluaranLainnyaLabel.setText("Lain-lain          :");

        investasiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        investasiLabel.setText("Investasi         :");

        sedekahLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sedekahLabel.setText("Sedekah          :");

        pendidikanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pendidikanLabel.setText("Pendidikan     :");

        periodePengeluaranComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hari Ini", "7 Hari", "30 hari" }));

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
                .addContainerGap()
                .addGroup(pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pengeluaranPanelLayout.createSequentialGroup()
                        .addGroup(pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pengeluaranPanelLayout.createSequentialGroup()
                                .addComponent(pengeluaranLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodePengeluaranComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pengeluaranPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(kesehatanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hiburanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(transportasiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tagihanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(makananLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pengeluaranLainnyaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(investasiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sedekahLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pendidikanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tambahPengeluaranButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pengeluaranPanelLayout.setVerticalGroup(
            pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengeluaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pengeluaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pengeluaranLabel)
                    .addComponent(periodePengeluaranComboBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makananLabel)
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

        exportPDFButton.setText("Ekspor ke PDF");
        exportPDFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPDFButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buatLaporanPanelLayout = new javax.swing.GroupLayout(buatLaporanPanel);
        buatLaporanPanel.setLayout(buatLaporanPanelLayout);
        buatLaporanPanelLayout.setHorizontalGroup(
            buatLaporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buatLaporanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buatLaporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buatLaporanPanelLayout.createSequentialGroup()
                        .addComponent(buatLaporanLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(buatLaporanPanelLayout.createSequentialGroup()
                        .addComponent(exportCSVButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        buatLaporanPanelLayout.setVerticalGroup(
            buatLaporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buatLaporanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buatLaporanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buatLaporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportCSVButton)
                    .addComponent(exportPDFButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout finanSTISPanelLayout = new javax.swing.GroupLayout(finanSTISPanel);
        finanSTISPanel.setLayout(finanSTISPanelLayout);
        finanSTISPanelLayout.setHorizontalGroup(
            finanSTISPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finanSTISPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(finanSTISPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finanSTISLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(pengeluaranPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buatLaporanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(finanSTISPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(finanSTISPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(saldoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        finanSTISPanelLayout.setVerticalGroup(
            finanSTISPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finanSTISPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finanSTISLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(pengeluaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buatLaporanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
            .addGroup(finanSTISPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(finanSTISPanelLayout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(saldoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(522, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(finanSTISPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambahPengeluaranButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahPengeluaranButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahPengeluaranButtonActionPerformed

    private void exportPDFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPDFButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportPDFButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bankLabel;
    private javax.swing.JLabel buatLaporanLabel;
    private javax.swing.JPanel buatLaporanPanel;
    private javax.swing.JLabel eMoneyLabel;
    private javax.swing.JButton exportCSVButton;
    private javax.swing.JButton exportPDFButton;
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