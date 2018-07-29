import java.io.Serializable;

public class Manager extends Person implements Serializable{
    public static String password;
    
    public Manager() { // Default constructor
        
    }
    
    public Manager(int ID, String name, String email, String contactNumber, String gender, String password) { // Overriding constructor
        super.ID = ID;
        super.name = name;
        super.email = email;
        super.contactNumber = contactNumber;
        super.gender = gender;
        Manager.password = password;
    }
    
    public static void register() { // Default method
        //TODO: Implement method
    }
    
    public static void register(int ID, String name, String email, String contactNumber, String gender, String password) { // Overloaded method
        // TODO: Implement method
    }
    
    public int getID() {
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
