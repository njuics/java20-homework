// comparable Hulu class, each Hulu has a index, differernt Hulu have differernt fingerprint(hashcode)
public class Hulu implements Comparable<Hulu> {
    public enum INDEX {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;

        String toChinsesString() {
            switch (this) {
                case ONE:
                    return "老大";
                case TWO:
                    return "老二";
                case THREE:
                    return "老三";
                case FOUR:
                    return "老四";
                case FIVE:
                    return "老五";
                case SIX:
                    return "老六";
                case SEVEN:
                    return "老七";
                default:
                    // unreached forever
                    assert (false);
                    return "";
            }
        }
    }

    private final INDEX index;

    public Hulu(final INDEX indexIn) {
        index = indexIn;
    }

    public INDEX getIndex() {
        return index;
    }

    @Override
    public int compareTo(final Hulu anotherHulu) {
        if (this.getIndex().compareTo(anotherHulu.getIndex()) == 0) {
            return this.hashCode() - anotherHulu.hashCode();
        } else {
            return this.getIndex().compareTo(anotherHulu.getIndex());
        }
    }

    @Override
    // Two object of Hulu is not equal, even if they have same index.
    public boolean equals(final Object obj) {
        return this == obj;
    }

    @Override
    // in order to remove warnings... super.hashcode() is what we need
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return index.toChinsesString() + " @" + this.hashCode();
    }

    public static void main(final String[] args) {
        final Hulu[] huluArray = { new Hulu(Hulu.INDEX.FIVE), new Hulu(Hulu.INDEX.SEVEN), new Hulu(Hulu.INDEX.SIX),
                new Hulu(Hulu.INDEX.FOUR), new Hulu(Hulu.INDEX.TWO), new Hulu(Hulu.INDEX.THREE), new Hulu(Hulu.INDEX.THREE),
                new Hulu(Hulu.INDEX.ONE), new Hulu(Hulu.INDEX.TWO), new Hulu(Hulu.INDEX.SIX) };

        System.out.println("before sort: ");
        for (final Hulu hulu : huluArray) {
            System.out.println(hulu.toString());
        }

        for (int i = 0; i < huluArray.length; ++i) {
            int minIndex = i;
            for (int j = i; j < huluArray.length; ++j) {
                if (huluArray[j].compareTo(huluArray[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            final Hulu tmp = huluArray[minIndex];
            huluArray[minIndex] = huluArray[i];
            huluArray[i] = tmp;
        }

        System.out.println("after sort: ");
        for (final Hulu hulu : huluArray) {
            System.out.println(hulu.toString());
        }
    }
}
