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
public class Admin extends Client{
    
    public Admin(String userName, String password, String name, String surname, String email, String 
            university, int userId, ArrayList <Message> messages, ArrayList <Item> items) {
        super(userName, password, name, surname, email, university, userId, messages, items);
    }
    
}
