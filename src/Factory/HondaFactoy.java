package Factory;

public class HondaFactoy implements Carfactory {

    @Override
    public Car createhondacar(Carnames carname) {

        if (carname.equals(Carnames.CIVIC)){
            return  new Civic();
        }
        else if (carname.equals(Carnames.CITY)){

            return new City();
        }
        else if (carname.equals(Carnames.BRV)){
            return new BRV();
        }
        else
            return null;
    }

    @Override
    public Car createtoyotacar(Carnames carname) {
        return null;
    }
}
