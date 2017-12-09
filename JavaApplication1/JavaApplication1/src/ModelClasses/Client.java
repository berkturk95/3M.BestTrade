/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClasses;

/**
 *
 * @author ibrah
 */
public class Client {
    
     private String userName;
     private String password;
     private String name;
     private String surname;
     private String email;
     private String university;
     private int userId;
     private Message messages[];
     private Item items[];
    
    public Client(String userName, String password,String name, String surname,String email, String university, int userId, Message messages[], Item items[]){
        
        
        this.userName = userName;
        this.password = password;
        this. name = name;
        this. surname = surname;
        this.email = email;
        this.university = university;
        this.userId = userId;
        this.messages = messages;
        this.items = items;
        
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

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
    
}
