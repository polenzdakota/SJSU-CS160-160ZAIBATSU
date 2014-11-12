package database;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
public class DataBase {
   public static void main(String[] args) throws SQLException {
       Connector connection = new Connector();
       ResultSet test = connection.allCards("card_id");
       List<Card> list;
       list = connection.OutFunction(test);
       
       for(Card c:list){
           c.toString();
       }
       
   }
}
  