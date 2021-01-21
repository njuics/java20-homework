import java.util.ArrayList;
import java.util.Collections;

class Calabash {    // 葫芦娃类
    private int color;  // 颜色；0-6分别代表葫芦娃的大娃到七娃；
    private int rank;   // 自己期望的排名，初始化为0；目前仅在Choreography形式的排序中有用；
    Calabash() {
        color=rank=0;
    }
    Calabash(int c) {
        color=c;
        rank=0;
    }
    int getColor() {
        return color;
    }
    int getRank() {
        return rank;
    }
    void sayColor() {
        switch(color) {
            case 0: System.out.print("老大");break;
            case 1: System.out.print("老二");break;
            case 2: System.out.print("老三");break;
            case 3: System.out.print("老四");break;
            case 4: System.out.print("老五");break;
            case 5: System.out.print("老六");break;
            case 6: System.out.print("老七");break;
        default: System.out.print("Error in Class Calabash sayRank(): color is not in 0-6;");break;
        }
        System.out.print(" ");
    }
    void message(int c) {
        if(c<color) {
            rank++;
        }
    }
}
class Grandpa { //爷爷类
    Grandpa() {}
    public void sortCalabashBrothers(ArrayList<Calabash> cbArrayList) {
        for(int i=0;i<cbArrayList.size();i++) {
            int minIndex= i;
            for(int j=i;j<cbArrayList.size();j++) {
                if(cbArrayList.get(j).getColor()<cbArrayList.get(minIndex).getColor())
                    minIndex=j;
            }
            if(minIndex!=i)
                Collections.swap(cbArrayList,i,minIndex);
        }
    }
}

public class CalabashBrothersSort { // 七葫芦娃排序类
    static void outputArray(ArrayList<Calabash> cbArrayList) {
        for (Calabash calabash : cbArrayList) {
            calabash.sayColor();
        }
        System.out.println();
    }
    static void shuffle(ArrayList<Calabash> cbArrayList) {
        Collections.shuffle(cbArrayList);
        outputArray(cbArrayList);
    }
    static void sortByAlgo(ArrayList<Calabash> cbArrayList) {
        for(int i=0;i<cbArrayList.size();i++) {
            int minIndex= i;
            for(int j=i;j<cbArrayList.size();j++) {
                if(cbArrayList.get(j).getColor()<cbArrayList.get(minIndex).getColor())
                    minIndex=j;
            }
            if(minIndex!=i)
                Collections.swap(cbArrayList,i,minIndex);
        }
    }
    static void sortOrchestration(ArrayList<Calabash> cbArrayList) {
        Grandpa grandpa=new Grandpa();
        grandpa.sortCalabashBrothers(cbArrayList);
    }
    static void sortChoreography(ArrayList<Calabash> cbArrayList) {
        for (int i = 0; i < cbArrayList.size(); i++) {
            int iColor=cbArrayList.get(i).getColor();
            for (int j = 0; j < cbArrayList.size(); j++) {
                if(j!=i)
                    cbArrayList.get(j).message(iColor);
            }
        }

        for (int i = 0; i < cbArrayList.size(); i++) {
            for (int j = i+1; j < cbArrayList.size(); j++) {
                if(cbArrayList.get(j).getRank()==i) {
                    Collections.swap(cbArrayList, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Calabash> calabashBrothers = new ArrayList<>();
        for(int i=0;i<7;i++) {
            Calabash cb=new Calabash(i);
            calabashBrothers.add(cb);
        }

        System.out.println("初始化：");
        outputArray(calabashBrothers);

        // 1.
        System.out.println("\n1.打乱顺序：");
        shuffle(calabashBrothers);
        // 选择排序：
        sortByAlgo(calabashBrothers);
        
        System.out.println("排序后：");
        outputArray(calabashBrothers);

        // 2.
        System.out.println("\n2.打乱顺序：");
        shuffle(calabashBrothers);
        // orchestration排序
        sortOrchestration(calabashBrothers);
        System.out.println("排序后：");
        outputArray(calabashBrothers);

        // 3.
        System.out.println("\n3.打乱顺序：");
        shuffle(calabashBrothers);
        // choreography排序
        sortChoreography(calabashBrothers);
        System.out.println("排序后：");
        outputArray(calabashBrothers);
    }
}