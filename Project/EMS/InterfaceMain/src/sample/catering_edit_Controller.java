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

public class catering_edit_Controller {

    private ArrayList<String> catererIDs;

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

    ///////////// BUTTONS //////////////

    @FXML private JFXButton exit_btn;
    @FXML private JFXButton save_btn;

    //////////////////////////////////////////////

    // set values to be displayed
    public void init() {
        System.out.println("Initialising catering edit window");

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
        caterer1_price.setText(Integer.toString(c1.getCharges()));
        caterer1_days.setText(Integer.toString(c1.getDays()));

        // second caterer details
        caterer2_name.setText(c2.getCompany_name());
        caterer2_contact.setText(c2.getContact_info());
        caterer2_specialty.setText(c2.getSpeciality());
        caterer2_price.setText(Integer.toString(c2.getCharges()));
        caterer2_days.setText(Integer.toString(c2.getDays()));

        // second caterer details
        caterer3_name.setText(c3.getCompany_name());
        caterer3_contact.setText(c3.getContact_info());
        caterer3_specialty.setText(c3.getSpeciality());
        caterer3_price.setText(Integer.toString(c3.getCharges()));
        caterer3_days.setText(Integer.toString(c3.getDays()));
    }

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        // null values
        if (caterer1_name == null || caterer1_contact == null || caterer1_specialty == null || caterer1_price == null || caterer1_days == null) {
            openPopup("Missing Input", "Please fill all the fields for 1st caterer.");
            return false;
        }

        if (caterer2_name == null || caterer2_contact == null || caterer2_specialty == null || caterer2_price == null || caterer2_days == null) {
            openPopup("Missing Input", "Please fill all the fields for 2nd caterer.");
            return false;
        }

        if (caterer3_name == null || caterer3_contact == null || caterer3_specialty == null || caterer3_price == null || caterer3_days == null) {
            openPopup("Missing Input", "Please fill all the fields for 2nd caterer.");
            return false;
        }

        // empty values
        if (caterer1_name.getText().isEmpty()|| caterer1_contact.getText().isEmpty() || caterer1_specialty.getText().isEmpty() || caterer1_price.getText().isEmpty() || caterer1_days.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 1st caterer.");
            return false;
        }

        if (caterer2_name.getText().isEmpty() || caterer2_contact.getText().isEmpty()|| caterer2_specialty.getText().isEmpty() || caterer2_price.getText().isEmpty() || caterer2_days.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 2nd caterer.");
            return false;
        }

        if (caterer3_name.getText().isEmpty() || caterer3_contact.getText().isEmpty() || caterer3_specialty.getText().isEmpty() || caterer3_price.getText().isEmpty() || caterer3_days.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 2nd caterer.");
            return false;
        }

        // letters in price
        if (caterer1_price.getText().matches(".*[a-zA-Z]+.*") || caterer2_price.getText().matches(".*[a-zA-Z]+.*") || caterer3_price.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Missing Input", "All prices must be numbers.");
            return false;
        }

        // letters in days
        if (caterer1_days.getText().matches(".*[a-zA-Z]+.*") || caterer2_days.getText().matches(".*[a-zA-Z]+.*") || caterer3_days.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Missing Input", "All days must be in numbers.");
            return false;
        }

        // negative prices
        int c1_price = Integer.parseInt(caterer1_price.getText());
        int c2_price = Integer.parseInt(caterer2_price.getText());
        int c3_price = Integer.parseInt(caterer3_price.getText());

        if ( c1_price < 0 || c2_price < 0 || c3_price < 0 ) {
            openPopup("Invalid Input", "Prices cannot be negative");
            return false;
        }

        return true;
    }

    ////////////////////////////////////////////////

    // exit this screen, go back to manager menu
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

        String name, contact, specialty, price, days;
        Catering_Service caterer = new Catering_Service();

        // getting values entered
        name = caterer1_name.getText();
        contact = caterer1_contact.getText();
        specialty = caterer1_specialty.getText();
        price = caterer1_price.getText();
        days = caterer1_days.getText();

        // updating records in database
        caterer.editCateringField(catererIDs.get(0),"name",name,false);
        caterer.editCateringField(catererIDs.get(0),"contact",contact,false);
        caterer.editCateringField(catererIDs.get(0),"specialty",specialty,false);
        caterer.editCateringField(catererIDs.get(0),"days", days, true);
        caterer.editCateringField(catererIDs.get(0),"charges",price,true);

        // getting values entered
        name = caterer2_name.getText();
        contact = caterer2_contact.getText();
        specialty = caterer2_specialty.getText();
        price = caterer2_price.getText();
        days = caterer2_days.getText();

        // updating records in database
        caterer.editCateringField(catererIDs.get(1),"name",name,false);
        caterer.editCateringField(catererIDs.get(1),"contact",contact,false);
        caterer.editCateringField(catererIDs.get(1),"specialty",specialty,false);
        caterer.editCateringField(catererIDs.get(1),"days", days, true);
        caterer.editCateringField(catererIDs.get(1),"charges",price,true);

        // getting values stored
        name = caterer3_name.getText();
        contact = caterer3_contact.getText();
        specialty = caterer3_specialty.getText();
        price = caterer3_price.getText();
        days = caterer3_days.getText();

        // getting values entered
        caterer.editCateringField(catererIDs.get(2),"name",name,false);
        caterer.editCateringField(catererIDs.get(2),"contact",contact,false);
        caterer.editCateringField(catererIDs.get(2),"specialty",specialty,false);
        caterer.editCateringField(catererIDs.get(2),"days", days, true);
        caterer.editCateringField(catererIDs.get(2),"charges",price,true);

        // refresh window
        goToCateringOptions();
    }

    ///////////////// SCENE SWITCHING //////////////////

    public void goToMgrMenu() throws IOException {
        System.out.println("Loading manager menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mgr_menu.fxml"));
        Parent root = loader.load();

        //Get controller of manager menu scene
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

    public void goToCateringOptions() throws IOException {
        System.out.println("Loading catering options window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("catering_edit.fxml"));
        Parent root = loader.load();

        //Get controller of catering scene
        catering_edit_Controller controller = loader.getController();
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

        window.setTitle("Edit Catering Services");
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
