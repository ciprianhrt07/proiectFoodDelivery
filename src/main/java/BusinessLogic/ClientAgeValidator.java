package BusinessLogic;

import Model.Client;

/**
 * Clasa implementeaza interfata Validator
 * pentru un client ce are varsta cuprinsa
 * intre 14-70 va fi valid altfel nu
 *
 */
public class ClientAgeValidator implements Validator<Client> {


    private static final int varstaMinima =14;
    private static final int varstaMaxma =70;

    /**
     * Compara valoarea varstei introduse cu intervalul acceptat
     * @param client
     * @return true daca indeplineste conditia
     *          false altfel
     */
    @Override
    public boolean valideaza(Client client) {


        if(client.getAge()<14||client.getAge()>70)
            return false;
             else
            return true;
    }
}
