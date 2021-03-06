package Controller;

import BackEndCode.Database;
import BackEndCode.DatabaseProxy;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {


    @FXML
    private AnchorPane root;

    @FXML
    private Pane panewallpaper;

    @FXML
    private Pane panewallpaper2;
    @FXML
    private Pane panewallpaper3;
    @FXML
    private Pane panewallpaper4;
    @FXML
    private Pane panewallpaper5;


    @FXML
    void Exit(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        animation();
    }


    public void animation() {
        FadeTransition transition = new FadeTransition(Duration.seconds(4), panewallpaper);
        transition.setFromValue(1);
        transition.setToValue(0.1);
        transition.play();

        transition.setOnFinished(e -> {
            FadeTransition transition1 = new FadeTransition(Duration.seconds(3), panewallpaper2);
            transition1.setFromValue(1);
            transition1.setToValue(0);
            transition1.play();

            transition1.setOnFinished(e2 -> {
                FadeTransition transition2 = new FadeTransition(Duration.seconds(3), panewallpaper3);
                transition2.setFromValue(1);
                transition2.setToValue(0);
                transition2.play();

                transition2.setOnFinished(e3 -> {
                    FadeTransition transition3 = new FadeTransition(Duration.seconds(3), panewallpaper4);
                    transition3.setFromValue(1);
                    transition3.setToValue(0);
                    transition3.play();

                    transition3.setOnFinished(e4 -> {
                        FadeTransition transition4 = new FadeTransition(Duration.seconds(3), panewallpaper5);
                        transition4.setFromValue(1);
                        transition4.setToValue(0);
                        transition4.play();

                        transition4.setOnFinished(e5 -> {
                            animation();
                        });
                    });

                });


            });
        });

    }


    @FXML
    private JFXButton rentbutton;
    @FXML
    void rentaction(MouseEvent event) throws IOException {
            rentbutton.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("../View/RentCar.fxml"));
        Scene welcome_scene = new Scene(root);
        Stage weclomestage = new Stage();
        weclomestage.setScene(welcome_scene);
        weclomestage.setTitle("Rental Car");
        weclomestage.show();
    }


    @FXML
    void Myprofile(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../View/ProfileDetail.fxml"));
        Scene welcome_scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(welcome_scene);
        stage.setTitle("My Profile Setting");
        stage.show();

    }

    @FXML
    private JFXTextField firstname;

    @FXML
    private JFXTextField phonenumber;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField Cnic;

    @FXML
    private JFXTextField lastname;

    @FXML
    private JFXButton savebutton;

    @FXML
    private AnchorPane rootpanep;

    @FXML
    void saveprofile(MouseEvent event) {

        Database database = new DatabaseProxy();
        database.registeruserdetail(firstname.getText(), lastname.getText(),phonenumber.getText(),email.getText(),Cnic.getText());
        savebutton.setOnAction(e ->{
        showbar("Successfully saved...");
        });

}
    @FXML
    private Label successfulnoti;

    public void showbar(String s){
        successfulnoti.setStyle("-fx-background-color:#84DB6B");
        successfulnoti.setText(s);
        successfulnoti.setAlignment(Pos.BOTTOM_CENTER);
    }


    @FXML
    private ImageView back;
    @FXML
    void backtologin(MouseEvent event) throws IOException {
        back.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/LoginPage.fxml"));
        Stage login = new Stage();
        login.setTitle("Login");
        login.setScene(new Scene(loader.load()));
        login.show();
    }
}
