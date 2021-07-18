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

public class studio_edit_Controller {

    private ArrayList<String> studioIDs;

    ////////// STUDIO 1 VARS //////////

    @FXML private JFXTextField studio1_name;
    @FXML private JFXTextField studio1_contact;
    @FXML private JFXTextField studio1_cost;

    ////////// STUDIO 2 VARS //////////

    @FXML private JFXTextField studio2_name;
    @FXML private JFXTextField studio2_contact;
    @FXML private JFXTextField studio2_cost;

    ////////// STUDIO 3 VARS //////////

    @FXML private JFXTextField studio3_name;
    @FXML private JFXTextField studio3_contact;
    @FXML private JFXTextField studio3_cost;

    ///////////////// BUTTONS /////////////

    @FXML private JFXButton exit_btn;
    @FXML private JFXButton save_btn;

    ////////////////////////////////////////////////////////////

    public void init() {
        System.out.println("Initialising studio variables");

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
        studio1_cost.setText(Integer.toString(s1.getCost()));

        // second studio details
        studio2_name.setText(s2.getCompany_name());
        studio2_contact.setText(s2.getContact_info());
        studio2_cost.setText(Integer.toString(s2.getCost()));

        // third studio details
        studio3_name.setText(s3.getCompany_name());
        studio3_contact.setText(s3.getContact_info());
        studio3_cost.setText(Integer.toString(s3.getCost()));
    }

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (studio1_name == null || studio1_contact == null || studio1_cost == null) {
            openPopup("Missing Input", "Please fill all the fields for 1st studio.");
            return false;
        }

        if (studio2_name == null || studio2_contact == null || studio2_cost == null) {
            openPopup("Missing Input", "Please fill all the fields for 2nd studio.");
            return false;
        }

        if (studio3_name == null || studio3_contact == null || studio3_cost == null) {
            openPopup("Missing Input", "Please fill all the fields for 3rd studio.");
            return false;
        }

        if (studio1_name.getText().isEmpty() || studio1_contact.getText().isEmpty() || studio1_cost.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 1st studio.");
            return false;
        }

        if (studio2_name.getText().isEmpty() || studio2_contact.getText().isEmpty() || studio2_cost.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 2nd studio.");
            return false;
        }

        if (studio3_name.getText().isEmpty() || studio3_contact.getText().isEmpty() || studio3_cost.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields for 3rd studio.");
            return false;
        }

        if (studio1_cost.getText().matches(".*[a-zA-Z]+.*") || studio2_cost.getText().matches(".*[a-zA-Z]+.*") || studio3_cost.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Invalid Input", "All costs must be numeric only.");
            return false;
        }

        int s1_price = Integer.parseInt(studio1_cost.getText());
        int s2_price = Integer.parseInt(studio2_cost.getText());
        int s3_price = Integer.parseInt(studio3_cost.getText());

        if ( s1_price < 0 || s2_price < 0 || s3_price < 0 ) {
            openPopup("Invalid Input", "Costs cannot be negative");
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
            System.out.println("Input check failed.");
            return;
        }

        String name, contact, cost;
        Studio studio = new Studio();

        // get values
        name = studio1_name.getText();
        contact = studio1_contact.getText();
        cost = studio1_cost.getText();

        // update values
        studio.editStudioField(studioIDs.get(0),"name",name,false);
        studio.editStudioField(studioIDs.get(0),"contact_info",contact,false);
        studio.editStudioField(studioIDs.get(0),"cost",cost,true);

        // get values
        name = studio2_name.getText();
        contact = studio2_contact.getText();
        cost = studio2_cost.getText();

        // update values
        studio.editStudioField(studioIDs.get(1),"name",name,false);
        studio.editStudioField(studioIDs.get(1),"contact_info",contact,false);
        studio.editStudioField(studioIDs.get(1),"cost",cost,true);

        // get values
        name = studio3_name.getText();
        contact = studio3_contact.getText();
        cost = studio3_cost.getText();

        // update values
        studio.editStudioField(studioIDs.get(2),"name",name,false);
        studio.editStudioField(studioIDs.get(2),"contact_info",contact,false);
        studio.editStudioField(studioIDs.get(2),"cost",cost,true);

        // refresh window
        goToStudioOptions();
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

    public void goToStudioOptions() throws IOException {
        System.out.println("Loading studio options window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("studio_edit.fxml"));
        Parent root = loader.load();

        //Get controller of edit studios scene
        studio_edit_Controller controller = loader.getController();
        controller.init();

        // close current window
        Stage window = (Stage) save_btn.getScene().getWindow();
        window.close();

        // start new window for edit studios scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Edit Studios");
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
