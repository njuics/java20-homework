import java.util.Random;
import java.util.Comparator;

enum Order {
    ASC, DESC, RANDOM
}

public class HuLuWa implements Comparable<HuLuWa> {

    private static final String BASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NAME_LENGTH = 12;

    private final String name;
    private final boolean gender;
    private Order order = Order.ASC;
    private boolean sortByGender = false;

    HuLuWa() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NAME_LENGTH; i++) {
            int index = random.nextInt(BASE.length());
            stringBuilder.append(BASE.charAt(index));
        }
        name = stringBuilder.toString();
        gender = random.nextBoolean();
    }

    public void setOrder(Order order, boolean sortByGender) {
        this.order = order;
        this.sortByGender = sortByGender;
    }

    public static Comparator<HuLuWa> getComparator(Order order, boolean sortByGender) {
        switch (order) {
            case ASC:
                return getAscComparator(sortByGender);
            case DESC:
                return getDesComparator(sortByGender);
            case RANDOM:
                return getRandComparator();
            default:
                return getRandComparator();
        }
    }

    public static Comparator<HuLuWa> getComparator(Order order) {
        return getComparator(order, false);
    }

    @Override
    public String toString() {
        return "Name: " + name + " Gender: " + (gender ? "male" : "female");
    }

    @Override
    public int compareTo(HuLuWa o) {
        if (sortByGender && gender != o.gender) {
            return (gender ? -1 : 1);
        } else {
            switch (order) {
                case ASC:
                    return name.compareTo(o.name);
                case DESC:
                    return o.name.compareTo(name);
                case RANDOM:
                    return ((new Random().nextDouble() > 0.5) ? 1 : -1);
                default:
                    return 0;
            }
        }
    }

    private static Comparator<HuLuWa> getAscComparator(boolean b) {
        return (o1, o2) -> {
            if (b && o1.gender != o2.gender) {
                return (o1.gender ? -1 : 1);
            } else {
                return o1.name.compareTo(o2.name);
            }
        };
    }

    private static Comparator<HuLuWa> getDesComparator(boolean b) {
        return (o1, o2) -> {
            if (b && o1.gender != o2.gender) {
                return (o1.gender ? -1 : 1);
            } else {
                return o2.name.compareTo(o1.name);
            }
        };
    }

    private static Comparator<HuLuWa> getRandComparator() {
        return (o1, o2) -> ((new Random().nextDouble() > 0.5) ? 1 : -1);
    }
}
