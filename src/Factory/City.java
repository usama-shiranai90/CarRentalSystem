package Factory;

public class City extends Car {



    public City() {

        super("Honda City", "Gray", 2005);
        setNum_seats("Four seats");
        setAvailable(true);
        setRent(2400.50);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
