package Classes;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lutfijamaluddin
 */
public class Employee extends Person{
    public static String username, password;
    
    // Verifies username and password based on the type of employee they are. Clerk / Manager
    public boolean verifyLogin(String employee, String username, String password) throws SQLException {
        Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();        
        String sql = "SELECT * FROM " + employee;
        ResultSet rs = s.executeQuery(sql);
        
        while(rs.next()) {
            // username and password in textbox equals to a valid value in the database
            if(rs.getString("USERNAME").equals(username) && rs.getString("PASSWORD").equals(password)) {
                return true;
            }
        }
        return false; 
    }  
    
    public void login() {
        //TODO: Implement method
    }
    
    public void menu() {
        //TODO: Implement method
    }
    
    public void generateReports() {
        //TODO: Implement method
    }
    
    public void register() {
        //TODO: Implement method
    }
}
