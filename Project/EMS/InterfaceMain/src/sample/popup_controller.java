package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class popup_controller {

    @FXML private JFXTextField heading;
    @FXML private JFXTextArea text;

    @FXML private JFXButton exit_btn;
    @FXML private JFXButton accept_btn;

    ////////////////////////////////////

    public void setContent(String headText, String bodyText) {
        heading.setText(headText);
        text.setText(bodyText);

        heading.setEditable(false);
        text.setEditable(false);
    }

    //////////////////////////////////////

    public void closeWindow() {
        if (exit_btn != null) {
            Stage window = (Stage) exit_btn.getScene().getWindow();
            window.close();
        }

        else if (accept_btn != null) {
            Stage window = (Stage) accept_btn.getScene().getWindow();
            window.close();
        }
    }
}
