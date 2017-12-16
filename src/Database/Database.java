/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import MailController.SendMail;
import ModelClasses.Client;
import ModelClasses.Item;
import MailController.SendMail;
import ModelClasses.ItemN;
import ModelClasses.Message;
import ModelClasses.NewClient;
import ModelClasses.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.CatchNode;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;

/**
 *
 * @author ibrah
 */
public class Database {
    
    private Connection connection;
    public Client client = null;
    public NewClient justClient = null;
    public String[] itemsId;
    public ArrayList <ModelClasses.Message> messagesList;
    public ArrayList <Item> itemsList = new ArrayList<Item>();
    public ArrayList <Item> myItemsList = new ArrayList <Item>();
    public int ActivationCode;
    public  ArrayList<ItemN> itemsToPrint;
   public ArrayList<ImageIcon> imagesList;
     public  ArrayList<ItemN> searchItems;
    public void getItem(String categoryName, String prices, String type,boolean cS, boolean tS, boolean pS )
    {
        connection();
        
        String sql =("SELECT * FROM item ");
        itemsToPrint = new ArrayList<ItemN>();
        //TRY add icon
         try{
       System.out.println("//////////////////////////////////////////////////////////////////////////");
       
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int smallInt=-1;
        int bigInt =300;
        System.out.println(prices);
        if(prices!=null)
        {
        String small = prices.substring( 0, prices.indexOf("-"));
        String big = prices.substring(prices.indexOf("-")+1, prices.length());   
        smallInt = Integer.parseInt(small);
        if(big.equals("..."))
        {
            bigInt=999999999;
        }
        else
        {
            bigInt = Integer.parseInt(big);
            System.out.println(bigInt);
        }
        System.out.println("-----------------------------------------------------");
        System.out.println(small + " is" + big);
        System.out.println("-----------------------------------------------------");
        System.out.println("cs " + cS + "tS " +tS);
        System.out.println("-----------------------------------------------------");
        }
        
        while(rs.next()) {
            if(cS==true && tS==false && pS==false)
            {
                if(categoryName.equals(rs.getString("category")))
                 {
             
                    ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
                    itemsToPrint.add(item);
                 }
           //System.out.println(price);
            }
           else if(cS==false && tS==true && pS==false) //0 1 0
           {
                if(type.equals(rs.getString("cond")))
                 {
             
                    ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
                    itemsToPrint.add(item);
                }
           }
           else if(cS==true && tS==true && pS==false) //1 1 0
           {
                if(categoryName.equals(rs.getString("category")) && type.equals(rs.getString("cond")))
                {
             
                     ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
                     itemsToPrint.add(item);
                }
           }
           else if(cS==false && tS==false && pS==false) //0 0 0
           {
               ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
               itemsToPrint.add(item);
           }
           else if(cS==true && tS==false && pS==true) //1 0 1
           {
               if(prices!=null)
               {
               if(categoryName.equals(rs.getString("category")) && Integer.parseInt(rs.getString("price"))>smallInt && Integer.parseInt(rs.getString("price"))<bigInt)
                {
             
                     ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
                     itemsToPrint.add(item);
                }
               }
           }
           else if(cS==true && tS==true && pS==true) // 1 1 1 
           {
               if(prices!=null)
               {
               if(categoryName.equals(rs.getString("category")) && Integer.parseInt(rs.getString("price"))>smallInt && Integer.parseInt(rs.getString("price"))<bigInt &&
                    type.equals(rs.getString("cond")) )
                {
             
                     ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
                     itemsToPrint.add(item);
                }
               }
           }
            else if(cS==false && tS==false && pS==true) //0 0 1
           {
               if(prices!=null)
               {
               if(Integer.parseInt(rs.getString("price"))>smallInt && Integer.parseInt(rs.getString("price"))<bigInt)
                {
             
                     ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
                     itemsToPrint.add(item);
                }
               }
           }
           else if(cS==false && tS==true && pS==true) // 0 1 1 
           {
               if(prices!=null)
               {
               if(Integer.parseInt(rs.getString("price"))>smallInt && Integer.parseInt(rs.getString("price"))<bigInt && type.equals(rs.getString("cond")))
                {
             
                     ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
                     itemsToPrint.add(item);
                }
               }
           }
      }
        
        /*for(int i=0;i<itemsToPrint.size();i++)
        {
            System.out.println(itemsToPrint.get(i).toString());
        }*/
        
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
         
    }
    public String PrintItem(int i)
    {
        if(itemsToPrint.size() > 0 && itemsToPrint.size() > i)
           return itemsToPrint.get(i).toString();
        else 
            return "WE COULD NOT FIND ANYTHING";
        
    }
    
    public ArrayList<ItemN> getArr()
    {
        return itemsToPrint;
    }
    
    ////////////////////////////////Berk Search Item////////////////////
      
public void searchItem(String keyword)
    {
        int itemId = 0;
        String sql = "";
        searchItems = new ArrayList<ItemN>();
        
        sql = "SELECT * FROM item WHERE title LIKE '%" + keyword + "%'";

        try {
            connection();
            PreparedStatement praparedStatement = this.connection.prepareStatement(sql);
            //int updateResult = praparedStatement.executeUpdate();
            ResultSet rs = praparedStatement.executeQuery();
            
             while(rs.next()) {
                 System.out.println(rs.getString("title"));
           if(rs.getString("title").toLowerCase().contains((keyword).toLowerCase()))
           {
             
               ItemN item = new ItemN(rs.getString("category"),rs.getString("description"),rs.getString("price"),rs.getString("cond"),rs.getString("title"));
               searchItems.add(item);
               System.out.println(searchItems.size());
           }
           //System.out.println(price);
           }
        
        for(int i=0;i<searchItems.size();i++)
        {
            System.out.println(searchItems.get(i).toString());
            System.out.println(searchItems.size());
        }
        
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }


        
        }
    public String PrintSearch(int i)
    {
        return searchItems.get(i).toString();
    }
    public ArrayList<ItemN> getSearchArr()
    {
        return searchItems;
    }


    public Client login(String username, String password) throws IOException{
        
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
                
                getItems();
                getIcons();
                
                if(!(items.equals(""))){
                    itemsId = items.split("\\,");
                    
                    int numOfItems = itemsId.length;
                    int counterNumOfItems = 0;
                    int myItemId = -1;
                    
                    System.out.print(itemsId.length );
                    
                    for(int i = 0; i < itemsId.length ; i++){
                        
                        if(itemsId[i] != ""){
                           
                            myItemId = (parseInt(itemsId[i]));
                            
                        }
                        for(int t = 0; t < itemsList.size(); t++){
                            
                            if(myItemId != -1 && (itemsList.get(t)).getItemId() == myItemId){
                                myItemsList.add(itemsList.get(t));
                                break;
                            }
                        }
                        
                    }
                }
                client = new Client(username, password, name, surname, email, university, userId, messagesList, myItemsList);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
        
        return client;
    }
    public ArrayList<ImageIcon> getIcons() throws IOException{
        
        imagesList = new ArrayList<ImageIcon>();
        
        String getIcons = "SELECT * FROM IMAGE WHERE id = ?";
        int i = 0;
        
        
        while(i < itemsList.size()){
            
            try {
                PreparedStatement statement = connection.prepareStatement(getIcons);
                statement.setInt(1,itemsList.get(i).getItemId());
                ResultSet result = statement.executeQuery();
                
                while (result.next()) {
                   Blob blob = result.getBlob("image");
                    int blobLength = (int) blob.length();  

                    byte[] bytes = blob.getBytes(1, blobLength);
                    //blob.free();     
                    ImageIcon icon = new ImageIcon(bytes);
                    System.out.println("\n" + itemsList.get(i).getItemId() + "\n" + i);
                    (itemsList.get(i)).setPhoto(icon);
                    imagesList.add(icon);
                   
                    }
                                  
                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i++;
        }
        return imagesList;
    }
    
    
    public boolean editItem(String title, String price, int itemid ,String category,
           String condition, String description, String path){

       String update = "UPDATE `item` SET title = ? , category = ?,description = ?,"
               + " price = ?, cond = ? WHERE ItemId = ?";

       try {
           connection();
           PreparedStatement praparedStatement =
this.connection.prepareStatement(update);
           praparedStatement.setString(1, title);
           praparedStatement.setString(2, category);
           praparedStatement.setString(3, description);
           praparedStatement.setString(4, price);
           praparedStatement.setString(5, condition);
           praparedStatement.setInt(6, itemid);

           int updateResult = praparedStatement.executeUpdate();

           if (updateResult > 0) {

               updateIcon(path, itemid);
               
               /*for(int i = 0; i < myItemsList.size(); i++){
               if(myItemsList.get(i).getItemId() == itemid){
               (myItemsList.get(i)).setTitle(title);
               (myItemsList.get(i)).setCategory(category);
               (myItemsList.get(i)).setCondition(condition);
               (myItemsList.get(i)).setDescription(description);
               (myItemsList.get(i)).setItemId(itemid);
               (myItemsList.get(i)).setPhoto(photo);
               (myItemsList.get(i)).setPrice(parseDouble(price));
               }
               }
               for(int i = 0; i < itemsList.size(); i++){
               if(itemsList.get(i).getItemId() == itemid){
               (itemsList.get(i)).setTitle(title);
               (itemsList.get(i)).setCategory(category);
               (itemsList.get(i)).setCondition(condition);
               (itemsList.get(i)).setDescription(description);
               (itemsList.get(i)).setItemId(itemid);
               (itemsList.get(i)).setPhoto(photo);
               (itemsList.get(i)).setPrice(parseDouble(price));
               }
               }*/
               return true;
           } else {
               System.out.println("Something went wrong!");
               return false;
           }

       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }

   }
    
    public Client signUp(String name, String surname, String username, 
            String password, String uniname, String email) throws MessagingException{
        
              
        int userId = (int) (Math.random()*9999) + 1;
        
        ArrayList<ModelClasses.Message> justMessage = new ArrayList<>();
        
        ArrayList<Item> justItem =  new ArrayList<>();
        
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
                return justClient;
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
                JOptionPane.showMessageDialog(null, "Email is used", "EMAIL IS USED!" , JOptionPane.INFORMATION_MESSAGE);
                return justClient;
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
              return null;
            }
        }
        
        ActivationCode = (int) (Math.random()*9999) + 1;
         
        justClient = new NewClient(username,password,name,surname,email,uniname,userId,justMessage, justItem, ActivationCode);
        
        SendMail mail = new SendMail(name, surname, email, ActivationCode);
       

        return justClient;
    }
    
    
    public void addClient(){
        
        String addClientSql = "INSERT INTO `client`(`UserId`, `UserName`, `Password`, `Name`, `Surname`, `Email`, "
                + "`University`, `Messages`, `Items`) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
        connection(); 
        PreparedStatement psAddClient = connection.prepareStatement(addClientSql);
        psAddClient.setInt(1, justClient.getUserId());
        psAddClient.setString(2, justClient.getUserName());
        psAddClient.setString(3, justClient.getPassword());
        psAddClient.setString(4, justClient.getName());
        psAddClient.setString(5, justClient.getSurname());
        psAddClient.setString(6, justClient.getEmail());
        psAddClient.setString(7, justClient.getUniversity());
        psAddClient.setString(8, "");
        psAddClient.setString(9, "");
        
        psAddClient.executeUpdate();
        
        }catch (SQLException ex) {
          System.out.println(ex.getMessage());
         
        }
       
    }
    
    
    
    public ArrayList<Item> getItems(){
        
        String sqlItem = "SELECT * FROM ITEM";
                try{
              
                PreparedStatement psItem = connection.prepareStatement(sqlItem);
                ResultSet rsItem = psItem.executeQuery();
                
                int counterItem = 0;
                        
                while(rsItem.next()){
                    
                   int itemId = rsItem.getInt("ItemId");
                   System.out.println("Hello");
                   String title =  rsItem.getString("Title");             
                   String category = rsItem.getString("category");
                   String description = rsItem.getString("description");
                   String priceString = rsItem.getString("price");
                   double price = Double.parseDouble(priceString);
                   ImageIcon photo = null;    //Photo yapılacak
                   String condition = rsItem.getString("cond");
                   
                                     
                   Item item = new Item(title, category, description, price, condition, photo, itemId);
                   itemsList.add(item);
                   counterItem++;
                }
                
                
                }catch(SQLException ex){
                System.out.println(ex.getMessage());
                }
        return itemsList;
    }
    
      public boolean editUser(int userId ,String name, String surname, 
              String username, String uniname, String email, String password){
    
        String sqlUsername = "SELECT * FROM CLIENT WHERE UserName = ?";
        String sqlEmail = "SELECT * FROM CLIENT WHERE Email = ?";
        
       
        if(!(username.equals(client.getUserName()))){
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
        }
        
        
        if(!(email.equals(client.getEmail()))){
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
        }
        
        
        String update = "UPDATE `client` SET UserName = ?, Password = ?, Name = ?, "
                + "Surname = ?, Email = ?, University =? WHERE UserId = ? "  ;

        try {
            connection();
            PreparedStatement praparedStatement = this.connection.prepareStatement(update);
            praparedStatement.setString(1, username);
            praparedStatement.setString(2, password);
            praparedStatement.setString(3, name);
            praparedStatement.setString(4, surname);
            praparedStatement.setString(5, email);
            praparedStatement.setString(6, uniname);
            praparedStatement.setInt(7, userId);
            int updateResult = praparedStatement.executeUpdate();

            if (updateResult > 0) {
                client.setEmail(email);
                client.setName(name);
                client.setPassword(password);
                client.setSurname(surname);
                client.setUniversity(uniname);
                client.setUserName(username);
                return true;
            } else {
                System.out.println("Something went wrong!");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    
    public void connection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://139.179.227.102/besttrade", "ezgi1", "aaa");
            System.out.println("Connection Succesfull");
        } catch (Exception e) {

            System.out.println("Error! " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Connection Error" , JOptionPane.INFORMATION_MESSAGE);
        }
    }


    
    public boolean deleteItem(int ItemId){
        
        String deleteItem = "DELETE FROM `item` WHERE itemId =?";
        
        try {
            connection();
            PreparedStatement praparedStatement = this.connection.prepareStatement(deleteItem);
            praparedStatement.setInt(1, ItemId);
            
            int updateResult = praparedStatement.executeUpdate();

            if (updateResult > 0) {
                JOptionPane.showMessageDialog(null, "Succesfully Deleted", "" , JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Can not delete", "Deletion Error" , JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Something went wrong!");
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can not delete", "Deletion Error" , JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
            return false;
        }
        
        
        
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String[] getItemsId() {
        return itemsId;
    }

    public void setItemsId(String[] itemsId) {
        this.itemsId = itemsId;
    }

    public ArrayList<Message> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(ArrayList<Message> messagesList) {
        this.messagesList = messagesList;
    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public ArrayList<Item> getMyItemsList() {
        return myItemsList;
    }

    public void setMyItemsList(ArrayList<Item> myItemsList) {
        this.myItemsList = myItemsList;
    }

    public int getActivationCode() {
        return ActivationCode;
    }

    public void setActivationCode(int ActivationCode) {
        this.ActivationCode = ActivationCode;
    }
    
    ///////////////////////////////////////////////////////////OZER/////////////////////////////////////////////////////////////////////////
     public boolean addItem(String category,String description, String
price, String condition, ImageIcon photo,String title, String path)
   {


       int itemId = (int) (Math.random()*9999) + 1;

       ImageIcon icon = new ImageIcon();
       String sql =("INSERT INTO item(itemId,category,description,price,cond,title) " + "VALUES (?,?,?,?,?,?)");
       String sqlUser = "SELECT * FROM CLIENT WHERE UserId = ?";

       try{
           connection();
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setInt(1, itemId);
           ps.setString(2,category);
           ps.setString(3, description);
           ps.setString(4, price);
           ps.setString(5, condition);
           ps.setString(6, title);

           ps.executeUpdate();

           PreparedStatement psUser = connection.prepareStatement(sqlUser);
           psUser.setInt(1, client.getUserId());
           ResultSet rs = psUser.executeQuery();

           if(rs.next()){
                String items = rs.getString("Items");
                items = items + "," + itemId;
                String sqlUpdate =("UPDATE CLIENT SET Items = ? WHERE UserId = ?");
                PreparedStatement psUpdate =
connection.prepareStatement(sqlUpdate);
                psUpdate.setString(1, items);
                psUpdate.setInt(2, client.getUserId());
                psUpdate.executeUpdate();
           }



       }
       catch (SQLException ex){
           System.out.println(ex.getMessage());
           return false;
       }
       addIcon(path,itemId);
       return true;
   }
    
    
    
    
    public void addIcon(String path, int itemId)
    {
        connection();
         String sqlIm =("INSERT INTO image(id,size,image) " + "VALUES (?,?,?)");
        //TRY add icon
         try{
             
        File imgfile = new File(path);
            // Image picture = ImageIO.read(new File("C:\\Users\\Emre\\Desktop\\3M.BestTrade-unstable4\\JavaApplication1\\JavaApplication1\\good.png"));
        FileInputStream fin = new FileInputStream(imgfile);
        PreparedStatement ps = connection.prepareStatement(sqlIm);
        ps.setString(1,itemId + "");
        ps.setInt(2,3);
        ps.setBinaryStream(3,(InputStream)fin,(int)imgfile.length());
        ps.executeUpdate();
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }
    public void refresh() throws IOException{
        
        String sql = "SELECT * FROM CLIENT WHERE UserId = ?"; //To prevent SQL Injection
        
        
        try{
            
            connection(); //Open connection
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, client.getUserId());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                int userId = rs.getInt("UserId");
                String userName = rs.getString("UserName");
                String pw = rs.getString("Password");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String university = rs.getString("University");
                String messages = rs.getString("Messages");
                String items = rs.getString("Items");
                
            
            
           
            
            getItems();
            getIcons();
            
             myItemsList = new ArrayList <Item>();
            
            if(!(items.equals(""))){
                    itemsId = items.split("\\,");
                    
                    int numOfItems = itemsId.length;
                    int counterNumOfItems = 0;
                    int myItemId = -1;
                    
                    System.out.print(itemsId.length );
                    
                    for(int i = 0; i < itemsId.length ; i++){
                        
                        if(itemsId[i] != ""){
                           
                            myItemId = (parseInt(itemsId[i]));
                            
                        }
                        for(int t = 0; t < itemsList.size(); t++){
                            
                            if(myItemId != -1 && (itemsList.get(t)).getItemId() == myItemId){
                                myItemsList.add(itemsList.get(t));
                                break;
                            }
                        }
                        
                    }
                }
                client = new Client(userName, pw, name, surname, email, university, userId, messagesList, myItemsList);
                
            }
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
           
        }
        
    }
    
    public void updateIcon(String path, int itemId)
    {
        connection();
         String sqlIm =("UPDATE IMAGE SET(size,image) " + "VALUES (?,?) WHERE id = ?");
        //TRY add icon
         try{
             
        File imgfile = new File(path);
            // Image picture = ImageIO.read(new File("C:\\Users\\Emre\\Desktop\\3M.BestTrade-unstable4\\JavaApplication1\\JavaApplication1\\good.png"));
        FileInputStream fin = new FileInputStream(imgfile);
        PreparedStatement ps = connection.prepareStatement(sqlIm);
        
        ps.setInt(1,3);
        ps.setBinaryStream(2,(InputStream)fin,(int)imgfile.length());
        ps.setInt(3, itemId);
        ps.executeUpdate();
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }
    
   
    
    
}
