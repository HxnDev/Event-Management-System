package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Database to store each customer's information
// MANAGER also has access to this class.
// Manager/Customer -> CustomerDB
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.sql.*;
import java.util.Scanner;

public class CustomerDB
{
    public void displayAllCustomers()                                   //Will display the list of all the customers for manager
    {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - displaying all customers");

                String query = "select * from customer";  // query to be sent

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {                                            // reads a row
                    String name = rs.getString("name");             // finds a column in the row
                    String phone = rs.getString("phone_no");
                    String email = rs.getString("email");
                    String acc = rs.getString("account_number");
                    String ps = rs.getString("priority_status");
                    String id = rs.getString("cust_id");
                    String age = rs.getString("age");
                    String cnic = rs.getString("cnic");

                    System.out.print("ID: ");
                    System.out.println(id);

                    System.out.print("Name: ");
                    System.out.println(name);

                    System.out.print("Age: ");
                    System.out.println(age);

                    System.out.print("Phone number: ");
                    System.out.println(phone);

                    System.out.print("Email: ");
                    System.out.println(email);

                    System.out.print("CNIC: ");
                    System.out.println(cnic);

                    System.out.print("Account Number: ");
                    System.out.println(acc);

                    System.out.print("Priority Status: ");
                    System.out.println(ps);
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void displayCustomer(String id)                            //Display the specific customer details
    {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - display a customer");

                String query = "select * from customer where CUST_ID = " + id;  // query to be sent

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {                                            // reads a row
                    String name = rs.getString("name");             // finds a column in the row
                    String phone = rs.getString("phone_no");
                    String email = rs.getString("email");
                    String acc = rs.getString("account_number");
                    String ps = rs.getString("priority_status");
                    String cnic = rs.getString("cnic");
                    String age = rs.getString("age");

                    System.out.print("ID: ");
                    System.out.println(id);

                    System.out.print("Name: ");
                    System.out.println(name);

                    System.out.print("Age: ");
                    System.out.println(age);

                    System.out.print("Phone number ");
                    System.out.println(phone);

                    System.out.print("Email: ");
                    System.out.println(email);

                    System.out.print("CNIC: ");
                    System.out.println(cnic);

                    System.out.print("Account Number: ");
                    System.out.println(acc);

                    System.out.print("Priority Status: ");
                    System.out.println(ps);
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Customer getCustomer(String id)
    {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - getting a customer");

                String query = "select * from customer where CUST_ID = " + id;  // query to be sent

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {                                            // reads a row
                    String name = rs.getString("name");             // finds a column in the row
                    String phone = rs.getString("phone_no");
                    String email = rs.getString("email");
                    String acc = rs.getString("account_number");
                    int ps = rs.getInt("priority_status");
                    String cnic = rs.getString("cnic");
                    int age = rs.getInt("age");

                    Customer cust = new Customer(name, cnic, age, phone, email, acc, ps);
                    return cust;
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        Customer emptyObj = new Customer();
        return emptyObj;
    }

    public Customer getCustomerByEmail(String email)
    {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - getting a customer by email");

                String query = "select * from customer where email = '" + email + "'";  // query to be sent

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {                                            // reads a row
                    String name = rs.getString("name");             // finds a column in the row
                    String phone = rs.getString("phone_no");
                    String acc = rs.getString("account_number");
                    int ps = rs.getInt("priority_status");
                    String cnic = rs.getString("cnic");
                    int age = rs.getInt("age");

                    Customer cust = new Customer(name, cnic, age, phone, email, acc, ps);
                    return cust;
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        Customer emptyObj = new Customer();
        return emptyObj;
    }

    public void insertCustomer()
    {
        Customer cust = new Customer();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter name: ");
        cust.setName(input.nextLine());

        System.out.print("Enter phone no: ");
        cust.setContact_info(input.nextLine());

        System.out.print("Enter email: ");
        cust.setEmail_address(input.nextLine());

        System.out.print("Enter cnic: ");
        cust.setCnic(input.nextLine());

        System.out.print("Enter account number: ");
        cust.setAccount_number(input.nextLine());

        System.out.print("Enter Priority Status: ");
        cust.setPriority_status(input.nextInt());

        System.out.print("Enter age: ");
        cust.setAge(input.nextInt());

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - inserting a customer");

                String query = "select * from customer";  // selects all data from database

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String last_id = "10000";

                while (rs.next()) {                                            // reads a row
                    last_id = rs.getString("cust_id");             // reads an id
                }

                int temp = Integer.parseInt(last_id);
                temp++;
                String new_id = Integer.toString(temp);

                query = "insert into customer(CUST_ID, name, cnic, age, phone_no, email, ACCOUNT_NUMBER, PRIORITY_STATUS)" +
                        "values('" + new_id + "','" + cust.getName() + "','" + cust.getCnic() + "'," + Integer.toString(cust.getAge()) + ",'" + cust.getContact_info() +
                        "','" + cust.getEmail_address() + "','" + cust.getAccount_number() + "'," + Integer.toString(cust.getPriority_status()) + ")";

                //System.out.println(query);
                stmt.executeUpdate(query);
                stmt.executeUpdate("commit");
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String insertCustomerWithPassword(Customer cust, String pass)
    {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - inserting a customer + password");

                String query = "select * from customer";  // selects all data from database

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String last_id = "10000";

                while (rs.next()) {                                            // reads a row
                    last_id = rs.getString("cust_id");             // reads an id
                }

                int temp = Integer.parseInt(last_id);
                temp++;
                String new_id = Integer.toString(temp);

                query = "insert into customer(CUST_ID, name, cnic, age, phone_no, email, ACCOUNT_NUMBER, PRIORITY_STATUS)" +
                        "values('" + new_id + "','" + cust.getName() + "','" + cust.getCnic() + "'," + Integer.toString(cust.getAge()) + ",'" + cust.getContact_info() +
                        "','" + cust.getEmail_address() + "','" + cust.getAccount_number() + "'," + Integer.toString(cust.getPriority_status()) + ")";

                //System.out.println(query);
                stmt.executeUpdate(query);
                stmt.executeUpdate("commit");

                this.addPasswordRecord(new_id, pass);

                return  new_id;
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public void insertCustomer(Customer cust, String id)
    {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                 System.out.println("Database - inserting customer + id!");

                Statement stmt = conn.createStatement();

                String query = "insert into customer(CUST_ID, name, cnic, age, phone_no, email, ACCOUNT_NUMBER, PRIORITY_STATUS)" +
                        "values('" + id + "','" + cust.getName() + "','" + cust.getCnic() + "'," + Integer.toString(cust.getAge()) + ",'" + cust.getContact_info() +
                        "','" + cust.getEmail_address() + "','" + cust.getAccount_number() + "'," + Integer.toString(cust.getPriority_status()) + ")";

                //System.out.println(query);
                stmt.executeUpdate(query);
                stmt.executeUpdate("commit");

                this.addPasswordRecord(id, id);
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCustomer(String id)
    {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - deleting customer");

                this.deletePasswordRecord(id);

                String query = "delete from customer where cust_id = " + id;  // selects all data from database

                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);

                query = "commit";
                stmt.executeUpdate(query);
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editCustomer(String id)
    {
        Customer cust = this.getCustomer(id);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter name: ");
        cust.setName(input.nextLine());

        System.out.print("Enter phone no: ");
        cust.setContact_info(input.nextLine());

        System.out.print("Enter email: ");
        cust.setEmail_address(input.nextLine());

        System.out.print("Enter cnic: ");
        cust.setCnic(input.nextLine());

        System.out.print("Enter account number: ");
        cust.setAccount_number(input.nextLine());

        System.out.print("Enter Priority Status: ");
        cust.setPriority_status(input.nextInt());

        System.out.print("Enter age: ");
        cust.setAge(input.nextInt());

        this.removeCustomer(id);
        this.insertCustomer(cust, id);
    }

    public void editCustomer(Customer cust, String id)
    {
        this.removeCustomer(id);
        this.insertCustomer(cust, id);
    }

    // Returns true if password correct against that id, false otherwise
    public boolean customerLogin(String idOrEmail, String pass) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - logging in customer");
                String query;

                if (idOrEmail.indexOf('@') == -1) {
                    query = "SELECT password FROM customerpass WHERE cust_id = \'" + idOrEmail + "\'";
                }

                else {
                    query = "SELECT password FROM customerpass WHERE cust_id IN " +
                            "(SELECT cust_id FROM customer WHERE email = \'" + idOrEmail + "\')";
                }

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String db_pass = "";

                while (rs.next()) {
                    db_pass = rs.getString("password");

                    if (pass.equals(db_pass))
                        return true;
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public void updateField(String id, String field, String new_value) {
        System.out.println("field = " + field);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - updating a field for customer");

                String query = "update CUSTOMER set " + field + " = '" + new_value + "' where CUST_ID = " + id;

                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);

             //   System.out.println("query = " + query);

                query = "commit";
                stmt.executeUpdate(query);
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Returns true if password changed successfully, false otherwise
    public boolean changeCustomerPassword(String id, String old_pass, String new_pass) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - changing customer password");

                String query = "update CUSTOMERPASS set PASSWORD = '" + new_pass + "' where CUST_ID = '" + id + "' and PASSWORD = '" + old_pass + "'";

                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);

                query = "commit";
                stmt.executeUpdate(query);

                return true;
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Changes password without checking
    public void changeCustomerPassword(String id, String new_pass) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - changing customer password");

                String query = "update CUSTOMERPASS set PASSWORD = '" + new_pass + "' where CUST_ID = '" + id + "'";

                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);

                query = "commit";
                stmt.executeUpdate(query);
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePasswordRecord(String id) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - deleting password record");

                String query = "delete from CUSTOMERPASS where cust_id = " + id;  // selects all data from database

                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);

                query = "commit";
                stmt.executeUpdate(query);
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Default password is same as cust when customer is created
    public void addPasswordRecord(String id, String pass) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - adding password record!");

                Statement stmt = conn.createStatement();

                String query = "insert into CUSTOMERPASS(CUST_ID, PASSWORD)" + "values('" + id + "','" + pass + "')";
                //System.out.println(query);
                stmt.executeUpdate(query);
                stmt.executeUpdate("commit");
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCustomerIDbyEmail(String email) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - returning customer ID against an email");
                String query;

                query = "SELECT cust_id FROM customer WHERE email = '" + email + "'";
                System.out.println("query = " + query);

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    return rs.getString("cust_id");
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return "";
    }

    public String getCustomerEmailByID(String ID) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - returning customer email against an ID");
                String query;

                query = "SELECT email FROM customer WHERE cust_id = '" + ID + "'";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    return rs.getString("email");
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return "";
    }
}