package BusinessLogic;

/**
 *
 * @param <T> interfata generica folositoare pentru mai multe obiecte ce impart aceeasi metoda
 *           in acest caz metoda valideaza.
 */

public interface Validator<T> {

    public boolean valideaza(T t);


}
