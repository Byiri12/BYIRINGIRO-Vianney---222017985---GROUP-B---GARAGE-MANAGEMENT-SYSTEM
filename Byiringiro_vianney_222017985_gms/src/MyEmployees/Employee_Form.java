package MyEmployees;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Employee.MyEmployee;

public class Employee_Form implements ActionListener {
    JFrame frame;
    JLabel Employee_Id_lb = new JLabel("Employee_Id");
    JLabel First_Name_lb = new JLabel("First_Name");
    JLabel Last_Name_lb = new JLabel("Last_Name");
    JLabel Contact_Number_lb = new JLabel("Contact_Number");
    JLabel Email_lb = new JLabel(" Email");
    JLabel Position_lb = new JLabel("Position");

    JTextField Employee_Id_txf = new JTextField();
    JTextField First_Name_txf = new JTextField();
    JTextField Last_Name_txf = new JTextField();
    JTextField Contact_Number_txf = new JTextField();
    JTextField Email_txF = new JTextField();
    JTextField Position_txF = new JTextField();

    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getHeight(); // Fix getWidth to getHeight

    public Employee_Form() {
        setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }

    private void actionEvent() {
        insert_btn.addActionListener(this); // Remove unnecessary cast
        read_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Employee_Form");
        frame.setBounds(0, 0, w / 2, h / 2); // Correct height calculation
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        Employee_Id_lb.setBounds(10, 10, 200, 30);
        First_Name_lb.setBounds(10, 50, 200, 30);
        Last_Name_lb.setBounds(10, 90, 200, 30);
        Contact_Number_lb.setBounds(10, 130, 200, 30);
        Email_lb.setBounds(10, 170, 200, 30);
        Position_lb.setBounds(10, 210, 200, 30);

        Employee_Id_txf.setBounds(200, 10, 150, 30);
        First_Name_txf.setBounds(200, 50, 150, 30);
        Last_Name_txf.setBounds(200, 90, 150, 30);
        Contact_Number_txf.setBounds(200, 130, 150, 30);
        Email_txF.setBounds(200, 170, 150, 30);
        Position_txF.setBounds(200, 210, 150, 30);

        insert_btn.setBounds(10, 300, 85, 30);
        read_btn.setBounds(100, 300, 85, 30);
        update_btn.setBounds(190, 300, 85, 30);
        delete_btn.setBounds(280, 300, 85, 30);

        table.setBounds(450, 10, 700, 250);
    }

    private void setFontForAll() {
        Font fontLabel = new Font("Georgia", Font.BOLD, 18);
        Employee_Id_lb.setFont(fontLabel);
        First_Name_lb.setFont(fontLabel);
        Last_Name_lb.setFont(fontLabel);
        Contact_Number_lb.setFont(fontLabel);
        Email_lb.setFont(fontLabel);
        Position_lb.setFont(fontLabel);

        Font fontText = new Font("Georgia", Font.BOLD, 18);
        Employee_Id_txf.setFont(fontText);
        First_Name_txf.setFont(fontText);
        Last_Name_txf.setFont(fontText);
        Contact_Number_txf.setFont(fontText);
        Email_txF.setFont(fontText);
        Position_txF.setFont(fontText);

        Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
        insert_btn.setFont(fontButtonItalic);
        read_btn.setFont(fontButtonItalic);
        update_btn.setFont(fontButtonItalic);
        delete_btn.setFont(fontButtonItalic);
    }

    private void addComponentToFrame() {
        frame.add(Employee_Id_lb);
        frame.add(First_Name_lb);
        frame.add(Last_Name_lb);
        frame.add(Contact_Number_lb);
        frame.add(Email_lb);
        frame.add(Position_lb);

        frame.add(Employee_Id_txf);
        frame.add(First_Name_txf);
        frame.add(Last_Name_txf);
        frame.add(Contact_Number_txf);
        frame.add(Email_txF);
        frame.add(Position_txF);

        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);

        frame.add(table);
    }

    public void actionPerformed(ActionEvent e) {
        MyEmployee Ep = new MyEmployee();
        if (e.getSource() == insert_btn) {
            Ep.setFirst_Name(First_Name_txf.getText());
            Ep.setLast_Name(Last_Name_txf.getText());
            Ep.setContact_Number(Contact_Number_txf.getText());
            Ep.setEmail(Email_txF.getText());
            Ep.setPosition(Position_txF.getText());
            Ep.insertData();
        } else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Employee_Id"); // Correct column names
            model.addColumn("First_Name");
            model.addColumn("Last_Name");
            model.addColumn("Contact_Number");
            model.addColumn("Email");
            model.addColumn("Position");

            ResultSet resultSet = MyEmployee.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                                resultSet.getString(6) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == update_btn) {
            int id = Integer.parseInt(Employee_Id_txf.getText());
            Ep.setFirst_Name(First_Name_txf.getText());
            Ep.setLast_Name(Last_Name_txf.getText());
            Ep.setContact_Number(Contact_Number_txf.getText());
            Ep.setEmail(Email_txF.getText());
            Ep.setPosition(Position_txF.getText());
            Ep.update(id);
        } else {
            int id = Integer.parseInt(Employee_Id_txf.getText());
            Ep.delete(id);
        }
    }

    public static void main(String[] args) {
        Employee_Form Empf = new Employee_Form();
        System.out.println(Empf);
    }
}
