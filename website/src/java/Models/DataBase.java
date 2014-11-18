package Models;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
public class DataBase {
   public static void main(String[] args) throws SQLException {
       
       Queries q = new Queries();
       ResultSet test = q.searchREGEXP("Elf");
       List<Card> list;
       
       list = q.setCards(test);
       //q.statement.close();
       
       for(Card c:list){
           System.out.print("" + c.getId() + " ");
           System.out.print(""+c.getCardloyalty()+" ");
           System.out.println(""+c.getName());
           
       }
       q.con.closeConnection();
       
   }
}
  