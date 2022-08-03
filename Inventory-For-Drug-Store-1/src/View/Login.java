package View;

import Model.*;
import Controller.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class Login extends JFrame implements ActionListener,MouseListener{

    JTextField userNameTf = new JTextField();
    JPasswordField passwordTf = new JPasswordField();
    JLabel userNameLb = new JLabel("Username:");
    JLabel passwordLb = new JLabel("Password:");
   
   
    JButton showBt=new JButton("Show");
    JButton loginBt=new JButton("Login");
   
EmployeeController pr;
Employee user;

    public Login(){
        super("Login");
        setSize(1200,700);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       

        loginBt.setBounds(550,450,80,30); //Login button size
        loginBt.addActionListener(this);
        add(loginBt);

        showBt.setBounds(690,300,80,30); //Show button size
        showBt.addMouseListener(this);
        add(showBt);
       
        userNameTf.setBounds(480,200,200,40); //Username Textfield size
        add(userNameTf);
        userNameLb.setBounds(405,200,100,30); //Username Label size
        add(userNameLb);

        passwordTf.setBounds(480,300,200,40); //Password Textfield size
        add(passwordTf);

        passwordLb.setBounds(405,300,100,30); //Password label size
        add(passwordLb);
     }
   
public void mousePressed(MouseEvent me){
        passwordTf.setEchoChar((char)0);
    }
   
public void mouseReleased(MouseEvent me){
         passwordTf.setEchoChar('*');
    }

    public void mouseClicked(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}

    public void actionPerformed(ActionEvent a){
if(userNameTf.getText().equals("")){
JOptionPane.showMessageDialog(this,"Username required","ERROR",JOptionPane.WARNING_MESSAGE);
}
else if(passwordTf.getText().equals("")){
JOptionPane.showMessageDialog(this,"Password required","ERROR",JOptionPane.WARNING_MESSAGE);
        }
else{
	
pr = new EmployeeController();
user = new Employee(userNameTf.getText(),passwordTf.getText());

if(pr.loginEmployee(user)){
	//JOptionPane.showMessageDialog(null,"User found.\nTry Again","ERROR",JOptionPane.INFORMATION_MESSAGE);
new Home(user);
this.setVisible(false);
}
else{
JOptionPane.showMessageDialog(null,"User not found.\nTry Again","ERROR",JOptionPane.INFORMATION_MESSAGE);
}
}
}
}