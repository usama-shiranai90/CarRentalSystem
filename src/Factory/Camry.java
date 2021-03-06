package Factory;

public class Camry extends Car {

    public Camry(){
        super("Toyota Camry","Galactic Aqua Mica",2018);

        setRent(1450);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
