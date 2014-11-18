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
      /**
       *  Method will search data using REGEXP given a text field
       * @param s
       * @return resultSet
       * @throws SQLException 
       */
     public ResultSet searchREGEXP(String s) throws SQLException{
       
       con = new Connector();
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
       
   public List<Card> setCards(ResultSet rs) throws SQLException{
       List<Card> list;
       list = new ArrayList<>();
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
