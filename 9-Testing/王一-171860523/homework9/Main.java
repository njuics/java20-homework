package homework9;

import java.util.Random;

public class Main {
    public static void main(String args[]) {
        Random random = new Random();
        int calaBroNum = random.nextInt(20) + 1; // [1,20]个葫芦娃
        CalaBro cb = null;
        for(int i = 0; i < calaBroNum; ++i)
            cb = new CalaBro();
        System.out.println("诞生了" + calaBroNum + "个葫芦娃");
        cb.sortPrint();
    }
}
