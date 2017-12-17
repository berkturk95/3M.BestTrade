/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClasses;

import java.util.ArrayList;

/**
 *
 * @author ibrah
 */
public class Client{
    
     private String userName;
     private String password;
     private String name;
     private String surname;
     private String email;
     private String university;
     private int userId;
     private ArrayList <Message> messages;
     private ArrayList <Item> items;
     private int ActivationCode;
     
    public Client(String userName, String password,String name, String surname,String email, String 
            university, int userId, ArrayList <Message> messages, ArrayList <Item> items, int ActivationCode){
        
        
        this.userName = userName;
        this.password = password;
        this. name = name;
        this. surname = surname;
        this.email = email;
        this.university = university;
        this.userId = userId;
        this.messages = messages;
        this.items = items;
        this.ActivationCode = ActivationCode;
    }

    public int getActivationCode() {
        return ActivationCode;
    }

    public void setActivationCode(int ActivationCode) {
        this.ActivationCode = ActivationCode;
    }
    
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList <Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList <Message> messages) {
        this.messages = messages;
    }

    public ArrayList <Item> getItems() {
        return items;
    }

    public void setItems(ArrayList <Item> items) {
        this.items = items;
    }
    
}
