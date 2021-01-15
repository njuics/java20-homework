package cn.edu.nju.cs;

import com.google.common.base.MoreObjects;

public class HuLuWa extends Creature {

    HuLuWa() {
        super();
    }

    HuLuWa(String name) {
        super(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("HuLuWa").add("name", getName()).add("gender", isGender() ? "male" : "female")
                .toString();
    }
}
