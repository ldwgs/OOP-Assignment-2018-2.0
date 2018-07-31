package Classes;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Customer extends Person implements Serializable{
    public Customer() {
        
    }
    
    public Customer(String ID, String name, String gender, String email, String contactNumber) {
        super.ID = ID;
        super.name = name;
        super.gender = gender;
        super.email = email;
        super.contactNumber = contactNumber;
    }
    
    // Overloading method (w/o Gender and Password)
    public void register(String ID, String name, String email, String contactNumber, String property, String date) {
        try {
            // Object reference
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
            
            String sql = "INSERT INTO Manager " + "VALUES (" +
                    ID + "," +
                    "'" + name + "'" + "," +
                    "'" + email + "'" + "," +
                    "'" + contactNumber + "'" + "," +
                    "'" + property + "'" + "," +
                    "'" + date + "'" + ")";
            
            s.executeUpdate(sql); // This line of code executes the SQL query and adds in the values to the table
            JOptionPane.showMessageDialog(null, "Successfully added new manager: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(BookingAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Default method (w/ Gender and Password)
    public void register(String ID, String name, String email, String contactNumber, String gender, String property, String date, String password) {
        try {
            // Object reference
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
            
            String sql = "INSERT INTO Manager " + "VALUES (" +
                    ID + "," +
                    "'" + name + "'" + "," +
                    "'" + email + "'" + "," +
                    "'" + contactNumber + "'" + "," +
                    "'" + gender + "'" + "," +
                    "'" + property + "'" + "," +
                    "'" + date + "'" + "," +
                    "'" + password + "'" + ")";
            
            s.executeUpdate(sql); // This line of code executes the SQL query and adds in the values to the table
            JOptionPane.showMessageDialog(null, "Successfully added new manager: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(BookingAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String contactNumber() {
        return contactNumber;
    }
}
