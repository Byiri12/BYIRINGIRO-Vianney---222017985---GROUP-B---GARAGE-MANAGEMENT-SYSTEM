package Appointment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyAppointer {
	private int Appoint_Id ;
	private String Cust_Id;
	private String Vehic_Id;
	private String Serv_Id;
	private String Appoint_Date;
	private String Status;
	

	public MyAppointer() {
		//cons
	}

	public MyAppointer(int Appoitment_Id,String Cust_Id,String Vehic_Id,String Serv_Id,String Appoint_Date,String Status){
		super();
		this.Appoint_Id=Appoint_Id;
		this.Cust_Id=Cust_Id;
		this.Vehic_Id=Vehic_Id;
		this.Serv_Id=Serv_Id;
		this.Appoint_Date=Appoint_Date;
		this.Status=Status;
		}

   public int getAppoint_Id() {
		return Appoint_Id;
	}


	public void setAppoint_Id(int appoint_Id) {
		Appoint_Id = appoint_Id;
	}


	public String getCust_Id() {
		return Cust_Id;
	}


	public void setCust_Id(String cust_Id) {
		Cust_Id = cust_Id;
	}


	public String getVehic_Id() {
		return Vehic_Id;
	}


	public void setVehic_Id(String vehic_Id) {
		Vehic_Id = vehic_Id;
	}


	public String getServ_Id() {
		return Serv_Id;
	}


	public void setServ_Id(String serv_Id) {
		Serv_Id = serv_Id;
	}


	public String getAppoint_Date() {
		return Appoint_Date;
	}


	public void setAppoint_Date(String appoint_Date) {
		Appoint_Date = appoint_Date;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}
	


public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/garage_management";
    String user = "222017985";
    String password = "222017985";

    // SQL query to insert data
    String sql = "INSERT INTO Appointments (Customer_Id,Vehicle_Id,Service_Id,Appointment_Date,Status) VALUES (?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
      
       preparedStatement.setString(1, this.Cust_Id);
       preparedStatement.setString(2, this.Vehic_Id);
       preparedStatement.setString(3, this.Serv_Id);
       preparedStatement.setString(4, this.Appoint_Date);
       preparedStatement.setString(5, this.Status); 
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

	        String sql = "SELECT * FROM Appointments ";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
		public void update(int inputAppoint_Id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/garage_management";
		    String user = "222017985";
		    String password = "222017985";

		    // SQL query to update data
		    String sql = "UPDATE Appointments SET Customer_Id=?, Vehicle_Id=?, Service_Id=?, Appointment_Date=?, Status=? WHERE Appointment_Id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement appoint = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	
		          appoint.setString(1, this.getCust_Id());
		          appoint.setString(2, this.getVehic_Id());
		          appoint.setString(3, this.getAppoint_Date());
		          appoint.setString(4, this.getStatus());
		          appoint.setString(5, this.getStatus());
		          // Assuming there is a column named 'id' for the WHERE clause
		       
		          appoint.setInt(6, inputAppoint_Id);
		       
		        // Execute the update
		        int rowsAffected = appoint.executeUpdate();

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
		public void delete(int inputAppointment_Id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/garage_management";
		    String user = "222017985";
		    String password = "222017985";

		    // SQL query to delete data
		    String sql = "DELETE FROM Appointments WHERE  Appointment_Id = ?";

		    try (
		        // Establish the 
		        Connection con= DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = con.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputAppointment_Id); // Assuming there is a column named 'id' for the WHERE clause

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

