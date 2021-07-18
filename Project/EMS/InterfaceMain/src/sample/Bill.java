package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Used for maintaining bill in the event itself (this is not stored separately in the database)
//This has a function that returns total bill of the event booked which will be directly called in the event class
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Bill
{
    // These will be set by manager
    private int electricity_cost;
    private int security_cost;
    private int staff_cost;

    // These will be fetched from database as per requirement
    private int menu_cost;
    private int venue_cost;
    private int studio_cost;
    private int catering_cost;
    private double tax;

    int total;

    public Bill() {
        electricity_cost = security_cost = staff_cost = menu_cost = venue_cost = studio_cost = total = 0;
        tax = 3/100; // 3% tax
    }

    public int getElectricity_cost() {
        return electricity_cost;
    }
    public void setElectricity_cost(int electricity_cost) {
        this.electricity_cost = electricity_cost;
    }

    public int getSecurity_cost() {
        return security_cost;
    }
    public void setSecurity_cost(int security_cost) {
        this.security_cost = security_cost;
    }

    public int getStaff_cost() {
        return staff_cost;
    }
    public void setStaff_cost(int staff_cost) {
        this.staff_cost = staff_cost;
    }

    public int getMenu_cost() {
        return menu_cost;
    }
    public void setMenu_cost(int menu_cost) {
        this.menu_cost = menu_cost;
    }

    public int getVenue_cost() {
        return venue_cost;
    }
    public void setVenue_cost(int venue_cost) {
        this.venue_cost = venue_cost;
    }

    public int getStudio_cost() {
        return studio_cost;
    }
    public void setStudio_cost(int studio_cost) {
        this.studio_cost = studio_cost;
    }

    public int getCatering_cost() {
        return catering_cost;
    }
    public void setCatering_cost(int catering_cost) {
        this.catering_cost = catering_cost;
    }

    public int totalCost(int guests) {
        this.electricity_cost = 50 * guests;
        this.staff_cost = 100 * guests;
        this.security_cost = 50 * guests;

        total = electricity_cost + staff_cost + security_cost + studio_cost + menu_cost + venue_cost + catering_cost;
        tax = tax * total;
        total = total + (int)tax;
        return total;
    }
}
