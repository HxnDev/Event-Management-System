package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class will contain the complete information of a studio. This information will then be stored in Database
// Manager -> Studio -> StudioDB
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.HashMap;

import static java.awt.SystemColor.info;

public class Studio
{
    private String company_name;
    private String contact_info;
    private int cost;

    public Studio() {
        company_name = contact_info = "";
        cost = 0;
    }

    public Studio(String company_name, String contact_info, int cost) {
        this.company_name = company_name;
        this.contact_info = contact_info;
        this.cost = cost;
    }

    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getContact_info() {
        return contact_info;
    }
    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void display() {

        System.out.print("Name: ");
        System.out.println(company_name);

        System.out.print("Contact Info: ");
        System.out.println(contact_info);

        System.out.print("Cost: ");
        System.out.println(cost);

        System.out.println("");
    }

    public Studio getStudio(String studio_id) {
        StudioDB obj = new StudioDB();
        return obj.getStudio(studio_id);
    }

    public HashMap<ArrayList<String>, ArrayList<Studio>> getListOfStudiosAndIDs() {
        StudioDB obj = new StudioDB();
        return obj.getListOfStudiosAndIDs();
    }

    // edit one field
    public void editStudioField(String id, String field, String new_value, boolean isNumeric) {
        StudioDB obj = new StudioDB();
        obj.updateField(id,field,new_value, isNumeric);
    }
}

