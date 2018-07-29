package Classes;

import jForms.*;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BookingAgent extends Employee implements Serializable{
    
    public BookingAgent() {
        
    }
    
    public BookingAgent(String ID, String password, String username, String name, String gender, String email, String contactNumber) {
        super.ID = ID;
        Employee.password = password;
        Employee.username = username;
        super.name = name;
        super.gender = gender;
        super.email = email;
        super.contactNumber = contactNumber;
    }
    
    @Override
    public void login(){
        // Object reference
        BookingAgentLogin bookingAgentLogin = new BookingAgentLogin();
        bookingAgentLogin.setVisible(true);
    }
    
    @Override
    public void menu() {
        // Object reference
        BookingClerkMenu bookingAgentMenu = new BookingClerkMenu();
        bookingAgentMenu.setVisible(true);
    }
    
    @Override
    public void generateReports() {
        // Obect reference
        ClerkBookings clerkBookings = new ClerkBookings();
        clerkBookings.setVisible(true);
    }
    
    public void addBooking() throws SQLException {
        // Object reference
        AddBooking addBooking = new AddBooking();
        addBooking.setVisible(true);
    }
    
    public void register(String ID, String password, String username, String name, String gender, String email, String contactNumber) {
        try {
            // Object reference
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
            
            String sql = "INSERT INTO Clerk " + "VALUES (" +
                            ID + "," +
                    "'" + password + "'" + "," +
                    "'" + username + "'" + "," +
                    "'" + name + "'" + "," +
                    "'" + gender + "'" + "," +
                    "'" + email + "'" + "," +
                    "'" + contactNumber + "'" + ")";
            
            s.executeUpdate(sql); // This line of code executes the SQL query and adds in the values to the table
            JOptionPane.showMessageDialog(null, "Successfully added new clerk: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(BookingAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getID() {
        return ID;
    }
    
    public String getUsername() {
        return Employee.username;
    }
    
    public String getPassword() {
        return Employee.password;
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
