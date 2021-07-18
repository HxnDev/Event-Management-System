package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class is inherited by MANAGER
// A super class that has information variables to store information about the employees. Every employee will be given
// a unique employee id (5 digit).

// Employee -> EmployeeDB -> Manager
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;

public class Employee
{
    protected String employee_id;                 //5-digit unique id
    protected String name;
    protected String dob;
    protected String phone_no;
    protected String email;
    protected String cnic;
    protected String account_number;          //Bank Details
    protected String wage_type;               //Hourly/Daily/Monthly
    protected int wage_rate;
    protected int points;
    protected String mgr_id;

    String fname, lname;

    public Employee()
    {
        employee_id = name = dob = phone_no = email = cnic = account_number = wage_type = mgr_id = "";
        this.wage_rate = points = 0;
        fname = lname = "";
    }

    public Employee(String id)
    {
        employee_id = id;
        name = dob = phone_no = email = cnic = account_number = wage_type = mgr_id = fname = lname = "";
        this.wage_rate = points = 0;
    }


    public Employee(String employee_id, String name, String dob, String phone_no, String email, String cnic, String account_number, String wage_type, int wage_rate, int points, String mgr_id) {
        this.employee_id = employee_id;
        this.name = name;
        this.dob = dob;
        this.phone_no = phone_no;
        this.email = email;
        this.cnic = cnic;
        this.account_number = account_number;
        this.wage_type = wage_type;
        this.wage_rate = wage_rate;
        this.points = points;
        this.mgr_id = mgr_id;

        fname = name.contains(" ") ? name.split(" ")[0] : name;
        lname = name.contains(" ") ? name.split(" ")[1] : "";
    }

    public Employee(String name, String dob, String phone_no, String email, String cnic, String account_number, String wage_type, int wage_rate, int points, String mgr_id) {
        this.employee_id = "";
        this.name = name;
        this.dob = dob;
        this.phone_no = phone_no;
        this.email = email;
        this.cnic = cnic;
        this.account_number = account_number;
        this.wage_type = wage_type;
        this.wage_rate = wage_rate;
        this.points = points;
        this.mgr_id = mgr_id;

        fname = name.contains(" ") ? name.split(" ")[0] : name;
        lname = name.contains(" ") ? name.split(" ")[1] : "";
    }

    public Employee(Employee emp) {
        this.employee_id = emp.getEmployee_id();
        this.name = emp.getName();
        this.dob = emp.getDob();
        this.phone_no = emp.getPhone_no();
        this.email = emp.getEmail();
        this.cnic = emp.getCnic();
        this.account_number = emp.getAccount_number();
        this.wage_type = emp.getWage_type();
        this.wage_rate = emp.getWage_rate();
        this.mgr_id = emp.getMgr_id();
        this.points = emp.getPoints();

        fname = name.contains(" ") ? name.split(" ")[0] : name;
        lname = name.contains(" ") ? name.split(" ")[1] : "";
    }

    ///////////////////////////////////////////

    public String getEmployee_id()
    {
        return employee_id;
    }
    public void setEmployee_id(String employee_id)
    {
        this.employee_id = employee_id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getDob()
    {
        return dob;
    }
    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getPhone_no()
    {
        return phone_no;
    }
    public void setPhone_no(String phone_no)
    {
        this.phone_no = phone_no;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCnic()
    {
        return cnic;
    }
    public void setCnic(String cnic)
    {
        this.cnic = cnic;
    }

    public String getAccount_number()
    {
        return account_number;
    }
    public void setAccount_number(String account_number)
    {
        this.account_number = account_number;
    }

    public String getWage_type()
    {
        return wage_type;
    }
    public void setWage_type(String wage_type)
    {
        this.wage_type = wage_type;
    }

    public int getWage_rate()
    {
        return wage_rate;
    }
    public void setWage_rate(int wage_rate)
    {
        this.wage_rate = wage_rate;
    }

    public String getMgr_id() {
        return mgr_id;
    }
    public void setMgr_id(String mgr_id) {
        this.mgr_id = mgr_id;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    public void display() {
        System.out.print("ID: ");
        System.out.println(employee_id);

        System.out.print("Manager ID: ");
        System.out.println(mgr_id);

        System.out.print("Name: ");
        System.out.println(name);

        System.out.print("Date of birth: ");
        System.out.println(dob);

        System.out.print("Phone number ");
        System.out.println(phone_no);

        System.out.print("Email: ");
        System.out.println(email);

        System.out.print("CNIC: ");
        System.out.println(cnic);

        System.out.print("Account Number: ");
        System.out.println(account_number);

        System.out.print("Wage Type: ");
        System.out.println(wage_type);

        System.out.print("Wage Rate: ");
        System.out.println(wage_rate);

        System.out.print("Manager ID: ");
        System.out.println(mgr_id);

        System.out.println("points = " + points);

    }

    ////////// CALLING DATABASE METHODS /////////////

    public void getEmployeeRecord(String id) {
        EmployeeDB obj = new EmployeeDB();
        Employee emp = obj.getEmployee(id);

        this.employee_id = id;
        this.name = emp.getName();
        this.dob = emp.getDob();
        this.phone_no = emp.getPhone_no();
        this.email = emp.getEmail();
        this.cnic = emp.getCnic();
        this.account_number = emp.getAccount_number();
        this.wage_type = emp.getWage_type();
        this.wage_rate = emp.getWage_rate();
        this.mgr_id = emp.getMgr_id();
    }

    public void editEmployee() {
        EmployeeDB obj = new EmployeeDB();
        obj.editEmployee(this.employee_id);
    }

    // Employee logging in
    public boolean employeeLogin() {
        String id, pass;

        Scanner input = new Scanner(System.in);

        System.out.print("Logging in. Enter your employee ID: ");
        id = input.nextLine();

        System.out.print("Enter your password: ");
        pass = input.nextLine();

        EmployeeDB obj = new EmployeeDB();
        return obj.employeeLogin(id, pass);
    }

    public boolean employeeLogin(String id, String pass) {
        EmployeeDB obj = new EmployeeDB();
        return obj.employeeLogin(id, pass);
    }

    // Employee changing password
    public void changePassword() {
        String id, old_pass, new_pass;

        Scanner input = new Scanner(System.in);

        System.out.print("Changing password. Enter your employee ID: ");
        id = input.nextLine();

        System.out.print("Enter your current password: ");
        old_pass = input.nextLine();

        System.out.print("Enter your new password: ");
        new_pass = input.nextLine();

        EmployeeDB obj = new EmployeeDB();
        obj.changeEmployeePassword(id, old_pass, new_pass);
    }

    public boolean changePassword(String curr, String neww) {
        EmployeeDB obj = new EmployeeDB();
        return obj.changeEmployeePassword(employee_id,curr,neww);
    }

    // edit one field
    public void editEmployeeAccountField(String id, String field, String new_value, boolean isNumeric) {
        EmployeeDB obj = new EmployeeDB();
        obj.updateField(id,field,new_value, isNumeric);
    }

    public int getPointsFromDB() {
        EmployeeDB obj = new EmployeeDB();
        this.points = obj.getPoints(this.employee_id);
        return this.points;
    }

    // reset employee object
    public void clear() {
        employee_id = name = dob = phone_no = email = cnic = account_number = wage_type = mgr_id = "";
        this.wage_rate = points = 0;
    }

    // check is an employee is a manager
    public static boolean isManager(String id) {
        EmployeeDB obj = new EmployeeDB();
        return obj.isManager(id);
    }

    public ArrayList<Employee> getListOfEmployees() {
        EmployeeDB obj = new EmployeeDB();
        return obj.getAllEmployees();
    }

    public void addEmployee() {
        EmployeeDB obj = new EmployeeDB();
        employee_id = obj.insertEmployee(this);
    }

    public void deleteEmployee() {
        EmployeeDB obj = new EmployeeDB();
        obj.removeEmployee(this.employee_id);
    }

    public Employee getEmployee(String id) {
        EmployeeDB obj = new EmployeeDB();
        return obj.getEmployee(id);
    }

    public static boolean checkIfEmailRegistered(String email) {
        EmployeeDB obj = new EmployeeDB();
        return !(obj.getEmployeeByEmail(email).getEmployee_id().isEmpty());
    }
}
