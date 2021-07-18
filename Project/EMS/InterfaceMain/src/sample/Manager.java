package sample;

import java.util.*;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class will store/edit/remove the manager's information The information will be stored in ManagerDB
// It is inherited from Employee
// Manager -> ManagerDB
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Manager extends Employee
{

    public Manager()
    {
        super();
    }

    /////////////// CALLING EMPLOYEE DATABASE METHODS ///////////////

    public void viewAllEmployees()
    {
        EmployeeDB obj = new EmployeeDB();
        obj.displayAllEmployees();
    }

    public void viewEmployee()
    {
        EmployeeDB obj = new EmployeeDB();
        String id = new String();
        System.out.print("Viewing employee details. Enter employee ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.displayEmployee(id);
    }

    public void addEmployee()                               //Add a new employee
    {
        EmployeeDB obj = new EmployeeDB();
        employee_id = obj.insertEmployee(this);
    }

    public void deleteEmployee()                            //Delete an existing Employee
    {
        EmployeeDB obj = new EmployeeDB();
        String id = new String();
        System.out.print("Removing an employee. Enter employee ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeEmployee(id);
    }

    @Override
    public void editEmployee() {
        EmployeeDB obj = new EmployeeDB();
        String id = new String();
        System.out.print("Editing an employee. Enter employee ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.editEmployee(id);
    }

    void changeEmployeeManager() {
        EmployeeDB obj = new EmployeeDB();
        String mid, eid;

        System.out.print("Enter employee ID: ");
        Scanner input = new Scanner(System.in);
        eid = input.nextLine();

        System.out.print("Enter manager ID: ");
        mid = input.nextLine();

        obj.changeManager(eid, mid);
    }

    /////////////// CALLING CUSTOMER DATABASE METHODS ///////////////

    public void viewAllCustomers() {
        CustomerDB obj = new CustomerDB();
        obj.displayAllCustomers();
    }

    public void viewCustomer() {
        CustomerDB obj = new CustomerDB();
        String id = "";
        System.out.print("Viewing a customer. Enter customer ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.displayCustomer(id);
    }

    public void createCustomerAccount()                     //Manager can create customer's account
    {
        CustomerDB obj = new CustomerDB();
        obj.insertCustomer();
    }

    public void editCustomerAccount()                     //Manager can edit customer's account details
    {
        CustomerDB obj = new CustomerDB();
        String id = new String();
        System.out.print("Editing a customer. Enter ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.editCustomer(id);
    }

    public void deleteCustomerAccount()                     //Manager can delete customer's account
    {
        CustomerDB obj = new CustomerDB();
        String id = "";
        System.out.print("Deleting a customer. Enter ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeCustomer(id);
    }

    /////////////////// CALLING VENUE DATABASE METHODS ////////////////////

    public void addVenue() {
        VenueDB obj = new VenueDB();
        obj.addVenue();
    }

    public void deleteVenue() {
        String id = "";
        System.out.print("Removing a venue record. Enter venue ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        VenueDB obj = new VenueDB();
        obj.deleteVenue(id);
    }

    public void viewVenue() {
        String id = "";
        System.out.print("Viewing venue details. Enter venue ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        VenueDB obj = new VenueDB();
        obj.displayVenue(id);
    }

    public void viewAllVenues() {
        VenueDB obj = new VenueDB();
        obj.displayAllVenues();
    }

    public void editVenue() {
        String id = "";
        System.out.print("Editing a venue record. Enter venue ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        VenueDB obj = new VenueDB();
        obj.editVenue(id);
    }

    ////////////////// CALLING STUDIO DATABASE METHODS ///////////////////

    public void addStudio() {
        StudioDB obj = new StudioDB();
        obj.addStudio();
    }

    public void deleteStudio() {
        String id = "";
        System.out.print("Deleting a studio. Enter it's studio ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        StudioDB obj = new StudioDB();
        obj.removeStudio(id);
    }

    public void viewAllStudios() {
        StudioDB obj = new StudioDB();
        obj.displayAllStudios();
    }

    public void viewStudio() {
        String id = "";
        System.out.print("Viewing a studio. Enter it's studio ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        StudioDB obj = new StudioDB();
        obj.displayStudio(id);
    }

    public void editStudio() {
        String id = "";
        System.out.print("Editing a studio. Enter it's studio ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        StudioDB obj = new StudioDB();
        obj.editStudio(id);
    }

    /////////////////////// CALLING MENU DATABASE METHODS ////////////////

    public void viewMenu() {
        System.out.print("Viewing a menu. Enter it's ID: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

        MenuDB obj = new MenuDB();
        obj.displayMenu(id);
    }

    public void viewAllMenus() {
        MenuDB obj = new MenuDB();
        obj.displayAllMenus();
    }

    public void deleteMenu() {
        System.out.print("Deleting a menu. Enter it's ID: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

        MenuDB obj = new MenuDB();
        obj.removeMenu(id);
    }

    /////////////////////// CALLING CATERING SERVICE DATABASE METHODS ///////////////

    public void viewAllCateringServices()
    {
        CateringServicesDB obj = new CateringServicesDB();
        obj.displayAllCatering();
    }

    public void viewCateringService()
    {
        CateringServicesDB obj = new CateringServicesDB();
        String id = new String();
        System.out.print("Viewing a catering service. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.displayCatering(id);
    }

    public void addCateringService()
    {
        CateringServicesDB obj = new CateringServicesDB();
        obj.addCateringVendor();
    }

    public void deleteCateringService()
    {
        CateringServicesDB obj = new CateringServicesDB();
        String id = new String();
        System.out.print("Deleting a catering service. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeCatering(id);
    }

    public void editCateringService() {
        CateringServicesDB obj = new CateringServicesDB();
        String id = new String();
        System.out.print("Editing a catering service. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.editCatering(id);
    }

    /////////////////// CALLING MEDIA REQUIREMENTS DATABASE METHODS ///////////////////

    public void viewAllMediaRequirements() {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        obj.displayAllMediaRequirements();
    }

    public void viewMediaRequirement() {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        String id = "";
        System.out.print("Viewing a media requirement record. Enter ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.displayMediaRequirement(id);
    }

    public void createMediaRequirement()
    {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        obj.addMediaRequirement();
    }

    public void editMediaRequirement()
    {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        String id = new String();
        System.out.print("Editing a media requirement record. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.editMediaRequirement(id);
    }

    public void deleteMediaRequirement()
    {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        String id = "";
        System.out.print("Deleting a media requirement record. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeMediaRequirement(id);
    }

    //////////////////////

    public void approveEvent(String eventid) {
        ManagerDB obj = new ManagerDB();
        obj.approveEvent(eventid);
    }
}
