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
public class Users {
    private final int userId;
    private final String userName;
    private int userCollectionId;
    private String userPassword;
    public Users(int id, String userName){
        this. userId = id;
        this. userName = userName;
    }
    
    public String getUserName(){
        return userName;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserCollectionId(int userCollectionId){
        this.userCollectionId = userCollectionId;
    }
    public int getUserCollectionId(){
        return userCollectionId;
    } 
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
    public String getUserPassWord(){
        return userPassword;
    }
  
}
