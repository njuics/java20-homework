package homework_A;

public class HFactory implements HuluwaFactory<Huluwa>{
    @Override
    public Huluwa create() {
        return new Huluwa();
    }
}
