create table media_requirements (
media_id char(5) PRIMARY KEY,
photography tinyint,
videography tinyint,
album tinyint,
drone tinyint,
crane tinyint
);

insert into media_requirements(media_id, photography, videography, album, drone, crane)
values('56790', 1, 0, 1, 0, 1);

insert into media_requirements(media_id, photography, videography, album, drone, crane)
values('56791', 1, 1, 1, 1, 1);

insert into media_requirements(media_id, photography, videography, album, drone, crane)
values('56792', 1, 1, 0, 0, 0);

create table catering (
catering_id char(5) PRIMARY KEY,
name varchar(30),
contact varchar(30),
specialty varchar(30),
days numeric(38,0),
charges numeric(38,0)
);

insert into catering(catering_id, name, contact, specialty, days, charges)
values('75001', 'Rashi Cooks', '0316-7884565', 'Desi', 30, 20000);

insert into catering(catering_id, name, contact, specialty, days, charges)
values('75002', 'El Pacho Caterers', '0306-7978565', 'Continental', 20, 45000);

insert into catering(catering_id, name, contact, specialty, days, charges)
values('75003', 'Zee Caterers', '0701-3999124', 'Desi', 10, 20000);

create table customer (
cust_id char(5) PRIMARY KEY,
name varchar(30),
cnic varchar(20),
age double,
phone_no varchar(30),
email varchar(30),
account_number varchar(20),
priority_status numeric(38,0)
);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10001', 'Hassaan Shahzad', '32201-482843-4', 20, '0321-2565432', 'donttalktome@gmail.com', '023113566', 1);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10002', 'Ahmed Khan', '22345-674839-4', 43, '0354-456652', 'akjjan@yahoo.com', '046773566', 2);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10003', 'Sara Ismail', '32345-678429-5', 33, '0301-2534332', 'ssismail@gmail.com', '023676785', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10004', 'Hassan Shahzad', '32344-675629-5', 18, '0301-2584332', 'chhxnshah@gmail.com', '023676485', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10005', 'Funk Jood', '32344-698759-5', 20, '0301-8474332', 'detectivefunkjood@gmail.com', '0234426485', 1);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10006', 'Sana Ali', '32344-675629-5', 21, '0321-87941662', 'sanakahnn@gmail.com', '023676485', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10007', 'Abeera Fatima', '32344-675629-5', 22, '0301-2584332', 'abeerafatima9@gmail.com', '023676485', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10008', 'Shopper Man', '32344-675629-5', 21, '0301-2584332', 'hxnxhah@gmail.com', '023676485', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10009', 'Azka Khurram', '32344-675629-5', 21, '0301-2584332', 'azkakhurram666@gmail.com', '023676485', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10010', 'Sana Khan', '32344-675629-5', 22, '0301-2584332', 'sanakhan_17@outlook.com', '023676485', 1);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10011', 'Azka Ali', '32344-675629-5', 37, '0301-2584332', 'azkakhurram661@yahoo.com', '023676485', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10012', 'Cherry NU', '32344-675629-5', 23, '0301-2584332', 'i180411@nu.edu.pk', '023676485', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10013', 'Azka NU', '32344-675629-5', 20, '0301-2584332', 'i180461@nu.edu.pk', '023676485', 3);

insert into customer(cust_id, name, cnic, age, phone_no, email, account_number, priority_status)
values('10014', 'Sana NU', '32344-675629-5', 18, '0301-2584332', 'i180439@nu.edu.pk', '023676485', 3);

create table customerPass (
cust_id char(5) PRIMARY KEY,
password varchar(30)
);

ALTER TABLE customerPass
ADD FOREIGN KEY (cust_id) REFERENCES Customer(cust_id);

insert into customerPass(cust_id, password)
values('10001', '10001');

insert into customerPass(cust_id, password)
values('10002', '10002');

insert into customerPass(cust_id, password)
values('10003', '10003');

insert into customerPass(cust_id, password)
values('10004', '10004');

insert into customerPass(cust_id, password)
values('10005', '10005');

insert into customerPass(cust_id, password)
values('10006', '10006');

insert into customerPass(cust_id, password)
values('10007', '10007');

insert into customerPass(cust_id, password)
values('10008', '10008');

insert into customerPass(cust_id, password)
values('10009', '10009');

insert into customerPass(cust_id, password)
values('10010', '10010');

insert into customerPass(cust_id, password)
values('10011', '10011');

insert into customerPass(cust_id, password)
values('10012', '10012');

insert into customerPass(cust_id, password)
values('10013', '10013');

insert into customerPass(cust_id, password)
values('10014', '10014');

create table employee (
emp_id char(5) PRIMARY KEY,
name varchar(30),
dob date,
email varchar(30),
phone_no varchar(30),
cnic varchar(20),
account_number varchar(20),
wage_type varchar(10),
wage_rate numeric(10),
points numeric(10),
mgr_id char(5) REFERENCES employee(emp_id)
);

insert into employee(emp_id, name, dob, email, phone_no, cnic, account_number, wage_type, wage_rate, points, mgr_id)
values('20001', 'Dummy Manager', STR_TO_DATE('16/3/00', '%d/%m/%y'), 'dummy@yahoo.com', '0330-33643257', '1242-532450', 934545, 'Monthly', 1000, 800, NULL);

insert into employee(emp_id, name, dob, email, phone_no, cnic, account_number, wage_type, wage_rate, points, mgr_id)
values('20002', 'Ahmed Khan', STR_TO_DATE('12/4/01', '%d/%m/%y'), 'ahmed@gmail.com', '0300-67534567', '3323-322938475', 765434567, 'Hourly', 2000, 600, '20001');

insert into employee(emp_id, name, dob, email, phone_no, cnic, account_number, wage_type, wage_rate, points, mgr_id)
values('20003', 'Ali Arshad', STR_TO_DATE('03/3/02', '%d/%m/%y'), 'doublea@gmail.com', '0300-4446357', '42201-499398', 456945543, 'Monthly', 1000, 0, '20002');

insert into employee(emp_id, name, dob, email, phone_no, cnic, account_number, wage_type, wage_rate, points, mgr_id)
values('20004', 'Queen Elizabeth', STR_TO_DATE('22/5/04', '%d/%m/%y'), 'hermajesty@royals.edu', 'Unavailable', 'Nothing', 65434654, 'Daily', 100, 150, '20002');

insert into employee(emp_id, name, dob, email, phone_no, cnic, account_number, wage_type, wage_rate, points, mgr_id)
values('20005', 'Garbage Man', STR_TO_DATE('17/5/01', '%d/%m/%y'), 'IamTrash@gmail.com', '0300-6684727', '144-2948820', '794-3553', 'Daily', 1000, 475, '20002');

create table employeePass (
emp_id char(5) PRIMARY KEY,
password varchar(30)
);

ALTER TABLE employeePass
ADD FOREIGN KEY (emp_id) REFERENCES Employee(emp_id);

insert into employeePass(emp_id, password)
values('20001', '20001');

insert into employeePass(emp_id, password)
values('20002', '20002');

insert into employeePass(emp_id, password)
values('20003', '20003');

insert into employeePass(emp_id, password)
values('20004', '20004');

insert into employeePass(emp_id, password)
values('20005', '20005');

create table menu (
menu_id char(5) PRIMARY KEY,
rice varchar(100),
bread varchar(100),
protein varchar(100),                      
coke tinyint,                    
miranda tinyint,          
sprite tinyint,     
water tinyint,
dryfruit tinyint, 
sugarfree tinyint,
icecream tinyint,
cake tinyint,   
cost numeric(38,0)
);

insert into menu(menu_id, rice, bread, protein, coke, miranda, sprite, water, dryfruit, sugarfree, icecream, cake, cost)
values('10003', 'Biryani, Egg-fried', 'Tandoori', 'Chicken', 1, 0, 1, 0, 1, 0, 1, 0, 60000);

insert into menu(menu_id, rice, bread, protein, coke, miranda, sprite, water, dryfruit, sugarfree, icecream, cake, cost)
values('10004', 'Biryani, Egg-fried, Kabuli', 'Naan, Lebanese', 'Chicken, Beef, Seafood', 1, 1, 0, 1, 0, 0, 1, 0, 100000);

insert into menu(menu_id, rice, bread, protein, coke, miranda, sprite, water, dryfruit, sugarfree, icecream, cake, cost)
values('10005', 'Biryani, Plain Boiled', 'Tandoori', 'Chicken', 1, 1, 1, 0, 1, 0, 1, 0, 100000);


create table studio (
studio_id char(5) PRIMARY KEY,
name varchar(30),
contact_info varchar(30),
cost numeric(38,0)
);


insert into studio(studio_id, name, contact_info, cost)
values('44002', 'Studio HXN', '0301-6666357', 45000);

insert into studio(studio_id, name, contact_info, cost)
values('44003', 'Studio Umairish', '0301-6666375', 30000);

insert into studio(studio_id, name, contact_info, cost)
values('44004', 'Mahas Photography', '0103-1248535', 100000);

create table venue (
venue_id char(5) PRIMARY KEY,
name varchar(20),
location varchar(50),
address varchar(100),
max_capacity numeric(38,0),
description varchar(200),
category varchar(30),
contact_info varchar(30),
cost numeric(38,0)
);

insert into venue(venue_id, name, location, address, max_capacity, category, contact_info, cost)
values('88885', 'Aura Grande', 'Islamabad', 'Service Road E, E 11, Islamabad, Pakistan (11.08 km)', 2000,'Indoor', '033319922', 300000);

insert into venue(venue_id, name, location, address, max_capacity, category, contact_info, cost)
values('88884', 'F9 Park', 'Islamabad', 'F9/1, Islamabad', 20000,'Outdoor', '090078601', 50000);

insert into venue(venue_id, name, location, address, max_capacity, category, contact_info, cost)
values('88883', 'Lake View Park', 'Islamabad', 'Murree Rd, LAKE VIEW PARK, Islamabad', 1500,'Riverside', '03011030090', 75000);


create table event (
event_id char(5) PRIMARY KEY,
name varchar(30),
type varchar(30),
event_date date,
guests numeric,
total_cost numeric,
starting_time varchar(30),
ending_time varchar(30),
cust_id char(5),
venue_id char(5),
studio_id char(5),
menu_id char(5),
catering_id char(5),
media_id char(5),
approved tinyint
);

ALTER TABLE event
ADD FOREIGN KEY (cust_id) REFERENCES customer(cust_id);

ALTER TABLE event
ADD FOREIGN KEY (venue_id) REFERENCES venue(venue_id);

ALTER TABLE event
ADD FOREIGN KEY (studio_id) REFERENCES studio(studio_id);

ALTER TABLE event
ADD FOREIGN KEY (menu_id) REFERENCES menu(menu_id);

ALTER TABLE event
ADD FOREIGN KEY (catering_id) REFERENCES catering(catering_id);

ALTER TABLE event
ADD FOREIGN KEY (media_id) REFERENCES media_requirements(media_id);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20001','Sara\'s Bridal Shower', 'Bridal Shower', str_to_date('24/12/20', '%d/%m/%y'), 150, 45000, '7 pm', '11 pm', '10001', '88883', '44002', '10003', '75002', '56790', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20002','Ali\'s Enagement', 'Enagement', str_to_date('31/12/20', '%d/%m/%y'), 34, 21000, '1 pm', '4 pm', '10002', '88884', '44002', '10004', '75002', '56791', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20003','Sana\'s Birthday', 'Birthday', str_to_date('25/12/20', '%d/%m/%y'), 100, 75000, '7 pm', '11 pm', '10003', '88885', '44004', '10005', '75001', '56792', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20004','Saneya\'s Enagement', 'Enagement', str_to_date('30/12/20', '%d/%m/%y'), 90, 40000, '4 pm', '9 pm', '10004', '88885', '44003', '10005', '75002', '56791', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20005','Mishal\'s Bridal Shower', 'Bridal Shower', str_to_date('26/12/20', '%d/%m/%y'), 50, 15000, '7 pm', '11 pm', '10005', '88884', '44002', '10003', '75001', '56790', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20006','Ali\'s Nikkah', 'Nikkah', str_to_date('29/12/20', '%d/%m/%y'), 34, 21000, '12 pm', '2 pm', '10006', '88883', '44003', '10004', '75001', '56792', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20007','Abeera\'s Treat', 'Thanks Giving', str_to_date('27/12/20', '%d/%m/%y'), 10, 10000, '7 pm', '11 pm', '10007', '88885', '44004', '10003', '75002', '56791', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20008','Aimen\'s Enagement', 'Enagement', str_to_date('28/12/20', '%d/%m/%y'), 100, 25000, '9 pm', '12 pm', '10008', '88884', '44004', '10004', '75003', '56790', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20009','Saleha\'s Bridal Shower', 'Bridal Shower', str_to_date('1/1/21', '%d/%m/%y'), 23, 17000, '3 pm', '6 pm', '10009', '88883', '44003', '10004', '75003', '56790', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20010','Musa\'s Graduation', 'Graduation', str_to_date('6/1/21', '%d/%m/%y'), 120, 21000, '1 pm', '4 pm', '10010', '88883', '44002', '10003', '75003', '56792', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20011','Hassan\'s Valima', 'Wedding', str_to_date('2/1/21', '%d/%m/%y'), 700, 1400000, '1 pm', '5 pm', '10011', '88884', '44002', '10005', '75002', '56792', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20012','Adil\'s Baraat', 'Wedding', str_to_date('5/1/21', '%d/%m/%y'), 290, 200000, '6 pm', '10 pm', '10012', '88885', '44002', '10005', '75003', '56790', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20013','Ayesha\'s Aqeeqa', 'Aqeeqa', str_to_date('3/1/21', '%d/%m/%y'), 90, 45000, '10 am', '1 pm', '10013', '88883', '44004', '10005', '75003', '56791', 1);

insert into event(event_id, name, type, event_date, guests, total_cost, starting_time, ending_time, cust_id, venue_id, studio_id, menu_id, catering_id, media_id, approved)
values ('20014','Subhan\'s Bachelors Party', 'Bachelors Party', str_to_date('4/1/21', '%d/%m/%y'), 400, 500000, '7 pm', '12 am', '10014', '88884', '44003', '10005', '75001', '56790', 1);
