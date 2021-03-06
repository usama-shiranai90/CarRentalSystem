package Controller;

import Factory.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RentaCarController implements Initializable {

    Car car = null; // garii ki jo bi details
    List<String> storeallmodel = new ArrayList<>();
    List<String> storeallcolor = new ArrayList<>();
    List<Integer> storeallmfyear = new ArrayList<>();

    @FXML
    private ComboBox<String> choosecompany;   // sleect company  .,  "Honda"

    @FXML
    private ComboBox<String> choosemodel;

    @FXML
    private ComboBox<Integer> chooseyear;

    @FXML
    private ComboBox<String> choosecolor;

    @FXML
    private DatePicker datefrom;

    @FXML
    private DatePicker returndate;

    LocalDate fromdate;
    LocalDate tilldate;

    Carfactory[] hondacars = new Carfactory[3];
    List<Car> carList = new ArrayList<>();
    public void hondaprocess() {

        for (int i = 0; i < hondacars.length; i++) {
            hondacars[i] = new HondaFactoy();
        }
        car = hondacars[0].createhondacar(Carnames.CITY);   // car = store ref city......
        carList.add(car);
        storeallmodel.add(car.getModel());
        storeallcolor.add(car.getColor());
        storeallmfyear.add(car.getManufactyear());

        car = hondacars[1].createhondacar(Carnames.CIVIC);  // car = store ref civic.....
        carList.add(car);
        storeallmodel.add(car.getModel());
        storeallcolor.add(car.getColor());
        storeallmfyear.add(car.getManufactyear());

        car = hondacars[2].createhondacar(Carnames.BRV);
        carList.add(car);
        storeallmodel.add(car.getModel());
        storeallcolor.add(car.getColor());
        storeallmfyear.add(car.getManufactyear());

    }

    public void toyotaprocess() {
        Carfactory[] toyotacars = new Carfactory[3];
        for (int i = 0; i < toyotacars.length; i++) {
            toyotacars[i] = new ToyotaFactory();
        }
        car = toyotacars[0].createtoyotacar(Carnames.PRIUS);
        carList.add(car);
        storeallmodel.add(car.getModel());
        storeallcolor.add(car.getColor());
        storeallmfyear.add(car.getManufactyear());

        car = toyotacars[1].createtoyotacar(Carnames.COROLLA);
        carList.add(car);
        storeallmodel.add(car.getModel());
        storeallcolor.add(car.getColor());
        storeallmfyear.add(car.getManufactyear());

        car = toyotacars[2].createtoyotacar(Carnames.CAMRY);
        carList.add(car);
        storeallmodel.add(car.getModel());
        storeallcolor.add(car.getColor());
        storeallmfyear.add(car.getManufactyear());
    }

    private int count = 0;

    @FXML
    void onselectcompany(KeyEvent event) {
        try {
            if (!choosecompany.getValue().equals(null)) {
                if (choosecompany.getItems().contains("Honda") && count == 0) {
                    if (choosecompany.getValue().equals("Honda")) {
                        clearbox();
                        hondaprocess();
                        addtobox();
                    }
                    count++;
                } else if (choosecompany.getItems().contains("Toyota") && count != 0) {

                    if (choosecompany.getValue().equals("Toyota")) {
                        clearbox();
                        toyotaprocess();
                        addtobox();
                    }
                    count = 0;
                }
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }


    }

    public void addtobox() {
        choosemodel.getItems().addAll(storeallmodel);
        choosecolor.getItems().addAll(storeallcolor);
        chooseyear.getItems().addAll(storeallmfyear);

    }


    public void clearbox() {
        choosemodel.getItems().clear();  // models namesss , or clear
        choosecolor.getItems().clear();
        chooseyear.getItems().clear();
        storeallmfyear.clear();
        storeallcolor.clear();
        storeallmodel.clear();
    }

    public void pickdate() {
        fromdate = datefrom.getValue();
        tilldate = returndate.getValue();
    }

    @FXML
    private TextArea displaydetail;


    double rent = 0;

    @FXML
    void onclick(MouseEvent event) {
        pickdate();

        int numberofbookdated = tilldate.getDayOfMonth() - fromdate.getDayOfMonth();
        if (choosemodel.getValue().equalsIgnoreCase("Honda City")) {
           car = carList.get(0);
           rent = car.getRent();
        }
         if (choosemodel.getValue().equalsIgnoreCase("Honda Civic")){
            car = carList.get(1);
            rent = car.getRent();
        }
         if (choosemodel.getValue().equalsIgnoreCase("Honda BRV")){
            car = carList.get(2);
            rent = car.getRent();
        }
         if (choosemodel.getValue().equalsIgnoreCase("Toyota Prius")){
            car = carList.get(3);
            rent = car.getRent();
        }
         if (choosemodel.getValue().equalsIgnoreCase("Toyota Corolla")){
            car = carList.get(4);
            rent = car.getRent();
        }
         if (choosemodel.getValue().equalsIgnoreCase("Toyota Camry")){
            car = carList.get(5);
            rent = car.getRent();
        }

        displaydetail.setText("Company :" + choosecompany.getValue() + "\nCar Name is :" + choosemodel.getValue()
                + "\nManufacturing Year :" + chooseyear.getValue() + "\nSelected Color :" +
                choosecolor.getValue() + "\nRent of car:" + car.getRent()+ "\nReserved For : " + numberofbookdated + " days\nRent is :" + (rent * numberofbookdated));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choosecompany.getItems().add("Honda");
        choosecompany.getItems().add("Toyota");
    }
}
