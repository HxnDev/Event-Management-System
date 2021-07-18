package sample;

import com.jfoenix.controls.JFXButton;
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

public class payment_Controller {

    @FXML private JFXTextField netTotal;

    @FXML private JFXRadioButton card;
    @FXML private JFXRadioButton easypaisa;
    @FXML private JFXRadioButton jazzcash;

    @FXML private JFXTextField cardNo;
    @FXML private JFXTextField cardPin;
    @FXML private JFXTextField mobile;

    @FXML private JFXButton exit_btn;
    @FXML private JFXButton save_btn;

    ///////////////////////////////

    public void setNetTotal(String total) {
        netTotal.setText(total);
    }

    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        goToCustMenu();
    }

    public void handleSaveButton(ActionEvent actionEvent) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (checkInputs() == false) {
            return;
        }

        openPopup("Payment Validation", "Your payment details have been verified.");
        goToCustMenu();
    }

    ///////////////////////////////

    public boolean checkInputs() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (!card.isSelected() && !easypaisa.isSelected() && !jazzcash.isSelected()) {
            openPopup("Missing Input", "Please select a payment method.");
            return false;
        }

        return true;
    }

    ////////////////////////////////

    public void goToCustMenu() throws IOException {
        System.out.println("Loading customer menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_menu.fxml"));
        Parent root = loader.load();

        //Get controller of menu scene
        cust_menu_Controller controller = loader.getController();

        //setting information
        controller.setWelcome(LoggedInUsers.getCust().getName());
        controller.setEventBookedStatus(LoggedInUsers.getCust_id());

        // close current window
        Stage window = (Stage) exit_btn.getScene().getWindow();
        window.close();

        // start new window for menu scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Welcome");
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
