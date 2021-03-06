package Factory;

public class Corolla extends Car{


    public Corolla() {
        super("Toyota Corolla","Midnight Black Metallic",2019);
        setRent(2400);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
