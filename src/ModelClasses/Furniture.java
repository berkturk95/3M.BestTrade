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
public class Furniture extends Item {
    
    public Furniture(String title, String category, String description, double price, String condition, ImageIcon photo, int itemId) {
        super(title, category, description, price, condition, photo, itemId);
    }
    
}
