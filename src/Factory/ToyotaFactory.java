package Factory;

public class ToyotaFactory implements Carfactory {


    @Override
    public Car createhondacar(Carnames carname) {
        return null;
    }

    @Override
    public Car createtoyotacar(Carnames carname) {

        if (carname.equals(Carnames.CAMRY)){
            return  new Camry();
        }
        else if (carname.equals(Carnames.COROLLA)){

            return new Corolla();
        }
        else if (carname.equals(Carnames.PRIUS)){
            return new Prius();
        }
        else
        return null;
    }
}
