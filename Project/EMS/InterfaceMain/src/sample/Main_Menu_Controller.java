package sample;

import com.jfoenix.controls.JFXButton;
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

public class Main_Menu_Controller {

    @FXML private JFXButton cust_btn;
    @FXML private JFXButton emp_btn;
    @FXML private JFXButton mgr_btn;

    ///////////////////////////////////////

    public void handleEmployeeButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Employee button pressed");
        goToEmpSignIn();
    }

    public void handleManagerButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Manager button pressed");
        goToMgrSignIn();
    }

    public void handleCustomerButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Customer button pressed");
        goToCustSignIn();
    }

    /////////////////// SCENE SWITCHING /////////////////

    public void goToCustSignIn() throws IOException {
        System.out.println("Loading customer sign in window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_signin.fxml"));
        Parent root = loader.load();

        //Get controller of sign in scene
        cust_signin_Controller controller = loader.getController();

        // close current window
        Stage window = (Stage) cust_btn.getScene().getWindow();
        window.close();

        // start new window for sign in scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Sign In");
        window.show();
    }

    public void goToEmpSignIn() throws IOException {
        System.out.println("Loading employee sign in window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("emp_signin.fxml"));
        Parent root = loader.load();

        //Get controller of employee ign in scene
        emp_signin_Controller controller = loader.getController();
        controller.disableManagerButton();

        // close current window
        Stage window = (Stage) emp_btn.getScene().getWindow();
        window.close();

        // start new window for sign in scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Sign In");
        window.show();
    }

    public void goToMgrSignIn() throws IOException {
        System.out.println("Loading manager sign in window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mgr_signin.fxml"));
        Parent root = loader.load();

        //Get controller of employee ign in scene
        mgr_signin_Controller controller = loader.getController();
        controller.enableManagerButton();

        // close current window
        Stage window = (Stage) mgr_btn.getScene().getWindow();
        window.close();

        // start new window for sign in scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Sign In");
        window.show();
    }

    public void handleAboutButton(ActionEvent actionEvent) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        openPopup("About Us", "We are a team of highly qualified individuals who started this in the start of this year and thanks to Almighty Allah, we are here now. We deal in all kinds of events and try to provide the best services possible.\n" +
                "Currently we are providing 3 major services:\n" +
                "\t\t1: Media Services\n" +
                "\t\t2: Location Services\n" +
                "\t\t3: Catering Services\n" +
                "\n" +
                "We plan to expand our scope in the near future. For any further assistance, feel free to contact us");
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

    public void handlePrivacyButton(ActionEvent actionEvent) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        openPopup("Privacy Policy", "Privacy Policy\n" +
                "Last updated: December 31, 2020\n" +
                "\n" +
                "This Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your information when You use the Service and tells You about Your privacy rights and how the law protects You.\n" +
                "\n" +
                "We use Your Personal data to provide and improve the Service. By using the Service, You agree to the collection and use of information in accordance with this Privacy Policy. This Privacy Policy has been created with the help of the Privacy Policy Generator.\n" +
                "\n" +
                "Interpretation and Definitions\n" +
                "Interpretation\n" +
                "The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.\n" +
                "\n" +
                "Definitions\n" +
                "For the purposes of this Privacy Policy:\n" +
                "\n" +
                "Account means a unique account created for You to access our Service or parts of our Service.\n" +
                "\n" +
                "Company (referred to as either \"the Company\", \"We\", \"Us\" or \"Our\" in this Agreement) refers to ASH Event Planners, FAST-NUCES, A.K Brohi Road, H11/1, Islamabad.\n" +
                "\n" +
                "Cookies are small files that are placed on Your computer, mobile device or any other device by a website, containing the details of Your browsing history on that website among its many uses.\n" +
                "\n" +
                "Country refers to: Pakistan\n" +
                "\n" +
                "Device means any device that can access the Service such as a computer, a cellphone or a digital tablet.\n" +
                "\n" +
                "Personal Data is any information that relates to an identified or identifiable individual.\n" +
                "\n" +
                "Service refers to the Website.\n" +
                "\n" +
                "Service Provider means any natural or legal person who processes the data on behalf of the Company. It refers to third-party companies or individuals employed by the Company to facilitate the Service, to provide the Service on behalf of the Company, to perform services related to the Service or to assist the Company in analyzing how the Service is used.\n" +
                "\n" +
                "Third-party Social Media Service refers to any website or any social network website through which a User can log in or create an account to use the Service.\n" +
                "\n" +
                "Usage Data refers to data collected automatically, either generated by the use of the Service or from the Service infrastructure itself (for example, the duration of a page visit).\n" +
                "\n" +
                "Website refers to ASH Event Planners, accessible from www.ashevents.com\n" +
                "\n" +
                "You means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.\n" +
                "\n" +
                "Collecting and Using Your Personal Data\n" +
                "Types of Data Collected\n" +
                "Personal Data\n" +
                "While using Our Service, We may ask You to provide Us with certain personally identifiable information that can be used to contact or identify You. Personally identifiable information may include, but is not limited to:\n" +
                "\n" +
                "Email address\n" +
                "\n" +
                "First name and last name\n" +
                "\n" +
                "Phone number\n" +
                "\n" +
                "Usage Data\n" +
                "\n" +
                "Usage Data\n" +
                "Usage Data is collected automatically when using the Service.\n" +
                "\n" +
                "Usage Data may include information such as Your Device's Internet Protocol address (e.g. IP address), browser type, browser version, the pages of our Service that You visit, the time and date of Your visit, the time spent on those pages, unique device identifiers and other diagnostic data.\n" +
                "\n" +
                "When You access the Service by or through a mobile device, We may collect certain information automatically, including, but not limited to, the type of mobile device You use, Your mobile device unique ID, the IP address of Your mobile device, Your mobile operating system, the type of mobile Internet browser You use, unique device identifiers and other diagnostic data.\n" +
                "\n" +
                "We may also collect information that Your browser sends whenever You visit our Service or when You access the Service by or through a mobile device.\n" +
                "\n" +
                "Tracking Technologies and Cookies\n" +
                "We use Cookies and similar tracking technologies to track the activity on Our Service and store certain information. Tracking technologies used are beacons, tags, and scripts to collect and track information and to improve and analyze Our Service. The technologies We use may include:\n" +
                "\n" +
                "Cookies or Browser Cookies. A cookie is a small file placed on Your Device. You can instruct Your browser to refuse all Cookies or to indicate when a Cookie is being sent. However, if You do not accept Cookies, You may not be able to use some parts of our Service. Unless you have adjusted Your browser setting so that it will refuse Cookies, our Service may use Cookies.\n" +
                "Flash Cookies. Certain features of our Service may use local stored objects (or Flash Cookies) to collect and store information about Your preferences or Your activity on our Service. Flash Cookies are not managed by the same browser settings as those used for Browser Cookies. For more information on how You can delete Flash Cookies, please read \"Where can I change the settings for disabling, or deleting local shared objects?\" available at https://helpx.adobe.com/flash-player/kb/disable-local-shared-objects-flash.html#main_Where_can_I_change_the_settings_for_disabling__or_deleting_local_shared_objects_\n" +
                "Web Beacons. Certain sections of our Service and our emails may contain small electronic files known as web beacons (also referred to as clear gifs, pixel tags, and single-pixel gifs) that permit the Company, for example, to count users who have visited those pages or opened an email and for other related website statistics (for example, recording the popularity of a certain section and verifying system and server integrity).\n" +
                "Cookies can be \"Persistent\" or \"Session\" Cookies. Persistent Cookies remain on Your personal computer or mobile device when You go offline, while Session Cookies are deleted as soon as You close Your web browser. You can learn more about cookies here: All About Cookies by TermsFeed.\n" +
                "\n" +
                "We use both Session and Persistent Cookies for the purposes set out below:\n" +
                "\n" +
                "Necessary / Essential Cookies\n" +
                "\n" +
                "Type: Session Cookies\n" +
                "\n" +
                "Administered by: Us\n" +
                "\n" +
                "Purpose: These Cookies are essential to provide You with services available through the Website and to enable You to use some of its features. They help to authenticate users and prevent fraudulent use of user accounts. Without these Cookies, the services that You have asked for cannot be provided, and We only use these Cookies to provide You with those services.\n" +
                "\n" +
                "Cookies Policy / Notice Acceptance Cookies\n" +
                "\n" +
                "Type: Persistent Cookies\n" +
                "\n" +
                "Administered by: Us\n" +
                "\n" +
                "Purpose: These Cookies identify if users have accepted the use of cookies on the Website.\n" +
                "\n" +
                "Functionality Cookies\n" +
                "\n" +
                "Type: Persistent Cookies\n" +
                "\n" +
                "Administered by: Us\n" +
                "\n" +
                "Purpose: These Cookies allow us to remember choices You make when You use the Website, such as remembering your login details or language preference. The purpose of these Cookies is to provide You with a more personal experience and to avoid You having to re-enter your preferences every time You use the Website.\n" +
                "\n" +
                "For more information about the cookies we use and your choices regarding cookies, please visit our Cookies Policy or the Cookies section of our Privacy Policy.\n" +
                "\n" +
                "Use of Your Personal Data\n" +
                "The Company may use Personal Data for the following purposes:\n" +
                "\n" +
                "To provide and maintain our Service, including to monitor the usage of our Service.\n" +
                "\n" +
                "To manage Your Account: to manage Your registration as a user of the Service. The Personal Data You provide can give You access to different functionalities of the Service that are available to You as a registered user.\n" +
                "\n" +
                "For the performance of a contract: the development, compliance and undertaking of the purchase contract for the products, items or services You have purchased or of any other contract with Us through the Service.\n" +
                "\n" +
                "To contact You: To contact You by email, telephone calls, SMS, or other equivalent forms of electronic communication, such as a mobile application's push notifications regarding updates or informative communications related to the functionalities, products or contracted services, including the security updates, when necessary or reasonable for their implementation.\n" +
                "\n" +
                "To provide You with news, special offers and general information about other goods, services and events which we offer that are similar to those that you have already purchased or enquired about unless You have opted not to receive such information.\n" +
                "\n" +
                "To manage Your requests: To attend and manage Your requests to Us.\n" +
                "\n" +
                "For business transfers: We may use Your information to evaluate or conduct a merger, divestiture, restructuring, reorganization, dissolution, or other sale or transfer of some or all of Our assets, whether as a going concern or as part of bankruptcy, liquidation, or similar proceeding, in which Personal Data held by Us about our Service users is among the assets transferred.\n" +
                "\n" +
                "For other purposes: We may use Your information for other purposes, such as data analysis, identifying usage trends, determining the effectiveness of our promotional campaigns and to evaluate and improve our Service, products, services, marketing and your experience.\n" +
                "\n" +
                "We may share Your personal information in the following situations:\n" +
                "\n" +
                "With Service Providers: We may share Your personal information with Service Providers to monitor and analyze the use of our Service, to contact You.\n" +
                "For business transfers: We may share or transfer Your personal information in connection with, or during negotiations of, any merger, sale of Company assets, financing, or acquisition of all or a portion of Our business to another company.\n" +
                "With Affiliates: We may share Your information with Our affiliates, in which case we will require those affiliates to honor this Privacy Policy. Affiliates include Our parent company and any other subsidiaries, joint venture partners or other companies that We control or that are under common control with Us.\n" +
                "With business partners: We may share Your information with Our business partners to offer You certain products, services or promotions.\n" +
                "With other users: when You share personal information or otherwise interact in the public areas with other users, such information may be viewed by all users and may be publicly distributed outside. If You interact with other users or register through a Third-Party Social Media Service, Your contacts on the Third-Party Social Media Service may see Your name, profile, pictures and description of Your activity. Similarly, other users will be able to view descriptions of Your activity, communicate with You and view Your profile.\n" +
                "With Your consent: We may disclose Your personal information for any other purpose with Your consent.\n" +
                "Retention of Your Personal Data\n" +
                "The Company will retain Your Personal Data only for as long as is necessary for the purposes set out in this Privacy Policy. We will retain and use Your Personal Data to the extent necessary to comply with our legal obligations (for example, if we are required to retain your data to comply with applicable laws), resolve disputes, and enforce our legal agreements and policies.\n" +
                "\n" +
                "The Company will also retain Usage Data for internal analysis purposes. Usage Data is generally retained for a shorter period of time, except when this data is used to strengthen the security or to improve the functionality of Our Service, or We are legally obligated to retain this data for longer time periods.\n" +
                "\n" +
                "Transfer of Your Personal Data\n" +
                "Your information, including Personal Data, is processed at the Company's operating offices and in any other places where the parties involved in the processing are located. It means that this information may be transferred to — and maintained on — computers located outside of Your state, province, country or other governmental jurisdiction where the data protection laws may differ than those from Your jurisdiction.\n" +
                "\n" +
                "Your consent to this Privacy Policy followed by Your submission of such information represents Your agreement to that transfer.\n" +
                "\n" +
                "The Company will take all steps reasonably necessary to ensure that Your data is treated securely and in accordance with this Privacy Policy and no transfer of Your Personal Data will take place to an organization or a country unless there are adequate controls in place including the security of Your data and other personal information.\n" +
                "\n" +
                "Disclosure of Your Personal Data\n" +
                "Business Transactions\n" +
                "If the Company is involved in a merger, acquisition or asset sale, Your Personal Data may be transferred. We will provide notice before Your Personal Data is transferred and becomes subject to a different Privacy Policy.\n" +
                "\n" +
                "Law enforcement\n" +
                "Under certain circumstances, the Company may be required to disclose Your Personal Data if required to do so by law or in response to valid requests by public authorities (e.g. a court or a government agency).\n" +
                "\n" +
                "Other legal requirements\n" +
                "The Company may disclose Your Personal Data in the good faith belief that such action is necessary to:\n" +
                "\n" +
                "Comply with a legal obligation\n" +
                "Protect and defend the rights or property of the Company\n" +
                "Prevent or investigate possible wrongdoing in connection with the Service\n" +
                "Protect the personal safety of Users of the Service or the public\n" +
                "Protect against legal liability\n" +
                "Security of Your Personal Data\n" +
                "The security of Your Personal Data is important to Us, but remember that no method of transmission over the Internet, or method of electronic storage is 100% secure. While We strive to use commercially acceptable means to protect Your Personal Data, We cannot guarantee its absolute security.\n" +
                "\n" +
                "Links to Other Websites\n" +
                "Our Service may contain links to other websites that are not operated by Us. If You click on a third party link, You will be directed to that third party's site. We strongly advise You to review the Privacy Policy of every site You visit.\n" +
                "\n" +
                "We have no control over and assume no responsibility for the content, privacy policies or practices of any third party sites or services.\n" +
                "\n" +
                "Changes to this Privacy Policy\n" +
                "We may update Our Privacy Policy from time to time. We will notify You of any changes by posting the new Privacy Policy on this page.\n" +
                "\n" +
                "We will let You know via email and/or a prominent notice on Our Service, prior to the change becoming effective and update the \"Last updated\" date at the top of this Privacy Policy.\n" +
                "\n" +
                "You are advised to review this Privacy Policy periodically for any changes. Changes to this Privacy Policy are effective when they are posted on this page.\n" +
                "\n" +
                "Contact Us\n" +
                "If you have any questions about this Privacy Policy, You can contact us:\n" +
                "\n" +
                "By email: asheventshelp@gmail.com");
    }
}
