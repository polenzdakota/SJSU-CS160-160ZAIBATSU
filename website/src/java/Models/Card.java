/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Zaibatsu - chris
 */

/*
* Card class getters for all the columns in the database. 
* Constructor initializes all the variables in this particular case the  columns of the Card Tables
*
*/
public class Card implements Serializable{
   private final String cardName;
   private final int id;
   private final int color;
   private final String cost;
   private final int card_cmc;
   private final String card_supertypes;
   private final String card_types;
   private final String card_subtypes;
   private final String card_text;
   private final String card_power;
   private final String card_toughness;
   private final String card_loyalty;
   private final String card_image_location;
   
   public Card(String cardName, int id, int color,String cost,int card_cmc, String card_supertypes,
           String card_types,String card_subtypes, String card_text, String card_power, 
           String card_toughness,String card_loyalty,String card_image_location){
           
            this.cardName = cardName;
            this.id = id;
            this.color = color;
            this.cost = cost;
            this.card_cmc = card_cmc;
            this.card_supertypes = card_supertypes;
            this.card_types = card_types;
            this.card_subtypes = card_subtypes;
            this.card_text = card_text;
            this.card_power = card_power;
            this.card_toughness = card_toughness;
            this.card_loyalty = card_loyalty;
            this.card_image_location = card_image_location;
            
                    
   }
   

 

   public String getName(){
       return cardName;
   }
    public int getId(){
       return id;
   }
   
   public int getColors(){
    return color;   
   }
   public String getCost(){
       return cost;
   }
   public int getCmc(){
       return card_cmc;
   }
   public String getSupertypes(){   
       return card_supertypes;
   }
   public String getCardtypes(){
       return card_types;
   }
   public String getCardsubtypes(){
       return card_subtypes;
   }
   public String getText(){
       return card_text;
   }
   public String getCardPower(){
       return card_power;
   }
   public String getCardtoughness(){
       return card_toughness;
   }
  
   public String getCardloyalty(){
       return card_loyalty;
   }
   
   public String getImageCardlocation(){
       return card_image_location;
   }
   
}