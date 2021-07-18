package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
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

public class emp_signin_Controller {

    /////////// BUTTONS /////////////

    @FXML private JFXRadioButton mgr_btn;
    @FXML private JFXButton signin_btn;
    @FXML private JFXButton exit_btn;

    /////// VARIABLES ///////////

    @FXML private JFXTextField emp_id;
    @FXML private JFXTextField emp_pass;

    ////////////////////////////////////////////////////////////

    public void disableManagerButton() {
        mgr_btn.setSelected(false);
        mgr_btn.setDisable(true);
    }

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        // null/blank value
        if (emp_id == null || emp_id.getText().isEmpty()) {
            openPopup("Missing Input", "Please enter employee ID.");
            return false;
        }

        // null/blank value
        if (emp_pass == null || emp_pass.getText().isEmpty()) {
            openPopup("Missing Input", "Please enter password.");
            return false;
        }

        return true;
    }

    ///////////////////////////////////////////////////////////////

    public void handleSignInButton(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Sign in button pressed (Employee)");

        if (checkInputs() == false) {
            System.out.println("Input check failed");
            return;
        }

        // get values
        String id = emp_id.getText();
        String password = emp_pass.getText();

        // attempting login
        Employee emp = new Employee();
        boolean login = emp.employeeLogin(id, password);

        //close login window if login unsuccessful - to be changed
        if (!login) {
            openPopup("Login Failed", "Invalid email/ID and password combination.");
            System.out.println("Login unsuccessful");
        }

        // Login successful - go to welcome screen
        else {
            // store customer info
            System.out.println("Login successful");
            LoggedInUsers.initEmp(id);

            // send email
            String msg = "You have just signed in to our system. If this was not you, then please contact us at asheventshelp@gmail.com";
            emailClass.sendEmail("Successful Login", msg, LoggedInUsers.getEmp().getEmail());

            goToEmpEdit();
        }
    }

    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        goToMainMenu();
    }

    ///////////////////// SCENE SWITCHING //////////////////

    public void goToMainMenu() throws IOException {
        System.out.println("Loading main menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main_menu.fxml"));
        Parent root = loader.load();

        //Get controller of main menu scene
        Main_Menu_Controller controller = loader.getController();

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

        window.setTitle("Main Menu");
        window.show();
    }

    public void goToEmpEdit() throws IOException {
        System.out.println("Loading emp edit menu");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("emp_edit.fxml"));
        Parent root = loader.load();

        //Get controller of main menu scene
        emp_edit_Controller controller = loader.getController();
        controller.init();

        // close current window
        Stage window = (Stage) signin_btn.getScene().getWindow();
        window.close();

        // start new window for main scene
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
