CREATE TABLE Employee (
   UserID varchar(11) NOT NULL,
   Name varchar(10) NOT NULL,
   Contact varchar(11) NOT NULL,
   salary int(8) NOT NULL,
   password varchar(20) NOT NULL,
   Designation varchar(15) NOT NULL
) ;


INSERT INTO Employee (UserID, Name,Contact, salary, password, designation) VALUES
('u101','navya', '123456789', 90000, 'navya123','manager'),
('u102','tarunika', '987654321', 80000, 'tarunika123','manager'),
('u103','nischitha', '643219876', 70000, 'nischitha123','manager'),
('u104','bindu', '678912345', 60000, 'bindu123','salesman'),
('u105','Kushi', '983217654', 50000, 'kushi123','salesman'),
('u106','appi', '19843276', 40000, 'appi123','salesman'),
('u107','bhavvu', '41987632', 30000, 'bhavvu123','manager'),
('u108','swapna', '674589123', 20000, 'swapna123','salesman'),
('u109','kulal', '98743216', 10000, 'kulal123','manager');



CREATE TABLE Medicine (
   MedID varchar(7) NOT NULL,
   Name varchar(20) DEFAULT NULL,
   Price double(6,2) NOT NULL,
   ExpiryDate Date NOT NULL,
   ExpiryStatus varchar(20),
   quantity int
) ;

INSERT INTO Medicine (MedID, Name, Price, ExpiryDate, ExpiryStatus, quantity) VALUES
('m101', 'Eumovate', 41.00, '2022-04-12' ,'Expired',20),
('m102', 'Xpain',2.50, '2022-04-12', 'notExpired',100),
('m103', 'Adora', 50.00, '2022-04-12','expiringSoon', 125 ),
('m104', 'Compiron',30.00, '2022-04-12', 'Expired', 299),
('m105', 'Rifamex', 65.00,'2022-04-12','notExpired', 90 ),
('m106', 'Alacot DS', 150.45,'2022-04-12','expiringSoon', 122),
('m107', 'Ansulin', 4150.00,'2022-04-12','expired',200),
('m108', 'Cefotil',199.34,'2022-04-12','notExpired',19),
('m109', 'Phylopen Forte', 110.41, '2022-04-12', 'notExpired',30);




CREATE TABLE Stock (
   MedID varchar(7) NOT NULL,
   MedName varchar(20) NOT NULL,
   StockQuantity int(7) NOT NULL
);

INSERT INTO Stock (MedId, MedName, StockQuantity) VALUES
('m101','Eumovate', 20),
('m102','Xpain', 100),
('m103','Adora', 125),
('m104', 'Compiron', 299),
('m105','Rifamex', 90),
('m106','Alacot DS', 122),
('m107','Ansulin', 200),
('m108','Cefotil', 19),
('m109','Phylopen Forte', 30);




CREATE TABLE User (
  Name varchar(10) NOT NULL,
  Contact varchar(11) NOT NULL,
  UserID varchar(11) NOT NULL
);

INSERT INTO User (Name, Contact, UserID) VALUES
('navya', '23456789', 'u101'),
('tarunika', '987654321', 'u102'),
('nischitha', '43219876', 'u103'),
('bindu', '678912345', 'u104'),
('Kushi', '983217654', 'u106'),
('appi', '19843276', 'u106'),
('bhavvu', '41987632', 'u107'),
('swapna', '674589123', 'u108'),
('kulal', '98743216', 'u108'),
('ram', '786912345', 'u109');


CREATE TABLE Orders (
   OrderID varchar(7) NOT NULL,
   MedID varchar(7) NOT NULL,
   MedName varchar(20) NOT NULL,
   Quantity int(7) NOT NULL,
   CustID varchar(11) NOT NULL
);

INSERT INTO Orders (OrderID, MedId,MedName,Quantity, CustID) VALUES
('o101', 'm101','Eumovate', 20, 'c101'),
('o102', 'm102','Fexo', 100,'c102'),
('o103', 'm103','Qpine', 125,'c103'),
('o104', 'm104','Rifamex', 299,'c104'),
('o105', 'm105','Ansulin', 90,'c105'),
('o106', 'm106','Adora', 122,'c106'),
('o107', 'm107','Phylopen Forte', 200,'c107'),
('o108', 'm108','Brofex', 19,'c108'),
('o109', 'm109','Prevas', 30,'c109');

CREATE TABLE Customer (
  Name varchar(10) NOT NULL,
  Contact varchar(11) NOT NULL,
  UserID varchar(11) NOT NULL,
  Address varchar(20) NOT NULL
);
INSERT INTO Customer (Name,Contact,UserId,Address) VALUES
('navya', 123456789, 'u101','mandya'),
('tarunika', '987654321', 'u102', 'banglore'),
('nischitha', '43219876', 'u103', 'jayanagara'),
('bindu', '678912345', 'u104','jpnagar'),
('Kushi', '983217654', 'u105', 'bansankari'),
('appi', '19843276', 'u106', 'hosakerehalli'),
('bhavvu', '41987632', 'u107', 'malavalli'),
('swapna', '674589123', 'u108', 'maddur'),
('kulal', '98743216', 'u109', 'kenegeri');




CREATE TABLE Sale (
  SaleId int NOT NULL,
medId varchar(20) NOT NULL,
 medName varchar(20) NOT NULL, quantity int NOT NULL, unitPrice double NOT NULL, amount double NOT NULL
  
);

INSERT INTO Sale VALUES
(1,'m100','Eumovate',5 ,41.0, 205.0);


create table payment(custId varchar(20), orderId varchar(20), paymentMode varchar(20));
insert into payment values('u101', 'o101', 'cash');
