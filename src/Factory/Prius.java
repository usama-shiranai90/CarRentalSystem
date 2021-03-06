package Factory;

public class Prius extends Car {

    public Prius() {
        super("Toyota Prius", "Ruby Flare Pearl", 2019);

        setRent(1200);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
