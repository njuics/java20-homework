public class Hulu {

    public enum Gender {
        MALE, FEMAIL;
    }

    private String name;
    private Gender gender;

    public Hulu(final String nameIn, Gender genderIn) {
        name = nameIn;
        gender = genderIn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Hulu other = (Hulu) obj;
        if (gender != other.gender)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Hulu [name=" + name + ", gender=" + gender + "]";
    }

    public static void main(final String[] args) {
        Hulu hulu = new Hulu("erf3t43f43g", Hulu.Gender.FEMAIL);
        System.out.println(hulu);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
