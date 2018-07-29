package Classes;

public class Property {
	public int ID;
	public String name;
	public String address;
	public String type;
	public boolean vacancy;
	public boolean toRent = false;
	public boolean toSell = false;
	public String state;
	public double price;
	public double squareFootage;
	
	public Property() { // Default constructor
		
	}

	public Property(int ID, String name, String address, String type, boolean vacancy, boolean toRent, boolean toSell, String state, double price, double squareFootage) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.type = type;
		this.vacancy = vacancy;
		this.toRent = toRent;
		this.toSell = toSell;
		this.state = state;
		this.price = price;
		this.squareFootage = squareFootage;
	}
}
