package MyTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Transaction {
	private int Transaction_Id  ;
	private String Customer_Id ;
	private String Employee_Id ;
	private String Service_Id  ;
	private String Transaction_Name ;
	private String Transaction_Date ;
	private String Total_Amount;
	private String Payment_Method;
	public Transaction(int Transaction_Id,String Customer_Id,String Employee_Id,String Service_Id,String Transaction_Name, String Transaction_Date,String Total_Amount,String Payment_Method){
		super();
		this.Transaction_Id=Transaction_Id;
		this.Customer_Id=Customer_Id;
		this.Service_Id=Service_Id;
		this.Transaction_Name=Transaction_Name;
		this.Transaction_Date=Transaction_Date;
		this.Total_Amount=Total_Amount;
		this.Payment_Method=Payment_Method;
		
		}
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	public int getTransaction_Id() {
		return Transaction_Id;
	}
	public void setTransaction_Id(int transaction_Id) {
		Transaction_Id = transaction_Id;
	}
	public String getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getEmployee_Id() {
		return Employee_Id;
	}
	public void setEmployee_Id(String employee_Id) {
		Employee_Id = employee_Id;
	}
	public String getService_Id() {
		return Service_Id;
	}
	public void setService_Id(String service_Id) {
		Service_Id = service_Id;
	}
	public String getTransaction_Name() {
		return Transaction_Name;
	}
	public void setTransaction_Name(String transaction_Name) {
		Transaction_Name = transaction_Name;
	}
	public String getTransaction_Date() {
		return Transaction_Date;
	}
	public void setTransaction_Date(String transaction_Date) {
		Transaction_Date = transaction_Date;
	}
	public String getTotal_Amount() {
		return Total_Amount;
	}
	public void setTotal_Amount(String total_Amount) {
		Total_Amount = total_Amount;
	}
	public String getPayment_Method() {
		return Payment_Method;
	}
	public void setPayment_Method(String payment_Method) {
		Payment_Method = payment_Method;
	}
	

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/byiringiro_vianney_garage_management_system";
    String user = "222017985";
    String password = "222017985";

    // SQL query to insert data
    String sql = "INSERT INTO Transactions (Customer_Id, Employee_Id,Service_Id, Transaction_Name, Transaction_Date,Total_Amount, Payment_Method) VALUES (?,?,?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
      
       preparedStatement.setString(1, this.Customer_Id);
       preparedStatement.setString(2, this.Employee_Id);
       preparedStatement.setString(3, this.Service_Id);
       preparedStatement.setString(4, this.Transaction_Name);
       preparedStatement.setString(5, this.Transaction_Date);
       preparedStatement.setString(6, this.Total_Amount);
       preparedStatement.setString(7, this.Payment_Method); 
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
	        String host = "jdbc:mysql://localhost/byiringiro_vianney_garage_management_system";
	        String user = "222017985";
	        String password = "222017985";

	        String sql = "SELECT * FROM Transactions ";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputTransaction_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/byiringiro_vianney_garage_management_system";
    String user = "222017985";
    String password = "222017985";

    // SQL query to update data
    String sql = "UPDATE Transactions SET Customer_Id=?, Employee_Id=?, Service_Id=?, Transaction_Name=?, Transaction_Date=?, Total_Amount=?, Payment_Method=?   WHERE Transaction_Id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement trs = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	 
    	  trs.setString(1, this.getCustomer_Id());
          trs.setString(2, this.getEmployee_Id());
          trs.setString(3, this.getService_Id());
          trs.setString(4, this.getTransaction_Name());
          trs.setString(5, this.getTransaction_Date());
          trs.setString(6, this.getTotal_Amount());
          trs.setString(7, this.getPayment_Method());
          // Assuming there is a column named 'id' for the WHERE clause
       
          trs.setInt(8, inputTransaction_Id);
       
        // Execute the update
        int rowsAffected = trs.executeUpdate();

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
public void delete(int inputTransaction_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/byiringiro_vianney_garage_management_system";
    String user = "222017985";
    String password = "222017985";

    // SQL query to delete data
    String sql = "DELETE FROM Transactions WHERE  Transaction_Id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputTransaction_Id); // Assuming there is a column named 'id' for the WHERE clause

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

