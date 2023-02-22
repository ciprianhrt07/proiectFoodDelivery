package BusinessLogic;

import Model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *     Clasa implementeaza interfata validator
 *     folosind un pattern in care se accepta ca si email corect
 *     un emai ce are la inceput litere mici si mari 1 sau mai multe
 *     urmate sau nu de cifre , la care se adauga @ si extensia . extensie
 */
public class EmailValidator implements Validator {

    private static final String emailPattern ="([a-zA-Z]{1,})([\\d]{0,})([@\\w])([a-zA-Z]{1,})([.\\w])([a-zA-Z]{1,})";

    /**
     * Implementarea metodei din interfata
     *
     * @param o
     * @return true daca emailul respecta pattern ul false altfel
     */
    @Override
    public  boolean valideaza(Object o) {

         Client client = (Client)o;

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(client.getEmail());

        boolean ok = client.getEmail().contains("@");

        if(matcher.matches()&&ok==true)
            return  true;
              else
            return false;
    }
}

   // String  monomPattern1=  "[0-9]{1,6}[*\\w](X[^\\w])([0-9]{1,3})";
