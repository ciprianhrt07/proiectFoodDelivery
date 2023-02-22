package BusinessLogic;

import Model.Product;

/**
 * Clasa implementeaza interfata Validator
 * se verifica daca exista valori negative
 * in campurile stoc si pret
 */
public class ValideazaStocSiPret implements Validator<Product> {
    /**
     *
     * @param product
     * @return  true daca nu exista valori negative in
     * campurile stoc si pret si false altfel
     */

    @Override
    public boolean valideaza(Product product) {

        if(product.getStoc()<0||product.getPret()<0)
            return false;
               else
            return true;

    }
}
