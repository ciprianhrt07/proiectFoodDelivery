package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *  Aceasta clasa este folosita pentru a interactiona cu utilizatorul
 *  Se poate face schimbarea dintre ferestre in vederea executarii de operatii specifice
 * @author Hirtescu Ciprian-Gabriel
 */


public class Decission {

    private JFrame frmFereastraprincipala;
    private JButton btnShowClients;
    private  JButton btnShowProducts;
    private  JButton btnShowOrders;
    /**
     * Launch the application.
     */
  /*  public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Presentation.Decission window = new Presentation.Decission();
                    window.frmFereastraprincipala.setVisible(true);
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
    public Decission() {
        initialize();
    }


    /**
     * Metoda initializeaza intreaga fereastra cu etichete,butoane
     * Dintre acestea se mentioneaza:
     * -> butonul din stanga face vizibila fereastra asociata clientilor
     * -> butonul din dreapta face vizibila fereastra pentru comenzi
     * -> butonul din mijloc face ca fereastra pentru produse sa apara
     * @param
     * @return
     */
    private void initialize() {
        frmFereastraprincipala = new JFrame();
        frmFereastraprincipala.setTitle("Fereastra_Principala_de_Interactiune");
        frmFereastraprincipala.setBounds(100, 100, 706, 342);
        frmFereastraprincipala.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmFereastraprincipala.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("WELCOME");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(282, 46, 152, 68);
        frmFereastraprincipala.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("For_Clients_Opperations_Press");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(25, 115, 226, 35);
        frmFereastraprincipala.getContentPane().add(lblNewLabel_1);

        btnShowClients = new JButton("Clients");
        btnShowClients.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnShowClients.setBounds(43, 172, 134, 35);
        frmFereastraprincipala.getContentPane().add(btnShowClients);

        JLabel lblNewLabel_1_1 = new JLabel("For_Products_Opperations_Press");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(261, 115, 241, 35);
        frmFereastraprincipala.getContentPane().add(lblNewLabel_1_1);

        btnShowProducts = new JButton("Products");
        btnShowProducts.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnShowProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnShowProducts.setBounds(282, 172, 134, 35);
        frmFereastraprincipala.getContentPane().add(btnShowProducts);

        JLabel lblNewLabel_1_1_1 = new JLabel("For_Orders_Press");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBounds(534, 115, 134, 35);
        frmFereastraprincipala.getContentPane().add(lblNewLabel_1_1_1);

        btnShowOrders = new JButton("Model.Orders");
        btnShowOrders.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnShowOrders.setBounds(534, 172, 134, 35);
        frmFereastraprincipala.getContentPane().add(btnShowOrders);
    }

    public JFrame getFrmFereastraprincipala() {
        return frmFereastraprincipala;
    }

    public void setFrmFereastraprincipala(JFrame frmFereastraprincipala) {
        this.frmFereastraprincipala = frmFereastraprincipala;
    }

    public JButton getBtnShowClients() {
        return btnShowClients;
    }

    public void setBtnShowClients(JButton btnShowClients) {
        this.btnShowClients = btnShowClients;
    }

    public JButton getBtnShowProducts() {
        return btnShowProducts;
    }

    public void setBtnShowProducts(JButton btnShowProducts) {
        this.btnShowProducts = btnShowProducts;
    }

    public JButton getBtnShowOrders() {
        return btnShowOrders;
    }

    public void setBtnShowOrders(JButton btnShowOrders) {
        this.btnShowOrders = btnShowOrders;
    }
}
