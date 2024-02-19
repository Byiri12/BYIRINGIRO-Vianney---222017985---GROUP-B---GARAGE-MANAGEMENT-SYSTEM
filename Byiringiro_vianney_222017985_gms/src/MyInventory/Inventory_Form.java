package MyInventory;

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
import PARTY_INVENTORY.Inventory;

public abstract class Inventory_Form implements ActionListener {
	
	JFrame frame;
	JLabel Item_Id_lb=new JLabel("Item_Id");
	JLabel Item_Name_lb=new JLabel("item_name");
	JLabel Descript_lb=new JLabel("Description");
	JLabel It_Type_lb=new JLabel("Item_Type");
	JLabel Cost_P_T_lb=new JLabel("Cost_Per_Type");
	
	
	JTextField Item_Id_txf=new JTextField();
	JTextField Item_Name_txf=new JTextField();
    JTextField Descript_txf=new JTextField();
    JTextField It_Type_txf= new JTextField();
    JTextField Cost_P_T_txF=new JTextField();
   
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    
    
    
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  Inventory_Form() {
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
        frame.setTitle("Inventory_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Item_Id_lb.setBounds(10, 10, 200, 30);
    	Item_Name_lb.setBounds(10, 50, 200, 30);
    	Descript_lb.setBounds(10, 90, 200, 30);
    	It_Type_lb.setBounds(10, 130, 200, 30);
    	Cost_P_T_lb.setBounds(10, 170, 200, 30);
    	
    	
    	Item_Id_txf.setBounds(200, 10, 150, 30);
    	Item_Name_txf.setBounds(200, 50, 150, 30);
    	Descript_txf.setBounds(200, 90, 150, 30);
    	It_Type_txf.setBounds(200, 130, 150, 30);
    	Cost_P_T_txF.setBounds(200, 170, 150, 30);
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100, 250, 85, 30);
         update_btn.setBounds(190, 250, 85, 30);
         delete_btn.setBounds(280, 250, 85, 30);
         
         table.setBounds(450, 10, 700, 250);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	Item_Id_lb.setFont(fontLabel);
   	Item_Name_lb.setFont(fontLabel);
   	Descript_lb.setFont(fontLabel);
   	It_Type_lb.setFont(fontLabel);
   	Cost_P_T_lb.setFont(fontLabel);
   	
   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	Item_Id_txf.setFont(fontText);
   	Item_Name_txf.setFont(fontText);
   	Descript_txf.setFont(fontText);
   	It_Type_txf.setFont(fontText);
   	Cost_P_T_txF.setFont(fontText);
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(Item_Id_lb);
        frame.add(Item_Name_lb);
        frame.add(Descript_lb);
        frame.add(It_Type_lb);
        frame.add(Cost_P_T_lb);	
        	
       
    	
        frame.add(Item_Id_txf);
        frame.add(Item_Name_txf);
        frame.add(Descript_txf);
        frame.add(It_Type_txf);
        frame.add(Cost_P_T_txF);

       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        
        frame.add(table);
    }
    
   public void actionPerformed(ActionEvent e) {
	   Inventory st=new Inventory();
      if (e.getSource() == insert_btn) {
    	
        st.setItem_Name(Item_Name_txf.getText());
        st.setDescription(Descript_txf.getText());
        st.setItem_Type(It_Type_txf.getText());
        st.setCst_Per_Type(Cost_P_T_txF.getText());
        st.insertData();
    }else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("Item_Id"); // Correct column names
        model.addColumn("item_name");
        model.addColumn("Description");
        model.addColumn("Item_Type");
        model.addColumn("Cost_Per_Type");
        
        
        
       

        ResultSet resultSet = Inventory.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                             });
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(Item_Id_txf.getText());
        st.setItem_Name(Item_Name_txf.getText());
        st.setDescription(Descript_txf.getText());
        st.setItem_Type(It_Type_txf.getText());
        st.setCst_Per_Type(Cost_P_T_txF.getText());
        st.update(id);
    } 
    else {
        int id= Integer.parseInt(Item_Id_txf.getText());
        st.delete(id); }
     }	
	public static void main(String[] args) {
		
		Inventory_Form st=new Inventory_Form() {
		};
		 System.out.println(st);
		
	}
}