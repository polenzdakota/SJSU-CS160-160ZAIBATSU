/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author chris
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chris
 */
import java.sql.*;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Connector implements Serializable{
    Statement statement;
    Connection conn;
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/mydb"; //this can be any database

   static final String USER = "root";
   static final String PASS = "hachiman24";
   
   public Connector(){
            conn = null;
            ResultSet rs;
         try{
        
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Database connected");
        //rs = statement.executeQuery("Select card_id,card_name from Cards where card_id=0");
         }
        catch(ClassNotFoundException e){
            System.out.println("Driver error");
        }catch(SQLException e){
            System.out.println("SQL error" + e.getMessage());   
        }
   }
   
   public ResultSet allCards(String s) throws SQLException{
       ResultSet rs = null;
       try{
           
       statement = conn.createStatement();
       rs = statement.executeQuery("Select " + s + " from Cards");
       
       }catch(SQLException e){
           System.out.println("SQL error" + e.getMessage());
       }
       return rs;
   }
   
   public List<Card> OutFunction(ResultSet rs) throws SQLException{
       List<Card> list;
       list = new ArrayList<>();
       try{
        while(rs.next()){
            Card c = new Card();
           //System.out.println("Cards id: "+rs.getInt("card_id"));
           c.setId(rs.getInt("card_id"));
           list.add(c);
       }
        
      }catch(SQLException e){
          System.out.println("SQL error is " + e.getMessage());
      }
       return list;
      }
    @Override
     public String toString(){
         return "";
     }
}
