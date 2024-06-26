/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author yedij
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFactory {

    public static JMenuBar createMenuBar(FinanSTISApp mainApp) {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        menu.add(createMenuItem("Login", mainApp, "login"));
        menu.add(createMenuItem("Dashboard", mainApp, "dashboard"));
        menu.add(createMenuItem("Pemasukan", mainApp, "pemasukan"));
        menu.add(createMenuItem("Pengeluaran", mainApp, "pengeluaran"));
        menu.add(createMenuItem("Transfer", mainApp, "transfer"));
        menu.add(createMenuItem("Transaksi", mainApp, "transaksi"));

        return menuBar;
    }

    private static JMenuItem createMenuItem(String title, FinanSTISApp mainApp, String viewName) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if ("login".equals(viewName) || mainApp.isLoggedIn()) {
                    mainApp.showView(viewName);
                } else {
                    JOptionPane.showMessageDialog(mainApp, "Anda harus login terlebih dahulu!", "Akses Ditolak", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return menuItem;
    }
}

