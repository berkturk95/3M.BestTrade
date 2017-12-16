/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClasses;

import javax.swing.ImageIcon;

/**
 *
 * @author Ilhami
 */
public class ItemN {
    String category;
    String description;
    String price;
    String cond;
    String title;
    public ItemN(String category,String description,String price,String cond,String title)
    {
        this.category=category;
        this.description=description;
        this.price=price;
        this.cond=cond;
        this.title=title;
    }
    public String getCategory() {
        return category;
    }

     

    public String getDescription() {
        return description;
    }

    
    public String getPrice()
    {
        return price;
    }
   
    public String getTitle()
    {
        return title;
    }
     

    public String getCondition() {
        return cond;
    }

   public String toString()
   {
       String print="";
       String priceP ="Price = " + price + "\n";
       String categoryP ="Category = " + category + "\n" ;
       System.out.println();
       String Type = "Type = " + cond + "\n" ;
       String desc ="Description : "  + description; 
       print=priceP+ categoryP+ Type + desc;
       return print;
   }   
    
}
