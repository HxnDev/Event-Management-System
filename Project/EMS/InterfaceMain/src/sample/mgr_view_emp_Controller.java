package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class mgr_view_emp_Controller implements Initializable {

    //////////// TABLE VARIABLES ///////////////////

    @FXML private TableView MainTable;
    @FXML private TableColumn<Employee, String> C_ID;
    @FXML private TableColumn<Employee, String> C_FN;
    @FXML private TableColumn<Employee, String> C_LN;
    @FXML private TableColumn<Employee, String> C_CNIC;
    @FXML private TableColumn<Employee, String> C_DOB;
    @FXML private TableColumn<Employee, String> C_Email;
    @FXML private TableColumn<Employee, String> C_Contact;
    @FXML private TableColumn<Employee, String> C_Acc;
    @FXML private TableColumn<Employee, String> C_MgrID;
    @FXML private TableColumn<Employee, String> C_WageT;
    @FXML private TableColumn<Employee, String> C_WageR;
    @FXML private TableColumn<Employee, String> C_Points;

    //////////// TEXT VARIABLES ///////////////////

    @FXML private JFXTextField Text_Fname;
    @FXML private JFXTextField Text_LName;
    @FXML private JFXTextField Text_DOB;
    @FXML private JFXTextField Text_Email;
    @FXML private JFXTextField Text_Contact;
    @FXML private JFXTextField Text_WageRate;
    @FXML private JFXTextField Text_WageType;
    @FXML private JFXTextField Text_Account;
    @FXML private JFXTextField Text_MID;
    @FXML private JFXTextField Text_Searchbar;
    @FXML private JFXTextField Text_CNIC;
    @FXML private JFXTextField selectedEmpID;

    /////////////// BUTTONS ////////////////////////

    @FXML private JFXButton Button_AddEmployee;
    @FXML private JFXButton Button_DelEmployee;
    @FXML private JFXButton Button_Refresh;
    @FXML private JFXButton Button_EditEmployee;
    @FXML private JFXButton exit_btn;

    // list to store data from DB
    private final ObservableList<Employee> dataList = FXCollections.observableArrayList();

    /////////////////////////////////////////////////////////

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        C_ID.setCellValueFactory(new PropertyValueFactory<Employee, String>("employee_id"));
        C_FN.setCellValueFactory(new PropertyValueFactory<Employee, String>("fname"));
        C_LN.setCellValueFactory(new PropertyValueFactory<Employee, String>("lname"));
        C_CNIC.setCellValueFactory(new PropertyValueFactory<Employee, String>("cnic"));
        C_DOB.setCellValueFactory(new PropertyValueFactory<Employee, String>("dob"));
        C_Email.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        C_Contact.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone_no"));
        C_Acc.setCellValueFactory(new PropertyValueFactory<Employee, String>("account_number"));
        C_MgrID.setCellValueFactory(new PropertyValueFactory<Employee, String>("mgr_id"));
        C_WageT.setCellValueFactory(new PropertyValueFactory<Employee, String>("wage_type"));
        C_WageR.setCellValueFactory(new PropertyValueFactory<Employee, String>("wage_rate"));
        C_Points.setCellValueFactory(new PropertyValueFactory<Employee, String>("points"));

        Employee emp = new Employee();
        ArrayList<Employee> EmpList = emp.getListOfEmployees();

        // loading all employees
        for (int i = 0; i < EmpList.size(); i++)
            dataList.add(EmpList.get(i));

        loadTable();
    }

    // for searching through table
    public void setFilter(FilteredList<Employee> filteredData) {
        Text_Searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (employee.getFname().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (employee.getEmployee_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (employee.getLname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(employee.getWage_rate()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false; // Does not match.
            });
        });
    }

    public void loadTable() {
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Employee> filteredData = new FilteredList<>(dataList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        setFilter(filteredData);

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Employee> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(MainTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        MainTable.setItems(sortedData);
    }

    public void clearTextFields() {
        Text_Fname.clear();
        Text_LName.clear();
        Text_DOB.clear();
        Text_Email.clear();
        Text_Contact.clear();
        Text_WageRate.clear();
        Text_WageType.clear();
        Text_Account.clear();
        Text_MID.clear();
        Text_CNIC.clear();
    }

    public boolean checkAddInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {

        // check for null values
        if (Text_Fname == null || Text_LName == null || Text_DOB == null || Text_Email == null || Text_Contact == null
                || Text_WageRate == null || Text_WageType == null || Text_Account == null || Text_MID == null || Text_CNIC == null) {
            openPopup("Missing Input", "Please fill all the fields.");
            return false;
        }

        // check for blank values
        if (Text_Fname.getText().isEmpty() || Text_LName.getText().isEmpty() || Text_DOB.getText().isEmpty() || Text_Email.getText().isEmpty()
                || Text_Contact.getText().isEmpty() || Text_WageRate.getText().isEmpty() || Text_WageType.getText().isEmpty()
                || Text_Account.getText().isEmpty() || Text_MID.getText().isEmpty()|| Text_CNIC.getText().isEmpty()) {
            openPopup("Missing Input", "Please fill all the fields.");
            return false;
        }

        // check that email is valid
        if (Text_Email.getText().indexOf('@') == -1) {
            openPopup("Invalid Input", "Please enter a valid email address.");
            return false;
        }

        // check that account is numeric
        if (Text_Account.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Invalid Input", "Account number should only contain numbers.");
            return false;
        }

        // account no is not negative
        if (Integer.parseInt(Text_Account.getText()) < 0) {
            openPopup("Invalid Input", "Account number cannot be negative.");
            return false;
        }

        // check if cnic has any letters
        if (Text_CNIC.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Invalid Input", "CNIC should contain only numbers and dashes.");
            return false;
        }

        // check if wage rate has any letters
        if (Text_WageRate.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Invalid Input", "Wage rate should only contain numbers.");
            return false;
        }

        // check if given email is already in use by employee
        if (Employee.checkIfEmailRegistered(Text_Email.getText())) { // email is already registered
            openPopup("Error", "An employee account has already been registered against that email.");
            return false;
        }

        return true;
    }

    public boolean checkID() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (selectedEmpID == null || selectedEmpID.getText().isEmpty()) {
            openPopup("Missing Input", "Please enter an employee ID.");
            return false;
        }

        return true;
    }

    ///////////////////////////////////////////////////////

    // called when exit X button pressed
    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        goToMgrMenu();
    }

    public void handleDeleteButton(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Delete button pressed");

        if (checkID() == false) {
            System.out.println("Input check failed");
            return;
        }

        String empID = selectedEmpID.getText();
        Employee emp = new Employee();
        emp.setEmployee_id(empID);

        int index = -1;

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getEmployee_id().equals(empID)) {
                index = i;
                break;
            }
        }

        // invalid emp ID
        if (index == -1) {
            openPopup("Invalid Input", "Entered Employee ID does not exist.");
            return;
        }

        else {
            dataList.remove(index);
            emp.deleteEmployee();
        }

        // refresh table
        loadTable();
    }

    public void handleRefreshButton(ActionEvent actionEvent) {
        System.out.println("Refresh button pressed");

        Employee emp = new Employee();
        ArrayList<Employee> EmpList = emp.getListOfEmployees();

        dataList.clear();

        for (int i = 0; i < EmpList.size(); i++)
            dataList.add(EmpList.get(i));

        loadTable();
    }

    public void handleEditButton(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Edit button pressed");

        if (checkID() == false) {
            System.out.println("Input check failed");
            return;
        }

        String empID = selectedEmpID.getText();

        int index = -1;

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getEmployee_id().equals(empID)) {
                index = i;
                break;
            }
        }

        // invalid emp ID
        if (index == -1) {
            openPopup("Invalid Input", "Entered Employee ID does not exist.");
            return;
        }

        else {
            // open screen to edit employee
            goToEmpEdit(empID);
        }
    }

    // called when add Add Employee button pressed
    public void handleAddButtonAction(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Add button pressed");

        if (checkAddInputs() == false) {
            System.out.println("Input check failed");
            return;
        }

        // get non-empty values
        String f_name = "";
        String l_name = "";
        String dob = "";
        String contact = "";
        String email = "";
        String c_cnic = "";
        String w_t = "";
        String w_r = "";
        String acc = "";
        String mid = "";

        if (Text_LName != null) {
            l_name = Text_LName.getText();
        }
        if (Text_Fname != null) {
            f_name = Text_Fname.getText();
        }
        if (Text_DOB != null) {
            dob = Text_DOB.getText();
        }
        if (Text_Email != null) {
            email = Text_Email.getText();
        }
        if (Text_Contact != null) {
            contact = Text_Contact.getText();
        }
        if (Text_WageRate != null) {
            w_r= Text_WageRate.getText();
        }
        if (Text_WageType != null) {
            w_t = Text_WageType.getText();
        }
        if (Text_Account != null) {
            acc = Text_Account.getText();
        }
        if (Text_MID != null) {
            mid = Text_MID.getText();
        }
        if (Text_CNIC != null) {
            c_cnic = Text_CNIC.getText();
        }

        Employee emp = new Employee(f_name + " " + l_name, dob, contact, email, c_cnic, acc, w_t, Integer.parseInt(w_r), 0, mid);
        emp.addEmployee();
        dataList.addAll(emp);

        // clear the values
        clearTextFields();

        // refresh table
        loadTable();

        // send email to new employee
        String msg = "Your account has been successfully registered. " + "You can login anytime to access different features. " +
                "Your Employee ID is " + emp.getEmployee_id() + " and password is " + emp.getEmployee_id() + ". Change it as quickly as possible for security reasons." +
                " We look forward to working with you!";

        emailClass.sendEmail("Account Registered",msg, emp.getEmail());
    }

    ////////////////// SCENE SWITCHING //////////////////

    public void goToMgrMenu() throws IOException {
        System.out.println("Loadingg manager menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mgr_menu.fxml"));
        Parent root = loader.load();

        //Get controller of menu scene
        mgr_menu_Controller controller = loader.getController();
        controller.setName(LoggedInUsers.getEmp().getName());

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

        window.setTitle("Manager Menu");
        window.show();
    }

    public void goToEmpEdit(String empID) throws IOException {
        System.out.println("Loading edit window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mgr_edit_emp.fxml"));
        Parent root = loader.load();

        //Get controller of edit scene
        mgr_edit_emp_Controller controller = loader.getController();
        controller.init(empID);

        // start new window for editing
        Stage window = new Stage();
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