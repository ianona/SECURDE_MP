package Controller;


import Model.User;
import View.Frame;
import java.util.ArrayList;

import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class Main {
    
    public SQLiteJDBCDriverConnection driver;
    
    //hashing the password before sotring into the database
    public String hashing(String password)
    {
        try { 
            // getInstance() method is called with algorithm SHA-512 
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(password.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            }
            return hashtext;
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
    
    public static void main(String[] args) {
        new Main().init();
    }
    
    public void init(){
        // Initialize a driver object
        driver = new SQLiteJDBCDriverConnection();

        // Create a database
        driver.createNewDatabase();
        
        // Drop users table if needed
         driver.dropUserTable();
        
        // Create users table if not exist
        driver.createUserTable();
        
        // Add users
        driver.addUser("admin", hashing("qwerty1234"));
        driver.addUser("manager", hashing("qwerty1234"));
        driver.addUser("staff", hashing("qwerty1234"));
        driver.addUser("client1", hashing("qwerty1234"));
        driver.addUser("client2", hashing("qwerty1234"));
        
        // Get users
        ArrayList<User> users = driver.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            System.out.println("===== User " + users.get(nCtr).getId() + " =====");
            System.out.println(" Username: " + users.get(nCtr).getUsername());
            System.out.println(" Password: " + users.get(nCtr).getPassword());
            System.out.println(" Role: " + users.get(nCtr).getRole());
        }
        
        // Initialize User Interface
        Frame frame = new Frame();
        frame.init(this);
    }
    
}
