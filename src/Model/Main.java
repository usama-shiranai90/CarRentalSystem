package Model;

import Controller.WelcomeLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {

    Stage primarystage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primarystage = primaryStage;
        runwelcome();
    }

    public void runwelcome() {

        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("../View/WelcomePage.fxml"));
            AnchorPane pane = root.load();
            Scene scene = new Scene(pane);

            WelcomeLogin welcomeLogin = root.getController();
            welcomeLogin.main(primarystage, this);

            primarystage.setTitle("Welcome");
            primarystage.initStyle(StageStyle.DECORATED);
            primarystage.setScene(scene);
            primarystage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginpage(Stage stage) throws IOException, InterruptedException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/LoginPage.fxml"));

        stage.setTitle("Login");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void close() {
        primarystage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
