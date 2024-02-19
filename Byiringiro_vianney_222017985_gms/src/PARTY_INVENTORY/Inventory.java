package PARTY_INVENTORY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Inventory {
	private int Item_Id  ;
	private String Item_Name;
	private String Description;
	private String Item_Type ;
	private String Cst_Per_Type;
	
	
	public Inventory() {
		//constructor
	}

	public Inventory(int Item_Id, String Item_Name, String Description, String Item_Type, String Cst_Per_Type){
		super();
		this.Item_Id =Item_Id ;
		this.Item_Name=Item_Name;
		this.Description=Description;
		this. Item_Type= Item_Type;
		this. Cst_Per_Type =Cst_Per_Type;
		}

    public int getItem_Id() {
		return Item_Id;
	}
   public void setItem_Id(int item_Id) {
		Item_Id = item_Id;
	}



	public String getItem_Name() {
		return Item_Name;
	}



	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public String getItem_Type() {
		return Item_Type;
	}



	public void setItem_Type(String item_Type) {
		Item_Type = item_Type;
	}



	public String getCst_Per_Type() {
		return Cst_Per_Type;
	}

 public void setCst_Per_Type(String cst_Per_Type) {
		Cst_Per_Type = cst_Per_Type;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/garage_management";
	    String user = "222017985";
	    String password = "222017985";

	    // SQL query to insert data
	    String sql = "INSERT INTO Inventory (Item_Name,	Description,	Item_Type,	Cost_Per_Type) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	      
	       preparedStatement.setString(1, this.Item_Name);
	       preparedStatement.setString(2, this.Description);
	       preparedStatement.setString(3, this.Item_Type);
	       preparedStatement.setString(4, this.Cst_Per_Type);
	       
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
			public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/garage_management";
		        String user = "222017985";
		        String password = "222017985";

		        String sql = "SELECT * FROM party_inventory ";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputItem_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/garage_management";
	    String user = "222017985";
	    String password = "222017985";

	    // SQL query to update data
	    String sql = "UPDATE party_inventory SET Item_Name=?, Description=?, Item_Type=?, Cost_Per_Type=?   WHERE Item_Id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	 
	    	  stm.setString(1, this.getItem_Name());
	          stm.setString(2, this.getDescription());
	          stm.setString(3, this.getItem_Type());
	          stm.setString(4, this.getCst_Per_Type()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputItem_Id);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputItem_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/garage_management";
	    String user = "222017985";
	    String password = "222017985";

	    // SQL query to delete data
	    String sql = "DELETE FROM party_inventory WHERE  Item_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputItem_Id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}










