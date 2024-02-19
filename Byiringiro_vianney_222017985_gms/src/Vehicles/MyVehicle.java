package Vehicles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyVehicle {
	private int Veh_Id;
	private String Cust_Id;
	private String Make;
	private String Model;
	private String License_P;
	private String Veh_Id_N; 
	public MyVehicle(int Veh_Id,String Cust_Id,String Make,String Model, String License_P,String Veh_Id_N) {
		super();
		this.Veh_Id=Veh_Id;
		this.Cust_Id=Cust_Id;
		this.Make=Make;
		this.Model=Model;
		this.License_P=License_P;
		this.Veh_Id_N=Veh_Id_N;
		
	}
	public MyVehicle() {
		// TODO Auto-generated constructor stub
	}
	public int getVeh_Id() {
		return Veh_Id;
	}
	public void setVeh_Id(int veh_Id) {
		Veh_Id = veh_Id;
	}
	public String getCust_Id() {
		return Cust_Id;
	}
	public void setCust_Id(String cust_Id) {
		Cust_Id = cust_Id;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String make) {
		Make = make;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getLicense_P() {
		return License_P;
	}
	public void setLicense_P(String license_P) {
		License_P = license_P;
	}
	public String getVeh_Id_N() {
		return Veh_Id_N;
	}
	public void setVeh_Id_N(String veh_Id_N) {
		Veh_Id_N = veh_Id_N;
	}
	
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/garage_management";
    String user = "222017985";
    String password = "222017985";

    // SQL query to insert data
    String sql = "INSERT INTO vehicles (Customer_Id, Make,	Model, Licence_Plate, Vehicle_Identification_Number) VALUES (?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.Cust_Id);
       preparedStatement.setString(2, this.Make);
       preparedStatement.setString(3, this.Model);
       preparedStatement.setString(4, this.License_P);
       preparedStatement.setString(5, this.Veh_Id_N);
       
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

	        String sql = "SELECT * FROM Vehicles ";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
		public void update(int inputVeh_Id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/garage_management";
		    String user = "222017985";
		    String password = "222017985";

		    // SQL query to update data
		    String sql = "UPDATE Vehicles SET Customer_Id=?, Make=?, Model=?, Licence_Plate=?, Vehicle_Identification_Number=?   WHERE Customer_Id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement Cust = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	 
		          Cust.setString(1, this.getCust_Id());
		          Cust.setString(2, this.getMake());
		          Cust.setString(3, this.getModel());
		          Cust.setString(4, this.getLicense_P());
		          Cust.setString(5, this.getVeh_Id_N());
		          Cust.setInt(6, inputVeh_Id);
		          
		          // Assuming there is a column named 'id' for the WHERE clause
		       
		          Cust.setInt(6, inputVeh_Id);
		       
		        // Execute the update
		        int rowsAffected = Cust.executeUpdate();

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
public void delete(int inputVeh_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/garage_management";
    String user = "222017985";
    String password = "222017985";

    // SQL query to delete data
    String sql = "DELETE FROM Vehicles WHERE  Vehicle_Id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputVeh_Id); // Assuming there is a column named 'id' for the WHERE clause

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

