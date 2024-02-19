package MyTransactions;

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

import MyCustomer.Customer;
import MyTransaction.Transaction;

public class Transactions_Form implements ActionListener {
	JFrame frame;
	JLabel Transaction_Id_lb=new JLabel("Transaction_Id");
	JLabel Customer_Id_lb=new JLabel("Customer_Id");
	JLabel Employee_Id_lb=new JLabel("Employee_Id");
	JLabel Service_Id_lb=new JLabel("Service_Id");
	JLabel Transaction_Name_lb=new JLabel("Transaction_Name");
	JLabel Transaction_Date_lb=new JLabel("Transaction_Date");
	JLabel Total_Amount_lb=new JLabel("Total_Amount");
	JLabel Payment_Method_lb=new JLabel("Payment_Method");
	
	JTextField Transaction_Id_txf=new JTextField();
	JTextField Customer_Id_txf=new JTextField();
    JTextField Employee_Id_txf=new JTextField();
    JTextField Service_Id_txf= new JTextField();
    JTextField Transaction_Name_txF=new JTextField();
    JTextField Transaction_Date_txF=new JTextField();
    JTextField Total_Amount_txF=new JTextField();
    JTextField Payment_Method_txF=new JTextField();
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  Transactions_Form() {
    	setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }
    private void actionEvent() {
        insert_btn.addActionListener((ActionListener) this);
        read_btn.addActionListener((ActionListener) this);
        update_btn.addActionListener((ActionListener) this);
        delete_btn.addActionListener((ActionListener) this);
        }
    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Transactions_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Transaction_Id_lb.setBounds(10, 10, 200, 30);
    	Customer_Id_lb.setBounds(10, 50, 200, 30);
    	Employee_Id_lb.setBounds(10, 90, 200, 30);
    	Service_Id_lb.setBounds(10, 130, 200, 30);
    	Transaction_Name_lb.setBounds(10, 170, 200, 30);
    	Transaction_Date_lb.setBounds(10, 210, 200, 30);
    	Total_Amount_lb.setBounds(10, 250, 200, 30);
    	Payment_Method_lb.setBounds(10, 290, 200, 30);
    	
    	Transaction_Id_txf.setBounds(200, 10, 150, 30);
    	Customer_Id_txf.setBounds(200, 50, 150, 30);
    	Employee_Id_txf.setBounds(200, 90, 150, 30);
    	Service_Id_txf.setBounds(200, 130, 150, 30);
    	Transaction_Name_txF.setBounds(200, 170, 150, 30);
    	Transaction_Date_txF.setBounds(200, 210, 150, 30);
    	Total_Amount_txF.setBounds(200, 250, 150, 30);
    	Payment_Method_txF.setBounds(200, 290, 150, 30);
    	 
    	 
    	 insert_btn.setBounds(10, 350, 85, 30);
         read_btn.setBounds(100, 350, 85, 30);
         update_btn.setBounds(190, 350, 85, 30);
         delete_btn.setBounds(280, 350, 85, 30);
         
         table.setBounds(400, 10, 800, 250);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	Transaction_Id_lb.setFont(fontLabel);
   	Customer_Id_lb.setFont(fontLabel);
   	Employee_Id_lb.setFont(fontLabel);
   	Service_Id_lb.setFont(fontLabel);
   	Transaction_Name_lb.setFont(fontLabel);
   	Transaction_Date_lb.setFont(fontLabel);
   	Total_Amount_lb.setFont(fontLabel);
   	Payment_Method_lb.setFont(fontLabel);
   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	Transaction_Id_txf.setFont(fontText);
   	Customer_Id_txf.setFont(fontText);
   	Employee_Id_txf.setFont(fontText);
   	Service_Id_txf.setFont(fontText);
   	Transaction_Name_txF.setFont(fontText);
   	Transaction_Date_txF.setFont(fontText);
   	Total_Amount_txF.setFont(fontText);
   	Payment_Method_txF.setFont(fontText);
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(Transaction_Id_lb);
        frame.add(Customer_Id_lb);
        frame.add(Employee_Id_lb);
        frame.add(Service_Id_lb);
        frame.add(Transaction_Name_lb);	
        frame.add(Transaction_Date_lb);
        frame.add(Total_Amount_lb);
        frame.add(Payment_Method_lb);
       
    	
        frame.add(Transaction_Id_txf);
        frame.add(Customer_Id_txf);
        frame.add(Employee_Id_txf);
        frame.add(Service_Id_txf);
        frame.add(Transaction_Name_txF);
        frame.add(Transaction_Date_txF);
        frame.add(Total_Amount_txF);
        frame.add(Payment_Method_txF);
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        
        frame.add(table);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    Transaction trs=new Transaction();
    int id;
	if (e.getSource() == insert_btn) {
        trs.setCustomer_Id(Customer_Id_txf.getText());
        trs.setEmployee_Id(Employee_Id_txf.getText());
        trs.setService_Id(Service_Id_txf.getText());
        trs.setTransaction_Name(Transaction_Name_txF.getText());
        trs.setTransaction_Date(Transaction_Date_txF.getText());
        trs.setTotal_Amount(Total_Amount_txF.getText());
        trs.setPayment_Method(Payment_Method_txF.getText());
        trs.insertData();
    }
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("Transaction_Id");
        model.addColumn("Customer_Id");
        model.addColumn("Employee_Id");
        model.addColumn("Service_Id");
        model.addColumn("Transaction_Name");
        model.addColumn("Transaction_Date");
        model.addColumn("Total_Amount");
        model.addColumn("Payment_Method");

        ResultSet resultSet = Transaction.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)
                            , resultSet.getString(6), resultSet.getString(7), resultSet.getString(8)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource() == update_btn) {
    	id=Integer.parseInt(Transaction_Id_txf.getText());
    	trs.setCustomer_Id(Customer_Id_txf.getText());
        trs.setEmployee_Id(Employee_Id_txf.getText());
        trs.setService_Id(Service_Id_txf.getText());
        trs.setTransaction_Name(Transaction_Name_txF.getText());
        trs.setTransaction_Date(Transaction_Date_txF.getText());
        trs.setTotal_Amount(Total_Amount_txF.getText());
        trs.setPayment_Method(Payment_Method_txF.getText());	
        trs.update(id);
    } 
    else {
        id=Integer.parseInt(Transaction_Id_txf.getText());
        trs.delete(id);}
    }	
	
	public static void main(String[] args) {
		Transactions_Form Transf=new Transactions_Form();
		System.out.println(Transf);
		
	}

	

}
