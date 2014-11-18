package Models;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
public class DataBase {
   public static void main(String[] args) throws SQLException {
       
       Queries q = new Queries();
       ResultSet test = q.searchREGEXP("elf");
       List<Card> list;
       
       list = q.setCards(test);
       q.con.connection.close();
       q.statement.close();
       
       for(Card c:list){
           System.out.print("" + c.getId() + " ");
           System.out.println(""+c.getName());
           //System.out.print("" + c.getCost());
           //System.out.println("" + c.getColor());
       }
         
       
   }
}
  