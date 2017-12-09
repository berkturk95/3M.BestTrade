/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import ModelClasses.Client;
import ModelClasses.Item;
import ModelClasses.Message;
import ModelClasses.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.CatchNode;

/**
 *
 * @author ibrah
 */
public class Database {
    
    private Connection connection;
    public  Client client = null;
    public Message[] messagesArray;
    public Item[] itemsArray;
    
    
    public Client login(String username, String password){
        
        String sql = "SELECT * FROM CLIENT WHERE UserName = ? and Password = ?"; //To prevent SQL Injection
                     
        
        try{
            
            connection(); //Open connection
           
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                int userId = rs.getInt("UserId");
                String pw = rs.getString("Password");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String university = rs.getString("University");
                String messages = rs.getString("Messages");
                String items = rs.getString("Items");
                
                
                /*
               messagesArray =  messages.split("\\,");
               
               Message message;
               
               String sqlMessages = "SELECT * FROM MESSAGES WHERE FromUser = ?";
               PreparedStatement psMessage = connection.prepareStatement(sqlMessages);
               psMessage.setString(1, Integer.toString(userId));
               ResultSet rsMessage = psMessage.executeQuery();
               
               
               for(int i = 0; i < messagesArray.length; i++ ){
                   
                   message = new Message();
               }
               */
               this.client = new User(username, password, name, surname, email, university, userId,messagesArray, itemsArray);
                
            }
            
            ps.close();
            
            
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
          return null;
        }
        
        
        return client;
    }
    
    
    public boolean signUp(String name, String surname, String username, String password, String uniname, String email){
        
        int userId = (int) (Math.random()*9999) + 1;
        
        Message[] justMessage = {};
        
        Item[] justItem = {};
        
        String sqlUsername = "SELECT * FROM CLIENT WHERE UserName = ?";
        String sqlEmail = "SELECT * FROM CLIENT WHERE Email = ?";
        String sqlUserId = "SELECT * FROM CLIENT WHERE UserId = ?";
       
        try{
            connection(); 
            PreparedStatement ps = connection.prepareStatement(sqlUsername);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
          
            if(rs.next()){
                //System.out.println();
                JOptionPane.showMessageDialog(null, "Username is taken", "USERNAME IS TAKEN!" , JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }catch (SQLException ex) {
          System.out.println(ex.getMessage());
          
        }
         
        
        try{
            connection(); 
            PreparedStatement ps = connection.prepareStatement(sqlEmail);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
          
            if(rs.next()){
                //System.out.println();
                JOptionPane.showMessageDialog(null, "Email is used", "EMAIL IS USED!" , JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }catch (SQLException ex) {
          System.out.println(ex.getMessage());
          
        }
        
        
        while(true){
            try{
                connection();
                PreparedStatement ps = connection.prepareStatement(sqlUserId);
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                   userId = (int) (Math.random()*9999) + 1;
                   continue;
                }
                else{
                    
                    break;
                }
                
            }catch (SQLException ex) {
              System.out.println(ex.getMessage());
              return false;
            }
        }
        Client justClient = new Client(username,password,name,surname,email,uniname,userId,justMessage, justItem);
        return true;
    }
    
    
    public void connection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/besttrade", "root", "");
            System.out.println("Connection Succesfull");
        } catch (Exception e) {

            System.out.println("Error! " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Connection Error" , JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
