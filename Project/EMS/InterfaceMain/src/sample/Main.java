package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Loading main menu window");

        window = primaryStage;

        // start off with main menu
        Parent root = FXMLLoader.load(getClass().getResource("main_menu.fxml"));
        window.setTitle("Event Management System");
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.show();
    }

    public void setScene(Scene scene) {
        window.setScene(scene);
    }

    // configuring database details
    public static void setMySQL() {
        Globals.setDb_name("ems");
        Globals.setDb_username("root");
        Globals.setDb_pass("1234");
    }

    // configuring email details
    public static void setEmailDetails() {
        emailClass.init(System.getProperties(), "asheventshelp@gmail.com", "securepassword");
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        setMySQL();
        setEmailDetails();
        launch(args);
    }
}
