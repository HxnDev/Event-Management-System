package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class will contain the details of a certain venue which will then be stored in a database
// Manager has access to this
// Manager -> Venue -> VenueDb
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Venue
{
    private String name;
    private String location;            //Area where venue is located
    private String venue_address;       //Proper coordinates of venue
    private int max_capacity;           //Maximum capacity venue can hold
    private String description;         //Description of the venue
    private String category;            //Seaside/Grasslands/Indoor
    private String contact_info;          //Contact details of venue
    private int cost;                   //Price of venue

    public Venue() {
    }

    public Venue(String name, String location, String venue_address, int max_capacity, String description, String category, String contact_info, int cost) {
        this.name = name;
        this.location = location;
        this.venue_address = venue_address;
        this.max_capacity = max_capacity;
        this.description = description;
        this.category = category;
        this.contact_info = contact_info;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getVenue_address() {
        return venue_address;
    }
    public void setVenue_address(String venue_address) {
        this.venue_address = venue_address;
    }

    public int getMax_capacity() {
        return max_capacity;
    }
    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
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

    public Venue getVenue(String venue_id) {
        VenueDB obj = new VenueDB();
        return obj.getVenue(venue_id);
    }

    public HashMap<ArrayList<String>, ArrayList<Venue>> getListOfVenuesAndIDs() {
        VenueDB obj = new VenueDB();
        return obj.getListOfVenuesAndIDs();
    }

    // edit one field
    public void editVenueField(String id, String field, String new_value, boolean isNumeric) {
        VenueDB obj = new VenueDB();
        obj.updateField(id,field,new_value, isNumeric);
    }
}
