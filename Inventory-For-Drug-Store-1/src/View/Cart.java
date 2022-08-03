package View;

import javax.swing.*;
import java.awt.event.*;

import Model.*;
import Controller.*;

public class Cart extends JFrame implements ActionListener{
	DatabaseConnection datacon = new DatabaseConnection();

JButton logout=new JButton("Logout");
    JButton back=new JButton("Back");

JTextField searchTf = new JTextField();
JButton searchBt = new JButton("search");

JTable saleTable,medTable;
JScrollPane saleTableSP,medTableSP;

JLabel saleIdLb = new JLabel("Sale Id");
JTextField saleIdTf = new JTextField();

JLabel medIdLb = new JLabel("Med Id");
JTextField medIdTf = new JTextField();

JLabel medNameLb = new JLabel("Med Name");
JTextField medNameTf = new JTextField();


JLabel unitPriceLb = new JLabel("Unit price");
JTextField unitPriceTf = new JTextField();

JLabel quantityLb = new JLabel("Quantity");
JTextField quantityTf = new JTextField();

JLabel amountLb = new JLabel("Amount");
JTextField amountTf = new JTextField();

JCheckBox load = new JCheckBox("Load");
JCheckBox calculateBt = new JCheckBox("Calculate");

JButton addToCart = new JButton("Add to Cart");

JButton refreshBt = new JButton("Refresh");

JButton updateCartBt = new JButton("Update");



JButton calculateTotalAmountBt = new JButton("Calculate Total Amount");

JLabel totalAmountLb = new JLabel("Total amount");
JTextField totalAmountTf = new JTextField();

JLabel cashPaidLb = new JLabel("Cash Paid");
JTextField cashPaidTf = new JTextField();

JCheckBox getChange = new JCheckBox();

JLabel changeAmountLb = new JLabel("Change Amount");
JTextField changeAmountTf = new JTextField();

JButton checkOutBt = new JButton("Check Out");

Employee user;
BillController sr = new BillController();
MedicineController mr = new MedicineController();

public Cart(Employee user){

setSize(1200,700);
setTitle("SalePoint");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout(null);
setLocationRelativeTo(null);

this.user=user;

logout.setBounds(1070,20,80,20);
        logout.addActionListener(this);
        add(logout);

        back.setBounds(1075,50,70,20);
        back.addActionListener(this);
        add(back);

searchTf.setBounds(50,120,200,20);
add(searchTf);
searchBt.setBounds(260,120,80,20);
add(searchBt);
searchBt.addActionListener(this);

String dataM[][] = {{"", "", "", "",""}};
String headM[] = {"medId", "medName", "medType", "unitPrice", "quantity"};

medTable = new JTable(dataM,headM);
medTable.setEnabled(false);
medTableSP = new JScrollPane(medTable);
medTableSP.setBounds(50,150,400,100);
add(medTableSP);

saleIdLb.setBounds(50,310,60,20);
add(saleIdLb);
saleIdTf.setBounds(130,310,120,20);
add(saleIdTf);
saleIdTf.setEnabled(false);
saleIdTf.setText(sr.getSaleId()+"");

medIdLb.setBounds(50,340,60,20);
add(medIdLb);
medIdTf.setBounds(130,340,120,20);
medNameTf.setEnabled(false);
add(medIdTf);

load.setBounds(260,340,80,20);
add(load);
load.addActionListener(this);

medNameLb.setBounds(50,370,60,20);
add(medNameLb);
medNameTf.setBounds(130,370,120,20);
medNameTf.setEnabled(true);
add(medNameTf);

unitPriceLb.setBounds(50,400,60,20);
add(unitPriceLb);
unitPriceTf.setBounds(130,400,120,20);
unitPriceTf.setEnabled(false);
add(unitPriceTf);

quantityLb.setBounds(50,430,60,20);
add(quantityLb);
quantityTf.setBounds(130,430,120,20);
add(quantityTf);

quantityLb.setBounds(50,430,60,20);
add(quantityLb);
quantityTf.setBounds(130,430,120,20);
add(quantityTf);
quantityTf.setEnabled(false);

calculateBt.setBounds(260,430,80,20);
add(calculateBt);
calculateBt.addActionListener(this);

amountLb.setBounds(50,460,60,20);
add(amountLb);
amountTf.setBounds(130,460,120,20);
add(amountTf);
amountTf.setEnabled(false);

addToCart.setBounds(50,510,100,20);
add(addToCart);
addToCart.addActionListener(this);

refreshBt.setBounds(50,540,100,20);
add(refreshBt);
refreshBt.addActionListener(this);

updateCartBt.setBounds(160,540,100,20);
add(updateCartBt);
updateCartBt.addActionListener(this);
updateCartBt.setEnabled(false);

String data[][] = {{"", "", "","","",""}};
String head[] = {"saleId", "medId", "medName", "quantity", "unitPrice", "amount"};

saleTable = new JTable(data,head);
saleTable.setEnabled(false);
saleTableSP = new JScrollPane(saleTable);
saleTableSP.setBounds(550,150,600,350);
add(saleTableSP);

calculateTotalAmountBt.setBounds(950,510,180,20);
add(calculateTotalAmountBt);
calculateTotalAmountBt.setEnabled(false);
calculateTotalAmountBt.addActionListener(this);

totalAmountLb.setBounds(550,540,80,20);
add(totalAmountLb);
totalAmountTf.setBounds(640,540,60,20);
add(totalAmountTf);
totalAmountTf.setEnabled(false);

cashPaidLb.setBounds(710,540,60,20);
add(cashPaidLb);
cashPaidTf.setBounds(780,540,60,20);
add(cashPaidTf);
cashPaidTf.setEnabled(false);

getChange.setBounds(860,540,20,20);
add(getChange);
getChange.addActionListener(this);

changeAmountLb.setBounds(910,540,100,20);
add(changeAmountLb);
changeAmountTf.setBounds(1020,540,80,20);
add(changeAmountTf);

checkOutBt.setBounds(1000,580,100,20);
add(checkOutBt);
checkOutBt.addActionListener(this);
checkOutBt.setEnabled(false);

setVisible(true);
}

public void actionPerformed(ActionEvent e){

if(e.getSource()==logout){
new Login();
this.setVisible(false);
}
else if(e.getSource()==back){
new Home(user);
this.setVisible(false);
}

else if(e.getSource()==searchBt){
	if(searchTf.getText().equals("")){
		JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
}
else{
	MedicineController mr = new MedicineController();
	mr = new MedicineController();
	Medicine med = mr.getMedicine(searchTf.getText());
	MyDate expdate = med.getExpiryDate();
	String date_str = expdate.year + "-" + expdate.month + "-" + expdate.day;
	String dataM[][] = {{med.getMedId(),med.getMedName(),med.getUnitPrice()+"",date_str,med.getQuantity()+""}};
	String headM[] = {"medId", "medName", "unitPrice", "ExpiryDate", "Quantity"};
	remove(medTableSP);
	

	medTable = new JTable(dataM,headM);
	medTable.setEnabled(false);
	medTableSP = new JScrollPane(medTable);
	medTableSP.setBounds(50,150,400,100);
	add(medTableSP);

	this.revalidate();
	this.repaint();
	}
}

else if(e.getSource()==load){
	if(medNameTf.getText().equals("")){
		JOptionPane.showMessageDialog(this,"Medicine Name required!!","WARNING",JOptionPane.WARNING_MESSAGE);
		load.setSelected(false);
}
else{
	MedicineController mr = new MedicineController();
	Medicine med = mr.getMedicine(medNameTf.getText());
	if(med==null){
		JOptionPane.showMessageDialog(this,"This medicine is not available","warning",JOptionPane.WARNING_MESSAGE);
		load.setSelected(false);
}
else{
	medIdTf.setText(med.getMedId());
	unitPriceTf.setText(med.getUnitPrice()+"");
	medIdTf.setEnabled(false);
	medNameTf.setEnabled(true);
	unitPriceTf.setEnabled(false);
	quantityTf.setEnabled(true);
		}
	}
}

else if(e.getSource()==calculateBt){
	if(quantityTf.getText().equals("")){
		JOptionPane.showMessageDialog(this,"Quantity required!!","warning",JOptionPane.WARNING_MESSAGE);
		calculateBt.setSelected(false);	
}
else{
	amountTf.setText((Double.parseDouble(quantityTf.getText()) * Double.parseDouble(unitPriceTf.getText())) + "");
}
}
else if(e.getSource()==addToCart){
	if(medIdTf.getText().equals("") || medNameTf.getText().equals("") || unitPriceTf.getText().equals("") || quantityTf.getText().equals("") || amountTf.getText().equals("")){
	JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
}
else {
Bill sale = new Bill();
sale.setBillId(Integer.parseInt(saleIdTf.getText()));
sale.setMedId(medIdTf.getText());
sale.setMedName(medNameTf.getText());
sale.setquantity(Integer.parseInt(quantityTf.getText()));
sale.setUnitPrice(Double.parseDouble(unitPriceTf.getText()));
sale.setamount(Double.parseDouble(amountTf.getText()));

sr.insertSale(sale);

String data[][] = sr.getSale(saleIdTf.getText());
String head[] = {"saleId", "medId", "medName", "quantity", "unitPrice", "amount"};
remove(saleTableSP);

saleTable = new JTable(data,head);
saleTable.setEnabled(false);
saleTableSP = new JScrollPane(saleTable);
saleTableSP.setBounds(550,150,600,350);
add(saleTableSP);

this.revalidate();
this.repaint();

updateCartBt.setEnabled(true);

calculateTotalAmountBt.setEnabled(true);
}
}

else if(e.getSource()==refreshBt){
searchTf.setText("");
saleIdTf.setEnabled(false);
medIdTf.setText("");
medNameTf.setText("");
unitPriceTf.setText("");
quantityTf.setText("");
amountTf.setText("");

load.setSelected(false);
calculateBt.setSelected(false);
quantityTf.setEnabled(false);
medIdTf.setEnabled(true);
}

else if(e.getSource()==updateCartBt){
if(amountTf.getText().equals("")){
JOptionPane.showMessageDialog(this,"Amount required!!","warning",JOptionPane.WARNING_MESSAGE);
}
else{
Bill sale = new Bill();
sale.setBillId(Integer.parseInt(saleIdTf.getText()));
sale.setMedId(medIdTf.getText());
sale.setMedName(medNameTf.getText());
sale.setquantity(Integer.parseInt(quantityTf.getText()));
sale.setUnitPrice(Double.parseDouble(unitPriceTf.getText()));
sale.setamount(Double.parseDouble(amountTf.getText()));

sr.updateSale(sale);

String data[][] = sr.getSale(saleIdTf.getText());
String head[] = {"saleId", "medId", "medName", "quantity", "unitPrice", "amount"};
remove(saleTableSP);

saleTable = new JTable(data,head);
saleTable.setEnabled(false);
saleTableSP = new JScrollPane(saleTable);
saleTableSP.setBounds(550,150,600,350);
add(saleTableSP);

this.revalidate();
this.repaint();
}
}

else if(e.getSource()==calculateTotalAmountBt){

totalAmountTf.setText(sr.calculatePrice(saleIdTf.getText())+"");
cashPaidTf.setEnabled(true);
}

else if(e.getSource()==getChange){
changeAmountTf.setText((int)(Double.parseDouble(cashPaidTf.getText()) - Double.parseDouble(totalAmountTf.getText())) +"");
checkOutBt.setEnabled(true);
}

else if(e.getSource()==checkOutBt){
StockController Sr = new StockController();

datacon.openConnection();
String saleid = saleIdTf.getText();
String[][] data = sr.getSale(saleid);
for(int i=0; i<data.length; i++)
{
	System.out.println(data[i][5]+data[i][4]+data[i][3]+data[i][2]+data[i][1]+data[i][0]);
	int quantity1 = Integer.parseInt(data[i][3]);
	double unitprice1 = Double.parseDouble(data[i][4]);
	double amount1 = Double.parseDouble(data[i][5]);
	Bill bill = new Bill(Integer.parseInt(data[i][0]),data[i][1],data[i][2],unitprice1,amount1,quantity1);
	Sr.removeStock(bill);
}
JOptionPane.showMessageDialog(this,"Order Placed Successfully!!","Order",JOptionPane.WARNING_MESSAGE);

}
}
}