/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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
public final class Connector implements Serializable{
    
   Connection connection;
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/mydb"; //this can be any database

   static final String USER = "root";
   static final String PASS = "";
   
   
   
   public void setConnection(){
         try{
        
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Database connected^^^^^^^^^");
        //rs = statement.executeQuery("Select card_id,card_name from Cards where card_id=0");
         }
        catch(ClassNotFoundException e){
            System.out.println("Driver error");
        }catch(SQLException e){
            System.out.println("SQL error" + e.getMessage());   
        }
   }
         
  
    public void closeConnection(){
       try{
             if(connection!=null){
                 System.out.println("Closing connection");
                 connection.close();
             
             }
             }catch(SQLException e){
                 System.out.println("SQL error" + e.getMessage());
                 }
            }
   }
  
   /*
     public ResultSet ForestBear(String s) throws SQLException{
       ResultSet rs = null;
       String inputString = "Select card_name ,card_colors , card_cost from Cards where card_name= 'Forest Bear';" ;
       try{ 
       statement = connection.createStatement();
       rs = statement.executeQuery(inputString);
       System.out.println(inputString);
       
       }catch(SQLException e){
           System.out.println("SQL error" + e.getMessage());
       }
       
       return rs;
   }
   */
   /*
   public List<Card> OneCard(ResultSet rs) throws SQLException{
       List<Card> list;
       list = new ArrayList<>();
       try{
           while(rs.next()){
            Card c = new Card();
           //System.out.println("Cards id: "+rs.getInt("card_id"));
           c.setName(rs.getString("card_name"));
           c.setColor(rs.getInt("card_colors"));
           c.setCost(rs.getString("card_cost"));
           /*
           System.out.println(""+c.getName());
           System.out.println("" + c.getCost());
           System.out.println("" + c.getColor());
            
           list.add(c);
           }
       
        
      }catch(SQLException e){
          System.out.println("SQL error is " + e.getMessage());
      }
       return list;
      }
   */
