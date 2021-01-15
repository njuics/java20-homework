package ulticalabash.util;

public enum Gender {
    BOY, GIRL;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
