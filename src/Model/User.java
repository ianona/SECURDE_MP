package Model;

import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class User {
    private int id;
    private String username;
    private String password;
    private int role;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        //link to how to do SHA-512 encryption (https://www.geeksforgeeks.org/sha-512-hash-in-java/)
        
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
            this.password = hashtext;
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
