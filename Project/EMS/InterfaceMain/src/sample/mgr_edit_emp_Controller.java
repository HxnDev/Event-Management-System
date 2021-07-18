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

public class mgr_edit_emp_Controller {

    String emp_id;

    ////////////////////////////////

    @FXML private JFXTextField points;
    @FXML private JFXTextField fname;
    @FXML private JFXTextField lname;
    @FXML private JFXTextField cnic;
    @FXML private JFXTextField dob;
    @FXML private JFXTextField accountno;
    @FXML private JFXTextField email;

    /////////// BUTTONS ///////////

    @FXML private JFXButton exit_btn;
    @FXML private JFXButton save_btn;

    //////////////////////////////////////////////////

    public void init(String emp_id) {
        System.out.println("Initialising employee info");

        this.emp_id  = emp_id;

        Employee emp = new Employee();
        emp.setEmployee_id(emp_id);
        emp = emp.getEmployee(emp_id);

        // set values
        points.setText(Integer.toString(emp.getPointsFromDB()));
        cnic.setText(emp.getCnic());
        dob.setText(emp.getDob());

        String firstName, lastName;
        String fullName = emp.getName();
        String[] tokens = fullName.split(" ", 2);
        firstName = tokens[0];
        lastName = tokens[1];

        fname.setText(firstName);
        lname.setText(lastName);

        accountno.setText(emp.getAccount_number());
        email.setText(emp.getEmail());

        fname.setEditable(false);
        lname.setEditable(false);
        cnic.setEditable(false);
        dob.setEditable(false);
    }

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        // check for null values
        if (email == null || accountno == null || points == null) {
            openPopup("Missing Input", "Please fill all the fields.");
            return false;
        }

        if (email.getText().isEmpty() || accountno.getText().isEmpty() || points.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields.");
            return false;
        }

        if (email.getText().indexOf('@') == -1) {
            openPopup("Invalid Input", "Please enter a valid email address.");
            return false;
        }

        if (accountno.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Invalid Input", "Account number should only contain numbers.");
            return false;
        }

        if (Integer.parseInt(accountno.getText()) < 0) {
            openPopup("Invalid Input", "Account number cannot be negative.");
            return false;
        }

        if (Integer.parseInt(points.getText()) < 0) {
            openPopup("Invalid Input", "Number of points cannot be negative.");
            return false;
        }

        return true;
    }

    //////////////////////////////////////////////////

    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        exitScreen();
    }

    public void handleSaveButton(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Save button pressed");

        if (checkInputs() == false) {
            System.out.println("Input check failed");
            return;
        }

        // getting values
        String emp_email = email.getText();
        String emp_account = accountno.getText();
        String emp_fname = fname.getText();
        String emp_lname = lname.getText();
        String emp_cnic = cnic.getText();
        String emp_dob = dob.getText();
        String emp_points = points.getText();

        // setting values
        Employee emp = new Employee();
        emp.setEmployee_id(emp_id);
        emp = emp.getEmployee(emp_id);

        emp.setEmail(emp_email);
        emp.setAccount_number(emp_account);
        emp.setCnic(emp_cnic);
        emp.setDob(emp_dob);
        emp.setName(emp_fname + " " + emp_lname);

        // updating record in database
        emp.editEmployeeAccountField(emp.getEmployee_id(),"email",emp.getEmail(), false);
        emp.editEmployeeAccountField(emp.getAccount_number(),"account_number",emp.getAccount_number(), false);
        emp.editEmployeeAccountField(emp.getEmployee_id(), "cnic", emp.getCnic(), false);
        emp.editEmployeeAccountField(emp.getEmployee_id(), "name", emp.getName(), false);
        emp.editEmployeeAccountField(emp.getEmployee_id(),"points", emp_points,true);

        // refresh screen
        goToEmpEdit();
    }

    /////////////////// SCENE SWITCHING ///////////////

    public void exitScreen() throws IOException {
        System.out.println("Closing edit window");
        Stage window = (Stage) exit_btn.getScene().getWindow();
        window.close();
    }

    public void goToEmpEdit() throws IOException {
        System.out.println("Loading employee edit window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mgr_edit_emp.fxml"));
        Parent root = loader.load();

        //Get controller of main menu scene
        mgr_edit_emp_Controller controller = loader.getController();
        controller.init(emp_id);

        // close current window
        Stage window = (Stage) save_btn.getScene().getWindow();
        window.close();

        // start new window for main scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Edit Employee");
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
