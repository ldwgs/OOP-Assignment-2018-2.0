import java.io.Serializable;

public class BookingAgent extends Person implements Serializable{
	public BookingAgent() {
		
	}
	
	public BookingAgent(int ID, String name, String gender, String email, String contactNumber) {
		super.ID = ID;
		super.name = name;
		super.gender = gender;
		super.email = email;
		super.contactNumber = contactNumber;
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
