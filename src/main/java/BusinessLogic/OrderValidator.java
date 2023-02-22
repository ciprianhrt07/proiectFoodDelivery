package BusinessLogic;

import Model.Orders;

/**
 * Clasa implementeaza interfata Validator
 * se verifica daca in interiorul comenzii exista valori negative
 */
public class OrderValidator implements Validator{

    /**
     *
     * @param o
     * @return true daca valorile sunt pozitive si false altfel
     */
    @Override
    public boolean valideaza(Object o) {

        Orders orders = (Orders) o;

        if(orders.getNumberOfProducts()<0||orders.getIdProdus()<0)
             return false;
               else
             return true;

    }
}
