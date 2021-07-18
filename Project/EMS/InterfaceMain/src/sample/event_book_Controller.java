package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("DuplicatedCode")
public class event_book_Controller {

    ////////// VARIABLES FOR EVENT CREATION ////////

    private String selectedVenue_id;
    private String selectedMenu_id;
    private String selectedCatering_id;
    private String selectedStudio_id;
    private String selectedMedia_id;

    private int selectedVenueCap;

    ////////// VARIABLES FOR BACKEND ////////

    private ArrayList<String> venueIDs;
    private ArrayList<String> catererIDs;
    private ArrayList<String> studioIDs;

    private HashMap<String, Integer> menuPrices;

    ////// BUTTON VARIABLES FROM INTERFACE //////

    @FXML private JFXButton exit_btn;
    @FXML private JFXButton book_btn;

    @FXML private JFXCheckBox venue1_btn;
    @FXML private JFXCheckBox venue2_btn;
    @FXML private JFXCheckBox venue3_btn;

    @FXML private JFXCheckBox caterer1_btn;
    @FXML private JFXCheckBox caterer2_btn;
    @FXML private JFXCheckBox caterer3_btn;

    @FXML private JFXCheckBox studio1_btn;
    @FXML private JFXCheckBox studio2_btn;
    @FXML private JFXCheckBox studio3_btn;

    //////////// VARIABLES WITH DATA ////////

    @FXML private JFXTextField contact;

    //////////// EVENT VARS //////////////

    @FXML private JFXTextField event_name;
    @FXML private JFXTextField event_type;
    @FXML private DatePicker event_date;
    @FXML private JFXTextField event_start;
    @FXML private JFXTextField event_end;
    @FXML private JFXTextField event_guests;

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

    ////////////// MENU VARS //////////////

    @FXML private JFXCheckBox menu_rice_eggfried;
    @FXML private  JFXCheckBox menu_rice_biryani;
    @FXML private  JFXCheckBox menu_rice_plain;
    @FXML private  JFXCheckBox menu_rice_kabuli;

    @FXML private  JFXCheckBox menu_bread_naan;
    @FXML private  JFXCheckBox menu_bread_tandoori;
    @FXML private  JFXCheckBox menu_bread_lebanese;

    @FXML private  JFXCheckBox menu_protein_chicken;
    @FXML private  JFXCheckBox menu_protein_beef;
    @FXML private  JFXCheckBox menu_protein_seafood;
    @FXML private  JFXCheckBox menu_protein_mutton;

    @FXML private  JFXCheckBox menu_drink_water;
    @FXML private  JFXCheckBox menu_drink_miranda;
    @FXML private  JFXCheckBox menu_drink_sprite;
    @FXML private  JFXCheckBox menu_drink_coke;

    @FXML private JFXCheckBox menu_extra_dryfruit;
    @FXML private JFXCheckBox menu_extra_sugarfree;
    @FXML private JFXCheckBox menu_extra_cake;
    @FXML private JFXCheckBox menu_extra_icecream;

    ////////// CATERER 1 VARS /////////

    @FXML private JFXTextField caterer1_name;
    @FXML private JFXTextField caterer1_contact;
    @FXML private JFXTextField caterer1_specialty;
    @FXML private JFXTextField caterer1_price;
    @FXML private JFXTextField caterer1_days;

    ////////// CATERER 2 VARS /////////

    @FXML private JFXTextField caterer2_name;
    @FXML private JFXTextField caterer2_contact;
    @FXML private JFXTextField caterer2_specialty;
    @FXML private JFXTextField caterer2_price;
    @FXML private JFXTextField caterer2_days;

    ////////// CATERER 3 VARS /////////

    @FXML private JFXTextField caterer3_name;
    @FXML private JFXTextField caterer3_contact;
    @FXML private JFXTextField caterer3_specialty;
    @FXML private JFXTextField caterer3_price;
    @FXML private JFXTextField caterer3_days;

    ////////// STUDIO 1 VARS //////////

    @FXML private JFXTextField studio1_name;
    @FXML private JFXTextField studio1_contact;

    ////////// STUDIO 2 VARS //////////

    @FXML private JFXTextField studio2_name;
    @FXML private JFXTextField studio2_contact;

    ////////// STUDIO 3 VARS //////////

    @FXML private JFXTextField studio3_name;
    @FXML private JFXTextField studio3_contact;

    ///////// MEDIA REQ VARS //////////

    @FXML private JFXCheckBox media_photo;
    @FXML private JFXCheckBox media_video;
    @FXML private JFXCheckBox media_album;
    @FXML private JFXCheckBox media_drone;
    @FXML private JFXCheckBox media_crane;

    ////////////////////////////////////////////////////////////////////////

    public void initBookEvent() {
        System.out.println("Initialising booking variables");

        contact.setText("ashseventshelp@gmail.com");

        initVenueVariables();
        initCatererVariables();
        initStudioVariables();
    }

    public void initVenueVariables() {
        System.out.println("Initialising venue variables");

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
        venue1_cap.setText("Capacity: " + Integer.toString(v1.getMax_capacity()));
        venue1_price.setText(Integer.toString(v1.getCost()) + " Rs");
        venue1_contact.setText(v1.getContact_info());

        // second venue details
        venue2_name.setText(v2.getName());
        venue2_cat.setText(v2.getCategory());
        venue2_addr.setText(v2.getVenue_address());
        venue2_loc.setText(v2.getLocation());
        venue2_cap.setText("Capacity: " + Integer.toString(v2.getMax_capacity()));
        venue2_price.setText(Integer.toString(v2.getCost()) + " Rs");
        venue2_contact.setText(v2.getContact_info());

        // third venue details
        venue3_name.setText(v3.getName());
        venue3_cat.setText(v3.getCategory());
        venue3_addr.setText(v3.getVenue_address());
        venue3_loc.setText(v3.getLocation());
        venue3_cap.setText("Capacity: " + Integer.toString(v3.getMax_capacity()));
        venue3_price.setText(Integer.toString(v3.getCost()) + " Rs");
        venue3_contact.setText(v3.getContact_info());
    }

    public void initCatererVariables() {
        System.out.println("Initialising catering variables");

        // get list of all caterers
        Catering_Service catering_obj = new Catering_Service();

        HashMap<ArrayList<String>, ArrayList<Catering_Service>> PairOfCaterersAndIDs = catering_obj.getListOfCaterersAndIDs();
        // at first index of hashmap
        ArrayList<Catering_Service> catererList = (ArrayList<Catering_Service>) PairOfCaterersAndIDs.values().toArray()[0];
        catererIDs = (ArrayList<String>) PairOfCaterersAndIDs.keySet().toArray()[0];

        // picking up all three caterers from database
        Catering_Service c1 = catererList.get(0);
        Catering_Service c2 = catererList.get(1);
        Catering_Service c3 = catererList.get(2);

        /// transferring to interface variables

        // first caterer details
        caterer1_name.setText(c1.getCompany_name());
        caterer1_contact.setText(c1.getContact_info());
        caterer1_specialty.setText(c1.getSpeciality());
        caterer1_price.setText(Integer.toString(c1.getCharges()) + " Rs");
        caterer1_days.setText(Integer.toString(c1.getDays()));

        // second caterer details
        caterer2_name.setText(c2.getCompany_name());
        caterer2_contact.setText(c2.getContact_info());
        caterer2_specialty.setText(c2.getSpeciality());
        caterer2_price.setText(Integer.toString(c2.getCharges()) + " Rs");
        caterer2_days.setText(Integer.toString(c2.getDays()));

        // second caterer details
        caterer3_name.setText(c3.getCompany_name());
        caterer3_contact.setText(c3.getContact_info());
        caterer3_specialty.setText(c3.getSpeciality());
        caterer3_price.setText(Integer.toString(c3.getCharges()) + " Rs");
        caterer3_days.setText(Integer.toString(c3.getDays()));

        // set menu prices
        menuPrices = new HashMap<String, Integer>();
        // rice
        menuPrices.put("biryani", 11000);
        menuPrices.put("eggfried",7000);
        menuPrices.put("plain", 3000);
        menuPrices.put("kabuli", 13000);
        // bread
        menuPrices.put("naan", 5000);
        menuPrices.put("tandoori", 4500);
        menuPrices.put("lebanese", 7000);
        // meat
        menuPrices.put("chicken",12000);
        menuPrices.put("beef", 15000);
        menuPrices.put("seafood", 22000);
        menuPrices.put("mutton", 19000);
        // drinks
        menuPrices.put("miranda", 7000);
        menuPrices.put("coke", 7000);
        menuPrices.put("sprite", 7000);
        menuPrices.put("water", 7000);
        // extras
        menuPrices.put("dryfruit",7000);
        menuPrices.put("icecream", 7000);
        menuPrices.put("cake", 7000);
    }

    public void initStudioVariables() {
        System.out.println("Intialising studio variables");

        // get list of all studios
        Studio studio_obj = new Studio();

        HashMap<ArrayList<String>, ArrayList<Studio>> PairOfStudiosAndIDs = studio_obj.getListOfStudiosAndIDs();
        // at first index of hashmap
        ArrayList<Studio> studioList = (ArrayList<Studio>) PairOfStudiosAndIDs.values().toArray()[0];
        studioIDs = (ArrayList<String>) PairOfStudiosAndIDs.keySet().toArray()[0];

        // picking up all three venues from database
        Studio s1 = studioList.get(0);
        Studio s2 = studioList.get(1);
        Studio s3 = studioList.get(2);

        // transferring to interface variables

        // first studio details
        studio1_name.setText(s1.getCompany_name());
        studio1_contact.setText(s1.getContact_info());

        // second studio details
        studio2_name.setText(s2.getCompany_name());
        studio2_contact.setText(s2.getContact_info());

        // third studio details
        studio3_name.setText(s3.getCompany_name());
        studio3_contact.setText(s3.getContact_info());
    }

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (event_type == null || event_date == null || event_start == null || event_end == null || event_guests == null) {
            openPopup("Invalid Input", "Please fill all the event details fields.");
            return false;
        }

        if (event_type.getText().isEmpty() || event_start.getText().isEmpty()|| event_end.getText().isEmpty() || event_guests.getText().isEmpty()) {
            openPopup("Invalid Input", "Please fill all the event details fields.");
            return false;
        }

        if (event_guests.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Incorrect Input", "Number of guests must be numeric.");
            return false;
        }

        if (selectedCatering_id == null) {
            openPopup("Incomplete Booking", "Please select a caterer to proceed with your booking.");
            return false;
        }

        if (selectedVenue_id == null) {
            openPopup("Incomplete Booking", "Please select a venue to proceed with your booking.");
            return false;
        }

        if (selectedStudio_id == null) {
            openPopup("Incomplete Booking", "Please select a studio to proceed with your booking.");
            return false;
        }

        if (Integer.parseInt(event_guests.getText()) > selectedVenueCap) {
            openPopup("Incorrect Input", "Number of guests exceeds capacity of selected venue.");
            return false;
        }

        if (Integer.parseInt(event_guests.getText()) < 1) {
            openPopup("Incorrect Input", "Number of guests must be 1 or more.");
            return false;
        }

        if (event_date.getValue().isBefore(java.time.LocalDate.now())) {
            openPopup("Invalid Input", "Event date cannot be before current date.");
            return false;
        }

        return true;
    }

    //////////////////////////////////////////////////////////

    public void handleVenue1Button(MouseEvent  actionEvent) {
        System.out.println("Venue 1 selected");
        selectedVenue_id = venueIDs.get(0);

        // getting capacity of the venue
        String[] tokens = venue1_cap.getText().split(" ", 2);
        String cap = tokens[1];

        selectedVenueCap = Integer.parseInt(cap);

        venue2_btn.setSelected(false);
        venue3_btn.setSelected(false);
    }

    public void handleVenue2Button(MouseEvent actionEvent) {
        System.out.println("Venue 2 selected");
        selectedVenue_id = venueIDs.get(1);

        // getting capacity of the venue
        String[] tokens = venue2_cap.getText().split(" ", 2);
        String cap = tokens[1];

        selectedVenueCap = Integer.parseInt(cap);

        venue1_btn.setSelected(false);
        venue3_btn.setSelected(false);
    }

    public void handleVenue3Button(MouseEvent  actionEvent) {
        System.out.println("Venue 3 selected");
        selectedVenue_id = venueIDs.get(2);

        // getting capacity of the venue
        String[] tokens = venue3_cap.getText().split(" ", 2);
        String cap = tokens[1];

        selectedVenueCap = Integer.parseInt(cap);

        venue1_btn.setSelected(false);
        venue2_btn.setSelected(false);
    }

    public void handleCaterer1Button(MouseEvent  actionEvent) {
        System.out.println("Caterer 1 selected");
        selectedCatering_id = catererIDs.get(0);

        caterer2_btn.setSelected(false);
        caterer3_btn.setSelected(false);
    }

    public void handleCaterer2Button(MouseEvent  actionEvent) {
        System.out.println("Caterer 2 selected");
        selectedCatering_id = catererIDs.get(1);

        caterer1_btn.setSelected(false);
        caterer3_btn.setSelected(false);
    }

    public void handleCaterer3Button(MouseEvent actionEvent) {
        System.out.println("Caterer 3 selected");
        selectedCatering_id = catererIDs.get(2);

        caterer2_btn.setSelected(false);
        caterer1_btn.setSelected(false);
    }

    public void handleStudio1Button(MouseEvent  actionEvent) {
        System.out.println("Studio 1 selected");
        selectedStudio_id = studioIDs.get(0);

        studio2_btn.setSelected(false);
        studio3_btn.setSelected(false);
    }

    public void handleStudio2Button(MouseEvent  actionEvent) {
        System.out.println("Studio 2 selected");
        selectedStudio_id = studioIDs.get(1);

        studio1_btn.setSelected(false);
        studio3_btn.setSelected(false);
    }

    public void handleStudio3Button(MouseEvent  actionEvent) {
        System.out.println("Studio 3 selected");
        selectedStudio_id = studioIDs.get(2);

        studio2_btn.setSelected(false);
        studio1_btn.setSelected(false);
    }

    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        goToCustMenu();
    }

    //////////////////////////////////////////////////////////////////

    public void generateMenu() {
        System.out.println("Generating desired menu");

        Menu menu = new Menu();
        int price = 0;

        String rice = "", bread = "", protein = "";

        if (menu_rice_biryani.isSelected()) {
            rice += "Biryani";
            price += menuPrices.get("biryani");
        }

        if (menu_rice_eggfried.isSelected()) {
            if (rice.isEmpty())
                rice += "Egg-fried";
            else
                rice += ", Egg-fried";

            price += menuPrices.get("eggfried");
        }

        if (menu_rice_plain.isSelected()) {
            if (rice.isEmpty())
                rice += "Plain boiled";
            else
                rice += ", Plain boiled";

            price += menuPrices.get("plain");
        }

        if (menu_rice_kabuli.isSelected()) {
            if (rice.isEmpty())
                rice += "Kabuli";
            else
                rice += ", Kabuli";

            price += menuPrices.get("kabuli");
        }

        menu.setRice(rice);

        if (menu_bread_naan.isSelected()) {
            bread += "Naan";
            price += menuPrices.get("naan");
        }

        if (menu_bread_tandoori.isSelected()) {
            if (bread.isEmpty())
                bread += "Tandoori";
            else
                bread += ", Tandoori";

            price += menuPrices.get("tandoori");
        }

        if (menu_bread_lebanese.isSelected()) {
            if (bread.isEmpty())
                bread += "Lebanese";
            else
                bread += ", Lebanese";

            price += menuPrices.get("lebanese");
        }

        menu.setBread(bread);

        if (menu_protein_chicken.isSelected()) {
            protein += "Chicken";
            price += menuPrices.get("chicken");
        }

        if (menu_protein_beef.isSelected()) {
            if (protein.isEmpty())
                protein += "Beef";
            else
                protein += ", Beef";

            price += menuPrices.get("biryani");
        }

        if (menu_protein_mutton.isSelected()) {
            if (protein.isEmpty())
                protein += "Mutton";
            else
                protein += ", Mutton";

            price += menuPrices.get("mutton");
        }

        if (menu_protein_seafood.isSelected()) {
            if (protein.isEmpty())
                protein += "Seafood";
            else
                protein += ", Seafood";

            price += menuPrices.get("seafood");
        }

        menu.setProtein(protein);

        menu.setCoke(menu_drink_coke.isSelected());
        price += menu_drink_coke.isSelected() ? menuPrices.get("coke") : 0;

        menu.setMiranda(menu_drink_miranda.isSelected());
        price += menu_drink_miranda.isSelected() ? menuPrices.get("miranda") : 0;

        menu.setSprite(menu_drink_sprite.isSelected());
        price += menu_drink_sprite.isSelected() ? menuPrices.get("sprite") : 0;

        menu.setWater(menu_drink_water.isSelected());
        price += menu_drink_water.isSelected() ? menuPrices.get("water") : 0;

        menu.setDryfruit(menu_extra_dryfruit.isSelected());
        price += menu_extra_dryfruit.isSelected() ? menuPrices.get("dryfruit") : 0;

        menu.setSugar(menu_extra_sugarfree.isSelected());

        menu.setCake(menu_extra_cake.isSelected());
        price += menu_extra_cake.isSelected() ? menuPrices.get("cake") : 0;

        menu.setIcecream(menu_extra_icecream.isSelected());
        price += menu_extra_icecream.isSelected() ? menuPrices.get("icecream") : 0;

        menu.setCost(price);

        // adding to database
        selectedMenu_id = menu.addMenu();
    }

    public void generateMediaReqs() {
        System.out.println("Generating new media requirements");

        Media_Requirements media = new Media_Requirements();

        media.setPhotography(media_photo.isSelected() ? 1 : 0);
        media.setVideography(media_video.isSelected() ? 1 : 0);
        media.setAlbum_printing(media_album.isSelected() ? 1 : 0);
        media.setDrone(media_drone.isSelected() ? 1 : 0);
        media.setCrane(media_crane.isSelected() ? 1 : 0);

        // adding to database
        selectedMedia_id = media.addMediaRequirements();
    }

    // processing booking details
    public void handleBookButton(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Book button pressed");

        if (checkInputs() == false) {
            System.out.println("Input check failed.");
            return;
        }

        Event event = new Event();

        // get event details
        event.setName(event_name.getText());
        event.setType(event_type.getText());
        event.setStarting_time(event_start.getText());
        event.setEnding_time(event_end.getText());
        event.setTotal_guests(Integer.parseInt(event_guests.getText()));

        LocalDate date = event_date.getValue();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        String e_date = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
        String temp_date = Integer.toString(year) + "-" +  Integer.toString(month) + "-" + Integer.toString(day);
        event.setDate(temp_date);

        if (event.isDateBooked()) {
            openPopup("Warning", "That date is unavailable. Please select another.");
            return;
        }

        event.setDate(e_date);

        generateMenu();
        generateMediaReqs();

        event.bookEvent(LoggedInUsers.getCust_id(), selectedVenue_id, selectedStudio_id,
               selectedMenu_id, selectedCatering_id, selectedMedia_id);

        String msg = "This is a confirmation message that your event has been booked with us. Event details are as follows: Name : " + event.getName() +
                ", Type : " + event.getType() + ", Date: " + event.getDate();
        emailClass.sendEmail("Event Booked", msg, LoggedInUsers.getCust().getEmail_address());

        goToPayment(Integer.toString(event.getPrice()));
    }

    ////////////////////// SCENE SWITCHING //////////////////////

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
        Stage window = (Stage) exit_btn.getScene().getWindow();
        window.close();

        // start new window for next scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);
        window.setTitle("Welcome");
        window.show();
    }

    public void goToPayment(String total) throws IOException {
        System.out.println("Loading customer menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml"));
        Parent root = loader.load();

        //Get controller of cust bg scene
        payment_Controller controller = loader.getController();

        //setting information
        controller.setNetTotal(total);

        // close current window
        Stage window = (Stage) book_btn.getScene().getWindow();
        window.close();

        // start new window for next scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);
        window.setTitle("Enter details");
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
