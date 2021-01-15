package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class CalabashCollection <T extends Calabash>{
    private static final int N=20;//调整葫芦娃数目
    private static final int LEN = 5;//调整名字长度
    public static <T extends Calabash> void main (String[] args) throws InstantiationException, IllegalAccessException
	{
		ArrayList<Calabash> cal = new ArrayList<>(); // 葫芦娃数组序列
		ArrayList<Calabash> male_cal = new ArrayList<Calabash>(); // 男葫芦娃数组序列
		ArrayList<Calabash> female_cal = new ArrayList<Calabash>(); // 女葫芦娃数组序列
		// 随机生成N个葫芦娃
		for (int i=0;i<N;i++) { 
			Calabash newcal = randomCalabash(Calabash.class);
			cal.add(newcal); // 生成葫芦娃数组序列
        }
        //按性别区分
        male_cal = sortBySex(cal, "male",Calabash.class);
        female_cal = sortBySex(cal, "female",Calabash.class);
        //测试排序
        System.out.println("*******葫芦娃排序测试*********");
        test(cal);
        System.out.println("*******男葫芦娃排序测试*********");
        test(male_cal);
        System.out.println("*******女葫芦娃排序测试*********");
        test(female_cal);
    }
    

    public static <T extends Calabash> void test(ArrayList<T> cal){
        // 正序（comparable），正序，反序，乱序排序测试(Comparator)
        System.out.println("========正序comparable序列=======");
        sortByComparable(cal);
		System.out.println("========正序comparator序列=======");
        incSort(cal);
        System.out.println("========反序comparator序列=======");
		decSort(cal);
		System.out.println("========乱序comparator序列=======");
        randSort(cal);
        System.out.print("\n\n\n");
    }


    public static <T extends Calabash> T randomCalabash(Class<T> type)
			throws InstantiationException, IllegalAccessException { // 随机生成一个葫芦娃
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
		T cal = type.newInstance();
		Calabash caltmp = new Calabash(name, sex);
		cal.rename(caltmp);
		return cal;
    }
    
    public static <T extends Calabash> ArrayList<T> sortBySex(ArrayList<T> cal,String sexkind,Class<T> type)
			throws InstantiationException, IllegalAccessException {
        ArrayList<T> ans = new ArrayList<>();
        Iterator<T> iter = cal.iterator(); 
		while(iter.hasNext()) {
		   Calabash caltemp=iter.next();
		   T cal1 = type.newInstance();
			cal1.rename(caltemp);
           if (caltemp.get_sex()==sexkind){
               ans.add(cal1);
           }
        }
        return ans;
    }

    public static <T extends Calabash> void sortByComparable(ArrayList<T> cal) {
		Collections.sort(cal);
		printArray(cal);
	}


    public static <T extends Calabash> void incSort(ArrayList<T> cal) { 
		Collections.sort(cal,new  CalabashIncComparator());
		printArray(cal);
	}	
	public static <T extends Calabash>  void decSort(ArrayList<T> cal) {
		Collections.sort(cal,new  CalabashDecComparator());
		printArray(cal);
	}
	public static <T extends Calabash> void randSort(ArrayList<T> cal) {
        Collections.sort(cal,new  CalabashRandomComparator());
		printArray(cal);
    }
    
    public static <T extends Calabash> void printArray(ArrayList<T> cal){
        Iterator<T> iter = cal.iterator(); 
		while(iter.hasNext()) {
			iter.next().selfIntroduce();
		}
    }
}