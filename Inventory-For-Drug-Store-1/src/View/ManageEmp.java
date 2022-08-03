package View;


import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.util.Random;
import Model.*;
import Model.Designation.designation;
import Controller.*;

public class ManageEmp extends JFrame implements ActionListener {

JTextField searchTf = new JTextField();
JButton searchBt = new JButton("Search");
JButton showAllBt = new JButton("Show All");

JTable empTable;
JScrollPane empTableSP;

JLabel  empIdLb = new JLabel("Emp Id");
JTextField empIdTf= new JTextField();

JCheckBox load = new JCheckBox("Load");

JLabel  empNameLb = new JLabel("Emp Name");
JTextField empNameTf= new JTextField();

JLabel  contactLb = new JLabel("Contact");
JTextField contactTf= new JTextField();

JLabel salaryLb = new JLabel("Salary");
JTextField salaryTf = new JTextField();

JLabel statusLb = new JLabel("Designation");
JTextField statusTf = new JTextField();


JButton addBt = new JButton("Add");
    JButton removeBt = new JButton("Remove");
JButton refreshBt = new JButton("Refresh");
JButton updateBt = new JButton("Update");

JButton logout=new JButton("Logout");
    JButton back=new JButton("Back");

Employee user;
EmployeeController pr = new EmployeeController();
//EmployeeRepository er = new EmployeeRepository();

    public ManageEmp(Employee user){
setSize(1200,700);
setTitle("Employee Management");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout(null);
setLocationRelativeTo(null);

this.user=user;
       
        logout.setBounds(1070,20,80,20); //Logout button size
        logout.addActionListener(this);
        add(logout);

        back.setBounds(1075,50,70,20); //Back button size
        back.addActionListener(this);
        add(back);

        searchTf.setBounds(550,120,200,30);
add(searchTf);
searchBt.setBounds(760,120,80,30);
add(searchBt);
searchBt.addActionListener(this);

showAllBt.setBounds(850,120,100,30);
add(showAllBt);
showAllBt.addActionListener(this);

String dataM[][] = {{"", "", "", "",""}};
String headM[] = {"empId", "empName", "contact", "salary", "status"};

empTable = new JTable(dataM,headM);
empTable.setEnabled(false);
empTableSP = new JScrollPane(empTable);
empTableSP.setBounds(500,170,600,400);
add(empTableSP);

empIdLb.setBounds(100,200,60,30);
add(empIdLb);
empIdTf.setBounds(170,200,120,30);
add(empIdTf);

load.setBounds(310,204,60,20);
add(load);
load.addActionListener(this);

empNameLb.setBounds(100,250,70,30);
add(empNameLb);
empNameTf.setBounds(170,250,120,30);
add(empNameTf);

contactLb.setBounds(100,300,60,30);
add(contactLb);
contactTf.setBounds(170,300,120,30);
add(contactTf);

salaryLb.setBounds(100,350,60,30);
add(salaryLb);
salaryTf.setBounds(170,350,120,30);
add(salaryTf);

statusLb.setBounds(100,400,60,30);
add(statusLb);
statusTf.setBounds(170,400,120,30);
add(statusTf);

addBt.setBounds(100,450,100,30);
add(addBt);
addBt.addActionListener(this);

removeBt.setBounds(210,450,100,30);
add(removeBt);
removeBt.addActionListener(this);
removeBt.setEnabled(false);

refreshBt.setBounds(100,500,100,30);
add(refreshBt);
refreshBt.addActionListener(this);

updateBt.setBounds(210,500,100,30);
add(updateBt);
updateBt.addActionListener(this);
updateBt.setEnabled(false);

setVisible(true);
    }

    public void actionPerformed(ActionEvent a){
if(a.getSource()==logout){
new Login();
this.setVisible(false);
}
else if(a.getSource()==back){
new Home(user);
this.setVisible(false);
}
else if(a.getSource()==searchBt){
if(searchTf.getText().equals("")){
JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
}
else{
String dataM[][] = pr.searchEmployee(searchTf.getText());
String headM[] = {"empId","empName","contact", "Designation", "Salary"};
remove(empTableSP);

empTable = new JTable(dataM,headM);
empTable.setEnabled(false);
empTableSP = new JScrollPane(empTable);
empTableSP.setBounds(500,170,600,400);
add(empTableSP);

this.revalidate();
this.repaint();
}
}
else if(a.getSource()==showAllBt){
String dataM[][] = pr.getEmployees();
String headM[] = {"empName", "contact","empId", "salary","Designation"};
remove(empTableSP);

empTable = new JTable(dataM,headM);
empTable.setEnabled(false);
empTableSP = new JScrollPane(empTable);
empTableSP.setBounds(500,170,600,400);
add(empTableSP);

this.revalidate();
this.repaint();
}
else if(a.getSource()==load){
if(empNameTf.getText().equals("")){
JOptionPane.showMessageDialog(this,"Employee Name required!!","WARNING",JOptionPane.WARNING_MESSAGE);
load.setSelected(false);
}
else{
Employee emp = (Employee) pr.searchUser((empNameTf.getText()));
if(emp==null){
JOptionPane.showMessageDialog(this,"No employee for this name","warning",JOptionPane.WARNING_MESSAGE);
load.setSelected(false);
}
else{
empIdTf.setText(emp.getUserId());
contactTf.setText(emp.getContact()+"");
salaryTf.setText(emp.getSalary()+"");
statusTf.setText(emp.getDesignation());
updateBt.setEnabled(true);
removeBt.setEnabled(true);
}
}
}
else if(a.getSource()==addBt){
if(empIdTf.getText().equals("") || empNameTf.getText().equals("") || contactTf.getText().equals("") || salaryTf.getText().equals("") || statusTf.getText().equals("")){
JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
}
else{
String id = (empIdTf.getText());
String name = empNameTf.getText();
String contact = (contactTf.getText());
double sal = Double.parseDouble(salaryTf.getText());
String designation = statusTf.getText();

Random rd = new Random();
String password = rd.nextInt(89999999)+ 10000000 +"";

Employee emp = new Employee(id,name,contact,sal,password,designation);

//Employee p = new Person(id,password,status);

pr.addUser(emp);

//pr.addUser(p);
JOptionPane.showMessageDialog(this,"id("+id+")  password("+password+")","your info",JOptionPane.INFORMATION_MESSAGE);

String dataM[][] = pr.searchEmployee(name);
String headM[] = {"empId", "empName","contact", "Designation","salary"};
remove(empTableSP);

empTable = new JTable(dataM,headM);
empTable.setEnabled(false);
empTableSP = new JScrollPane(empTable);
empTableSP.setBounds(500,170,600,400);
add(empTableSP);

this.revalidate();
this.repaint();
}
}
else if(a.getSource()==refreshBt){
searchTf.setText("");
empIdTf.setText("");
empNameTf.setText("");
contactTf.setText("");
salaryTf.setText("");
statusTf.setText("");

load.setSelected(false);
updateBt.setEnabled(false);
removeBt.setEnabled(false);
}
else if(a.getSource()==removeBt){
pr.deleteEmployee(empNameTf.getText());
JOptionPane.showMessageDialog(this,"Employee removed","Information",JOptionPane.INFORMATION_MESSAGE);
String data[][] = pr.getEmployees();
String head[] = {"empName","contact","empId", "salary", "Designation"};

remove(empTableSP);

empTable = new JTable(data,head);
empTable.setEnabled(false);
empTableSP = new JScrollPane(empTable);
empTableSP.setBounds(500,170,600,400);
add(empTableSP);

this.revalidate();
this.repaint();
}
else if(a.getSource()==updateBt){
if(empIdTf.getText().equals("") || empNameTf.getText().equals("") || contactTf.getText().equals("") || salaryTf.getText().equals("") || statusTf.getText().equals("")){
JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
}
else{
String id = (empIdTf.getText());
String name = empNameTf.getText();
String contact = (contactTf.getText());
double sal = Double.parseDouble(salaryTf.getText());
String designation = statusTf.getText();

Employee emp = new Employee(id,name,contact,sal,designation);

pr.updateUser(emp);
JOptionPane.showMessageDialog(this,"Employee Updated","Information",JOptionPane.INFORMATION_MESSAGE);
String dataM[][] = pr.getEmployees();
String headM[] = {"empName","contact","empId", "salary", "Designation"};
remove(empTableSP);

empTable = new JTable(dataM,headM);
empTable.setEnabled(false);
empTableSP = new JScrollPane(empTable);
empTableSP.setBounds(500,170,600,400);
add(empTableSP);

this.revalidate();
this.repaint();
}
}
}
}  