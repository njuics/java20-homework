import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CalabashList list= new CalabashList();

        int numofCB=10;

        Random rInt=new Random(); // 可以只用一个Random对象；

        for(int i=0; i<numofCB;i++) {   // 若干个葫芦娃出生，性别和姓名随机；姓名为随机长度(暂定1-7)的数字和字母组合；
            int gander=rInt.nextInt(2);
            int length = rInt.nextInt(7)+1;
            String name=getRandomString(rInt,length); // 名字默认为1-7位；
            list.add(new Calabash(gander,name));
        }
        System.out.println("初始化完成，葫芦娃队伍为：");
        list.outputList();

        list.sortByName();
        System.out.println("按姓名升序排序：");
        list.outputList();

        list.sortByNameReverse();
        System.out.println("按姓名降序排序：");
        list.outputList();

        list.sortByNameShuffle();
        System.out.println("乱序排序：");
        list.outputList();

        System.out.println("按性别分成两个队伍：");
        CalabashList listMale=list.getMaleList();
        CalabashList listFemale=list.getFemaleList();
        System.out.println("male队伍：");
        listMale.outputList(); 
        System.out.println("female队伍：");
        listFemale.outputList();

        listMale.sortByName();
        listFemale.sortByName();
        System.out.println("排序后male队伍：");
        listMale.outputList();
        System.out.println("排序后female队伍：");
        listFemale.outputList();
    }

    private static String getRandomString(Random rInt,int n) { // 随机姓名
        String name="";
        // 随机生成字符的选择区间：62个字母或数字；
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        for(int i=0; i<n;i++) {
            int index= rInt.nextInt(62);
            name+=str.charAt(index);
        }
        return name;
    }
    
}