package View;

import Model.*;
import Controller.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;


public class Home extends JFrame implements ActionListener {
   
    JButton logoutBt=new JButton("Logout");
    JButton manageMedBt = new JButton("Manage Medicines");
    JButton sellMedBt = new JButton("Sell medicine");
    JButton manageEmpBt= new JButton("Manage Employees");
    JButton changePasswordBt = new JButton("Change Password");
    Employee user;
    public Home(Employee user){
    	super("Home");
    	setTitle("Home");
    	setSize(1200,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.user = user;
        
        logoutBt.setBounds(1070,20,80,20); //Logout button size
        logoutBt.addActionListener(this);
        add(logoutBt);

        manageMedBt.setBounds(510,150,200,30); //Manage Medicine button size
        manageMedBt.addActionListener(this);
        add(manageMedBt);

        manageEmpBt.setBounds(510,250,200,30); //Manage emp button size
        manageEmpBt.addActionListener(this);
        add(manageEmpBt);
        

		changePasswordBt.setBounds(510,450,200,30);
		changePasswordBt.addActionListener(this);
		add(changePasswordBt);

        sellMedBt.setBounds(510,350,200,30); //Sell med button size
        sellMedBt.addActionListener(this);
        add(sellMedBt);
        

setVisible(true);
}

  public void actionPerformed(ActionEvent a){
  if(a.getSource()==logoutBt){
  new Login();
  this.setVisible(false);
    }

    else if(a.getSource()==manageEmpBt){
    	new ManageEmp(user);
    	this.setVisible(false);
}
    else if(a.getSource()==manageMedBt){
    	new ManageMed(user);
    	this.setVisible(false);
    }
  try {
    if(a.getSource()==sellMedBt){
    	new Cart(user);
    	this.setVisible(false);
    }
    
    else if(a.getSource()==changePasswordBt){
		new ChangePassword(user);
		this.setVisible(false);
	}}
    catch(Exception e){
    	System.out.println(e.getMessage());
    	}
    }
  
}

