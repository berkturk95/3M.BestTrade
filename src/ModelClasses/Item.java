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
    
    public String title;
    public String category;
    public String description;
    public double price;
    public String condition;
    public ImageIcon photo;
    public int itemId;
    
    
    
    public Item(String title, String category,String description, double price, 
            String condition, ImageIcon photo, int itemId ){
        
        this.title = title;
        this.category = category;
        this.description = description;
        this.price = price;
        this.condition = condition;
        this.photo = photo;
        this.itemId = itemId;
              
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
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
