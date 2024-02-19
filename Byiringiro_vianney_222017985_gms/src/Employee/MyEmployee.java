package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyEmployee {
    private int Employee_Id;
    private String First_Name;
    private String Last_Name;
    private String Contact_Number;
    private String Email;
    private String Position;

    public MyEmployee() {
        // Default constructor
    }

    public MyEmployee(int Employee_Id, String First_Name, String Last_Name, String Contact_Number, String Email, String Position) {
        super();
        this.Employee_Id = Employee_Id;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Contact_Number = Contact_Number;
        this.Email = Email;
        this.Position = Position;
    }

    public int getEmployee_Id() {
        return Employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        Employee_Id = employee_Id;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/byiringiro_vianney_garage_management_system.sql";
        String user = "222017985";
        String password = "222017985";

        String sql = "INSERT INTO Employees (First_Name, Last_Name, Contact_Number, Email, Position) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, this.First_Name);
            preparedStatement.setString(2, this.Last_Name);
            preparedStatement.setString(3, this.Contact_Number);
            preparedStatement.setString(4, this.Email);
            preparedStatement.setString(5, this.Position);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/byiringiro_vianney_garage_management_system.sql";
        String user = "222017985";
        String password = "222017985";

        String sql = "SELECT * FROM Employees";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(int inputEmployee_Id) {
        String url = "jdbc:mysql://localhost/byiringiro_vianney_garage_management_system.sql";
        String user = "222017985";
        String password = "222017985";

        String sql = "UPDATE Employees SET First_Name=?, Last_Name=?, Contact_Number=?, Email=?, Position=? WHERE Employee_Id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.getFirst_Name());
            stm.setString(2, this.getLast_Name());
            stm.setString(3, this.getContact_Number());
            stm.setString(4, this.getEmail());
            stm.setString(5, this.getPosition());
            stm.setInt(6, inputEmployee_Id);

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to update data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found!", "After update", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int inputEmployee_Id) {
        String url = "jdbc:mysql://localhost/garage_management";
        String user = "222017985";
        String password = "222017985";

        String sql = "DELETE FROM Employees WHERE Employee_Id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pl = con.prepareStatement(sql)) {
            pl.setInt(1, inputEmployee_Id);

            int rowsAffected = pl.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to delete data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found!", "After delete", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
