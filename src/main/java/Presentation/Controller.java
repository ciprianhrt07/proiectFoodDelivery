package Presentation;
import Model.*;
import Presentation.View;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Connection.*;
import BusinessLogic.*;
import DataAcces.*;
import com.mysql.cj.x.protobuf.MysqlxCrud;

public class Controller {

    private View view;
    private Model model;

    public Controller (View view , Model model)
    {
        this.view=view;
        this.model=model;


        view.getDecission().getBtnShowClients().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

               view.getFirstWindow().getFrmWindowforadding().setVisible(true);
               view.getSecondWindow().getFrmWindowforproducts().setVisible(false);
               view.getThirdWindow().getFrmPlaceanorder().setVisible(false);
            }
        });

        view.getDecission().getBtnShowProducts().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.getFirstWindow().getFrmWindowforadding().setVisible(false);
                view.getSecondWindow().getFrmWindowforproducts().setVisible(true);
                view.getThirdWindow().getFrmPlaceanorder().setVisible(false);

            }
        });

        view.getDecission().getBtnShowOrders().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFirstWindow().getFrmWindowforadding().setVisible(false);
                view.getSecondWindow().getFrmWindowforproducts().setVisible(false);
                view.getThirdWindow().getFrmPlaceanorder().setVisible(true);
            }
        });


        view.getFirstWindow().getBtnVizualizeazaClienti().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientBLL clientBLL = new ClientBLL();
                List<Client> clientList = clientBLL.findAllClients();

                ArrayList<String> returnedComponents = ClientDAO.clientProperties(clientList.get(0));

                Object[][] objects = new Object[clientList.size()][5];

                for(int i=0;i<clientList.size();i++)
                {
                    objects[i][0]=clientList.get(i).getId();
                    objects[i][1]=clientList.get(i).getName();
                    objects[i][2]=clientList.get(i).getAdress();
                    objects[i][3]=clientList.get(i).getEmail();
                    objects[i][4]=clientList.get(i).getAge();


                }

            //    view.getFirstWindow().getTable().setCol

                view.getFirstWindow().getTable().setModel( new DefaultTableModel(
                        objects,
                        returnedComponents.toArray()
                ));

            }
        });

        view.getFirstWindow().getBtnAdaugaClient().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientBLL clientBLL = new ClientBLL();



                int id,age;
                String nume , email,adresa;

              try {
                  id = Integer.parseInt(view.getFirstWindow().getTextID().getText());
                  age = Integer.parseInt(view.getFirstWindow().getTextVarsta().getText());
                  nume = view.getFirstWindow().getTextNume().getText();
                  email = view.getFirstWindow().getTextEmail().getText();
                  adresa = view.getFirstWindow().getTextAdresa().getText();

                int val=  clientBLL.insertClient(new Client(id,nume,adresa,email,age));

               // if(val == -1)
               //     JOptionPane.showMessageDialog(view.getFirstWindow().getFrmWindowforadding(),"Datele nu su fost valide");

              }catch (NumberFormatException ex)
              {
                  JOptionPane.showMessageDialog(view.getFirstWindow().getFrmWindowforadding(),"Inserati o valoare intreaga pentru ID ");
              }


            }
        });

        view.getFirstWindow().getBtnActulizeazaClient().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 ClientBLL clientBLL = new ClientBLL();



                int id=0,age=0;
                String nume="" , email="",adresa="";

                try {
                    id = Integer.parseInt(view.getFirstWindow().getTextID().getText());
                    age = Integer.parseInt(view.getFirstWindow().getTextVarsta().getText());
                    nume = view.getFirstWindow().getTextNume().getText();
                    email = view.getFirstWindow().getTextEmail().getText();
                    adresa = view.getFirstWindow().getTextAdresa().getText();

                    clientBLL.update(new Client(id,nume,adresa,email,age));

                }catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(view.getFirstWindow().getFrmWindowforadding(),"Inserati o valoare intreaga ");
                }




            }
        });

        view.getFirstWindow().getBtnStergeclient().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientBLL clientBLL = new ClientBLL();
                int id = 0 ;

                try{
                    id = Integer.parseInt(view.getFirstWindow().getTextID().getText());

                    if(view.getFirstWindow().getTextEmail().getText().length()==0 && view.getFirstWindow().getTextAdresa().getText().length()==0&&view.getFirstWindow().getTextNume().getText().length()==0&&view.getFirstWindow().getTextAdresa().getText().length()==0)

                       clientBLL.deleteClient(id);
                         else
                        JOptionPane.showMessageDialog(view.getFirstWindow().getFrmWindowforadding(),"Pentru stergere este nevoie doar de id");

                }catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(view.getFirstWindow().getFrmWindowforadding(),"Inserati o valoare intreaga pentru a fi stearsa");
                }

            }
        });

     view.getSecondWindow().getBtnVeziproduse().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

             ProductBLL productBLL = new ProductBLL();
             List<Product> productList = productBLL.findAllProducts();

             ArrayList<String> returnedComponents = ProductDAO.productProperties(productList.get(0));

             Object[][] objects = new Object[productList.size()][4];

             for(int i=0;i<productList.size();i++)
             {
                 objects[i][0]=productList.get(i).getId();
                 objects[i][1]=productList.get(i).getNume();
                 objects[i][2]=productList.get(i).getStoc();
                 objects[i][3]=productList.get(i).getPret();



             }

             //    view.getFirstWindow().getTable().setCol

             view.getSecondWindow().getTable().setModel( new DefaultTableModel(
                     objects,
                     returnedComponents.toArray()
             ));

         }
     });

     view.getSecondWindow().getBtnAdaugaProdus().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

             ProductBLL productBLL= new ProductBLL();

             Product product ;

              int id,stoc,pret;
              String nume;

              try{
                   id = Integer.parseInt(view.getSecondWindow().getTextID().getText());
                   stoc = Integer.parseInt(view.getSecondWindow().getTextStocProduse().getText());
                   pret = Integer.parseInt(view.getSecondWindow().getTextPret().getText());
                   nume =  view.getSecondWindow().getTextNumeProdus().getText() ;

                   product = new Product(id,nume,stoc,pret);

                   productBLL.insertProduct(product);

                 }catch(NumberFormatException ex)
              {

                  JOptionPane.showMessageDialog(view.getFirstWindow().getFrmWindowforadding(),"Inserati o valoare intreaga pentru ID ");

              }

         }
     });

     view.getSecondWindow().getBtnStergeprodus().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

             ProductBLL productBLL = new ProductBLL();

             int id = 0;
             try{

                 id = Integer.parseInt(view.getSecondWindow().getTextID().getText());

                 if(view.getSecondWindow().getTextNumeProdus().getText().length()==0 && view.getSecondWindow().getTextPret().getText().length()==0 &&view.getSecondWindow().getTextStocProduse().getText().length()==0)

                     productBLL.deleteProduct(id);
                 else
                     JOptionPane.showMessageDialog(view.getSecondWindow().getFrmWindowforproducts(),"Pentru stergere este nevoie doar de id");



             }catch (NumberFormatException ex)
             {
                 JOptionPane.showMessageDialog(view.getSecondWindow().getFrmWindowforproducts(),"Inserati o valoare intreaga pentru a fi stearsa");
             }


         }
     });

    view.getSecondWindow().getBtnActualizeaza().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();

            int id,stoc,pret;
            String nume;

            try{

                id = Integer.parseInt(view.getSecondWindow().getTextID().getText());
                stoc = Integer.parseInt(view.getSecondWindow().getTextStocProduse().getText());
                pret = Integer.parseInt(view.getSecondWindow().getTextPret().getText());
                nume =  view.getSecondWindow().getTextNumeProdus().getText() ;


                productBLL.update(new Product(id , nume , stoc , pret));

            }catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(view.getSecondWindow().getFrmWindowforproducts(),"Inserati o valoare intreaga ");
            }

        }
    });

        final int[] numarComenzi = new int[1];

         view.getThirdWindow().getBtnRefresh().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 ClientBLL clientBLL = new ClientBLL();
                 List<Client> clientList = clientBLL.findAllClients();

                 ArrayList<String> returnedComponents = ClientDAO.clientProperties(clientList.get(0));

                 Object[][] objects = new Object[clientList.size()][5];

                 for(int i=0;i<clientList.size();i++)
                 {
                     objects[i][0]=clientList.get(i).getId();
                     objects[i][1]=clientList.get(i).getName();
                     objects[i][2]=clientList.get(i).getAdress();
                     objects[i][3]=clientList.get(i).getEmail();
                     objects[i][4]=clientList.get(i).getAge();


                 }

                 //    view.getFirstWindow().getTable().setCol

                 view.getThirdWindow().getTableWithClients().setModel( new DefaultTableModel(
                         objects,
                         returnedComponents.toArray()
                 ));

                 ProductBLL productBLL = new ProductBLL();
                 List<Product> productList = productBLL.findAllProducts();

                 ArrayList<String> returnedComponent = ProductDAO.productProperties(productList.get(0));

                 Object[][] object = new Object[productList.size()][4];

                 for(int i=0;i<productList.size();i++)
                 {
                     object[i][0]=productList.get(i).getId();
                     object[i][1]=productList.get(i).getNume();
                     object[i][2]=productList.get(i).getStoc();
                     object[i][3]=productList.get(i).getPret();



                 }

                 view.getThirdWindow().getTableWithProducts().setModel( new DefaultTableModel(
                         object,
                         returnedComponent.toArray()
                 ));

                 ConnectionFactory connectionFactory = new ConnectionFactory();
                 Connection connection = ConnectionFactory.getConnection();

                 OrderBLL orderBLL = new OrderBLL();

                 List<Orders> ordersList = orderBLL.findAllOrders();

                 ArrayList<String> returnedInfo = OrdersDAO.productProperties(ordersList.get(0));

                // numarComenzi[0] = ordersList.get(ordersList.size()-1).getIdClient();

                 int max=-1;


                 if(ordersList.size()>=1)
                 numarComenzi[0] = ordersList.get(ordersList.size()-1).getId();
                   else
                 numarComenzi[0] = 1;

                 Object[][] objectes = new Object[ordersList.size()][5];

                 for(int i=0;i<ordersList.size();i++)
                 {
                     objectes[i][0]=ordersList.get(i).getId();
                     objectes[i][1]=ordersList.get(i).getNumberOfProducts();
                     objectes[i][2]=ordersList.get(i).getIdClient();
                     objectes[i][3]=ordersList.get(i).getIdProdus();
                     objectes[i][4]=ordersList.get(i).getTotal();


                 }

                 //    view.getFirstWindow().getTable().setCol

                 view.getThirdWindow().getTableWithOrders().setModel( new DefaultTableModel(
                         objectes,
                         returnedInfo.toArray()
                 ));


             }
         });

        final Client[] client = {null};
        final Product[] produs = {null};

         view.getThirdWindow().getTableWithProducts().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

             int cnt =1;

             @Override
             public void valueChanged(ListSelectionEvent e) {

                 if(cnt%2==1) {
                     ConnectionFactory connectionFactory = new ConnectionFactory();
                     ProductBLL productBLL = new ProductBLL();
                     // System.out.println(view.getThirdWindow().getTableWithProducts().getColumnName());


                     int row = view.getThirdWindow().getTableWithProducts().getSelectedRow();
                     if(row >=0) {
                         List<Product> productList = productBLL.findAllProducts();

                         connectionFactory = new ConnectionFactory();

                         produs[0] = productBLL.findProductById(productList.get(row).getId());

                         System.out.println(produs[0].toString());

                     }


                 }
                 ++cnt;

             }
         });


         view.getThirdWindow().getTableWithClients().getSelectionModel().addListSelectionListener(new ListSelectionListener() {


             int cnt = 1;

             @Override
             public void valueChanged(ListSelectionEvent e) {


                 if(cnt%2==1)
                 {
                     ConnectionFactory connectionFactory = new ConnectionFactory();

                     ClientBLL clientBLL = new ClientBLL();

                     int row = view.getThirdWindow().getTableWithClients().getSelectedRow();
                    if(row >=0){
                     List<Client> clientList = clientBLL.findAllClients();

                     connectionFactory = new ConnectionFactory();

                     client[0]  = clientBLL.findClientById(clientList.get(row).getId());

                     System.out.println(client[0].toString());}

                 }

                 cnt++;

             }
         });

         view.getThirdWindow().getBtnNewButton().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 int idClient = client[0].getId();
                 int idProdus = produs[0].getId();

                 OrderBLL orderBLL = new OrderBLL();

                 try{
                     int numarProduse = Integer.parseInt(view.getThirdWindow().getTextCantitate().getText());
                     int idComanda = numarComenzi[0]+1;
                     System.out.println(numarComenzi);
                    int val = orderBLL.insertOrder(new Orders(idComanda,numarProduse,idClient,idProdus));

                    if(val == -1)
                    {
                        JOptionPane.showMessageDialog(view.getThirdWindow().getFrmPlaceanorder(),"Stocul nu este suficient");
                    }

                   }catch (NumberFormatException ex)
                 {
                     JOptionPane.showMessageDialog(view.getThirdWindow().getFrmPlaceanorder(),"Numarul introdus este invalid ");

                 }


             }
         });


         view.getThirdWindow().getBtnChechOut().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 ConnectionFactory connectionFactory = new ConnectionFactory();
                 OrdersDAO.factura();

             }
         });




    }


}
