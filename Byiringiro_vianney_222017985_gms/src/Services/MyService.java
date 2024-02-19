package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyService {
	private int Service_Id;
	private String Service_Name;
	private String Description;
	private String Cost;
	 
	public MyService(int Service_Id,String Service_Name,String Description,String Cost){
		super();
		this.Service_Id=Service_Id;
		this.Service_Name=Service_Name;
		this.Description=Description;
		this.Cost= Cost;
		}

	public int getService_Id() {
		return Service_Id;
	}

	public void setService_Id(int service_Id) {
		Service_Id = service_Id;
	}

	public String getService_Name() {
		return Service_Name;
	}

	public void setService_Name(String service_Name) {
		Service_Name = service_Name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCost() {
		return Cost;
	}

	public void setCost(String cost) {
		Cost = cost;
	}
	
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/garage_management";
    String user = "222017985";
    String password = "22201798";

    // SQL query to insert data
    String sql = "INSERT INTO Services (Service_Name, Description,	Cost) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.Service_Name);
       preparedStatement.setString(2, this.Description);
       preparedStatement.setString(3, this.Cost);
       
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

	        String sql = "SELECT * FROM  Services ";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputService_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/garage_management";
    String user = "222017985";
    String password = "222017985";

    // SQL query to update data
    String sql = "UPDATE Services SET  Service_Name=?, Description=?, Cost=?   WHERE Service_Id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement svc = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	 
    	  svc.setString(1, this.getService_Name());
          svc.setString(2, this.getDescription());
          svc.setString(3, this.getCost());
           // Assuming there is a column named 'id' for the WHERE clause
       
          svc.setInt(4, inputService_Id);
       
        // Execute the update
        int rowsAffected = svc.executeUpdate();

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
public void delete(int inputService_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/garage_management";
    String user = "222017985";
    String password = "222017985";

    // SQL query to delete data
    String sql = "DELETE FROM Services WHERE  Service_Id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputService_Id); // Assuming there is a column named 'id' for the WHERE clause

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

