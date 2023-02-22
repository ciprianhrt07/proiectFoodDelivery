package BusinessLogic;

import Connection.ConnectionFactory;
import DataAcces.OrdersDAO;
import DataAcces.ProductDAO;
import Model.Orders;
import Model.Product;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *  Respectand Layered Architecture
 *   OrderBLL se ocupa de validarea inputului
 *   urmand sa apeleze executarea comezilor
 *   in caz de succes , altfel arunca o exceptie.
 */

public class OrderBLL {

    private Validator<Orders> validator;

    public OrderBLL()
    {
        this.validator = new OrderValidator();
    }

    public Orders findOrdersbyID (int id)
    {
        Orders orders = OrdersDAO.findByID(id);

        if(orders == null)
        {
            throw new NoSuchElementException(" The order with id"+ id +"was not found ");

        }

        return orders;

    }

    public List<Orders> findAllOrders()
    {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        List<Orders> ordersList = OrdersDAO.displayAllProducts();

        if(ordersList.size() == 0)
        {
            throw new NoSuchElementException(" Nu exista comenzi plasata ");
        }
        return ordersList;
    }

    public int insertOrder(Orders orders)
    {
       if(validator.valideaza(orders) == false)
       {
           throw new IllegalArgumentException(" Comanda : "+orders.toString()+ " nu a putut fi inserata din cauza nevalidarii");

       }
        ConnectionFactory connectionFactory  = new ConnectionFactory();

       return  OrdersDAO.insert(orders);

    }

}
