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
    String password;
    public Queries(){
        this.con = new Connector(); 
        con.setConnection();
        
    }
		
		 public int quantityCollection(String username) throws SQLException {
        String sql = "Select sum(quantity)as SUM from "+ username;
        //select sum(quantity) as SUM from ryan333;
        p = con.connection.prepareStatement(sql);
        //p.setString(1, username);
        System.out.println(sql);
        int count = 0;
        try{
            rs = p.executeQuery();
            while(rs.next()){
                count = rs.getInt("SUM");
            }
        }catch(SQLException e){
            System.out.println("Error in summing up quantity " + e.getMessage());
        }
        return count;
    }
    
    public ResultSet collectionJoin(String username)throws SQLException{
        String sql = "Select * from Cards Inner Join "+ username  +" on Cards.card_id = " + username +".card_id";
        System.out.println(sql);
        p = con.connection.prepareStatement(sql);
        
        try{
            rs = p.executeQuery();
            
        }catch(SQLException e){
            System.out.println("Error message for this Collection join query is " + e.getMessage());
        }
        return rs;
    }
    public void deleteUserDeck(String tablename, String deckname)throws SQLException{
        String sql = "DELETE FROM ? WHERE DECKNAME = ?";
        p = con.connection.prepareCall(sql);
        p.setString(1,tablename);
        p.setString(2,deckname);
        try{
            p.execute();
        }catch(SQLException e){
            System.out.println("deleteUserDeck doesn't work" + e.getMessage());
            
        }
        
    }
    public void dropDeck(String tablename) throws SQLException{
        String sql = "DROP TABLE ?";
        p = con.connection.prepareStatement(sql);
        p.setString(1,tablename);
        try{
            p.execute();
        }catch(SQLException e){
            System.out.println("Drop deck didn't work");
        }
        
    }
    public void insertUserDecks(int userId, String deckname)throws SQLException{
        String sql = "Insert into UserDecks(USER_ID,DECKNAME) values(?,?)";
        p = con.connection.prepareCall(sql);
        p.setInt(1,userId);
        p.setString(2,deckname);
        try{
            p.executeQuery();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    public void createCollection(String name)throws SQLException{
        String sql = "CREATE TABLE " + name + " (card_id int, quantity int, PRIMARY KEY(card_id),FOREIGN KEY (card_id) REFERENCES Cards(card_id))";
        p = con.connection.prepareStatement(sql);
        //p.setString(1, name);
       
        try{
            p.execute();
        }catch(SQLException e){
            System.out.println("Error is " + e.getMessage());
        }
        
    }
    
    public void createDeck(String deckname) throws SQLException{
        String sql = "CREATE TABLE "+ deckname +" (card_id int, quantity int, PRIMARY KEY(card_id) Foreign Key (card_id) REFERENCES Cards(card_id)";
        p = con.connection.prepareStatement(sql);
        p.setString(1,deckname);
        
        try{
            p.execute();
        }catch(SQLException e){
            System.out.println("" + e.getMessage());
        }
    }
 
    public void createUser(Users user) throws SQLException{
        //con.setConnection();
        String sql = "Insert into User(user_login_name,user_login_password) values" + "(?,?)";
        PreparedStatement p2 = con.connection.prepareStatement(sql);
        
        p2.setString(1, user.getUserName());
        p2.setString(2, user.getUserPassWord());
        String username = user.getUserName();
       createCollection(username);
       //System.out.println(sql);
        
        try{
            p2.execute();
           //p.executeQuery(sql);
        }catch(SQLException e){
           System.out.println("SQL error " + e.getMessage());
       }
    
    }
    
     public String hashPassword(String password) throws NoSuchAlgorithmException{
         this.password = password + "hoardr";
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
     
     public boolean userExists(String username)throws SQLException{
     String sql = "Select user_login_name from User where user_login_name = ?";
     p = con.connection.prepareStatement(sql);
     p.setString(1,username);
     try{
         rs = p.executeQuery();
         if(!rs.next()){
             return true;
         }
     }catch(SQLException e){
         System.out.println("Another error: " + e.getMessage());
     }
        return false;
     }
     public String retrievePassword(String username) throws SQLException{
         String pass = "";
         String sql = "Select user_login_password from User where user_login_name = ?";
         p = con.connection.prepareStatement(sql);
         p.setString(1,username);
         try{
            rs = p.executeQuery();
            while(rs.next()){
            pass = rs.getString("user_login_password");
            }
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
         con.setConnection();
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
     public void decrementCard(int cardId,int quantity, String tablename)throws SQLException{
         String sql = "Select quantity from "+ tablename +" where card_id = ?";
         p = con.connection.prepareStatement(sql);
        
         p.setInt(1, cardId);
         try{
             rs = p.executeQuery();
             
             while(rs.next()){
                 if(rs.getInt("quantity")>=1){
                     String sql2 = "Update "+ tablename +" set quantity = ? where card_id = ?";
                     p =con.connection.prepareStatement(sql2);
                     p.setInt(1,quantity);
                     p.setInt(2,cardId);
                     p.executeUpdate();
                 }
                 else{
                     String sql3 = "Delete from "+ tablename +" where card_id = ?";
                     p = con.connection.prepareStatement(sql3);
                     p.setInt(1,cardId);
                     p.executeUpdate();
                 }
             }
         }catch(SQLException e){
             System.out.println("Error in the sql code for delete " + e.getMessage());
         }
     }
     public void updateQuantityCollection(int cardId, String username,int quantity) throws SQLException{
         String sql = "UPDATE "+username+ " SET quantity = ? where card_id = ?";
         p = con.connection.prepareStatement(sql);
         p.setInt(1,quantity);
         p.setInt(2, cardId);
         
         try{
             int column = p.executeUpdate();
         }catch(SQLException e){
             System.out.println("Error in the update " + e.getMessage());
         }
     }
     public void insertCollection(int cardId,String username) throws SQLException{
         String sql = "Insert into "+username+ "(card_id) values(?)";
         p = con.connection.prepareStatement(sql);
         p.setInt(1,cardId);
         try{
            int columns =  p.executeUpdate();
         }catch(SQLException e){
             System.out.println("This could not insert " + e.getMessage());
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
           
       }
       return list;
   }
   
   public void closeData() throws SQLException{
      try{
          rs.close();
          con.closeConnection();
          
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

