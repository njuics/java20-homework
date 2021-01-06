import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GrandFather implements Sort {

    public  void sort(GourdBaby[] garry) {
        Arrays.sort(garry, new NewComparator());
    }
    public static void main(String[] args) {
        GrandFather grandFather = new GrandFather();
        GourdBaby garry[] = new GourdBaby[7];
        for(int i = 0; i  < 7; i++) {
            Scanner sc = new Scanner(System.in);
            String tempName;
            int tempRank;
            System.out.println("请输入葫芦娃的名字:");
            tempName = sc.nextLine();
            System.out.println("请输入他的排行(1~7）");
            tempRank = sc.nextInt();
            garry[i] = new GourdBaby(tempName, tempRank);
        }
        System.out.println("初始化完成，爷爷对他们排序:");
        grandFather.sort(garry);
        System.out.println("排序完成，让葫芦娃报数：");
        for(int i = 0; i < 7; i++) {
            garry[i].reportNumber(garry[i].getName());
        }

    }
}
