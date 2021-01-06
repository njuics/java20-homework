import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class CalabashCollection{
    private static final int N=20;//调整葫芦娃数目
    private static final int LEN = 5;//调整名字长度
    public static void main(String[] args)
	{
		ArrayList<Calabash> cal = new ArrayList<Calabash>(); // 葫芦娃数组序列
		ArrayList<Calabash> male_cal = new ArrayList<Calabash>(); // 男葫芦娃数组序列
		ArrayList<Calabash> female_cal = new ArrayList<Calabash>(); // 女葫芦娃数组序列
		// 随机生成N个葫芦娃
		for (int i=0;i<N;i++) { 
			Calabash newcal = randomCalabash();
			cal.add(newcal); // 生成葫芦娃数组序列
        }
        //按性别区分
        male_cal = sortBySex(cal, "male");
        female_cal = sortBySex(cal, "female");
        //测试排序
        System.out.println("*******葫芦娃排序测试*********");
        test(cal);
        System.out.println("*******男葫芦娃排序测试*********");
        test(male_cal);
        System.out.println("*******女葫芦娃排序测试*********");
        test(female_cal);
    }
    

    public static void test(ArrayList<Calabash> cal){
        // 正序（comparable），正序，反序，乱序排序测试(Comparator)
        System.out.println("========正序comparable序列=======");
        sortByComparable(cal);
		System.out.println("========正序comparator序列=======");
        IncSort(cal);
        System.out.println("========反序comparator序列=======");
		DecSort(cal);
		System.out.println("========乱序comparator序列=======");
        RandSort(cal);
        System.out.print("\n\n\n");
    }


    public static Calabash randomCalabash(){ // 随机生成一个葫芦娃
		String name = "";
		String sex ;
		Random r = new Random();
		for(int i=0;i<LEN;i++)
		{
			int rand = 0;
			if (i == 0){
				rand = 'A'+Math.abs(r.nextInt() % 26);
			}
			else {
				rand = 'a'+Math.abs(r.nextInt() % 26);
			}
			
			name += (char)rand;
		}
		if (r.nextBoolean() == true) {
			sex = "male";
		}
		else {
			sex = "female";
		}
		
		Calabash cal = new Calabash (name,sex);
		return cal;
    }
    
    public static ArrayList<Calabash> sortBySex(ArrayList<Calabash> cal,String sexkind){
        ArrayList<Calabash> ans = new ArrayList<Calabash>();
        Iterator<Calabash> iter = cal.iterator(); 
		while(iter.hasNext()) {
           Calabash caltemp=iter.next();
           if (caltemp.get_sex()==sexkind){
               ans.add(caltemp);
           }
        }
        return ans;
    }

    public static void sortByComparable(ArrayList<Calabash> cal) {
		Collections.sort(cal);
		printArray(cal);
	}


    public static void IncSort(ArrayList<Calabash> cal) { 
		Collections.sort(cal,new  CalabashIncComparator());
		printArray(cal);
	}	
	public static void DecSort(ArrayList<Calabash> cal) {
		Collections.sort(cal,new  CalabashDecComparator());
		printArray(cal);
	}
	public static void RandSort(ArrayList<Calabash> cal) {
        Collections.sort(cal,new  CalabashRandomComparator());
		printArray(cal);
    }
    
    public static void printArray(ArrayList<Calabash> cal){
        Iterator<Calabash> iter = cal.iterator(); 
		while(iter.hasNext()) {
			iter.next().selfIntroduce();
		}
    }
}