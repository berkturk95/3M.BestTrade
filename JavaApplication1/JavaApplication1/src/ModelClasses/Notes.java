/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClasses;

import javax.swing.ImageIcon;

/**
 *
 * @author ibrah
 */
public class Notes extends Item{
    
    public Notes(String category, String description, double price, int condition, ImageIcon photo, int itemId) {
        super(category, description, price, condition, photo, itemId);
    }
    
}
