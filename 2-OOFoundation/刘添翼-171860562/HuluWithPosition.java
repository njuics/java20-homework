// used for sort Hulu in a choreography manner
public class HuluWithPosition extends Hulu {
    public HuluWithPosition(final INDEX indexIn, final Position positionIn) {
        super(indexIn);
        position = positionIn;
    }

    // position on the playground
    private Position position;

    public static IPositionToHuluMapper mapper;

    public boolean trySwap() {
        if (position.getNextPosition() != Position.INVALID_POSITION) {
            HuluWithPosition anotherHulu = mapper.getHulu(position.getNextPosition());
            if (this.compareTo(anotherHulu) > 0) {
                this.setPosition(this.getPosition().getNextPosition());
                anotherHulu.setPosition(anotherHulu.getPosition().getPrevPosition());
                mapper.syncChange(this);
                mapper.syncChange(anotherHulu);
                return true;
            }
        }
        return false;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static void setMapper(IPositionToHuluMapper mapper) {
        HuluWithPosition.mapper = mapper;
    }
}