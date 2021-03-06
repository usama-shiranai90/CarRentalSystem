package Controller;

import BackEndCode.Database;
import BackEndCode.DatabaseProxy;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private JFXButton registerbutton;


    @FXML
    private JFXTextField reg_username;

    @FXML
    private JFXTextField reg_email;

    @FXML
    private JFXPasswordField userpassword;

    @FXML
    private JFXPasswordField reg_conpass;

    @FXML
    void Signupaction(MouseEvent event) throws SQLException, ClassNotFoundException {

        Database connection = new DatabaseProxy();
        if (userpassword.getText().equalsIgnoreCase(reg_conpass.getText())){
            connection.signupuser(reg_username.getText() , reg_email.getText(),userpassword.getText());
        }
        else{
            JOptionPane.showMessageDialog(null, "please input correct password....");
        }

    }

    @FXML
    private ImageView back;

    @FXML
    void backtologin(MouseEvent event) throws IOException {
        back.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/LoginPage.fxml"));
        Stage login = new Stage();
        login.setTitle("Login");
        login.setScene(new Scene((Parent) loader.load()));
        login.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
