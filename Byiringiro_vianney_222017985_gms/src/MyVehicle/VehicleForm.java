package MyVehicle;

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
import Vehicles.MyVehicle;



public class VehicleForm implements ActionListener {
	JFrame frame;
	JLabel Veh_Id_lb=new JLabel("Vehicle_Id");
	JLabel Cust_Id_lb=new JLabel("Customer_Id");
	JLabel Make_lb=new JLabel("Make");
	JLabel Model_lb=new JLabel("Model");
	JLabel License_P_lb=new JLabel("License_Plate");
	JLabel Veh_Id_N_lb=new JLabel("Vehicle_Identification_Number");
	
	JTextField Veh_Id_txf=new JTextField();
	JTextField Cust_Id_txf=new JTextField();
    JTextField Make_txf=new JTextField();
    JTextField Model_txf= new JTextField();
    JTextField License_P_txF=new JTextField();
    JTextField Veh_Id_N_txF=new JTextField();
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public VehicleForm() {
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
        frame.setTitle("VehicleForm");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setForeground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Veh_Id_lb.setBounds(10, 10, 200, 30);
    	Cust_Id_lb.setBounds(10, 50, 200, 30);
    	Make_lb.setBounds(10, 90, 200, 30);
    	Model_lb.setBounds(10, 130, 200, 30);
    	License_P_lb.setBounds(10, 170, 200, 30);
    	Veh_Id_N_lb.setBounds(10, 210, 300, 30);
    	
    	Veh_Id_txf.setBounds(350, 10, 150, 30);
    	Cust_Id_txf.setBounds(350, 50, 150, 30);
    	Make_txf.setBounds(350, 90, 150, 30);
    	Model_txf.setBounds(350, 130, 150, 30);
    	License_P_txF.setBounds(350, 170, 150, 30);
    	Veh_Id_N_txF.setBounds(350, 210, 150, 30);
    	 
    	 insert_btn.setBounds(10, 300, 85, 30);
         read_btn.setBounds(100, 300, 85, 30);
         update_btn.setBounds(190, 300, 85, 30);
         delete_btn.setBounds(280, 300, 85, 30);
         
         table.setBounds(550, 10, 700, 250);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	Veh_Id_lb.setFont(fontLabel);
   	Cust_Id_lb.setFont(fontLabel);
   	Make_lb.setFont(fontLabel);
   	Model_lb.setFont(fontLabel);
   	License_P_lb.setFont(fontLabel);
   	Veh_Id_N_lb.setFont(fontLabel);
   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	Veh_Id_txf.setFont(fontText);
   	Cust_Id_txf.setFont(fontText);
   	Make_txf.setFont(fontText);
   	Model_txf.setFont(fontText);
   	License_P_txF.setFont(fontText);
   	Veh_Id_N_txF.setFont(fontText);
   	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(Veh_Id_lb);
        frame.add(Cust_Id_lb);
        frame.add(Make_lb);
        frame.add(Model_lb);
        frame.add(License_P_lb);
        frame.add(Veh_Id_N_lb);
       
    	
        frame.add(Veh_Id_txf);
        frame.add(Cust_Id_txf);
        frame.add(Make_txf);
        frame.add(Model_txf);
        frame.add(License_P_txF);
        frame.add(Veh_Id_N_txF);
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    MyVehicle veh=new MyVehicle();
    if (e.getSource() == insert_btn) {
        veh.setCust_Id(Cust_Id_txf.getText());
        veh.setMake(Make_txf.getText());
        veh.setModel(Model_txf.getText());
        veh.setMake(Make_txf.getText());
        veh.setLicense_P(License_P_txF.getText());
        veh.setVeh_Id_N(Veh_Id_N_txF.getText());
        veh.insertData();
    } else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("Vehicle_Id");
        model.addColumn("Customer_Id");
        model.addColumn("Make");
        model.addColumn("Model");
        model.addColumn("License_Plate");
        model.addColumn("Vehicle_Identification_Number");
        

        ResultSet resultSet = MyVehicle.viewData();
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
    }
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(Veh_Id_txf.getText());
        veh.setCust_Id(Cust_Id_txf.getText());
        veh.setMake(Make_txf.getText());
        veh.setModel(Model_txf.getText());
        veh.setMake(Make_txf.getText());
        veh.setLicense_P(License_P_txF.getText());
        veh.setVeh_Id_N(Veh_Id_N_txF.getText());
        veh.update(id);
    } 
    else {
        int id = Integer.parseInt(Veh_Id_txf.getText());
        veh.delete(id);
    }
}	
	
	public static void main(String[] args) {
		VehicleForm Vehf=new VehicleForm();

	}
}