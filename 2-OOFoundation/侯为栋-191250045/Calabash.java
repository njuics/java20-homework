import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Calabash {
    private int seniority;
    private int position;
    private String name;
    private String capacity;

    public Calabash(int seniority, String name, String capacity) {
        this.seniority = seniority;
        this.name = name;
        this.capacity = capacity;
        this.position = 0;
    }

    public int getSeniority() {
        return this.seniority;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public String getCapacity() {
        return this.capacity;
    }

    public void pickPosition(int[] positions) {
        // 选择自己的位置
        try {
            Random rand = SecureRandom.getInstanceStrong();
            int index = rand.nextInt(7);
            while (positions[index] != -1) {
                index = rand.nextInt(7);
            }
            positions[index] = this.seniority;
            this.position = index;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void exchangePosition(Calabash brother, int[] positions) {
        // 和某位好兄弟交换位置
        int tmpSelf = this.position;
        int tmpBro = brother.getPosition();
        positions[tmpSelf] = brother.getSeniority();
        positions[tmpBro] = this.getSeniority();
        this.setPosition(tmpBro);
        brother.setPosition(tmpSelf);
    }

    public boolean isSenior(Calabash brother) {
        return this.seniority < brother.getSeniority();
    }

    public void callSelfName() {
        System.out.println(this.name + "！");
    }
}
