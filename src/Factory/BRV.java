package Factory;

public class BRV extends Car {


    public BRV() {
        super("Honda BRV", "silver",2019);

        setRent(1890.41);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
