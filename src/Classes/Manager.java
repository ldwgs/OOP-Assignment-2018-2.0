package Classes;

import jForms.*;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Manager extends Employee implements Serializable{
    
    public Manager() { // Default constructor
        
    }
    
    public Manager(String ID, String name, String email, String contactNumber, String gender, String password, String username) { // Overriding constructor
        super.ID = ID;
        super.name = name;
        super.email = email;
        super.contactNumber = contactNumber;
        super.gender = gender;
        Employee.password = password;
        Employee.username = username;
    }
    
//    public static void register() { // Default method
//        //TODO: Implement method
//    }
//    
//    public static void register(int ID, String name, String email, String contactNumber, String gender, String password) { // Overloaded method
//        // TODO: Implement method
//    }
    
    @Override
    public void login(){
        // Object reference
        ManagerLogin managerLogin = new ManagerLogin();
        managerLogin.setVisible(true);
    }
    
    @Override
    public void menu() {
        // Object reference
        ManagerMenu managerMenu = new ManagerMenu();
        managerMenu.setVisible(true);
    }
    
    @Override
    public void generateReports() {
        // Object reference
        ManagerBookings managerBookings = new ManagerBookings();
        managerBookings.setVisible(true);
    }
    
    public void register(String ID, String name, String email, String contactNumber, String gender, String password, String username) {
        try {
            // Object reference
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
            
            String sql = "INSERT INTO Clerk " + "VALUES (" +
                            ID + "," +
                    "'" + name + "'" + "," +
                    "'" + email + "'" + "," +
                    "'" + contactNumber + "'" + "," +
                    "'" + gender + "'" + "," +
                    "'" + password + "'" + "," +
                    "'" + username + "'" + ")";
            
            s.executeUpdate(sql); // This line of code executes the SQL query and adds in the values to the table
            JOptionPane.showMessageDialog(null, "Successfully added new manager: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(BookingAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Getter methods
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
    
    public String getUsername() {
        return Employee.username;
    }
    
    public String getPassword() {
        return Employee.password;
    }
}
