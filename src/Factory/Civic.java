package Factory;

public class Civic extends Car {


    public Civic(){
        super("Honda Civic", "blue",2020);
        setRent(3102.123);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
