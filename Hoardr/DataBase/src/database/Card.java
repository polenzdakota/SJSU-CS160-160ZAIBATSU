/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;

/**
 *
 * @author chris
 */
public class Card implements Serializable{
   private String cardName = null;
   private int id =0;
   
   public String getName(){
       return cardName;
   }
   public void setName(String cardName){
       this.cardName = cardName;
   }
   public int getId(){
       return id;
   }
   public void setId(int id){
       this.id = id;
   }
   public String toString(){
       return "Card--ID" + id;
   }
}
