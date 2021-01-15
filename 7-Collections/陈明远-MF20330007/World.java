
import java.util.Iterator;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        MyGourdBabyContainer myGourdBabyContainer = new MyGourdBabyContainer();
        System.out.print("请输入葫芦娃的数量: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++) {
            GourdBaby gourdBaby = new GourdBaby();
            myGourdBabyContainer.add(gourdBaby);
        }
        System.out.println("按照姓名进行排序： ");
        myGourdBabyContainer.sort();
        for(GourdBaby gourdBaby: myGourdBabyContainer) {
            gourdBaby.report();
        }
        System.out.println("按照性别进行遍历： 男性：");
        for (Iterator<GourdBaby> it = myGourdBabyContainer.maleiterator(); it.hasNext(); ) {
            GourdBaby gourdBaby = it.next();
            gourdBaby.report();
        }
        System.out.println("女性：");
        for(Iterator<GourdBaby> it = myGourdBabyContainer.femaleiterator(); it.hasNext();) {
            GourdBaby gourdBaby = it.next();
            gourdBaby.report();
        }
    }
}
