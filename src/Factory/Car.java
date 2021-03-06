package Factory;

public abstract class Car {

    private String model;
    private String color;
    private int manufactyear;


    private String num_seats;
    private boolean isAvailable;
    private double rent ;

    Car(String model , String color , int manufactyear){
        this.color = color;
        this.manufactyear = manufactyear;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getManufactyear() {
        return manufactyear;
    }

    public void setManufactyear(int manufactyear) {
        this.manufactyear = manufactyear;
    }

    public String getNum_seats() {
        return num_seats;
    }

    public void setNum_seats(String num_seats) {
        this.num_seats = num_seats;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString(){

        return String.format("Car name : %s \n Car color : %s \nCar MF : %d", getModel(),getColor(),getManufactyear());

    }
}
