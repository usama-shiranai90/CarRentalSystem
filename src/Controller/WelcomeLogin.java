package Controller;
import BackEndCode.Database;
import BackEndCode.DatabaseProxy;
import Model.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WelcomeLogin implements Initializable {

//    DatabaseConnection connectdb = new DatabaseConnection();
        Database connectedDB = new DatabaseProxy();

    @FXML
    private AnchorPane rootpane;

    @FXML
    private JFXTextField usertext;

    @FXML
    private JFXPasswordField userpassword;

    @FXML
    private JFXButton loginbutton;

    Main main;
    Stage stage;

    public WelcomeLogin() throws SQLException {
    }

    public void main(Stage s, Main m) {
        main = m;
        stage = s;
    }

    @FXML
    void cancel(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void login_to_homepage(MouseEvent event) throws Exception {

        loginbutton.getScene().getWindow().hide();


        connectedDB.authentication(usertext.getText(), userpassword.getText());

        String s1 = connectedDB.returnuser();
        String s2 = connectedDB.returnpass();

        if (usertext.getText().equals(s1) && userpassword.getText().equals(s2)){
            Parent root = FXMLLoader.load(getClass().getResource("../View/MainScreen.fxml"));
            Scene welcome_scene = new Scene(root);
            Stage weclomestage = new Stage();
            weclomestage.setScene(welcome_scene);
            weclomestage.setTitle("Welcome to Home-Screen Rent a Car");
            weclomestage.show();
        }
        else {
            JOptionPane.showMessageDialog(null, "wrong input..");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/LoginPage.fxml"));
            Stage login = new Stage();
            login.setTitle("Login");
            login.setScene(new Scene(loader.load()));
            login.show();
        }

    }
    @FXML
    private Hyperlink newaccount;

    @FXML
    void registration(MouseEvent event) throws IOException {
        newaccount.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/Registration.fxml"));
        Stage reg = new Stage();
        reg.setTitle("Register new User");
        reg.setScene(new Scene(fxmlLoader.load()));
        reg.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(4), rootpane);
        fadeTransition1.setFromValue(1);
        fadeTransition1.setToValue(0.8);
        fadeTransition1.play();

        fadeTransition1.setOnFinished(event5 -> {
            main.close();
//            System.out.println("------- splash screen is closed --------");
            try {
                main.loginpage(stage);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        //  Fill Animation gives error ...
       /* Color c= Color.web("#4CCADF");
        Color c1=Color.web("#E9FF55");
        JFXFillTransition transition = new JFXFillTransition();
        transition.setRegion(sastaa);
        transition.setDuration(Duration.millis(5000));
        transition.setFromValue(c);
        transition.setToValue(c1);
        transition.play();*/

    }


}
