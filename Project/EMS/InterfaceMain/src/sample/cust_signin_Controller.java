package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class cust_signin_Controller {

    //////////////////// CUSTOMER LOGIN //////////////////

    @FXML private JFXTextField pass;
    @FXML private JFXTextField id;

    @FXML private JFXButton sign_btn;
    @FXML private JFXButton exit_btn;
    @FXML private JFXButton reg_btn;

    ////////////////////////////////////////////////////////

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        // null values
        if (id == null || pass == null) {
            openPopup("Invalid Input", "Please fill all the fields.");
            return false;
        }

        // empty values
        if (id.getText().isEmpty() || pass.getText().isEmpty()) {
            openPopup("Invalid Input", "Please fill all the fields.");
            return false;
        }

        return true;
    }

    // this executes when "sign in" button is pressed
    public void handleSignInButtonAction(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Sign in button pressed");

        if (checkInputs() == false) {
            System.out.println("Input check failed");
            return;
        }

        String c_pass = pass.getText();
        String c_idOrEmail = id.getText();

        System.out.println("ID/Email = " + c_idOrEmail);
        System.out.println("Password = " + c_pass);

        Customer obj = new Customer();
        boolean login = obj.customerLogin(c_idOrEmail, c_pass);

        // give error if incorrect login
        if (!login) {
            openPopup("Login Failed", "Invalid email/ID and password combination.");
        }

        // Login successful - go to welcome screen
        else {
            // store customer info
            LoggedInUsers.initCust(c_idOrEmail);

            String msg = "You have just signed in to our system. If this was not you, then please contact us at asheventshelp@gmail.com";
            emailClass.sendEmail("Successful Login", msg, LoggedInUsers.getCust().getEmail_address());

            goToCustMenu();
        }
    }

    // go to registration screen
    public void handleRegisterButtonAction(ActionEvent actionEvent) throws IOException {
        System.out.println("Register button pressed");
        goToRegister();
    }

    //Goes back to main menu from sign in screen
    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        goToMainMenu();
    }

    public void handleForgotPassword(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (id == null || id.getText().isEmpty()) {
            openPopup("Missing Input", "Enter employee ID first before selecting 'Forgot Password'");
            return;
        }

        // generate random password
        String randomPass = Integer.toString(ThreadLocalRandom.current().nextInt());
        randomPass = randomPass.substring(0,5);

        // change password
        Customer cust = new Customer();
        cust.changePassword(id.getText(), randomPass);

        // email customer their new password
        String email = cust.getCustomerEmailByID(id.getText());
        System.out.println("email = " + email);
        String msg = "Your password has been resetted. New password is: " + randomPass + ". Change it as soon as possible for security reasons.";
        emailClass.sendEmail("Password Changed", msg, email);

        openPopup("Successful", "A new password has been generated for you and sent to your email.");
    }

    /////////////// SCENE SWITCHING ///////////////////////

    // go back to main menu
    public void goToMainMenu() throws IOException {
        System.out.println("Loading menu window");

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

    // go to customer background
    public void goToCustMenu() throws IOException {
        System.out.println("Loading customer menu");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_menu.fxml"));
        Parent root = loader.load();

        //Get controller of cust menu scene
        cust_menu_Controller controller = loader.getController();

        //setting information
        controller.setWelcome(LoggedInUsers.getCust().getName());
        controller.setEventBookedStatus(LoggedInUsers.getCust_id());

        // close current window
        Stage stage = (Stage) sign_btn.getScene().getWindow();
        stage.close();

        // start new window for next scene
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Welcome");
        stage.show();
    }

    // go to register screen
    public void goToRegister() throws IOException {
        System.out.println("Loading register window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_register.fxml"));
        Parent root = loader.load();

        //Get controller of register scene
        cust_register_Controller controller = loader.getController();

        // close current window
        Stage window = (Stage) reg_btn.getScene().getWindow();
        window.close();

        // start new window for main scene
        window = new Stage();
        window.setScene(new Scene(root, 400, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Register Your Account");
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
