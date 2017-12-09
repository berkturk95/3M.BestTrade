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
public class Item {
    
    
    public String category;
    public String description;
    public double price;
    public int condition;
    public ImageIcon photo;
    public int itemId;
    
    
    
    public Item(String category,String description, double price, int condition, ImageIcon photo, int itemId ){
        
        this.category = category;
        this.description = description;
        this.price = price;
        this.condition = condition;
        this.photo = photo;
        this.itemId = itemId;
              
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
}
