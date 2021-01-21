import java.util.Map;
import java.util.TreeMap;

// Hulu sorter, in an choreography manner
public class HuluChoreographySorter {
    // position to Hulu map
    private class PositionToHuluTreeMap implements IPositionToHuluMapper {
        private Map<Position, HuluWithPosition> map = new TreeMap<>();

        @Override
        public void syncChange(HuluWithPosition hulu) {
            // add a new Hulu to playground
            if (map.get(hulu.getPosition()) == null) {
                map.put(hulu.getPosition(), hulu);
            }
            // change the position of a Hulu
            else {
                // remove Hulu at old position
                map.remove(hulu.getPosition());
                // set this Hulu to that position
                map.put(hulu.getPosition(), hulu);
            }
        }

        @Override
        public HuluWithPosition getHulu(Position position) {
            return map.get(position);
        }
    }

    private PositionToHuluTreeMap positionToHuluTreeMap = new PositionToHuluTreeMap();

    private static void print(HuluWithPosition[] huluArray) {
        Position posi = Position.getMinPosition();
        while (posi != Position.INVALID_POSITION) {
            for (HuluWithPosition huluWithPosition : huluArray) {
                if (huluWithPosition.getPosition().equals(posi)) {
                    posi = posi.getNextPosition();
                    System.out.println(huluWithPosition.toString());
                }
            }
        }
    }

    public static void main(final String[] args) {
        HuluChoreographySorter sorter = new HuluChoreographySorter();
        HuluWithPosition.setMapper(sorter.positionToHuluTreeMap);

        HuluWithPosition[] huluArray = {
                new HuluWithPosition(Hulu.INDEX.FIVE, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.SEVEN, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.SIX, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.FOUR, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.TWO, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.THREE, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.THREE, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.ONE, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.TWO, Position.genNextPostion()),
                new HuluWithPosition(Hulu.INDEX.SIX, Position.genNextPostion()) };
        System.out.println("before sort: ");
        print(huluArray);

        for (HuluWithPosition huluWithPosition : huluArray) {
            HuluWithPosition.mapper.syncChange(huluWithPosition);
        }
        while (true) {
            boolean haveChange = false;
            for (HuluWithPosition huluWithPosition : huluArray) {
                if (huluWithPosition.trySwap()) {
                    haveChange = true;
                }
            }
            if (!haveChange) {
                break;
            }
        }
        System.out.println("after sort: ");
        print(huluArray);
    }
}