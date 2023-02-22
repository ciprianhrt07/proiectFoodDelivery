import BusinessLogic.OrderBLL;
import Connection.ConnectionFactory;
import DataAcces.OrdersDAO;
import Model.Model;
import Presentation.Controller;
import Presentation.View;

public class Main {


   public static void main(String [] args)
   {
      View view = new View();
      Model model = new Model();
      Controller controller = new Controller(view,model);
   }


}
