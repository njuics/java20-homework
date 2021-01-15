package homework_9;

public class HFactory implements HuluwaFactory<Huluwa>{
    @Override
    public Huluwa create() {
        return new Huluwa();
    }
}
