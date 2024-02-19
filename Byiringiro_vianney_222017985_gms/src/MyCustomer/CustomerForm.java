package MyCustomer;

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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CustomerForm implements ActionListener {

    JFrame frame;
    JLabel Cust_Id_lb = new JLabel("Customer_Id");
    JLabel fname_lb = new JLabel("First Name");
    JLabel lname_lb = new JLabel("Last Name");
    JLabel Cont_N_lb = new JLabel("Contact_Number");
    JLabel Addr_lb = new JLabel("Address");

    JTextField Cust_Id_txf = new JTextField();
    JTextField fname_txf = new JTextField();
    JTextField lname_txf = new JTextField();
    JTextField Cont_N_txf = new JTextField();
    JTextField Addr_txF = new JTextField();

    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screenSize.getWidth();
    int h = (int) screenSize.getHeight();

    public CustomerForm() {
        setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }

    private void actionEvent() {
        insert_btn.addActionListener(this);
        read_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("CustomerForm");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        Cust_Id_lb.setBounds(10, 10, 200, 30);
        fname_lb.setBounds(10, 50, 200, 30);
        lname_lb.setBounds(10, 90, 200, 30);
        Cont_N_lb.setBounds(10, 130, 200, 30);
        Addr_lb.setBounds(10, 170, 200, 30);

        Cust_Id_txf.setBounds(200, 10, 150, 30);
        fname_txf.setBounds(200, 50, 150, 30);
        lname_txf.setBounds(200, 90, 150, 30);
        Cont_N_txf.setBounds(200, 130, 150, 30);
        Addr_txF.setBounds(200, 170, 150, 30);

        insert_btn.setBounds(10, 300, 85, 30);
        read_btn.setBounds(100, 300, 85, 30);
        update_btn.setBounds(190, 300, 85, 30);
        delete_btn.setBounds(280, 300, 85, 30);

        table.setBounds(500, 10, 700, 250);
    }

    private void setFontForAll() {
        Font fontLabel = new Font("Georgia", Font.BOLD, 18);
        Cust_Id_lb.setFont(fontLabel);
        fname_lb.setFont(fontLabel);
        lname_lb.setFont(fontLabel);
        Cont_N_lb.setFont(fontLabel);
        Addr_lb.setFont(fontLabel);

        Font fontText = new Font("Georgia", Font.BOLD, 18);
        Cust_Id_txf.setFont(fontText);
        fname_txf.setFont(fontText);
        lname_txf.setFont(fontText);
        Cont_N_txf.setFont(fontText);
        Addr_txF.setFont(fontText);

        Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
        insert_btn.setFont(fontButtonItalic);
        read_btn.setFont(fontButtonItalic);
        update_btn.setFont(fontButtonItalic);
        delete_btn.setFont(fontButtonItalic);
    }

    private void addComponentToFrame() {
        frame.add(Cust_Id_lb);
        frame.add(fname_lb);
        frame.add(lname_lb);
        frame.add(Cont_N_lb);
        frame.add(Addr_lb);

        frame.add(Cust_Id_txf);
        frame.add(fname_txf);
        frame.add(lname_txf);
        frame.add(Cont_N_txf);
        frame.add(Addr_txF);

        // Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        
        frame.add(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Customer Cust = new Customer();
        if (e.getSource() == insert_btn) {
            Cust.setFname(fname_txf.getText());
            Cust.setLname(lname_txf.getText());
            Cust.setCont_N(Cont_N_txf.getText());
            Cust.setAddr(Addr_txF.getText());
            Cust.insertData();
            
        } else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Customer_Id");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Contact_Number");
            model.addColumn("Address");

            ResultSet resultSet = Customer.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == update_btn) {
            int id = Integer.parseInt(Cust_Id_txf.getText());
            Cust.setFname(fname_txf.getText());
            Cust.setLname(lname_txf.getText());
            Cust.setCont_N(Cont_N_txf.getText());
            Cust.setAddr(Addr_txF.getText());
            Cust.update(id);
        } else if (e.getSource() == delete_btn) {
            int id = Integer.parseInt(Cust_Id_txf.getText());
            Cust.delete(id);
        }
    }

    public static void main(String[] args) {
        CustomerForm custForm = new CustomerForm();
        System.out.println(custForm);
    }
}
