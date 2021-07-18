package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class event_view_Controller {

    /////////// VARIABLES FROM INTERFACE ///////////

    @FXML private JFXButton exit_btn;

    //////////// EVENT VARS //////////////

    @FXML private JFXTextField event_name;
    @FXML private JFXTextField event_type;
    @FXML private JFXTextField event_date;
    @FXML private JFXTextField event_time;
    @FXML private JFXTextField event_guests;
    @FXML private JFXTextField event_price;

    ////////// VENUE VARS //////////////

    @FXML private JFXTextField venue_name;
    @FXML private JFXTextField venue_loc;
    @FXML private JFXTextField venue_addr;
    @FXML private JFXTextField venue_cap;
    @FXML private JFXTextField venue_cat;
    @FXML private JFXTextField venue_contact;
    @FXML private JFXTextField venue_cost;

    ///////// MENU VARS //////////

    @FXML private JFXTextField menu_caterer;
    @FXML private JFXTextField menu_bread;
    @FXML private JFXTextField menu_rice;
    @FXML private JFXTextField menu_protein;
    @FXML private JFXTextField menu_cost;
    @FXML private JFXCheckBox menu_water;
    @FXML private JFXCheckBox menu_dryfruit;
    @FXML private JFXCheckBox menu_icecream;
    @FXML private JFXCheckBox menu_cake;
    @FXML private JFXCheckBox menu_sugarfree;
    @FXML private JFXCheckBox menu_miranda;
    @FXML private JFXCheckBox menu_coke;
    @FXML private JFXCheckBox menu_sprite;

    //////////////// STUDIO VARS ///////////

    @FXML private JFXTextField studio_name;
    @FXML private JFXTextField studio_contact;
    @FXML private JFXTextField studio_cost;

    //////////// MEDIA REQS VARS /////////////

    @FXML private JFXCheckBox media_photo;
    @FXML private JFXCheckBox media_video;
    @FXML private JFXCheckBox media_album;
    @FXML private JFXCheckBox media_drone;
    @FXML private JFXCheckBox media_crane;

    /////////////////////////////////////////////////////////

    public void disableExitButton() {
        exit_btn.setOpacity(0);
        exit_btn.setDisable(true);
    }

    public boolean setEventDetails(String id, int IDtype) {
        System.out.println("Initialising event details");

        Event event = new Event();
        event = event.getEvent(id, IDtype);

        // getting all associated ids
        HashMap<String, String> IDs;
        IDs = event.getEventIDs(id, IDtype);

        // no event found against that customer id
        if (event.getName().isEmpty()) {
            return false;
        }

        // event found
        else {
            event_name.setText(event.getName());
            event_type.setText(event.getType());
            event_date.setText(event.getDate());
            event_time.setText(event.getStarting_time() + " to " + event.getEnding_time());
            event_guests.setText(Integer.toString(event.getTotal_guests()));
            event_price.setText(Integer.toString(event.getPrice()));

            setVenueDetails(IDs.get("venue_id"));
            setMenuDetails(IDs.get("menu_id"), IDs.get("catering_id"));
            setStudioDetails(IDs.get("studio_id"));
            setMediaDetails(IDs.get("media_id"));

            disableEditing();

            return true;
        }
    }

    public void setVenueDetails(String venue_id) {
        System.out.println("Setting venue details");

        Venue venue = new Venue();
        venue = venue.getVenue(venue_id);

        venue_name.setText(venue.getName());
        venue_loc.setText(venue.getLocation());
        venue_addr.setText(venue.getVenue_address());
        venue_cap.setText(Integer.toString(venue.getMax_capacity()));
        venue_cat.setText(venue.getCategory());
        venue_contact.setText(venue.getContact_info());
        venue_cost.setText(Integer.toString(venue.getCost()));
    }

    public void setMenuDetails(String menu_id, String cat_id) {
        System.out.println("Setting menu details");

        Menu menu = new Menu();
        menu = menu.getMenu(menu_id);

        menu_bread.setText(menu.getBread());
        if (menu_bread.getText().isEmpty())
            menu_bread.setText("Nothing selected");

        menu_rice.setText(menu.getRice());
        if (menu_rice.getText().isEmpty())
            menu_rice.setText("Nothing selected");

        menu_protein.setText(menu.getProtein());
        if (menu_protein.getText().isEmpty())
            menu_protein.setText("Nothing selected");

        menu_cost.setText(Integer.toString(menu.getCost()));

        menu_miranda.setSelected(menu.isMiranda());
        menu_coke.setSelected(menu.isCoke());
        menu_sprite.setSelected(menu.isSprite());
        menu_water.setSelected(menu.isWater());

        menu_dryfruit.setSelected(menu.isDryfruit());
        menu_sugarfree.setSelected(menu.isSugarFree());

        menu_icecream.setSelected(menu.isIcecream());
        menu_cake.setSelected(menu.isCake());

        Catering_Service caterer = new Catering_Service();
        caterer = caterer.getCaterer(cat_id);

        menu_caterer.setText(caterer.getCompany_name());
    }

    public void setStudioDetails(String studio_id) {
        System.out.println("Setting studio details");

        Studio studio = new Studio();
        studio = studio.getStudio(studio_id);

        studio_name.setText(studio.getCompany_name());
        studio_contact.setText(studio.getContact_info());
        studio_cost.setText(Integer.toString(studio.getCost()));
    }

    public void setMediaDetails(String media_id) {
        System.out.println("Setting media details");

        Media_Requirements media = new Media_Requirements();
        media = media.getMedia(media_id);

        media_photo.setSelected(media.getPhotography() == 1);
        media_video.setSelected(media.getVideography() == 1);
        media_album.setSelected(media.getAlbum_printing() == 1);
        media_drone.setSelected(media.getDrone() == 1);
        media_crane.setSelected(media.getCrane() == 1);
    }

    // so user cannot change from 'view' screen
    public void disableEditing() {
        System.out.println("Disabling editing for view event");

        // disabling event text fields
        event_name.setEditable(false);
        event_type.setEditable(false);
        event_date.setEditable(false);
        event_time.setEditable(false);
        event_guests.setEditable(false);
        event_price.setEditable(false);

        // disabling venue text fields
        venue_name.setEditable(false);
        venue_loc.setEditable(false);
        venue_addr.setEditable(false);
        venue_cap.setEditable(false);
        venue_cat.setEditable(false);
        venue_contact.setEditable(false);
        venue_cost.setEditable(false);

        // disabling menu text fields
        menu_caterer.setEditable(false);
        menu_bread.setEditable(false);
        menu_rice.setEditable(false);
        menu_protein.setEditable(false);
        menu_cost.setEditable(false);

        // disabling menu check boxes
        menu_miranda.setDisable(true);
        menu_coke.setDisable(true);
        menu_sprite.setDisable(true);
        menu_water.setDisable(true);
        menu_dryfruit.setDisable(true);
        menu_sugarfree.setDisable(true);
        menu_cake.setDisable(true);
        menu_icecream.setDisable(true);

        // disabling media check boxes
        media_photo.setDisable(true);
        media_video.setDisable(true);
        media_album.setDisable(true);
        media_drone.setDisable(true);
        media_crane.setDisable(true);
    }

    /////////////////////////////////////////////////////////

    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        goToCustMenu();
    }

    //////////////////// SCENE SWITCHING ////////////////////

    public void goToCustMenu() throws IOException {
        System.out.println("Loading customer menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_menu.fxml"));
        Parent root = loader.load();

        //Get controller of cust bg scene
        cust_menu_Controller controller = loader.getController();

        //setting information
        controller.setWelcome(LoggedInUsers.getCust().getName());
        controller.setEventBookedStatus(LoggedInUsers.getCust_id());

        // close current window
        Stage stage = (Stage) exit_btn.getScene().getWindow();
        stage.close();

        // start new window for next scene
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Welcome");
        stage.show();
    }
}
