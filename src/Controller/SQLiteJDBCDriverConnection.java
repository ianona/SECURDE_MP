package Controller;


import Model.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteJDBCDriverConnection {
    
    String driverURL = "jdbc:sqlite:" + "database.db";
    
    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Database database.db created.");
            }
        } catch (Exception ex) {}
    }
    
    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL,\n"
            + " password TEXT NOT NULL,\n"
            + " role INTEGER DEFAULT 0\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db created.");
        } catch (Exception ex) {}
    }
    public void dropUserTable() {
        String sql = "DROP TABLE users;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db dropped.");
        } catch (Exception ex) {}
    }
    
    public ArrayList<User> getUsers(){
        String sql = "SELECT id, username, password, role FROM users";
        ArrayList<User> users = new ArrayList<User>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("password")));
            
            }
        } catch (Exception ex) {}
        return users;
    }
    
    public ArrayList<User> checkUsers(String temp){
        temp = temp.toLowerCase();
        String sql = "SELECT id, username, password, role FROM users WHERE username = '" +temp +"'";
        ArrayList<User> users = new ArrayList<User>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("password")));
            
            }
        } catch (Exception ex) {}
        return users;
    }
    
    public void addUser(String username, String password) {
        String sql = "INSERT INTO users(username,password) VALUES('" + username + "','" + password + "')";
        username = username.toLowerCase();
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            
//  For this activity, we would not be using prepared statements first.
//      String sql = "INSERT INTO users(username,password) VALUES(?,?)";
//      PreparedStatement pstmt = conn.prepareStatement(sql)) {
//      pstmt.setString(1, username);
//      pstmt.setString(2, password);
//      pstmt.executeUpdate();
        } catch (Exception ex) {}
    }
    
        public void addUser(String username, String password, int role) {
        username = username.toLowerCase();
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
            password = hashtext;
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
            
        String sql = "INSERT INTO users(username,password,role) VALUES('" + username + "','" + password + "','" + role + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            
        } catch (Exception ex) {}
    }
    public void removeUser(String username) {
        String sql = "DELETE FROM users WHERE username='" + username + "');";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("User " + username + " has been deleted.");
        } catch (Exception ex) {}
    }
    
    public ArrayList<User> getCredentials(String username, String password){
        //Please hash password before query code is executed
        String hashPassword = password;
        username = username.toLowerCase();
        ArrayList<User> users = new ArrayList<User>();
        String sql = "SELECT id, username, password, role FROM users where username ='" + username + "' and password ='" + hashPassword + "'" ;
      
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                User user = new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("password"));
                user.setRole(rs.getInt("role"));
                users.add(user);
            }
        } catch (Exception ex) {}
        return users;
        
    }
}
