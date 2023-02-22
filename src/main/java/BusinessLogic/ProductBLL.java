package BusinessLogic;

import Model.Product;

import java.util.List;
import java.util.NoSuchElementException;

import DataAcces.*;
import Connection.*;

/**
 *  * Respectand Layered Architecture
 *  * ProductBLL se ocupa de validarea inputului
 *  * urmand sa apeleze executarea comezilor
 *  * in caz de succes , altfel arunca o exceptie.
 */
public class ProductBLL {

    private Validator<Product> validator;

    public ProductBLL() {
        this.validator = new ValideazaStocSiPret();
    }

    public Product findProductById(int id)
    {
        Product product = ProductDAO.findByID(id);

        if(product == null)
        {
            throw new NoSuchElementException(" Model.Product with id"+ id +"was not found ");

        }
        return product;
    }

    public int insertProduct(Product product)
    {
        boolean ok = true;

        if(validator.valideaza(product)==false)
        {
            ok=false;
            throw new IllegalArgumentException(" Clientul "+product.toString()+ " nu a putut fi inserat din cauza validarii");

        }
        ConnectionFactory connectionFactory = new ConnectionFactory();

        return ProductDAO.insert(product);

    }


    public int deleteProduct(int id)
    {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        int ok = ProductDAO.delete(id);
        if(ok == 0 )
        {
            throw new NoSuchElementException(" Model.Product with id "+ id +" was not found ");
        }else
        if(ok == -1)
        {
            throw new  NoSuchElementException(" Model.Product with id "+ id +" nu s-a putut sterge ");
        }
        else
            return 1;


    }

    public int update(Product product)
    {
        boolean ok = true;
           if(validator.valideaza(product)==false)
            {   ok =false;
                throw new IllegalArgumentException(" Produsul "+product.toString()+ " nu a putut fi validat");

            }


        ConnectionFactory connectionFactory = new ConnectionFactory();

        if(ok==true)
            ProductDAO.update(product,product.getId());

        return 1;
    }

    public List<Product> findAllProducts()
    {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        List<Product> products = ProductDAO.displayAllProducts();

        if(products.size() == 0)
        {
            throw new NoSuchElementException(" Niciun client nu a fost gasit ");

        }

        return products;
    }

}
