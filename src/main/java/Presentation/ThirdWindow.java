package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ThirdWindow {

    private JFrame frmPlaceanorder;
    private JTable tableWithProducts;
    private JTable tableWithClients;
    private JTable tableWithOrders;
    private JScrollPane pane1;
    private JScrollPane pane2;
    private JScrollPane pane3;
    private JButton btnNewButton;
    private JTextField textCantitate;
    private JLabel lblCantitate;
    private JLabel lblNewLabel;
    private JLabel lblClienti;
    private JLabel lblComenzi;
    private JButton btnRefresh;
    private JButton btnChechOut;


/**
     * Launch the application.
     */
  /*  public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Presentation.ThirdWindow window = new Presentation.ThirdWindow();
                    window.frmPlaceanorder.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    /**
     * Create the application.
     */
    public ThirdWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmPlaceanorder = new JFrame();
        frmPlaceanorder.setTitle("Place_an_Order");
        frmPlaceanorder.setBounds(100, 100, 784, 800);
        frmPlaceanorder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPlaceanorder.getContentPane().setLayout(null);

        tableWithProducts = new JTable();
        tableWithProducts.setDefaultEditor(Object.class, null);
        tableWithProducts.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                }
        ));
        tableWithProducts.setBounds(10, 34, 750, 155);
        tableWithProducts.setColumnSelectionAllowed(true);
        tableWithProducts.setCellSelectionEnabled(true);
        pane1 = new JScrollPane(tableWithProducts);
        pane1.setBounds(10, 34, 750, 155);
        frmPlaceanorder.getContentPane().add(pane1);


        tableWithClients = new JTable();
        tableWithClients.setDefaultEditor(Object.class, null);
        tableWithClients.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                }
        ));
        tableWithClients.setBounds(10, 231, 750, 155);
        tableWithClients.setColumnSelectionAllowed(true);
        tableWithClients.setCellSelectionEnabled(true);
        pane2 = new JScrollPane(tableWithClients);
        pane2.setBounds(10, 231, 750, 155);
        frmPlaceanorder.getContentPane().add(pane2);

        tableWithOrders = new JTable();
        tableWithOrders.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                }
        ));
        tableWithOrders.setBounds(10, 428, 750, 155);
        //tableWithOrders.setColumnSelectionAllowed(true);
       // tableWithOrders.setCellSelectionEnabled(true);
        tableWithOrders.setDefaultEditor(Object.class, null);

        pane3 = new JScrollPane(tableWithOrders);
        pane3.setBounds(10, 428, 750, 155);
        frmPlaceanorder.getContentPane().add(pane3);

        btnNewButton = new JButton("PLASEAZA_COMANDA");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButton.setBounds(286, 707, 189, 33);
        frmPlaceanorder.getContentPane().add(btnNewButton);

        textCantitate = new JTextField();
        textCantitate.setBounds(317, 648, 135, 33);
        frmPlaceanorder.getContentPane().add(textCantitate);
        textCantitate.setColumns(10);

        lblCantitate = new JLabel("Cantitate");
        lblCantitate.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCantitate.setBounds(356, 613, 96, 33);

        frmPlaceanorder.setResizable(false);
        frmPlaceanorder.getContentPane().add(lblCantitate);

        lblNewLabel = new JLabel("Produse");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblNewLabel.setBounds(30, 10, 166, 14);
        frmPlaceanorder.getContentPane().add(lblNewLabel);

        lblClienti = new JLabel("Clienti");
        lblClienti.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblClienti.setBounds(30, 207, 166, 14);
        frmPlaceanorder.getContentPane().add(lblClienti);

        lblComenzi = new JLabel("Comenzi");
        lblComenzi.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblComenzi.setBounds(30, 404, 166, 14);
        frmPlaceanorder.getContentPane().add(lblComenzi);

        btnRefresh = new JButton("Refresh");
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRefresh.setBounds(72, 707, 135, 33);
        frmPlaceanorder.getContentPane().add(btnRefresh);

        btnChechOut = new JButton("Checkout");
        btnChechOut.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnChechOut.setBounds(559, 707, 145, 33);
        frmPlaceanorder.getContentPane().add(btnChechOut);

    }


    public JFrame getFrmPlaceanorder() {
        return frmPlaceanorder;
    }

    public void setFrmPlaceanorder(JFrame frmPlaceanorder) {
        this.frmPlaceanorder = frmPlaceanorder;
    }

    public JTable getTableWithProducts() {
        return tableWithProducts;
    }

    public void setTableWithProducts(JTable tableWithProducts) {
        this.tableWithProducts = tableWithProducts;
    }

    public JTable getTableWithClients() {
        return tableWithClients;
    }

    public void setTableWithClients(JTable tableWithClients) {
        this.tableWithClients = tableWithClients;
    }

    public JTable getTableWithOrders() {
        return tableWithOrders;
    }

    public void setTableWithOrders(JTable tableWithOrders) {
        this.tableWithOrders = tableWithOrders;
    }

    public JScrollPane getPane1() {
        return pane1;
    }

    public void setPane1(JScrollPane pane1) {
        this.pane1 = pane1;
    }

    public JScrollPane getPane2() {
        return pane2;
    }

    public void setPane2(JScrollPane pane2) {
        this.pane2 = pane2;
    }

    public JScrollPane getPane3() {
        return pane3;
    }

    public void setPane3(JScrollPane pane3) {
        this.pane3 = pane3;
    }

    public JButton getBtnNewButton() {
        return btnNewButton;
    }

    public void setBtnNewButton(JButton btnNewButton) {
        this.btnNewButton = btnNewButton;
    }

    public JTextField getTextCantitate() {
        return textCantitate;
    }

    public void setTextCantitate(JTextField textCantitate) {
        this.textCantitate = textCantitate;
    }

    public JLabel getLblCantitate() {
        return lblCantitate;
    }

    public void setLblCantitate(JLabel lblCantitate) {
        this.lblCantitate = lblCantitate;
    }

    public JButton getBtnRefresh() {
        return btnRefresh;
    }

    public void setBtnRefresh(JButton btnRefresh) {
        this.btnRefresh = btnRefresh;
    }
    public JButton getBtnChechOut() {
        return btnChechOut;
    }

    public void setBtnChechOut(JButton btnChechOut) {
        this.btnChechOut = btnChechOut;
    }
}


/*

table.setBounds(165, 29, 479, 405);
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);



pane = new JScrollPane(table);
pane.setBounds(165, 29, 479, 405);



frmWindowforadding.setResizable(false);
frmWindowforadding.getContentPane().add(pane);
*/