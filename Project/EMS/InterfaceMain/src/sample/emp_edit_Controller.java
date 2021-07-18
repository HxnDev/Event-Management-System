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

public class emp_edit_Controller {

    @FXML private JFXTextField points;
    @FXML private JFXTextField fname;
    @FXML private JFXTextField lname;
    @FXML private JFXTextField cnic;
    @FXML private JFXTextField dob;
    @FXML private JFXTextField accountno;
    @FXML private JFXTextField newpass;
    @FXML private JFXTextField curpass;
    @FXML private JFXTextField email;
    @FXML private JFXTextField wagetype;
    @FXML private JFXTextField wagerate;
    @FXML private JFXTextField mgrid;
    @FXML private JFXTextField contact;

    //////////// BUTTONS //////

    @FXML private JFXButton signout_btn;
    @FXML private JFXButton save_btn;

    //////////////////////////////////////////////////

    public void init() {
        System.out.println("Initialising employee information");

        Employee emp = LoggedInUsers.getEmp();

        // set values
        points.setText(Integer.toString(emp.getPointsFromDB()));
        cnic.setText(emp.getCnic());
        dob.setText(emp.getDob());
        wagetype.setText(emp.getWage_type());
        wagerate.setText(Integer.toString(emp.getWage_rate()));
        mgrid.setText(emp.getMgr_id());
        contact.setText(emp.getPhone_no());

        String firstName, lastName;
        String fullName = emp.getName();
        String[] tokens = fullName.split(" ", 2);
        firstName = tokens[0];
        lastName = tokens[1];

        fname.setText(firstName);
        lname.setText(lastName);

        accountno.setText(emp.getAccount_number());
        email.setText(emp.getEmail());

        // disable editing
        fname.setEditable(false);
        lname.setEditable(false);
        cnic.setEditable(false);
        dob.setEditable(false);
        points.setEditable(false);
        mgrid.setEditable(false);
        wagerate.setEditable(false);
        wagetype.setEditable(false);
    }

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        // null values or blank values
        if (accountno == null || accountno.getText().isEmpty()) {
            openPopup("Missing Input", "Account number should not be blank.");
            return false;
        }

        // null values or blank values
        if (contact == null || contact.getText().isEmpty()) {
            openPopup("Missing Input", "Contact number should not be blank.");
            return false;
        }

        // null values or blank values
        if (email == null || email.getText().isEmpty()) {
            openPopup("Missing Input", "Email should not be blank.");
            return false;
        }

        // improper email address
        if (email.getText().indexOf('@') == -1) {
            openPopup("Invalid Input", "Please enter a valid email address.");
            return false;
        }

        // account no has letters
        if (accountno.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Invalid Input", "Account number should only contain numbers.");
            return false;
        }

        // account no is negative
        if (Integer.parseInt(accountno.getText()) < 0) {
            openPopup("Invalid Input", "Account number cannot be negative.");
            return false;
        }

        return true;
    }

    //////////////////////////////////////////////////

    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        LoggedInUsers.clearEmp();
        goToEmpSignIn();
    }

    public void handleSaveButton(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Save button pressed");

        if (checkInputs() == false) {
            System.out.println("Input check failed");
            return;
        }

        // get values
        String emp_email = email.getText();
        String emp_account = accountno.getText();
        String emp_contact = contact.getText();

        // set values
        Employee emp = new Employee(LoggedInUsers.getEmp());
        emp.setEmail(emp_email);
        emp.setAccount_number(emp_account);
        emp.setPhone_no(emp_contact);

        // update database
        emp.editEmployeeAccountField(emp.getEmployee_id(),"email",emp_email, false);
        emp.editEmployeeAccountField(emp.getEmployee_id(),"account_number",emp_account, false);
        emp.editEmployeeAccountField(emp.getEmployee_id(), "phone_no", emp_contact, false);

        // changing password if required
        if (curpass != null && newpass != null) {
            String currPass = curpass.getText();
            String newPass = newpass.getText();

            if (!currPass.isEmpty() && !newPass.isEmpty()) {
                // password changed successfully
                if (emp.changePassword(currPass, newPass)) {
                    System.out.println("Password changed");
                }

                // password not changed
                else {
                    openPopup("Error", "Your password was not changed successfully, please try again.");
                }
            }
        }

        // refresh data
        LoggedInUsers.setEmp(emp);

        // send email to emplyoee
        String msg = "Your account details have been changed successfully. If this was not done by you, then please contact us at asheventshelp@gmail.com";
        emailClass.sendEmail("Account Info Updated", msg, emp.getEmail());

        // refresh screen
        goToEmpEdit();
    }

    /////////////////// SCENE SWITCHING ///////////////

    public void goToEmpSignIn() throws IOException {
        System.out.println("Loading employee sign in window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("emp_signin.fxml"));
        Parent root = loader.load();

        //Get controller of sign in scene
        emp_signin_Controller controller = loader.getController();
        controller.disableManagerButton();

        // close current window
        Stage window = (Stage) signout_btn.getScene().getWindow();
        window.close();

        // start new window for next scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Sign In");
        window.show();
    }

    public void goToEmpEdit() throws IOException {
        System.out.println("Loading employee edit window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("emp_edit.fxml"));
        Parent root = loader.load();

        //Get controller of edit scene
        emp_edit_Controller controller = loader.getController();
        controller.init();

        // close current window
        Stage window = (Stage) save_btn.getScene().getWindow();
        window.close();

        // start new window for edit scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Welcome Employee");
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
