package MyGarage;

public class Garage {
	private int Customer_Id;
	private String First_Name;
	private String Last_Name;
	private String Contact_Number;
	private String Address;

	public Garage(int Customer_Id,String First_Name,String Last_Name,String Contact_Number, String Address) {
		super();
		this.Customer_Id= Customer_Id;
		this.First_Name= First_Name;
		this.Last_Name=Last_Name;
		this.Contact_Number=Contact_Number;
		this.Address=Address;
		
	
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getContact_Number() {
		return Contact_Number;
	}

	public void setContact_Number(String contact_Number) {
		Contact_Number = contact_Number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	
	}		

