// position calss, can find next and prev position
public class Position implements Comparable<Position> {
    public static final Position INVALID_POSITION = new Position(-1);
    private static final int POSITION_INDEX_MIN = 0;
    // BUG: max is untouchable
    private static int positionIndexMax = 0;

    private int posi;

    public Position(int positionIn) {
        posi = positionIn;
    }

    public int getPositionIndex() {
        return posi;
    }

    public static Position genNextPostion() {
        return new Position(positionIndexMax++);
    }

    public Position getNextPosition() {
        if (posi == positionIndexMax - 1) {
            return INVALID_POSITION;
        } else {
            return new Position(posi + 1);
        }
    }

    public Position getPrevPosition() {
        if (posi == POSITION_INDEX_MIN) {
            return INVALID_POSITION;
        } else {
            return new Position(posi - 1);
        }
    }

    public static Position getMinPosition() {
        return new Position(POSITION_INDEX_MIN);
    }

    public static Position getMaxPosition() {
        return new Position(positionIndexMax);
    }

    public void setPositionIndex(int position) {
        this.posi = position;
    }

    public static void setPositionIndexMax(int positionIndexMax) {
        Position.positionIndexMax = positionIndexMax;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + posi;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        return posi == other.posi;
    }

    @Override
    public int compareTo(Position another) {
        return this.posi - another.getPositionIndex();
    }
}
