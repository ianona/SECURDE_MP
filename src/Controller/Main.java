package Controller;


import Model.User;
import View.Frame;
import java.util.ArrayList;



public class Main {
    
    public SQLiteJDBCDriverConnection driver;
    
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
        driver.addUser("admin", "qwerty1234");
        driver.addUser("manager", "qwerty1234");
        driver.addUser("staff", "qwerty1234");
        driver.addUser("client1", "qwerty1234");
        driver.addUser("client2", "qwerty1234");
        
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
