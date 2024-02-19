package MyAppointments;

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

import Appointment.MyAppointer;
import MyCustomer.Customer;

public class Appointment_Form implements ActionListener {
	
	JFrame frame;
	JLabel Appoint_Id_lb=new JLabel("Appointment_Id");
	JLabel Cust_Id_lb=new JLabel("Customer_Id");
	JLabel Vehic_Id_lb=new JLabel("Vehicle_Id");
	JLabel Serv_Id_lb=new JLabel("Service_Id");
	JLabel Appoint_Date_lb=new JLabel("Appointment_Date");
	JLabel Status_lb=new JLabel("Status");
	
	JTextField Appoint_Id_txf=new JTextField();
	JTextField Cust_Id_txf=new JTextField();
    JTextField Vehic_Id_txf=new JTextField();
    JTextField Serv_Id_txf= new JTextField();
    JTextField Appoint_Date_txF=new JTextField();
    JTextField Status_txF=new JTextField();
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  Appointment_Form() {
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
        frame.setTitle("Appointment_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Appoint_Id_lb.setBounds(10, 10, 200, 30);
    	Cust_Id_lb.setBounds(10, 50, 200, 30);
    	Vehic_Id_lb.setBounds(10, 90, 200, 30);
    	Serv_Id_lb.setBounds(10, 130, 200, 30);
    	Appoint_Date_lb.setBounds(10, 170, 200, 30);
    	Status_lb.setBounds(10, 210, 200, 30);
    	
    	Appoint_Id_txf.setBounds(200, 10, 150, 30);
    	Cust_Id_txf.setBounds(200, 50, 150, 30);
    	Vehic_Id_txf.setBounds(200, 90, 150, 30);
    	Serv_Id_txf.setBounds(200, 130, 150, 30);
    	Appoint_Date_txF.setBounds(200, 170, 150, 30);
    	Status_txF.setBounds(200, 210, 150, 30);
    	 
    	 
    	 insert_btn.setBounds(10, 300, 85, 30);
         read_btn.setBounds(100, 300, 85, 30);
         update_btn.setBounds(190, 300, 85, 30);
         delete_btn.setBounds(280, 300, 85, 30);
         
         table.setBounds(450, 10, 500, 250);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	Appoint_Id_lb.setFont(fontLabel);
   	Cust_Id_lb.setFont(fontLabel);
   	Vehic_Id_lb.setFont(fontLabel);
   	Serv_Id_lb.setFont(fontLabel);
   	Appoint_Date_lb.setFont(fontLabel);
   	Status_lb.setFont(fontLabel);
   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	Appoint_Id_txf.setFont(fontText);
   	Cust_Id_txf.setFont(fontText);
   	Vehic_Id_txf.setFont(fontText);
   	Serv_Id_txf.setFont(fontText);
   	Appoint_Date_txF.setFont(fontText);
   	Status_txF.setFont(fontText);
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(Appoint_Id_lb);
        frame.add(Cust_Id_lb);
        frame.add(Vehic_Id_lb);
        frame.add(Serv_Id_lb);
        frame.add(Appoint_Date_lb);	
        frame.add(Status_lb);	
       
    	
        frame.add(Appoint_Id_txf);
        frame.add(Cust_Id_txf);
        frame.add(Vehic_Id_txf);
        frame.add(Serv_Id_txf);
        frame.add(Appoint_Date_txF);
        frame.add(Status_txF);
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        
        frame.add(table);
    }
    @Override
     public void actionPerformed(ActionEvent e) {
    MyAppointer Appoint=new MyAppointer();
    if (e.getSource() == insert_btn) {
    	Appoint.setCust_Id(Cust_Id_txf.getText());
    	Appoint.setVehic_Id( Vehic_Id_txf.getText());
    	Appoint.setServ_Id(Serv_Id_txf.getText());
    	Appoint.setAppoint_Date(Appoint_Date_txF.getText());
    	Appoint.setStatus(Status_txF.getText());
    	Appoint.insertData();
    }else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("Appointment_Id");
        model.addColumn("Customer_Id");
        model.addColumn("Vehicle_Id");
        model.addColumn("Service_Id");
        model.addColumn("Appointment_Date");
        model.addColumn("Status");

        ResultSet resultSet = MyAppointer.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), 
                            resultSet.getString(6)});         
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(Appoint_Id_txf.getText());
        Appoint.setCust_Id(Cust_Id_txf.getText());
    	Appoint.setVehic_Id( Vehic_Id_txf.getText());
    	Appoint.setServ_Id(Serv_Id_txf.getText());
    	Appoint.setAppoint_Date(Appoint_Date_txF.getText());
    	Appoint.setStatus(Status_txF.getText());
        Appoint.update(id);;
    } 
    else {
       int id = Integer.parseInt(Appoint_Id_txf.getText());
		Appoint.delete(id);
    }
}	
	public static void main(String[] args) {
		Appointment_Form app=new Appointment_Form();
		System.out.println(app);

	}

}
