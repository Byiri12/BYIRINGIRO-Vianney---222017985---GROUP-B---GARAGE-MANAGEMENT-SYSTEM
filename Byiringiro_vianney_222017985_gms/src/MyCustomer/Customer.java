package MyCustomer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Customer {
	private int Cust_Id ;
	private String fname;
	private String lname;
	private String Cont_N;
	private String Addr;
	

	public Customer() {
		//cons
	}

	public Customer(int Cust_Id,String fname,String lname,String Cont_N,String Addr){
		super();
		this.Cust_Id=Cust_Id;
		this.fname=fname;
		this.lname=lname;
		this.Cont_N=Cont_N;
		this.Addr=Addr;
	
		}

   
	public int getCust_Id() {
		return Cust_Id;
	}

	public void setCust_Id(int cust_Id) {
		Cust_Id = cust_Id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCont_N() {
		return Cont_N;
	}

	public void setCont_N(String cont_N) {
		Cont_N = cont_N;
	}

	public String getAddr() {
		return Addr;
	}

	public void setAddr(String addr) {
		Addr = addr;
	}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/garage_management";
    String user = "222017985";
    String password = "222017985";

    // SQL query to insert data
    String sql = "INSERT INTO Customers (First_Name, Last_Name, Contact_Number, Address ) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
      
      
       preparedStatement.setString(1, this.fname);
       preparedStatement.setString(2, this.lname);
       preparedStatement.setString(3, this.Cont_N);
       preparedStatement.setString(4, this.Addr);
        
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

	        String sql = "SELECT * FROM Customers ";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
		public void update(int inputCust_Id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/garage_management";
		    String user = "222017985";
		    String password = "222017985";

		    // SQL query to update data
		    String sql = "UPDATE Customers SET First_Name=?, Last_Name=?, Contact_Number=?, Address=?   WHERE Customer_Id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement Cust = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	 
		          Cust.setString(1, this.getFname());
		          Cust.setString(2, this.getLname());
		          Cust.setString(3, this.getCont_N());
		          Cust.setString(4, this.getAddr());
		          
		          // Assuming there is a column named 'id' for the WHERE clause
		       
		          Cust.setInt(5, inputCust_Id);
		       
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
		public void delete(int inputCust_Id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/garage_management";
		    String user = "222017985";
		    String password = "222017985";

		    // SQL query to delete data
		    String sql = "DELETE FROM Customers WHERE  Customer_Id = ?";

		    try (
		        // Establish the 
		        Connection con= DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = con.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputCust_Id); // Assuming there is a column named 'id' for the WHERE clause

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


