// A class for maintaining info of customer/employee logged in

package sample;

public class LoggedInUsers {
    private static String cust_id;
    private static Customer cust = new Customer();

    private static String emp_id;
    private static Employee emp = new Employee();

    ////////////// CUST METHODS ////////////////////

    public static String getCust_id() {
        return cust_id;
    }
    public static void setCust_id(String cust_id) {
        LoggedInUsers.cust_id = cust_id;
    }

    public static void initCust(String idOrEmail) {
        if (idOrEmail.indexOf('@') == -1)
            cust_id = idOrEmail;

        else {
            cust_id = cust.getCustomerIDbyEmail(idOrEmail);
        }

        cust.getCustomerDetails(cust_id);
    }

    public static void clearCust() {
        cust_id = "";
        cust.clear();
    }

    public static Customer getCust() {
        return cust;
    }
    public static void setCust(Customer cust) {
        LoggedInUsers.cust = cust;
    }

    ///////////// EMP METHODS //////////////////

    public static String getEmp_id() {
        return emp_id;
    }
    public static void setEmp_id(String emp_id) {
        LoggedInUsers.emp_id = emp_id;
    }

    public static Employee getEmp() {
        return emp;
    }
    public static void setEmp(Employee emp) {
        LoggedInUsers.emp = emp;
    }

    public static void initEmp(String id) {
        emp_id = id;
        emp.getEmployeeRecord(emp_id);
    }

    public static void clearEmp() {
        emp_id = "";
        emp.clear();
    }
}
