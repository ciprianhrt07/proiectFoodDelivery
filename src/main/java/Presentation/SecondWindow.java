package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clasa face posibila interactiunea dintre utilizator si tabela produse in vederea executarii
 * de operatii pe aceasta
 * Contine etichete butoane si zone de text fiecare dintre acestea fiind denumite sugestiv
 * pentru a sugera scopul lor in cadrul clasei.
 * Se pot executa operatii de inserare actualizare stergere si vizualizare a informatiilor
 * cu o simpla apasarea de buton.
 *
 *  @author Hirtescu Ciprian-Gabriel
 */


public class SecondWindow {

    private JFrame frmWindowforproducts;
    private JTextField textID;
    private JTextField textNumeProdus;
    private JTextField textStocProduse;
    private JTextField textPret;
    private JTable table;
    private JScrollPane pane;
    private JPanel panel;
    private  JButton btnAdaugaProdus;
    private JButton btnStergeprodus;
    private  JButton btnActualizeaza;
    private JButton btnVeziproduse;
    /**
     * Launch the application.
     */
  /*  public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Presentation.SecondWindow window = new Presentation.SecondWindow();
                    window.frmWindowforproducts.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    /**
     * Create the application.
     */
    public SecondWindow() {
        initialize();
    }

    /**
     * In aceasta metoda se intializeaza continutul frame-ului
     *  cu etichete butoane tabela si zone de text
     */
    private void initialize() {
        frmWindowforproducts = new JFrame();
        frmWindowforproducts.setTitle("WindowforProducts");
        frmWindowforproducts.setBounds(100, 100, 758, 559);
        frmWindowforproducts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmWindowforproducts.getContentPane().setLayout(null);

        JLabel lblID = new JLabel("ID");
        lblID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblID.setBounds(67, 10, 39, 24);
        frmWindowforproducts.getContentPane().add(lblID);

        textID = new JTextField();
        textID.setBounds(10, 32, 128, 31);
        frmWindowforproducts.getContentPane().add(textID);
        textID.setColumns(10);

        textNumeProdus = new JTextField();
        textNumeProdus.setColumns(10);
        textNumeProdus.setBounds(10, 89, 128, 31);
        frmWindowforproducts.getContentPane().add(textNumeProdus);

        textStocProduse = new JTextField();
        textStocProduse.setColumns(10);
        textStocProduse.setBounds(10, 152, 128, 31);
        frmWindowforproducts.getContentPane().add(textStocProduse);

        textPret = new JTextField();
        textPret.setColumns(10);
        textPret.setBounds(10, 219, 128, 31);
        frmWindowforproducts.getContentPane().add(textPret);

        JLabel lblNUME = new JLabel("NUME");
        lblNUME.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNUME.setBounds(51, 65, 55, 24);
        frmWindowforproducts.getContentPane().add(lblNUME);

        JLabel lblSTOCK = new JLabel("STOCK");
        lblSTOCK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblSTOCK.setBounds(51, 130, 55, 24);
        frmWindowforproducts.getContentPane().add(lblSTOCK);

        JLabel lblPRET = new JLabel("PRET");
        lblPRET.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblPRET.setBounds(60, 193, 46, 24);
        frmWindowforproducts.getContentPane().add(lblPRET);

        btnAdaugaProdus = new JButton("ADAUGA_PRODUS");
        btnAdaugaProdus.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnAdaugaProdus.setBounds(10, 260, 128, 39);
        frmWindowforproducts.getContentPane().add(btnAdaugaProdus);

        btnStergeprodus = new JButton("STERGE_PRODUS");
        btnStergeprodus.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnStergeprodus.setBounds(10, 323, 128, 39);
        frmWindowforproducts.getContentPane().add(btnStergeprodus);

        btnActualizeaza = new JButton("ACTUAL_PRODUS");
        btnActualizeaza.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnActualizeaza.setBounds(10, 388, 128, 39);
        frmWindowforproducts.getContentPane().add(btnActualizeaza);

        btnVeziproduse = new JButton("VEZI_PRODUSE");
        btnVeziproduse.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnVeziproduse.setBounds(10, 448, 128, 39);
        frmWindowforproducts.getContentPane().add(btnVeziproduse);

        table = new JTable();
        table.setRowSelectionAllowed(false);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                }
        ));

       // table.setColumnSelectionAllowed(true);
      //  table.setCellSelectionEnabled(true);
        table.setDefaultEditor(Object.class, null);
        table.setBounds(158, 32, 560, 455);

        pane = new JScrollPane(table);
        pane.setBounds(158, 32, 560, 455);

        frmWindowforproducts.setResizable(false);
        frmWindowforproducts.getContentPane().add(pane);
    }

    public JFrame getFrmWindowforproducts() {
        return frmWindowforproducts;
    }

    public void setFrmWindowforproducts(JFrame frmWindowforproducts) {
        this.frmWindowforproducts = frmWindowforproducts;
    }

    public JTextField getTextID() {
        return textID;
    }

    public void setTextID(JTextField textID) {
        this.textID = textID;
    }

    public JTextField getTextNumeProdus() {
        return textNumeProdus;
    }

    public void setTextNumeProdus(JTextField textNumeProdus) {
        this.textNumeProdus = textNumeProdus;
    }

    public JTextField getTextStocProduse() {
        return textStocProduse;
    }

    public void setTextStocProduse(JTextField textStocProduse) {
        this.textStocProduse = textStocProduse;
    }

    public JTextField getTextPret() {
        return textPret;
    }

    public void setTextPret(JTextField textPret) {
        this.textPret = textPret;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getPane() {
        return pane;
    }

    public void setPane(JScrollPane pane) {
        this.pane = pane;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getBtnAdaugaProdus() {
        return btnAdaugaProdus;
    }

    public void setBtnAdaugaProdus(JButton btnAdaugaProdus) {
        this.btnAdaugaProdus = btnAdaugaProdus;
    }

    public JButton getBtnStergeprodus() {
        return btnStergeprodus;
    }

    public void setBtnStergeprodus(JButton btnStergeprodus) {
        this.btnStergeprodus = btnStergeprodus;
    }

    public JButton getBtnActualizeaza() {
        return btnActualizeaza;
    }

    public void setBtnActualizeaza(JButton btnActualizeaza) {
        this.btnActualizeaza = btnActualizeaza;
    }

    public JButton getBtnVeziproduse() {
        return btnVeziproduse;
    }

    public void setBtnVeziproduse(JButton btnVeziproduse) {
        this.btnVeziproduse = btnVeziproduse;
    }
}

