package MENU;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import MyAppointments.Appointment_Form;
import MyCustomer.CustomerForm;
import MyEmployees.Employee_Form;
import MyInventory.Inventory_Form;
import MyService.ServiceForm;
import MyTransactions.Transactions_Form;
import MyVehicle.VehicleForm;
import PARTY_INVENTORY.Inventory;


public class Mymenu extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JMenuBar menuBar;
    private JMenu appointmentMenu;
    private JMenu employeeMenu;
    private JMenu customerMenu;
    private JMenu inventoryMenu;
    private JMenu servicesMenu;
    private JMenu transactionMenu;
    private JMenu vehiclesMenu;
    private JMenu logoutMenu;

    private JMenuItem appointmentItem;
    private JMenuItem employeeItem;
    private JMenuItem customerItem;
    private JMenuItem inventoryItem;
    private JMenuItem servicesItem;
    private JMenuItem transactionItem;
    private JMenuItem vehiclesItem;
    private JMenuItem logoutItem;
    private String loggedInUser;

    public Mymenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create menu items
        appointmentMenu = new JMenu("Appointment");
        appointmentItem = new JMenuItem("Appointment Form");
        appointmentItem.addActionListener(this);
        appointmentMenu.add(appointmentItem);
        menuBar.add(appointmentMenu);

        employeeMenu = new JMenu("Employee");
        employeeItem = new JMenuItem("Employee Form");
        employeeItem.addActionListener(this);
        employeeMenu.add(employeeItem);
        menuBar.add(employeeMenu);

        customerMenu = new JMenu("Customer");
        customerItem = new JMenuItem("Customer Form");
        customerItem.addActionListener(this);
        customerMenu.add(customerItem);
        menuBar.add(customerMenu);

        inventoryMenu = new JMenu("Inventory");
        inventoryItem = new JMenuItem("Inventory_Form");
        inventoryItem.addActionListener(this);
        inventoryMenu.add(inventoryItem);
        menuBar.add(inventoryMenu);

        servicesMenu = new JMenu("Services");
        servicesItem = new JMenuItem("Services Form");
        servicesItem.addActionListener(this);
        servicesMenu.add(servicesItem);
        menuBar.add(servicesMenu);

        transactionMenu = new JMenu("Transaction");
        transactionItem = new JMenuItem("Transactions Form");
        transactionItem.addActionListener(this);
        transactionMenu.add(transactionItem);
        menuBar.add(transactionMenu);

        vehiclesMenu = new JMenu("Vehicles");
        vehiclesItem = new JMenuItem("Vehicle Form");
        vehiclesItem.addActionListener(this);
        vehiclesMenu.add(vehiclesItem);
        menuBar.add(vehiclesMenu);

        logoutMenu = new JMenu("Logout");
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);
        logoutMenu.add(logoutItem);
        menuBar.add(logoutMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " TO PROJECT DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appointmentItem) {
            new Appointment_Form();
            
        } else if (e.getSource() == employeeItem) {
            new Employee_Form();
            
        } else if (e.getSource() == customerItem) {
            new CustomerForm();
            
        } else if (e.getSource() == inventoryItem) {
        	new Inventory();
        	
        } else if (e.getSource() == servicesItem) {
            new ServiceForm();
            
        } else if (e.getSource() == transactionItem) {
            new Transactions_Form();
            
        } else if (e.getSource() == vehiclesItem) {
            new VehicleForm();
            
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Mymenu("TO GARAGE MANAGEMENT SYSTEM"));
    }
}
