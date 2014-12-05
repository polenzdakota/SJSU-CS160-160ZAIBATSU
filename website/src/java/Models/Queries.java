/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author chris
 */

/**
* Query class handles all database queries that is done to the database
* Query class will create a connection to the database
*
*/
public class Queries {
    ResultSet rs;
    PreparedStatement p;
    Statement statement;
    Connector con;
    
    public ResultSet collectionJoin(String username)throws SQLException{
        String sql = "Select * from Cards Inner Join ? on Cards.card_id = ?.card_collection_id";
        p = con.connection.prepareStatement(sql);
        p.setString(1, username);
        p.setString(2, username);
        try{
            rs = p.executeQuery();
            
        }catch(SQLException e){
            System.out.println("Error message for this query is " + e.getMessage());
        }
        return rs;
    }
    public void createCollection(String name)throws SQLException{
        String sql = "CREATE TABLE ? (Entry int , card_collection int, PRIMARY KEY(Entry),"
        + "FOREIGN KEY (card_collection) REFERENCES Cards(card_id))";
        p = con.connection.prepareCall(sql);
        p.setString(1, name);
        try{
            p.executeQuery();
        }catch(SQLException e){
            System.out.println("Error is " + e.getMessage());
        }
        
    }
    
    public void createUser(Users user) throws SQLException{
        String sql = "Insert into Users(user_login_name,user_login_password) values (?,?)";
        p = con.connection.prepareStatement(sql);
        p.setString(1, user.getUserName());
        p.setString(2, user.getUserPassWord());
        
        try{
           int columns =  p.executeUpdate();
        }catch(SQLException e){
           System.out.println("SQL error" + e.getMessage());
       }
    
    }
    
     public String hashPassword(String password) throws NoSuchAlgorithmException{
         MessageDigest hashpass = null;
         try{
         hashpass = MessageDigest.getInstance("SHA-256");
         }catch(NoSuchAlgorithmException e){
             System.out.println("This algorithm doesn't exist " + e.getMessage());
         }
         hashpass.update(password.getBytes());
         String encryption = new String(hashpass.digest());
         
         return encryption;
     }
     
     public String retrievePassword(int userid) throws SQLException{
         String pass = null;
         String sql = "Select user_login_password where user_id = ?";
         p = con.connection.prepareStatement(sql);
         p.setInt(1,userid);
         try{
            rs = p.executeQuery();
            pass = rs.getString("user_login_password");
         }catch(SQLException e){
             System.out.println("Password retrival failed :  "+ e.getMessage());
         }
         return pass;
     }
      /**
       *  Method will search data using REGEXP given a text field
       * @param s
       * @return resultSet
       * @throws SQLException 
       */
     public ResultSet searchREGEXP(String s) throws SQLException{

       try{
           String sql = "SELECT * from Cards where card_name REGEXP ? order by card_name;";
           p = con.connection.prepareStatement(sql);
           s = "[[:<:]]" + s + "[[:>:]]";
           p.setString(1, s);
           //System.out.println(p);
           rs = p.executeQuery();
      
      
       }catch(SQLException e){
           System.out.println("SQL error" + e.getMessage());
       }
      
       return rs;
     }
     public ResultSet oneCard(String s) throws SQLException{
         
       con = new Connector();
       con.setConnection();
       try{
           String sql = "SELECT * from Cards where card_id = ?";
           p = con.connection.prepareStatement(sql);
           p.setString(1, s);
           System.out.println(p);
           rs = p.executeQuery();
      
      
       }catch(SQLException e){
           System.out.println("SQL error" + e.getMessage());
       }
      
       return rs;
     }
     public void insert(int cardId,String username) throws SQLException{
         String sql = "Insert into ? (card_collection_id) values(?)";
         p = con.connection.prepareStatement(sql);
         p.setString(1, username);
         p.setInt(2,cardId);
         try{
            int columns =  p.executeUpdate();
         }catch(SQLException e){
             System.out.println("This could not insert" + e.getMessage());
         }
     }
     
       
   public ArrayList<Card> setCards(ResultSet rs) throws SQLException{
       ArrayList<Card> list;
       list = new ArrayList<Card>();
       try{
           while(rs.next()){ 
               int id = (rs.getInt("card_id"));
               String name = (rs.getString("card_name"));
               String card_cost = (rs.getString("card_cost"));
               int card_cmc = (rs.getInt("card_cmc"));
               int colors = (rs.getInt("card_colors"));
               String card_supertypes = (rs.getString("card_supertypes"));
               String card_subtypes = (rs.getString("card_subtypes"));
               String card_cardtypes = (rs.getString("card_cardtypes"));
               String card_text = (rs.getString("card_text"));
               String card_toughness= (rs.getString("card_toughness"));
               String card_power= (rs.getString("card_power"));
                String card_loyalty =(rs.getString("card_loyalty"));
               String image = (rs.getString("card_image_location"));
               Card c = new Card(name,id,colors,card_cost,card_cmc,card_supertypes,card_cardtypes,card_subtypes,card_text,card_power,card_toughness,card_loyalty,image);
               list.add(c);
           }
       }catch(SQLException e){
          System.out.println("SQL error is " + e.getMessage());
        }finally{
           closeData();
       }
       return list;
   }
   
   public void closeData() throws SQLException{
      try{
          rs.close();
          System.out.println("CLose resultset");
      }catch(SQLException e){
          System.out.println("SQL error " + e.getMessage());
      }
      try{
          p.close();
          System.out.println("Closing the preparedStatement");
      }catch(SQLException e){
          System.out.println("SQL error " + e.getMessage());
      }

   }
  
}

