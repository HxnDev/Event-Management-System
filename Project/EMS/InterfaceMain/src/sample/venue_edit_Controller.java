package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class venue_edit_Controller {

    private ArrayList<String> venueIDs;

    /////////// VENUE 1 VARS /////////////

    @FXML private JFXTextField venue1_name;
    @FXML private JFXTextField venue1_cat;
    @FXML private JFXTextField venue1_addr;
    @FXML private JFXTextField venue1_loc;
    @FXML private JFXTextField venue1_cap;
    @FXML private JFXTextField venue1_price;
    @FXML private JFXTextField venue1_contact;

    /////////// VENUE 2 VARS /////////////

    @FXML private JFXTextField venue2_name;
    @FXML private JFXTextField venue2_cat;
    @FXML private JFXTextField venue2_addr;
    @FXML private JFXTextField venue2_loc;
    @FXML private JFXTextField venue2_cap;
    @FXML private JFXTextField venue2_price;
    @FXML private JFXTextField venue2_contact;

    /////////// VENUE 3 VARS ////////////

    @FXML private JFXTextField venue3_name;
    @FXML private JFXTextField venue3_cat;
    @FXML private JFXTextField venue3_addr;
    @FXML private JFXTextField venue3_loc;
    @FXML private JFXTextField venue3_cap;
    @FXML private JFXTextField venue3_price;
    @FXML private JFXTextField venue3_contact;

    ///////////////// BUTTONS /////////////

    @FXML private JFXButton exit_btn;
    @FXML private JFXButton save_btn;

    ////////////////////////////////////////////////////////////

    public void init() {
        System.out.println("Initialising venues");

        // get list of all venues
        Venue venue_obj = new Venue();

        HashMap<ArrayList<String>, ArrayList<Venue>> PairOfVenuesAndIDs = venue_obj.getListOfVenuesAndIDs();
        // at first index of hashmap
        ArrayList<Venue> venueList = (ArrayList<Venue>) PairOfVenuesAndIDs.values().toArray()[0];
        venueIDs = (ArrayList<String>) PairOfVenuesAndIDs.keySet().toArray()[0];

        // picking up all three venues from database
        Venue v1 = venueList.get(0);
        Venue v2 = venueList.get(1);
        Venue v3 = venueList.get(2);

        // transferring to interface variables

        // first venue details
        venue1_name.setText(v1.getName());
        venue1_cat.setText(v1.getCategory());
        venue1_addr.setText(v1.getVenue_address());
        venue1_loc.setText(v1.getLocation());
        venue1_cap.setText(Integer.toString(v1.getMax_capacity()));
        venue1_price.setText(Integer.toString(v1.getCost()));
        venue1_contact.setText(v1.getContact_info());

        // second venue details
        venue2_name.setText(v2.getName());
        venue2_cat.setText(v2.getCategory());
        venue2_addr.setText(v2.getVenue_address());
        venue2_loc.setText(v2.getLocation());
        venue2_cap.setText(Integer.toString(v2.getMax_capacity()));
        venue2_price.setText(Integer.toString(v2.getCost()));
        venue2_contact.setText(v2.getContact_info());

        // third venue details
        venue3_name.setText(v3.getName());
        venue3_cat.setText(v3.getCategory());
        venue3_addr.setText(v3.getVenue_address());
        venue3_loc.setText(v3.getLocation());
        venue3_cap.setText(Integer.toString(v3.getMax_capacity()));
        venue3_price.setText(Integer.toString(v3.getCost()));
        venue3_contact.setText(v3.getContact_info());
    }

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (venue1_name == null || venue1_cat == null || venue1_addr == null || venue1_loc == null || venue1_cap == null || venue1_price == null || venue1_contact == null) {
            openPopup("Missing Input", "Please fill all the fields for 1st venue.");
            return false;
        }

        if (venue2_name == null || venue2_cat == null || venue2_addr == null || venue2_loc == null || venue2_cap == null || venue2_price == null || venue2_contact == null) {
            openPopup("Missing Input", "Please fill all the fields for 2nd venue.");
            return false;
        }

        if (venue3_name == null || venue3_cat == null || venue3_addr == null || venue3_loc == null || venue3_cap == null || venue3_price == null || venue3_contact == null) {
            openPopup("Missing Input", "Please fill all the fields for 3rd venue.");
            return false;
        }

        if (venue1_name.getText().isEmpty() || venue1_cat.getText().isEmpty() || venue1_addr.getText().isEmpty() || venue1_loc.getText().isEmpty()|| venue1_cap.getText().isEmpty() || venue1_price.getText().isEmpty() || venue1_contact.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 1st venue.");
            return false;
        }

        if (venue2_name.getText().isEmpty() || venue2_cat.getText().isEmpty() || venue2_addr.getText().isEmpty() || venue2_loc.getText().isEmpty() || venue2_cap.getText().isEmpty() || venue2_price.getText().isEmpty()|| venue2_contact.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 2nd venue.");
            return false;
        }

        if (venue3_name.getText().isEmpty() || venue3_cat.getText().isEmpty() || venue3_addr.getText().isEmpty() || venue3_loc.getText().isEmpty() || venue3_cap.getText().isEmpty()|| venue3_price.getText().isEmpty() || venue3_contact.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 3rd venue.");
            return false;
        }


        if (venue1_price.getText().matches(".*[a-zA-Z]+.*") ||venue2_price.getText().matches(".*[a-zA-Z]+.*") || venue3_price.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Missing Input", "All prices must be numbers.");
            return false;
        }

        if (venue1_cap.getText().matches(".*[a-zA-Z]+.*") ||venue2_cap.getText().matches(".*[a-zA-Z]+.*") || venue3_cap.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Missing Input", "All capacities must be numeric only.");
            return false;
        }

        int v1_price = Integer.parseInt(venue1_price.getText());
        int v2_price = Integer.parseInt(venue2_price.getText());
        int v3_price = Integer.parseInt(venue3_price.getText());

        if ( v1_price < 0 || v2_price < 0 || v3_price < 0 ) {
            openPopup("Invalid Input", "Prices cannot be negative");
            return false;
        }

        int v1_cap = Integer.parseInt(venue1_cap.getText());
        int v2_cap = Integer.parseInt(venue2_cap.getText());
        int v3_cap = Integer.parseInt(venue3_cap.getText());

        if ( v1_cap < 0 || v2_cap < 0 || v3_cap < 0 ) {
            openPopup("Invalid Input", "Prices cannot be negative");
            return false;
        }

        return true;
    }

    ////////////////////////////////////////////////////////////

    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        goToMgrMenu();
    }

    public void handleSaveButton(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Save button pressed");

        if (checkInputs() == false) {
            System.out.println("Input check failed");
            return;
        }

        String name, contact, cat, cap, addr, loc, price;
        Venue venue = new Venue();

        // getting values of first venue
        name = venue1_name.getText();
        contact = venue1_contact.getText();
        cat = venue1_cat.getText();
        cap = venue1_cap.getText();
        addr = venue1_addr.getText();
        loc = venue1_loc.getText();
        price = venue1_price.getText();

        // updating in database
        venue.editVenueField(venueIDs.get(0),"name", name, false);
        venue.editVenueField(venueIDs.get(0), "location", loc, false);
        venue.editVenueField(venueIDs.get(0), "address", addr, false);
        venue.editVenueField(venueIDs.get(0), "max_capacity", cap, true);
        venue.editVenueField(venueIDs.get(0), "category", cat, false);
        venue.editVenueField(venueIDs.get(0), "contact_info", contact, false);
        venue.editVenueField(venueIDs.get(0), "cost", price, true);

        // getting values of second venue
        name = venue2_name.getText();
        contact = venue2_contact.getText();
        cat = venue2_cat.getText();
        cap = venue2_cap.getText();
        addr = venue2_addr.getText();
        loc = venue2_loc.getText();
        price = venue2_price.getText();

        // updating in database
        venue.editVenueField(venueIDs.get(1),"name", name, false);
        venue.editVenueField(venueIDs.get(1), "location", loc, false);
        venue.editVenueField(venueIDs.get(1), "address", addr, false);
        venue.editVenueField(venueIDs.get(1), "max_capacity", cap, true);
        venue.editVenueField(venueIDs.get(1), "category", cat, false);
        venue.editVenueField(venueIDs.get(1), "contact_info", contact, false);
        venue.editVenueField(venueIDs.get(1), "cost", price, true);

        // getting values of third venue
        name = venue3_name.getText();
        contact = venue3_contact.getText();
        cat = venue3_cat.getText();
        cap = venue3_cap.getText();
        addr = venue3_addr.getText();
        loc = venue3_loc.getText();
        price = venue3_price.getText();

        // updating in database
        venue.editVenueField(venueIDs.get(2),"name", name, false);
        venue.editVenueField(venueIDs.get(2), "location", loc, false);
        venue.editVenueField(venueIDs.get(2), "address", addr, false);
        venue.editVenueField(venueIDs.get(2), "max_capacity", cap, true);
        venue.editVenueField(venueIDs.get(2), "category", cat, false);
        venue.editVenueField(venueIDs.get(2), "contact_info", contact, false);
        venue.editVenueField(venueIDs.get(2), "cost", price, true);

        // refreshing screen
        goToVenueOptions();
    }

    ///////////////// SCENE SWITCHING ///////////////////////

    public void goToMgrMenu() throws IOException {
        System.out.println("Loading manager menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mgr_menu.fxml"));
        Parent root = loader.load();

        //Get controller of main menu scene
        mgr_menu_Controller controller = loader.getController();
        controller.setName(LoggedInUsers.getEmp().getName());

        // close current window
        Stage window = (Stage) exit_btn.getScene().getWindow();
        window.close();

        // start new window for main scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Manager Menu");
        window.show();
    }

    public void goToVenueOptions() throws IOException {
        System.out.println("Loading venue options window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("venue_edit.fxml"));
        Parent root = loader.load();

        //Get controller of employee ign in scene
        venue_edit_Controller controller = loader.getController();
        controller.init();

        // close current window
        Stage window = (Stage) save_btn.getScene().getWindow();
        window.close();

        // start new window for sign in scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Edit Venues");
        window.show();
    }

    // open popup
    public void openPopup(String heading, String text) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popup.fxml"));
        Parent root = loader.load();

        //Get controller of register scene
        popup_controller controller = loader.getController();
        controller.setContent(heading,text);

        // start new window for main scene
        Stage window = new Stage();
        window.setScene(new Scene(root));
        window.show();
        audioPlayer.play();
    }
}
