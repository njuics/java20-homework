import java.util.Arrays;
import java.util.Random;

class HuLuBrother implements Comparable {

    //葫芦娃编号，用于排序
    public int id;
    //葫芦娃名字
    public String name;

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        HuLuBrother other = (HuLuBrother)o;
        if (id < other.id) return -1;
        else if (id == other.id) return 0;
        else return 1;
    }

    public void ReportNumber() {
        System.out.println(name);
    }
    
}

class Dawa extends HuLuBrother {

    public Dawa() {
        id = 1;
        name = "大娃";
    }

}

class Erwa extends HuLuBrother {

    public Erwa() {
        id = 2;
        name = "二娃";
    }

}

class Sanwa extends HuLuBrother {

    public Sanwa() {
        id = 3;
        name = "三娃";
    }

}

class Siwa extends HuLuBrother {

    public Siwa() {
        id = 4;
        name = "四娃";
    }

}

class Wuwa extends HuLuBrother {

    public Wuwa() {
        id = 5;
        name = "五娃";
    }

}

class Liuwa extends HuLuBrother {

    public Liuwa() {
        id = 6;
        name = "六娃";
    }

}

class Qiwa extends HuLuBrother {

    public Qiwa() {
        id = 7;
        name = "七娃";
    }

}

class Grandfather {
    /*
     * @
    */
    public void SortCalabashBaby(HuLuBrother[] queue) {
        Arrays.sort(queue);
    }

    public void LetReportNumber(HuLuBrother[] queue) {
        for (HuLuBrother brother : queue) {
            brother.ReportNumber();
        }
    }
}

public class SortHuLuBrothers {
    public static void main(String[] args) {
        System.out.println("编舞法排序葫芦娃：");
        SortByOrchestration();

        System.out.println("=================");

        System.out.println("协同法排序葫芦娃：");
        SortByChoreography();
    }

    private static void Shuffle(Object[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int rand = random.nextInt(i);
            Object temp = array[i];
            array[i] = array[rand];
            array[rand] = temp;
        }
    }

    private static void SortByOrchestration() {
        //七个葫芦娃的队伍
        HuLuBrother[] queue = { new Dawa(), new Erwa(), new Sanwa(), new Siwa(), 
                                 new Wuwa(), new Liuwa(), new Qiwa() };
        //爷爷
        Grandfather grandFather = new Grandfather();
        //初始乱序
        Shuffle(queue);
        //爷爷让乱序队伍报数
        System.out.println("初始乱序队伍报数：");
        grandFather.LetReportNumber(queue);
        //爷爷负责排序
        grandFather.SortCalabashBaby(queue);
        //爷爷让排序后的队伍报数
        System.out.println("排序后的队伍报数：");
        grandFather.LetReportNumber(queue);
    }

    private static void SortByChoreography() {
        //七个葫芦娃的队伍
        HuLuBrother[] queue = { new Dawa(), new Erwa(), new Sanwa(), new Siwa(), 
            new Wuwa(), new Liuwa(), new Qiwa() };
        //初始乱序
        Shuffle(queue);
        //乱序队伍报数
        System.out.println("初始乱序队伍报数：");
        for (HuLuBrother brother : queue) {
            brother.ReportNumber();
        }
        //葫芦娃询问左边和右边的葫芦娃，看是否需要往前往后冒泡
        for (int i = 0; i < queue.length; i++) {
            int j = i;
            while (true) {
                if (j-1 >= 0 && queue[j].compareTo(queue[j-1]) < 0) {
                    //System.out.println(queue[j-1].name + "与" + queue[j].name + "换位");
                    HuLuBrother temp = queue[j-1];
                    queue[j-1] = queue[j];
                    queue[j] = temp;
                    j = j-1;
                }
                else if (j+1 <= queue.length-1 && queue[j].compareTo(queue[j+1]) > 0) {
                    //System.out.println(queue[j].name + "与" + queue[j+1].name + "换位");
                    HuLuBrother temp = queue[j+1];
                    queue[j+1] = queue[j];
                    queue[j] = temp;
                    j = j+1;
                }
                else {
                    break;
                }
            }
        }
        //葫芦娃报数
        System.out.println("排序后的队伍报数：");
        for (HuLuBrother brother : queue) {
            brother.ReportNumber();
        }
    }
}