package MyService;

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
import MyVehicle.VehicleForm;
import Services.MyService;

public class ServiceForm implements ActionListener {
	JFrame frame;
	JLabel Service_Id_lb=new JLabel("Service_Id");
	JLabel Service_Name_lb=new JLabel("Service_Name");
	JLabel Description_lb=new JLabel("Description");
	JLabel Cost_lb=new JLabel("Cost");
	
	
	JTextField Service_Id_txf=new JTextField();
	JTextField Service_Name_txf=new JTextField();
    JTextField Description_txf=new JTextField();
    JTextField Cost_txf= new JTextField();
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public ServiceForm() {
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
        frame.setTitle("ServiceForm");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.RED);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Service_Id_lb.setBounds(10, 10, 200, 30);
    	Service_Name_lb.setBounds(10, 50, 200, 30);
    	Description_lb.setBounds(10, 90, 200, 30);
    	Cost_lb.setBounds(10, 130, 200, 30);
    	
    	
    	Service_Id_txf.setBounds(200, 10, 150, 30);
    	Service_Name_txf.setBounds(200, 50, 150, 30);
    	Description_txf.setBounds(200, 90, 150, 30);
    	Cost_txf.setBounds(200, 130, 150, 30);
    	 
    	 
    	 
    	 insert_btn.setBounds(10, 200, 85, 30);
         read_btn.setBounds(100, 200, 85, 30);
         update_btn.setBounds(190, 200, 85, 30);
         delete_btn.setBounds(280, 200, 85, 30);
         
         table.setBounds(450, 10, 700, 250);
     	}
    private void setFontForAll() {
   	 Font fontLabel = new Font("Georgia", Font.BOLD, 18);
     Service_Id_lb.setFont(fontLabel);
     Service_Name_lb.setFont(fontLabel);
     Description_lb.setFont(fontLabel);
     Cost_lb.setFont(fontLabel);
   	
   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	Service_Id_txf.setFont(fontText);
   	Service_Name_txf.setFont(fontText);
   	Description_txf.setFont(fontText);
   	Cost_txf.setFont(fontText);
      
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(Service_Id_lb);
        frame.add(Service_Name_lb);
        frame.add(Description_lb);
        frame.add(Cost_lb);
        
       
    	frame.add(Service_Id_txf);
        frame.add(Service_Name_txf);
        frame.add(Description_txf);
        frame.add(Cost_txf);
       
       //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        
        frame.add(table);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
   MyService svc=new MyService(0, null, null, null);
		   if (e.getSource() == insert_btn) {
        svc.setService_Name(Service_Name_txf.getText());
        svc.setDescription(Description_txf.getText());
        svc.setCost(Cost_txf.getText());
        svc.insertData();
    }else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("Service_Id");
        model.addColumn("Service_Name");
        model.addColumn("Description");
        model.addColumn("Cost");
        

        ResultSet resultSet =  MyService.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), });
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource() == update_btn) {
        int Id = Integer.parseInt(Service_Id_txf.getText());
        svc.setService_Name(Service_Name_txf.getText());
        svc.setDescription(Description_txf.getText());
        svc.setCost(Cost_txf.getText());
        
        svc.update(Id);
    } 
    else {
        int Id = Integer.parseInt(Service_Id_txf.getText());
        svc.delete(Id);
    }
}
	
	public static void main(String[] args) {
		ServiceForm Servf=new ServiceForm();

	}}
