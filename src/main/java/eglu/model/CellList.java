package eglu.model;

public class CellList {
	
	private String firstName;
	private String lastName;
	private String category;
	private String birthday;
	private String address;
	private String coutnCellList;
	//......................................................................
	// Get:
	public String getCoutnCellList() {
		return coutnCellList;
	}	
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getBirthday() {
		return birthday;
	}
		
	public String getAddress() {
		return address;
	}
		
	//......................................................................
	
	//Set:
		
	public CellList setFirstName (String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public CellList setLastName (String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public CellList setBirthday (String birthday) {
		this.birthday = birthday;
		return this;
	}
	
	public CellList setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public CellList setCategory (String category) {
		this.category = category;
		return this;
	}
	//......................................................................
	
	
}
