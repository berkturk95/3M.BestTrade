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
public class User extends Client{
    
    public User(String userName, String password, String name, String surname, String email, String university, int userId, Message messages[], Item items[]) {
        super(userName, password, name, surname, email, university, userId, messages, items);
    }
    
    
    
}
