package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;

/**
 *  Aceasta clasa a fost creata pentru a realiza interactiunea cu tabela asociata
 *  clientilor ; exista butoane textfield-uri si etichete destul de sugestive pentru rolul fiecareia
 *  -> cele 4 textfield-uri au asociate etichete pentru datele ce se doresc a fi inserate in locatiile respective
 *  -> urmatoarele 4 butoane o data ce vor fi apasate vor putea face opratii de :
 *     ->inserare
 *     ->stergere
 *     ->actualizare
 *     la nivelul tabelei asociate clientilor , daca datele sunt valide
 *  -> butonul vezi_clienti este in legatura cu locul liber din partea dreapta a stivei de butoane , loc in care
 *     o data ce acesta este apasat face ca informatiile stocate in BD sa fie vizibile.
 * @author Hirtescu Ciprian-Gabriel
 */


public class FirstWindow {

    private JFrame frmWindowforadding;
    private JTextField textID;
    private JTextField textNume;
    private JTextField textAdresa;
    private JTextField textEmail;
    private JTextField textVarsta;
    private JTable table;
    private Container container;
    private JScrollPane pane;
    private JPanel panel;
    private  JButton btnAdaugaClient;
    private   JButton btnStergeclient;
    private JButton btnVizualizeazaClienti;
    private JButton btnActulizeazaClient;

    public JButton getBtnAdaugaClient() {
        return btnAdaugaClient;
    }

    public void setBtnAdaugaClient(JButton btnAdaugaClient) {
        this.btnAdaugaClient = btnAdaugaClient;
    }

    public JButton getBtnStergeclient() {
        return btnStergeclient;
    }

    public void setBtnStergeclient(JButton btnStergeclient) {
        this.btnStergeclient = btnStergeclient;
    }

    public JButton getBtnVizualizeazaClienti() {
        return btnVizualizeazaClienti;
    }

    public void setBtnVizualizeazaClienti(JButton btnVizualizeazaClienti) {
        this.btnVizualizeazaClienti = btnVizualizeazaClienti;
    }

    public JButton getBtnActulizeazaClient() {
        return btnActulizeazaClient;
    }

    public void setBtnActulizeazaClient(JButton btnActulizeazaClient) {
        this.btnActulizeazaClient = btnActulizeazaClient;
    }
/**
     * Launch the application.
     */
   /* public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Presentation.FirstWindow window = new Presentation.FirstWindow();
                    window.frmWindowforadding.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
*/
    /**
     * Create the application.
     */
    public FirstWindow() {
        initialize();
    }

    /**
     * Se initializeaza continutul frame-ului cu butoanele , textfield-urile si etichetele.
     */
    private void initialize() {
        frmWindowforadding = new JFrame();
        frmWindowforadding.getContentPane().setForeground(Color.GREEN);
        frmWindowforadding.setTitle("WindowforClients");
        frmWindowforadding.setBounds(100, 100, 696, 497);
        frmWindowforadding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmWindowforadding.getContentPane().setLayout(null);

        textID = new JTextField();
        textID.setBounds(10, 29, 125, 29);
        frmWindowforadding.getContentPane().add(textID);
        textID.setColumns(10);

        textNume = new JTextField();
        textNume.setColumns(10);
        textNume.setBounds(10, 75, 125, 29);
        frmWindowforadding.getContentPane().add(textNume);

        textAdresa = new JTextField();
        textAdresa.setColumns(10);
        textAdresa.setBounds(10, 125, 125, 29);
        frmWindowforadding.getContentPane().add(textAdresa);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(10, 173, 125, 29);
        frmWindowforadding.getContentPane().add(textEmail);

        textVarsta = new JTextField();
        textVarsta.setColumns(10);
        textVarsta.setBounds(10, 222, 125, 29);
        frmWindowforadding.getContentPane().add(textVarsta);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel.setBounds(56, 10, 83, 24);
        frmWindowforadding.getContentPane().add(lblNewLabel);

        JLabel lblNume = new JLabel("NUME");
        lblNume.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNume.setBounds(43, 56, 102, 24);
        frmWindowforadding.getContentPane().add(lblNume);

        JLabel lblAdresa = new JLabel("ADRESA");
        lblAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblAdresa.setBounds(43, 103, 62, 24);
        frmWindowforadding.getContentPane().add(lblAdresa);

        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblEmail.setBounds(43, 153, 62, 24);
        frmWindowforadding.getContentPane().add(lblEmail);

        JLabel lblVarsta = new JLabel("VARSTA");
        lblVarsta.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblVarsta.setBounds(48, 201, 110, 24);
        frmWindowforadding.getContentPane().add(lblVarsta);

         btnAdaugaClient = new JButton("ADAUGA_CLIENT");
        btnAdaugaClient.setBounds(10, 261, 149, 37);
        frmWindowforadding.getContentPane().add(btnAdaugaClient);

        btnStergeclient = new JButton("STERGE_CLIENT");
        btnStergeclient.setBounds(9, 308, 149, 36);
        frmWindowforadding.getContentPane().add(btnStergeclient);



        btnVizualizeazaClienti = new JButton("VEZI_CLIENTI");
        btnVizualizeazaClienti.setBounds(10, 401, 149, 36);
        frmWindowforadding.getContentPane().add(btnVizualizeazaClienti);


        btnActulizeazaClient = new JButton("ACTUAL_CLIENT");
        btnActulizeazaClient.setBounds(10, 354, 149, 36);
        frmWindowforadding.getContentPane().add(btnActulizeazaClient);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                }
        ));
		  /*  private static void showFrame() {
        JPanel panel = new ScrollableJTable();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScrollableJTable::showFrame);
    }
    */



      //  table.setColumnSelectionAllowed(true);
     //   table.setCellSelectionEnabled(true);
        table.setDefaultEditor(Object.class, null);
        table.setBounds(165, 29, 479, 405);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);



        pane = new JScrollPane(table);
        pane.setBounds(165, 29, 479, 405);



        frmWindowforadding.setResizable(false);
        frmWindowforadding.getContentPane().add(pane);


    }

    public JFrame getFrmWindowforadding() {
        return frmWindowforadding;
    }

    public void setFrmWindowforadding(JFrame frmWindowforadding) {
        this.frmWindowforadding = frmWindowforadding;
    }

    public JTextField getTextID() {
        return textID;
    }

    public void setTextID(JTextField textID) {
        this.textID = textID;
    }

    public JTextField getTextNume() {
        return textNume;
    }

    public void setTextNume(JTextField textNume) {
        this.textNume = textNume;
    }

    public JTextField getTextAdresa() {
        return textAdresa;
    }

    public void setTextAdresa(JTextField textAdresa) {
        this.textAdresa = textAdresa;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(JTextField textEmail) {
        this.textEmail = textEmail;
    }

    public JTextField getTextVarsta() {
        return textVarsta;
    }

    public void setTextVarsta(JTextField textVarsta) {
        this.textVarsta = textVarsta;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
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
}
